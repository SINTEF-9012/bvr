package no.sintef.bvr.tool.primitive.impl;

import java.util.HashMap;

import no.sintef.bvr.tool.primitive.AbstractSymbol;
import no.sintef.bvr.tool.primitive.Symbol;

import org.eclipse.emf.common.util.BasicEList;

import bvr.FragmentSubstitution;
import bvr.VSpecResolution;


public class VSpecResolutionSymbol extends AbstractSymbol {

	public VSpecResolutionSymbol(VSpecResolution vSpecRes){
		multi = false;
		vSpecResolution = vSpecRes;
		children = new BasicEList<Symbol>();
		vSpec = vSpecRes.getResolvedVSpec();
		fragSubs = new BasicEList<FragmentSubstitution>();
		fragSubsToExecute = new BasicEList<FragmentSubstitution>();
		fragmentSubCopyMap = new HashMap<FragmentSubstitution, FragmentSubstitution>();
	}
}
