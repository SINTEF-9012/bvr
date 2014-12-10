/**
 */
package no.sintef.bvr.table.resolution.custom;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ViewerNotification;

import bvr.ConfigurableUnit;
import bvr.BvrFactory;
import bvr.BvrPackage;
import bvr.provider.ConfigurableUnitItemProvider;

/**
 * This is the item provider adapter for a {@link bvr.ConfigurableUnit} object.
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
			// .add(BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC);
			// childrenFeatures
			// .add(BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT);
			// childrenFeatures
			// .add(BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT);
			// childrenFeatures
			// .add(BvrPackage.Literals.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT);
			childrenFeatures
					.add(BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION);
			// childrenFeatures
			// .add(BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION);
			// childrenFeatures
			// .add(BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE);
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
		// case BvrPackage.CONFIGURABLE_UNIT__OWNED_VSPEC:
		// case BvrPackage.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT:
		// case BvrPackage.CONFIGURABLE_UNIT__OWNED_CONSTRAINT:
		// case BvrPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT:
		case BvrPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION:
			// case BvrPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION:
			// case BvrPackage.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE:
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
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
		// BvrFactory.eINSTANCE.createChoice()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
		// BvrFactory.eINSTANCE.createVClassifier()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
		// BvrFactory.eINSTANCE.createVariable()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC,
		// BvrFactory.eINSTANCE.createCVSpec()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createFragmentSubstitution()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createPlacementFragment()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createObjectSubstitution()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createSlotAssignment()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createObjectExistence()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createLinkEndSubstitution()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createConfigurableUnit()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createLinkExistence()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createOpaqueVariationPoint()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createToPlacement()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createToReplacement()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createFromPlacement()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createFromReplacement()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createSlotValueExistence()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createParametricLinkEndSubstitution()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createParametricObjectSubstitution()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createParametricSlotAssignmet()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT,
		// BvrFactory.eINSTANCE.createConfigurableUnitUsage()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
		// BvrFactory.eINSTANCE.createConstraint()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
		// BvrFactory.eINSTANCE.createOpaqueConstraint()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_CONSTRAINT,
		// BvrFactory.eINSTANCE.createBCLConstraint()));
		//
		// newChildDescriptors
		// .add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT,
		// BvrFactory.eINSTANCE.createObjectHandle()));

		newChildDescriptors.add(createChildParameter(
				BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				BvrFactory.eINSTANCE.createChoiceResolutuion()));

		newChildDescriptors.add(createChildParameter(
				BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				BvrFactory.eINSTANCE.createVInstance()));

		newChildDescriptors.add(createChildParameter(
				BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				BvrFactory.eINSTANCE.createVariableValueAssignment()));

		newChildDescriptors.add(createChildParameter(
				BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION,
				BvrFactory.eINSTANCE.createVConfiguration()));

		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
		// BvrFactory.eINSTANCE.createVSpecDerivation()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
		// BvrFactory.eINSTANCE.createChoiceDerivation()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
		// BvrFactory.eINSTANCE.createVariableDerivation()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION,
		// BvrFactory.eINSTANCE.createCVSpecDerivation()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE,
		// BvrFactory.eINSTANCE.createVariabletype()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE,
		// BvrFactory.eINSTANCE.createReplacementFragmentType()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE,
		// BvrFactory.eINSTANCE.createPrimitveType()));
		//
		// newChildDescriptors.add(createChildParameter(
		// BvrPackage.Literals.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE,
		// BvrFactory.eINSTANCE.createObjectType()));
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

		boolean qualify = childFeature == BvrPackage.Literals.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] {
					getTypeText(childObject), getFeatureText(childFeature),
					getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
