/**
 */
package org.bangbangbang.cvl.resolution.custom;

import java.util.ArrayList;
import java.util.Collection;

import org.bangbangbang.cvl.ConfigurableUnit;
import org.bangbangbang.cvl.CvlFactory;
import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.provider.ConfigurableUnitItemProvider;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link cvl.ConfigurableUnit} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class CustomConfigurableUnitItemProvider extends
		ConfigurableUnitItemProvider {

	public CustomConfigurableUnitItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT Remove without resolution children
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			// super.getChildrenFeatures(object);
			childrenFeatures = new ArrayList<EStructuralFeature>();
			// childrenFeatures
			// .add(CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC);
			// childrenFeatures
			// .add(CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT);
			// childrenFeatures
			// .add(CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT);
			// childrenFeatures
			// .add(CvlPackage.Literals.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT);
			childrenFeatures
					.add(CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION);
			// childrenFeatures
			// .add(CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION);
			// childrenFeatures
			// .add(CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE);
		}
		return childrenFeatures;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT Remove without resolution
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ConfigurableUnit.class)) {
		// case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC:
		// case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT:
		// case CvlPackage.CONFIGURABLE_UNIT__OWNED_CONSTRAINT:
		// case CvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT:
		case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION:
			// case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION:
			// case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
			return;
		}

		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT Remove without resolution
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {

		// super.collectNewChildDescriptors(newChildDescriptors, object);

		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
		// CvlFactory.eINSTANCE.createChoice()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
		// CvlFactory.eINSTANCE.createVClassifier()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
		// CvlFactory.eINSTANCE.createVariable()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
		// CvlFactory.eINSTANCE.createCVSpec()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createFragmentSubstitution()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createPlacementFragment()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createObjectSubstitution()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createSlotAssignment()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createObjectExistence()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createLinkEndSubstitution()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createConfigurableUnit()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createLinkExistence()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createOpaqueVariationPoint()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createToPlacement()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createToReplacement()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createFromPlacement()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createFromReplacement()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createSlotValueExistence()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createParametricLinkEndSubstitution()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createParametricObjectSubstitution()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createParametricSlotAssignmet()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// CvlFactory.eINSTANCE.createConfigurableUnitUsage()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
		// CvlFactory.eINSTANCE.createConstraint()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
		// CvlFactory.eINSTANCE.createOpaqueConstraint()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
		// CvlFactory.eINSTANCE.createBCLConstraint()));
		//
		// newChildDescriptors
		// .add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT,
		// CvlFactory.eINSTANCE.createObjectHandle()));

		newChildDescriptors.add(createChildParameter(
				CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				CvlFactory.eINSTANCE.createChoiceResolutuion()));

		newChildDescriptors.add(createChildParameter(
				CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				CvlFactory.eINSTANCE.createVInstance()));

		newChildDescriptors.add(createChildParameter(
				CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				CvlFactory.eINSTANCE.createVariableValueAssignment()));

		newChildDescriptors.add(createChildParameter(
				CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				CvlFactory.eINSTANCE.createVConfiguration()));

		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
		// CvlFactory.eINSTANCE.createVSpecDerivation()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
		// CvlFactory.eINSTANCE.createChoiceDerivation()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
		// CvlFactory.eINSTANCE.createVariableDerivation()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
		// CvlFactory.eINSTANCE.createCVSpecDerivation()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE,
		// CvlFactory.eINSTANCE.createVariabletype()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE,
		// CvlFactory.eINSTANCE.createReplacementFragmentType()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE,
		// CvlFactory.eINSTANCE.createPrimitveType()));
		//
		// newChildDescriptors.add(createChildParameter(
		// CvlPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE,
		// CvlFactory.eINSTANCE.createObjectType()));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ConfigurableUnit) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ConfigurableUnit_type")
				: getString("_UI_ConfigurableUnit_type") + " " + label;
	}

	/**
	 * This returns the label text for
	 * {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == CvlPackage.Literals.VARIATION_POINT__SOURCE_OBJECT
				|| childFeature == CvlPackage.Literals.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] {
					getTypeText(childObject), getFeatureText(childFeature),
					getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
