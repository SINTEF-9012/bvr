package org.bangbangbang.cvl.resolution.custom;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

public class CustomAdapterFactoryLabelProvider extends
		AdapterFactoryLabelProvider {

	public CustomAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		if(object instanceof VirtualVClassifier){
			return "VClassifier: " + ((VirtualVClassifier)object).getResolvedVSpec().getName();
		}else{
			return super.getText(object);
		}
	}
	

}
