package no.sintef.cvl.tool.strategy.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;


import cvl.FragmentSubstitution;

import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.primitive.Symbol;
import no.sintef.cvl.tool.primitive.SymbolTable;
import no.sintef.cvl.tool.strategy.RealizationStrategy;

public class RealizationStrategyScopeless implements RealizationStrategy {
	

	@Override
	public void deriveProduct(SymbolTable table) {
		if(table.getChildren().size() != 0)
			throw new UnsupportedOperationException("Scopes are not supported yet, do not use VClassifier...");
		
		EList<FragmentSubstitution> frgamentSusbstitutions = new BasicEList<FragmentSubstitution>();
		ArrayList<Symbol> symbols = table.getSymbols();
		for(Symbol symbol : symbols){
			frgamentSusbstitutions.addAll(symbol.getFragmentSubstitutions());
		}
		
		Context.eINSTANCE.initSubEngine(frgamentSusbstitutions);
		Context.eINSTANCE.performSubstitutions(symbols);
	}
}
