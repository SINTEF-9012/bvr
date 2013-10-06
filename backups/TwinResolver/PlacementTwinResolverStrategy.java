package no.sintef.cvl.tool.strategy.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.engine.adjacent.AdjacentFragment;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.tool.exception.CVLModelException;
import no.sintef.cvl.tool.exception.UnexpectedException;
import no.sintef.cvl.tool.primitive.Symbol;
import no.sintef.cvl.tool.primitive.SymbolTable;
import no.sintef.cvl.tool.strategy.TwinResolverStrategy;

import cvl.FragmentSubstitution;

public class PlacementTwinResolverStrategy implements TwinResolverStrategy {

	private AdjacentFinderImpl adjacentFinder;
	private HashMap<FragmentSubstitution, FragmentSubstitutionHolder> fragmentHolders;

	@Override
	public void resolveTwins(SymbolTable table) {
		fragmentHolders = wrapFragmentSubstitutionsInHolder(getFragmentSubstitutionsToResolve(table));
		adjacentFinder = new AdjacentFinderImpl(new BasicEList<FragmentSubstitutionHolder>(fragmentHolders.values()));
	}
	
	private void processFragmentSubstitution(FragmentSubstitution substitution,
			Symbol symbol, HashSet<AdjacentFragment> parentTwinAdjFragments)
	{
		FragmentSubstitutionHolder holder = fragmentHolders.get(substitution);
		AdjacentFragment currentAdjFrag = adjacentFinder.getAdjacentMap().get(holder);
		if(currentAdjFrag == null)
			return;
		
		HashSet<AdjacentFragment> adjacentFragments = currentAdjFrag.getAdjacentFragments();
		if(adjacentFragments.size() < 2)
			return;
		
		HashSet<AdjacentFragment> adjFragsWithTwins = getTwinFragmentsFromList(adjacentFragments);
		if(adjFragsWithTwins.isEmpty())
			return;
		
		adjFragsWithTwins = filterOutParentAdjFragments(adjFragsWithTwins, parentTwinAdjFragments);
		if(adjFragsWithTwins.isEmpty())
			return;
		
		HashSet<AdjacentFragment> allTwins = new HashSet<AdjacentFragment>();
		for(AdjacentFragment adjFragment : adjFragsWithTwins){
			allTwins.add(adjFragment);
			allTwins.addAll(adjFragment.getTwinAdjacentFragments());
		}
		
		HashMap<AdjacentFragment, Symbol> fragmentSymbolMap = findSymbolsWithTwinAdjFragments(allTwins, symbol);
		for(AdjacentFragment fragment : adjFragsWithTwins){
			HashSet<AdjacentFragment> twins = collectAllTwinsForFragment(fragment);
			ArrayList<Symbol> twinSymbols = new ArrayList<Symbol>();
			for(AdjacentFragment twin : twins){
				Symbol twinSymbol = fragmentSymbolMap.get(twin);
				if(twinSymbol == null)
					throw new CVLModelException("can not find symbol to which the current twin is attached in this subtree" +
							twin.getFragmentHolder().getFragment());
				twinSymbols.add(twinSymbol);
			}
			HashSet<Symbol> symbols = new HashSet<Symbol>(twinSymbols);
			if(symbols.size() != twinSymbols.size())
				throw new CVLModelException("twin fragments should be attached to different VSpec-s");
		}
	}
	
	private void copyAdjacentFragmentTwin(AdjacentFragment twin){
		
	}
	
	private HashSet<AdjacentFragment> collectAllTwinsForFragment(AdjacentFragment fragment){
		HashSet<AdjacentFragment> set = new HashSet<AdjacentFragment>();
		set.add(fragment);
		set.addAll(fragment.getAdjacentFragments());
		return set;
	}
	
	private HashMap<AdjacentFragment, Symbol> findSymbolsWithTwinAdjFragments(HashSet<AdjacentFragment> adjFragment, Symbol root){
		HashMap<AdjacentFragment, Symbol> map = new HashMap<AdjacentFragment, Symbol>();
		for(AdjacentFragment fragment : adjFragment){
			Symbol symbol = findSymbolForFragment(fragment.getFragmentHolder().getFragment(), root);
			if(symbol != null) map.put(fragment, symbol);
		}
		return map;
	}
	
	private Symbol findSymbolForFragment(FragmentSubstitution fragment, Symbol root){
		Symbol parent = null;
		HashSet<FragmentSubstitution> fragments = getSymbolsFragmentSubstitutions(root);
		if(fragments.contains(fragment)){
			parent = root;
		}else{
			EList<Symbol> children = root.getChildren();
			for(Symbol child : children){
				parent = findSymbolForFragment(fragment, child);
				if(parent != null)
					return parent;
			}
		}
		
		return parent;
	}
	
	private HashSet<AdjacentFragment> filterOutParentAdjFragments(Collection<AdjacentFragment> twinFragments,
			Collection<AdjacentFragment> parentTwinAdjFragments)
	{
		for(AdjacentFragment fragment : parentTwinAdjFragments)
			if(twinFragments.contains(fragment))
				twinFragments.remove(fragment);
		return new HashSet<AdjacentFragment>(twinFragments);
	}
	
	private HashSet<AdjacentFragment> getTwinFragmentsFromList(Collection<AdjacentFragment> adjacentFragments){
		HashSet<AdjacentFragment> fragments = new HashSet<AdjacentFragment>();
		HashSet<AdjacentFragment> alreadyProcessed = new HashSet<AdjacentFragment>();
		for(AdjacentFragment fragment : adjacentFragments){
			if(!alreadyProcessed.contains(fragment)){
				HashSet<AdjacentFragment> twins = fragment.getTwinAdjacentFragments();
				if(!twins.isEmpty()){
					fragments.add(fragment);
					alreadyProcessed.addAll(twins);
				}
			}
		}
		return fragments;
	}
	
	private HashMap<FragmentSubstitution, FragmentSubstitutionHolder> wrapFragmentSubstitutionsInHolder(Collection<FragmentSubstitution> fragments){
		HashMap<FragmentSubstitution, FragmentSubstitutionHolder> map = new HashMap<FragmentSubstitution, FragmentSubstitutionHolder>();
		for(FragmentSubstitution fragment : fragments){
			FragmentSubstitutionHolder holder = new FragmentSubstitutionHolder(fragment);
			map.put(fragment, holder);
		}
		return map;
	}
	
	private HashSet<FragmentSubstitution> getFragmentSubstitutionsToResolve(SymbolTable table){
		HashSet<FragmentSubstitution> fss = new HashSet<FragmentSubstitution>();
		ArrayList<Symbol> symbols = table.getSymbols();
		for(Symbol symbol : symbols){
			EList<FragmentSubstitution> fragmentSubstitutions = symbol.getFragmentSubstitutions();
			for(FragmentSubstitution fragment : fragmentSubstitutions){
				FragmentSubstitution fragmentCopy = symbol.getFragmentSubstitutionCopy(fragment);
				FragmentSubstitution fragmentToExecute = (fragmentCopy == null) ? fragment : fragmentCopy;
				symbol.addFragmentSubstitutionsToExecute(fragmentToExecute);
				fss.add(fragmentToExecute);
			}
		}
		ArrayList<SymbolTable> tables = table.getChildren();
		for(SymbolTable symbolTable : tables){
			fss.addAll(getFragmentSubstitutionsToResolve(symbolTable));
		}
		return fss;
	}
	
	private HashSet<FragmentSubstitution> getSymbolsFragmentSubstitutions(Symbol symbol){
		HashSet<FragmentSubstitution> fragmentSubstitutions = new HashSet<FragmentSubstitution>();
		for(FragmentSubstitution fragment : symbol.getFragmentSubstitutions()){
			FragmentSubstitution fragmentCopy = symbol.getFragmentSubstitutionCopy(fragment);
			FragmentSubstitution fragmentToExecute = (fragmentCopy == null) ? fragment : fragmentCopy;
			symbol.addFragmentSubstitutionsToExecute(fragmentToExecute);
			fragmentSubstitutions.add(fragmentToExecute);
		}
		return fragmentSubstitutions;
	}

}
