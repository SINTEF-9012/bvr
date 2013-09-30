package no.sintef.cvl.tool.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VariationPoint;

import no.sintef.cvl.engine.adjacent.AdjacentFinder;
import no.sintef.cvl.engine.adjacent.AdjacentResolver;
import no.sintef.cvl.engine.adjacent.impl.AdjacentFinderImpl;
import no.sintef.cvl.engine.adjacent.impl.AdjacentResolverImpl;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.ContainmentCVLModelException;
import no.sintef.cvl.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.cvl.engine.operation.impl.FragmentSubOperation;
import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.primitive.Symbol;
import no.sintef.cvl.tool.primitive.SymbolTable;
import no.sintef.cvl.tool.strategy.RealizationStrategy;

public class StaleSimpleRealizationStrategy implements RealizationStrategy {
	
	private EList<FragmentSubstitution> frgamentSusbstitutions; 
	private HashMap<FragmentSubstitution, FragmentSubstitutionHolder> fsHMap;
	private AdjacentFinder adjacentFinder;
	private AdjacentResolver adjacentResolver;

	@Override
	public void deriveProduct(SymbolTable table) {
		frgamentSusbstitutions = new BasicEList<FragmentSubstitution>();
		ConfigurableUnit cu = table.getConfigurableUnit();
		EList<VariationPoint> ownedVariationPoints = cu.getOwnedVariationPoint();
		for(VariationPoint vp : ownedVariationPoints){
			if(vp instanceof FragmentSubstitution){
				frgamentSusbstitutions.add((FragmentSubstitution) vp);
			}
		}
		Context.eINSTANCE.initSubEngine(frgamentSusbstitutions);
		
		/*fsHMap = new HashMap<FragmentSubstitution, FragmentSubstitutionHolder>(); 
		ConfigurableUnit cu = table.getConfigurableUnit();
		EList<VariationPoint> ownedVariationPoints = cu.getOwnedVariationPoint();
		for(VariationPoint vp : ownedVariationPoints){
			if(vp instanceof FragmentSubstitution){
				FragmentSubstitution fs = (FragmentSubstitution) vp;
				try {
					fsHMap.put(fs, new FragmentSubstitutionHolder(fs));
				} catch (BasicCVLEngineException e) {
					e.printStackTrace();
				}
			}
		}
		adjacentFinder = new AdjacentFinderImpl(new BasicEList<FragmentSubstitutionHolder>(fsHMap.values()));
		adjacentResolver = new AdjacentResolverImpl(adjacentFinder);*/
		
		this.resolveScope(table);
	}
	
	private void resolveScope(SymbolTable table){
		ArrayList<Symbol> symbols = table.getSymbols();
		for(Symbol symbol : symbols){
			this.resolveSymbol(symbol);
		}
		
		ArrayList<SymbolTable> underneathScopes = table.getChildren();
		for(SymbolTable scope : underneathScopes){
			this.resolveScope(scope);
		}
	}
	
	private void resolveSymbol(final Symbol symbol){
		ConfigurableUnit cu = symbol.getScope().getConfigurableUnit();
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(cu.eResource().getResourceSet());
		EList<FragmentSubstitution> symbolsFragSubs = symbol.getFragmentSubstitutions();
		for(final FragmentSubstitution fs : symbolsFragSubs){
			/*final FragmentSubstitutionHolder fsH = fsHMap.get(fs);
			final FragmentSubOperation fso = new FragmentSubOperation(fsH);*/
			
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				protected void doExecute() {
					try {
						Context.eINSTANCE.getSubEngine().subsitute(fs, !symbol.getMulti());
					} catch (ContainmentCVLModelException e) {
						e.printStackTrace();
					}
					
					/*try {
						fso.execute(!symbol.getMulti());
						adjacentResolver.resolve(fsH);
						fso.checkConsistence();
					} catch (BasicCVLEngineException e) {
						e.printStackTrace();
					}*/
				}
			});
		}
	}

}