package no.sintef.bvr.tool.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import no.sintef.bvr.thirdparty.common.Utility;
import no.sintef.bvr.tool.interfaces.model.IBVREditingDomain;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class BVRExecutionEditingDomain implements IBVREditingDomain {

	private ResourceSet resourceSet;
	private TransactionalEditingDomain editingDomain;
	private List<String> messages;

	public BVRExecutionEditingDomain(ResourceSet _resourceSet) {
		resourceSet = _resourceSet;
		messages = new ArrayList<String>();
		editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
		setUpResouceListener();
	}

	@Override
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	@Override
	public List<String> getErrorMessages() {
		return messages;
	}

	@Override
	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}

	private void setUpResouceListener() {
		editingDomain.addResourceSetListener(new ResourceSetListenerImpl() {

			@Override
			public void resourceSetChanged(ResourceSetChangeEvent event) {
				Transaction transaction = event.getTransaction();
				if (transaction == null)
					return;
				HashMap<String, Object> info = Utility.parseTransaction(transaction);
				if ((Boolean) info.get(Utility.isOk))
					return;
				event.getEditingDomain().getResourceSet();
				messages.add((String) info.get(Utility.message));
			}

		});
	}
}
