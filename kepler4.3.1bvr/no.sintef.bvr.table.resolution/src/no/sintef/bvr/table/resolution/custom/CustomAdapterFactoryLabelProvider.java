package no.sintef.bvr.table.resolution.custom;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;

public class CustomAdapterFactoryLabelProvider extends
		TransactionalAdapterFactoryLabelProvider {

	public CustomAdapterFactoryLabelProvider(TransactionalEditingDomain domain,
			AdapterFactory adapterFactory) {
		super(domain, adapterFactory);
	}

	@Override
	public String getText(Object object) {
		if (object instanceof VirtualVClassifier) {
			return "VClassifier: "
					+ ((VirtualVClassifier) object).getResolvedVSpec()
							.getName();
		} else {
			return super.getText(object);
		}
	}

}
