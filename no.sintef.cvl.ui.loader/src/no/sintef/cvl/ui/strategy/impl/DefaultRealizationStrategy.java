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

public class DefaultRealizationStrategy implements RealizationStrategy {
	

	@Override
	public void deriveProduct(SymbolTable table) {
		EList<FragmentSubstitution> frgamentSusbstitutions = new BasicEList<FragmentSubstitution>(getFragmentSubstitutionsToResolve(table));
		System.out.println("DefaultRealizationStrategy");
		System.out.println(frgamentSusbstitutions);
		EList<Symbol> symbols = collectSymbols(table, new BasicEList<Symbol>());
		System.out.println(symbols);
		for(Symbol symbol : symbols){
			frgamentSusbstitutions.addAll(symbol.getFragmentSubstitutions());
		}
		
		Context.eINSTANCE.initSubEngine(frgamentSusbstitutions);
		Context.eINSTANCE.performSubstitutions(symbols);
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
	
	private EList<Symbol> collectSymbols(SymbolTable table, EList<Symbol> result){
		result.addAll(table.getSymbols());
		for(SymbolTable sTable : table.getChildren()){
			result = collectSymbols(sTable, result);
		}
		return result;
	}
}
