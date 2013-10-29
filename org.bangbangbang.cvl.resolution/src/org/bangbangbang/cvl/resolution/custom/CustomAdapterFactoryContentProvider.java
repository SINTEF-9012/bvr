package org.bangbangbang.cvl.resolution.custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bangbangbang.cvl.VClassifier;
import org.bangbangbang.cvl.VInstance;
import org.bangbangbang.cvl.VSpec;
import org.bangbangbang.cvl.VSpecResolution;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

public class CustomAdapterFactoryContentProvider extends
		AdapterFactoryContentProvider {

	public CustomAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);

	}

	@Override
	public Object[] getChildren(Object object) {
		if (!(object instanceof VSpecResolution)) {
			// This is not VSpecResolution case
			return super.getChildren(object);
		} else if (object instanceof VirtualVClassifier) {
			// This object is Virtual.
			// This children are VInstance(ResolvedVClassifier is matched) of
			// child of parent of the object
			List<VSpecResolution> resolutionList = new ArrayList<VSpecResolution>();
			EList<VSpecResolution> childs = ((VirtualVClassifier) object)
					.getParent().getChild();

			for (Iterator<VSpecResolution> iterator = childs.iterator(); iterator
					.hasNext();) {
				VSpecResolution target = iterator.next();
				if (target instanceof VInstance
						&& ((VirtualVClassifier) object).getResolvedVSpec() == ((VInstance) target)
								.getResolvedVSpec()) {
					resolutionList.add((VSpecResolution) target);
				}
			}
			return resolutionList.toArray();
		} else {
			// For all VSpecResolution which may have VInstance,
			// Add Virtual VClassisfer as child to the object.
			List<VSpecResolution> resolutionList = new ArrayList<VSpecResolution>();
			Object[] objList = super.getChildren(object);

			for (int i = 0; i < objList.length; i++) {
				if (!(objList[i] instanceof VInstance)) {
					resolutionList.add((VSpecResolution) objList[i]);
				}
			}

			List<VSpec> vspecList = ((VSpecResolution) object)
					.getResolvedVSpec().getChild();
			for (Iterator<VSpec> iterator = vspecList.iterator(); iterator
					.hasNext();) {
				VSpec vs = iterator.next();
				if (vs instanceof VClassifier) {
					VirtualVClassifier virtual = (VirtualVClassifier) new VirtualVClassifierImpl();
					virtual.setResolvedVSpec(vs);
					virtual.setParent((VSpecResolution) object);
					resolutionList.add(virtual);
				}
			}

			return resolutionList.toArray();
		}
	}

	@Override
	public boolean hasChildren(Object object) {
		if (!(object instanceof VSpecResolution)) {
			return super.hasChildren(object);
		} else if (object instanceof VirtualVClassifier) {
			// When Virtual Classifier's parent's children are only VInstance of
			// zero, return false;
			EList<VSpecResolution> childs = ((VirtualVClassifier) object)
					.getParent().getChild();

			for (Iterator<VSpecResolution> iterator = childs.iterator(); iterator
					.hasNext();) {
				VSpecResolution target = iterator.next();
				if (target instanceof VInstance
						&& ((VirtualVClassifier) object).getResolvedVSpec() == ((VInstance) target)
								.getResolvedVSpec()) {
					return true;
				}
			}
			return false;
		} else {
			// When Normal VSpecResolution may have VInstance as a child,
			// return true;
			List<VSpec> vspecList = ((VSpecResolution) object)
					.getResolvedVSpec().getChild();
			for (Iterator<VSpec> iterator = vspecList.iterator(); iterator
					.hasNext();) {
				VSpec vs = iterator.next();
				if (vs instanceof VClassifier) {
					return true;
				}
			}

			return super.hasChildren(object);
		}
	}

	@Override
	public Object getParent(Object object) {
		// TODO Auto-generated method stub
		return super.getParent(object);
	}

}
