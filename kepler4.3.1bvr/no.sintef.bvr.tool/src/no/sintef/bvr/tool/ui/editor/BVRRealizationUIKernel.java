package no.sintef.bvr.tool.ui.editor;

import no.sintef.bvr.tool.ui.loader.BVRRealizationUIKernelInterface;

public class BVRRealizationUIKernel implements BVRRealizationUIKernelInterface {
	
	private FragmentSubstitutionJTable fst;
	private SubstitutionFragmentJTable sft;
	private BindingJTable bt;

	@Override
	public FragmentSubstitutionJTable getFragmentSubstitutionTable() {
		return fst;
	}

	@Override
	public SubstitutionFragmentJTable getSubsitutionFragmentTable() {
		return sft;
	}

	@Override
	public BindingJTable getBindingTable() {
		return bt;
	}

	@Override
	public void setFragmentSubstitutionTable(FragmentSubstitutionJTable table) {
		fst = table;
	}

	@Override
	public void setSubsitutionFragmentTable(SubstitutionFragmentJTable table) {
		sft = table;
	}

	@Override
	public void setBindingTable(BindingJTable table) {
		bt = table;
	}

}
