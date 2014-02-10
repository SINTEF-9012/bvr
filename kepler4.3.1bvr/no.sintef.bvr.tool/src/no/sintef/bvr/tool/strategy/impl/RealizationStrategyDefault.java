package no.sintef.bvr.tool.strategy.impl;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;


import bvr.FragmentSubstitution;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.primitive.SymbolTable;
import no.sintef.bvr.tool.strategy.RealizationStrategy;

public class RealizationStrategyDefault implements RealizationStrategy {
	

	@Override
	public void deriveProduct(SymbolTable table) {
		EList<FragmentSubstitution> frgamentSusbstitutions = new BasicEList<FragmentSubstitution>(getFragmentSubstitutionsToResolve(table));
		EList<Symbol> symbols = collectSymbols(table, new BasicEList<Symbol>());
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
