package no.sintef.cvl.ui.observer.impl;

import cvl.FragmentSubstitution;
import no.sintef.cvl.ui.primitive.impl.ObserverDataBulk;

public class SelectedFragmentSubstitutionSubject extends AbstractViewSubject {

	private FragmentSubstitution selectedFragmentSubstitution;
	
	public SelectedFragmentSubstitutionSubject(FragmentSubstitution fs){
		this.selectedFragmentSubstitution = fs;
	}
	
	@Override
	public void setState(ObserverDataBulk data) {
		Object object = data.getDataField("selectedFragmentSubstitution");
		if(object instanceof FragmentSubstitution)
			selectedFragmentSubstitution = (FragmentSubstitution) object;
	}
	
	public FragmentSubstitution getSelectedFragmentSubstitution(){
		return selectedFragmentSubstitution;
	}
	
	public void resetSelectedFragmentSubstitution(){
		selectedFragmentSubstitution = null;
	}

	@Override
	public boolean isApplicable(ObserverDataBulk data) {
		Object object = data.getDataField("selectedFragmentSubstitution");
		if(object instanceof FragmentSubstitution){
			return true;
		}
		return false;
	}

}
