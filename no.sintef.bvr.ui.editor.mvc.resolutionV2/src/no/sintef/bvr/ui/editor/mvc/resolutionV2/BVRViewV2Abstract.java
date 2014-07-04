package no.sintef.bvr.ui.editor.mvc.resolutionV2;

import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import bvr.ConfigurableUnit;

public abstract class BVRViewV2Abstract implements BVRViewV2 {

	@Override
	public BVRUIKernel getKernel() {
		throw new UnsupportedOperationException("not supported for this view"); 

	}

	@Override
	public ConfigurableUnitSubject getConfigurableUnitSubject() {
		throw new UnsupportedOperationException("not supported for this view"); 

	}

	@Override
	public ConfigurableUnit getCU() {
		throw new UnsupportedOperationException("not supported for this view"); 

	}

	@Override
	public BVRModel getModel() {
		throw new UnsupportedOperationException("not supported for this view"); 

	}

	@Override
	public void setMaximized(Object v) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not supported for this view"); 
	}

	@Override
	public void setMinimized(Object v) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not supported for this view"); 
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not supported for this view"); 
	}

	@Override
	public void setStripped(Object v) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not supported for this view"); 
	}

	@Override
	public void setUnstripped(Object v) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not supported for this view"); 
	}

}
