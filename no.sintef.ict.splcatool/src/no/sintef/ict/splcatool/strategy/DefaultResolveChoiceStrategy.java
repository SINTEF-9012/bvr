package no.sintef.ict.splcatool.strategy;

import no.sintef.ict.splcatool.interfaces.IResolveChoiceStrategy;
import bvr.VSpec;

public class DefaultResolveChoiceStrategy implements IResolveChoiceStrategy {

	@Override
	public VSpec getOriginalVSpec(VSpec vSpec) {
		return vSpec;
	}

}
