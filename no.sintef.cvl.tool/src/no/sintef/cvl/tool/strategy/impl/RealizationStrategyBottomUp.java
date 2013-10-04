package no.sintef.cvl.tool.strategy.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;


import cvl.FragmentSubstitution;
import cvl.VInstance;

import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.primitive.Symbol;
import no.sintef.cvl.tool.primitive.SymbolTable;
import no.sintef.cvl.tool.strategy.RealizationStrategy;

public class RealizationStrategyBottomUp implements RealizationStrategy {
	

	@Override
	public void deriveProduct(SymbolTable table) {
		EList<FragmentSubstitution> fragmentSubstitutions = new BasicEList<FragmentSubstitution>(getFragmentSubstitutionsToResolve(table));
		Context.eINSTANCE.initSubEngine(fragmentSubstitutions);
		resolve(table);
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
	
	private void resolve(SymbolTable table){
		ArrayList<SymbolTable> children = table.getChildren();
		for(SymbolTable child : children){
			resolve(child);
		}
		Context.eINSTANCE.performSubstitutions(prioritizeSymbols(table.getSymbols()));
	}
	
	private ArrayList<Symbol> prioritizeSymbols(ArrayList<Symbol> symbols){
		ArrayList<Symbol> prioritizedSymbols = new ArrayList<Symbol>();
		Iterator<Symbol> iterator = symbols.iterator();
		while(iterator.hasNext()){
			Symbol symbol = iterator.next();
			if(symbol.getVSpecResolution() instanceof VInstance){
				prioritizedSymbols.add(prioritizedSymbols.size(), symbol);
			}else{
				prioritizedSymbols.add(0, symbol);
			}
		}
		return prioritizedSymbols;
	}
}
