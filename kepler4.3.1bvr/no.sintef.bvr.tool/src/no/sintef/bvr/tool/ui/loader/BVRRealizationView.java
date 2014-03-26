package no.sintef.bvr.tool.ui.loader;

import no.sintef.bvr.tool.ui.editor.BindingJTable;
import no.sintef.bvr.tool.ui.editor.FragmentSubstitutionJTable;
import no.sintef.bvr.tool.ui.editor.SubstitutionFragmentJTable;

public interface BVRRealizationView {

	public FragmentSubstitutionJTable getFragmentSubstitutionTable();
	
	public SubstitutionFragmentJTable getSubsitutionFragmentTable();
	
	public BindingJTable getBindingTable();
}
