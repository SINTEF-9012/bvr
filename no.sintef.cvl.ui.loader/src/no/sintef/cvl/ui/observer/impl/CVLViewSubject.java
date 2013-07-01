package no.sintef.cvl.ui.observer.impl;

import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.primitive.impl.ObserverDataBulk;

public class CVLViewSubject extends AbstractViewSubject {

	private CVLView cvlView;

	public CVLViewSubject(CVLView view){
		cvlView = view;
	}
	
	@Override
	public void setState(ObserverDataBulk data) {
		Object field = data.getDataField("cvlView");
		if(field instanceof CVLView){
			cvlView = (CVLView) field;
		}
	}

	public CVLView getCvlView() {
		return cvlView;
	}
}
