package no.sintef.ict.splcatool.interfaces;

import org.eclipse.emf.common.util.EList;

import bvr.ChoiceResolution;

public interface IResolutionFinderStrategy {

	public EList<ChoiceResolution> getResolutions();

}
