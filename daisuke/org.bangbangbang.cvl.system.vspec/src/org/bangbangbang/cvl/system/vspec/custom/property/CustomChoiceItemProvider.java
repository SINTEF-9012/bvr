package org.bangbangbang.cvl.system.vspec.custom.property;

import java.util.List;

import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.provider.ChoiceItemProvider;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

public class CustomChoiceItemProvider extends ChoiceItemProvider {

	public CustomChoiceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		super.getPropertyDescriptors(object);

		addRelationPropertyDescriptor(object);

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the relation . <!-- begin-user-doc
	 * --> INTEGER_LITERAL_EXP__INTEGER is dummy feature. <!-- end-user-doc -->
	 * 
	 * 
	 * @generated NOT
	 */
	protected void addRelationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				"Relation ", "",
				CvlPackage.Literals.INTEGER_LITERAL_EXP__INTEGER, true, true,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null) {

			@Override
			public Object getPropertyValue(Object object) {
				return "";
			}

			@Override
			public void setPropertyValue(Object object, Object value) {
				return;
			}

		});
	}

}
