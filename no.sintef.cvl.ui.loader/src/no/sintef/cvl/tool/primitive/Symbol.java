package no.sintef.cvl.tool.primitive;


import org.eclipse.emf.common.util.EList;

import cvl.FragmentSubstitution;
import cvl.VSpec;
import cvl.VSpecResolution;

public interface Symbol {

	public void setVSpec(VSpec vSpec);
	
	public void setVSpecResolution(VSpecResolution vSpecResolution);
	
	public VSpec getVSpec();
	
	public VSpecResolution getVSpecResolution();
	
	public void addFragmentSubstitution(FragmentSubstitution fragmentSubstiotution);
	
	public EList<FragmentSubstitution> getFragmentSubstitutions();
	
	public FragmentSubstitution getFragmentSubstitutionCopy(FragmentSubstitution original);
	
	public void setFragmentSubstitutionCopy(FragmentSubstitution original, FragmentSubstitution copy);
	
	public EList<FragmentSubstitution> getFragmentSubstitutionsToExecute();
	
	public void addFragmentSubstitutionsToExecute(FragmentSubstitution fragment);
	
	public void setParent(Symbol parent);
	
	public Symbol getParent();
	
	public void addChild(Symbol child);
	
	public EList<Symbol> getChildren();
	
	public void setScope(SymbolTable table);
	
	public SymbolTable getScope();
	
	public void setMulti(boolean multi);
	
	public boolean getMulti();
}
