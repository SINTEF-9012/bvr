package no.sintef.cvl.tool.primitive.impl;

import java.util.HashMap;

import no.sintef.cvl.tool.primitive.AbstractSymbol;
import no.sintef.cvl.tool.primitive.Symbol;

import org.eclipse.emf.common.util.BasicEList;

import cvl.FragmentSubstitution;
import cvl.VSpecResolution;


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
