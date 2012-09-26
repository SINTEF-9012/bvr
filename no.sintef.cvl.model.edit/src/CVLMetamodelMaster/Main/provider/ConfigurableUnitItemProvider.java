/**
 */
package CVLMetamodelMaster.Main.provider;


import CVLMetamodelMaster.Main.ConfigurableUnit;
import CVLMetamodelMaster.Main.MainFactory;
import CVLMetamodelMaster.Main.MainPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link CVLMetamodelMaster.Main.ConfigurableUnit} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurableUnitItemProvider
	extends CompositeVariationPointItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurableUnitItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addUnitInterfacePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Unit Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUnitInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConfigurableUnit_unitInterface_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConfigurableUnit_unitInterface_feature", "_UI_ConfigurableUnit_type"),
				 MainPackage.Literals.CONFIGURABLE_UNIT__UNIT_INTERFACE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC);
			childrenFeatures.add(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT);
			childrenFeatures.add(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT);
			childrenFeatures.add(MainPackage.Literals.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT);
			childrenFeatures.add(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION);
			childrenFeatures.add(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ConfigurableUnit.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConfigurableUnit"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ConfigurableUnit)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ConfigurableUnit_type") :
			getString("_UI_ConfigurableUnit_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ConfigurableUnit.class)) {
			case MainPackage.CONFIGURABLE_UNIT__OWNED_VSPEC:
			case MainPackage.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT:
			case MainPackage.CONFIGURABLE_UNIT__OWNED_CONSTRAINT:
			case MainPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT:
			case MainPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION:
			case MainPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
				 MainFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
				 MainFactory.eINSTANCE.createVClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
				 MainFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
				 MainFactory.eINSTANCE.createCVSpec()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createFragmentSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createPlacementFragment()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createObjectSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createSlotAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createObjectExistence()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createLinkEndSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createConfigurableUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createLinkExistence()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createOpaqueVariationPoint()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createSlotValueExistence()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createParametricLinkEndSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createParametricObjectSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createParametricSlotAssignmet()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 MainFactory.eINSTANCE.createConfigurableUnitUsage()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
				 MainFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
				 MainFactory.eINSTANCE.createOpaqueConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
				 MainFactory.eINSTANCE.createBCLConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT,
				 MainFactory.eINSTANCE.createObjectHandle()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				 MainFactory.eINSTANCE.createChoiceResolutuion()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				 MainFactory.eINSTANCE.createVInstance()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				 MainFactory.eINSTANCE.createVariableValueAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				 MainFactory.eINSTANCE.createVConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
				 MainFactory.eINSTANCE.createVSpecDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
				 MainFactory.eINSTANCE.createChoiceDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
				 MainFactory.eINSTANCE.createVariableDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
				 MainFactory.eINSTANCE.createCVSpecDerivation()));
	}

}
