package org.bangbangbang.cvl.diagram.custom.property;

import org.bangbangbang.cvl.ConfigurableUnit;
import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.VInterface;
import org.bangbangbang.cvl.VPackageable;
import org.bangbangbang.cvl.diagram.custom.ocl.OCLCustomUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class CustomPropertySource extends PropertySource {

	public CustomPropertySource(Object object,
			IItemPropertySource itemPropertySource) {
		super(object, itemPropertySource);
	}

	@Override
	protected IPropertyDescriptor createPropertyDescriptor(
			IItemPropertyDescriptor itemPropertyDescriptor) {
		CvlPackage pkg = CvlPackage.eINSTANCE;
		Object feature = itemPropertyDescriptor.getFeature(object);

		// OpaqueConstraint Constraint property
		// delegate to ConstraintPropertyDescripter
		if (pkg.getOpaqueConstraint_Constraint().equals(feature)) {
			// Set Keywords from names in Model instance

			OCLCustomUtil.getInstance().setKeywordInModel(
					getRoot((EObject) this.object));

			return new ConstraintPropertyDescriptor(object,
					itemPropertyDescriptor);
		} else {
			return super.createPropertyDescriptor(itemPropertyDescriptor);
		}
	}

	private VPackageable getRoot(EObject node) {
		EObject root = node;
		while (!(root instanceof ConfigurableUnit || root instanceof VInterface)) {
			root = root.eContainer();
		}
		return (VPackageable) root;
	}
}
