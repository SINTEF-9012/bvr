package no.sintef.bvr.constraints.bcl;

import java.util.Set;

import bvr.NamedElement;
import bvr.VSpecResolution;

public interface BCLChecker {
	// These might not be feasible with Eclipse OCL. 
	// It might be possible by guessing and trying with the boolean functions below
	// {
		// This command gives the valid single additions of "cu" at "parent"
		Set<NamedElement> getValidChildren(VSpecResolution parent);
		
		// This command gives the valid resolutions of "cu" for "vsr"
		Set<String> getValidAssignments(VSpecResolution vsr);
	// }
	
	// This command determines if a configuration is valid
	boolean isValid();
	boolean isValid(VSpecResolution vr);
	
	// This command determines if a VSpec has any valid configurations
	boolean hasConfigurations();
}
