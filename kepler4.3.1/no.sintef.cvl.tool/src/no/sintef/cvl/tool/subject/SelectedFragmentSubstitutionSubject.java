package no.sintef.cvl.tool.subject;

import cvl.FragmentSubstitution;
import no.sintef.cvl.tool.primitive.impl.ObserverDataBulk;

public class SelectedFragmentSubstitutionSubject extends AbstractViewSubject {

	private FragmentSubstitution selectedFragmentSubstitution;
	private String[] fields = {"selectedFragmentSubstitution"};
	
	public SelectedFragmentSubstitutionSubject(FragmentSubstitution fs){
		this.selectedFragmentSubstitution = fs;
	}
	
	@Override
	public void setState(ObserverDataBulk data) {
		Object value = data.getDataField("selectedFragmentSubstitution");
		selectedFragmentSubstitution = (value != null) ? (FragmentSubstitution) value : null;
	}
	
	public FragmentSubstitution getSelectedFragmentSubstitution(){
		return selectedFragmentSubstitution;
	}

	public void resetSelectedFragmentSubstitution() {
		selectedFragmentSubstitution = null;
	}
	
	@Override
	protected String[] getFileds(){
		return fields;
	}
}
