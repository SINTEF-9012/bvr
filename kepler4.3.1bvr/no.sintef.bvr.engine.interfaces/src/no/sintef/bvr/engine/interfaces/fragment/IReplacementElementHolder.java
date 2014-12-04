package no.sintef.bvr.engine.interfaces.fragment;

import no.sintef.bvr.common.engine.error.BasicBVREngineException;
import bvr.ReplacementFragmentType;

public interface IReplacementElementHolder extends IElementHolderOIF, IElementHolder {

	public void update() throws BasicBVREngineException;
	
	public ReplacementFragmentType getReplacementFragment();
}
