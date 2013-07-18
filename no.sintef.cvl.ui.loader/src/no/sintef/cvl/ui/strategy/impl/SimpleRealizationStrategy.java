package no.sintef.cvl.ui.strategy.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;


import cvl.FragmentSubstitution;

import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.primitive.Symbol;
import no.sintef.cvl.ui.primitive.SymbolTable;
import no.sintef.cvl.ui.strategy.RealizationStrategy;

public class SimpleRealizationStrategy implements RealizationStrategy {
	

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
