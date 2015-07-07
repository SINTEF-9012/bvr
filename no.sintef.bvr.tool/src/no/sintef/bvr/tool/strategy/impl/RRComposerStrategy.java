/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.BVRModel;
import bvr.FragmentSubstitution;
import bvr.NegResolution;
import bvr.PosResolution;
import bvr.VClassifier;
import bvr.VSpecResolution;
import bvr.VariationPoint;
import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.primitive.SymbolVSpec;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.primitive.impl.VSpecResolutionSymbol;
import no.sintef.bvr.tool.primitive.impl.VSpecResolutionSymbolTable;
import no.sintef.bvr.tool.strategy.TableBuilderStrategy;

public class RRComposerStrategy implements TableBuilderStrategy {

	private EList<VariationPoint> vps;
	private BasicEList<FragmentSubstitution> fss;

	public SymbolVSpecResolutionTable buildSymbolTable(BVRModel bvrModel, PosResolution posResolution) {
		vps = bvrModel.getRealizationModel();
		fss = new BasicEList<FragmentSubstitution>();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fss.add((FragmentSubstitution) vp);
			}
		}
		
		VSpecResolutionSymbolTable table = new VSpecResolutionSymbolTable((VSpecResolution) posResolution);
		table.setBVRModel(bvrModel);
		VSpecResolutionSymbol symbol = new VSpecResolutionSymbol((VSpecResolution) posResolution);
		parse(symbol, table);
		return table;
	}

	private boolean parse(SymbolVSpec symbol, SymbolVSpecResolutionTable table) {
		VSpecResolution vSpecResolution = symbol.getVSpecResolution();
		if(vSpecResolution instanceof NegResolution){
			return false;
		}else if((vSpecResolution instanceof PosResolution) && (CommonUtility.getResolvedVSpec(vSpecResolution) instanceof VClassifier)){
			VSpecResolutionSymbolTable subTable = new VSpecResolutionSymbolTable(vSpecResolution);
			subTable.setParent(table);
			subTable.setBVRModel(table.getBVRModel());
			table.setChild(subTable);
			table = subTable;
		}else if (!(vSpecResolution instanceof PosResolution || vSpecResolution instanceof NegResolution)) {
			throw new UnsupportedOperationException("we can not handle VSpecResolution of this kind =>" + vSpecResolution);
		}
		
		for(FragmentSubstitution fs : fss){
			if(fs.getBindingVSpec() != null && fs.getBindingVSpec().equals(symbol.getVSpec())){
				symbol.addFragmentSubstitution(fs);
			}
		}
		
		symbol.setScope(table);
		table.insert(symbol);
		
		EList<VSpecResolution> children = ((PosResolution) vSpecResolution).getMembers();
		for(VSpecResolution child : children){
			VSpecResolutionSymbol childSymbol = new VSpecResolutionSymbol(child);
			childSymbol.setParent(symbol);
			boolean isDecision = parse(childSymbol, table);
			if(isDecision)
				symbol.addChild(childSymbol);
		}
		return true;
	}

}
