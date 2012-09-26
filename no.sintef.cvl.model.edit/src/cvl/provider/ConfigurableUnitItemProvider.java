/**
 */
package cvl.provider;


import cvl.ConfigurableUnit;
import cvl.cvlFactory;
import cvl.cvlPackage;

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
 * This is the item provider adapter for a {@link cvl.ConfigurableUnit} object.
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
				 cvlPackage.Literals.CONFIGURABLE_UNIT__UNIT_INTERFACE,
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
			childrenFeatures.add(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC);
			childrenFeatures.add(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT);
			childrenFeatures.add(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT);
			childrenFeatures.add(cvlPackage.Literals.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT);
			childrenFeatures.add(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION);
			childrenFeatures.add(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION);
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
			case cvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC:
			case cvlPackage.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT:
			case cvlPackage.CONFIGURABLE_UNIT__OWNED_CONSTRAINT:
			case cvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT:
			case cvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION:
			case cvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION:
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
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
				 cvlFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
				 cvlFactory.eINSTANCE.createVClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
				 cvlFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
				 cvlFactory.eINSTANCE.createCVSpec()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createFragmentSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createPlacementFragment()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createObjectSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createSlotAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createObjectExistence()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createLinkEndSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createConfigurableUnit()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createLinkExistence()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createOpaqueVariationPoint()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createSlotValueExistence()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createParametricLinkEndSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createParametricObjectSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createParametricSlotAssignmet()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
				 cvlFactory.eINSTANCE.createConfigurableUnitUsage()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
				 cvlFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
				 cvlFactory.eINSTANCE.createOpaqueConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
				 cvlFactory.eINSTANCE.createBCLConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT,
				 cvlFactory.eINSTANCE.createObjectHandle()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				 cvlFactory.eINSTANCE.createChoiceResolutuion()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				 cvlFactory.eINSTANCE.createVInstance()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				 cvlFactory.eINSTANCE.createVariableValueAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				 cvlFactory.eINSTANCE.createVConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
				 cvlFactory.eINSTANCE.createVSpecDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
				 cvlFactory.eINSTANCE.createChoiceDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
				 cvlFactory.eINSTANCE.createVariableDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(cvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
				 cvlFactory.eINSTANCE.createCVSpecDerivation()));
	}

}
