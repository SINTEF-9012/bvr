/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import bvr.BVRModel;
import bvr.FragmentSubstitution;
import bvr.VariationPoint;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.SymbolVSpec;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.strategy.RealizationStrategy;

public class StaleSimpleRealizationStrategy implements RealizationStrategy {
	
	private EList<FragmentSubstitution> frgamentSusbstitutions; 


	@Override
	public void deriveProduct(SymbolVSpecResolutionTable table) {
		frgamentSusbstitutions = new BasicEList<FragmentSubstitution>();
		BVRModel model = table.getBVRModel();
		EList<VariationPoint> ownedVariationPoints = model.getRealizationModel();
		for(VariationPoint vp : ownedVariationPoints){
			if(vp instanceof FragmentSubstitution){
				frgamentSusbstitutions.add((FragmentSubstitution) vp);
			}
		}
		Context.eINSTANCE.initSubEngine(frgamentSusbstitutions);
		this.resolveScope(table);
	}
	
	private void resolveScope(SymbolVSpecResolutionTable table){
		ArrayList<SymbolVSpec> symbols = table.getSymbols();
		for(SymbolVSpec symbol : symbols){
			this.resolveSymbol(symbol);
		}
		
		ArrayList<SymbolVSpecResolutionTable> underneathScopes = table.getChildren();
		for(SymbolVSpecResolutionTable scope : underneathScopes){
			this.resolveScope(scope);
		}
	}
	
	private void resolveSymbol(final SymbolVSpec symbol){
		BVRModel model = symbol.getScope().getBVRModel();
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(model.eResource().getResourceSet());
		EList<FragmentSubstitution> symbolsFragSubs = symbol.getFragmentSubstitutions();
		for(final FragmentSubstitution fs : symbolsFragSubs){
			
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				protected void doExecute() {
					Context.eINSTANCE.getSubEngine().subsitute(fs, !symbol.getMulti());
				}
			});
		}
	}

}
