package no.sintef.bvr.tool.controller;

import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.ui.loader.BVRRealizationUIKernelInterface;

public interface RealizationControllerInterface {

	public BVRRealizationUIKernelInterface getUIKernel();
	
	public SimpleExeCommandInterface createPlacementFragmentCommand(boolean conatinment);
	
	public SimpleExeCommandInterface createReplacementFragmentCommand(boolean conatinment);
	
	public void deleteSubstitutionFragments();
	
	public SimpleExeCommandInterface createDeleteSubstitutionFragmentsCommand();

	public void deleteFragmentSubstitutions();
	
	public SimpleExeCommandInterface createDeleteFragmentSubstitutionsCommand();

	public void createFragmentSubstitution();

	public SimpleExeCommandInterface createGenerateBindingsCommand();
}
