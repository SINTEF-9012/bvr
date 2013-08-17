package no.sintef.cvl.ui.strategy.impl;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;


import cvl.FragmentSubstitution;

import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.primitive.Symbol;
import no.sintef.cvl.ui.primitive.SymbolTable;
import no.sintef.cvl.ui.strategy.RealizationStrategy;

public class RealizationStrategyBottomUp implements RealizationStrategy {
	

	@Override
	public void deriveProduct(SymbolTable table) {
		EList<FragmentSubstitution> frgamentSusbstitutions = new BasicEList<FragmentSubstitution>(getFragmentSubstitutionsToResolve(table));
		Context.eINSTANCE.initSubEngine(frgamentSusbstitutions);
		resolve(table);
	}
	
	private HashSet<FragmentSubstitution> getFragmentSubstitutionsToResolve(SymbolTable table){
		HashSet<FragmentSubstitution> fss = new HashSet<FragmentSubstitution>();
		ArrayList<Symbol> symbols = table.getSymbols();
		for(Symbol symbol : symbols){
			fss.addAll(symbol.getFragmentSubstitutions());
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
		System.out.println("resolve before");
		Context.eINSTANCE.performSubstitutions(table.getSymbols());
		System.out.println("resolve after");
	}
}
