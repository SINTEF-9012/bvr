package no.sintef.bvr.tool.interfaces.ui.editor;


public interface BVRRealizationUIKernelInterface<FRAGSUB_TABLE, SUBFRAG_TABLE, BINDING_TABLE> {

	public FRAGSUB_TABLE getFragmentSubstitutionTable();
	
	public SUBFRAG_TABLE getSubsitutionFragmentTable();
	
	public BINDING_TABLE getBindingTable();
	
	public void setFragmentSubstitutionTable(FRAGSUB_TABLE table);
	
	public void setSubsitutionFragmentTable(SUBFRAG_TABLE table);
	
	public void setBindingTable(BINDING_TABLE table);
}
