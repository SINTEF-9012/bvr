package no.sintef.cvl.ui.primitive.impl;

import no.sintef.cvl.ui.primitive.AbstractSymbol;
import no.sintef.cvl.ui.primitive.Symbol;

import org.eclipse.emf.common.util.BasicEList;

import cvl.FragmentSubstitution;
import cvl.VSpecResolution;


public class VSpecResolutionSymbol extends AbstractSymbol {

	public VSpecResolutionSymbol(VSpecResolution vSpecResolution){
		fragSubs = new BasicEList<FragmentSubstitution>();
		children = new BasicEList<Symbol>();
		this.vSpecResolution = vSpecResolution;
		this.vSpec = vSpecResolution.getResolvedVSpec();
		this.multi = false;
	}
}
