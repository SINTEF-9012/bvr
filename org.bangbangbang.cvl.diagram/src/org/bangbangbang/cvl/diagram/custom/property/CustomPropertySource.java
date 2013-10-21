package org.bangbangbang.cvl.diagram.custom.property;

import org.bangbangbang.cvl.CvlPackage;
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
			return new ConstraintPropertyDescriptor(object,
					itemPropertyDescriptor);
			
		} else {
			return super.createPropertyDescriptor(itemPropertyDescriptor);
		}
	}

}
