package no.sintef.bvr.tool.strategy.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;


import bvr.FragmentSubstitution;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.SymbolVSpec;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.strategy.RealizationStrategy;

public class RealizationStrategyScopeless implements RealizationStrategy {
	

	@Override
	public void deriveProduct(SymbolVSpecResolutionTable table) {
		if(table.getChildren().size() != 0)
			throw new UnsupportedOperationException("Scopes are not supported yet, do not use VClassifier...");
		
		EList<FragmentSubstitution> frgamentSusbstitutions = new BasicEList<FragmentSubstitution>();
		ArrayList<SymbolVSpec> symbols = table.getSymbols();
		for(SymbolVSpec symbol : symbols){
			frgamentSusbstitutions.addAll(symbol.getFragmentSubstitutions());
		}
		
		Context.eINSTANCE.initSubEngine(frgamentSusbstitutions);
		Context.eINSTANCE.performSubstitutions(symbols);
	}
}
