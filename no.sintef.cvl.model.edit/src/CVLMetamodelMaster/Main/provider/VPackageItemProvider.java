/**
 */
package CVLMetamodelMaster.Main.provider;


import CVLMetamodelMaster.Main.MainFactory;
import CVLMetamodelMaster.Main.MainPackage;
import CVLMetamodelMaster.Main.VPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link CVLMetamodelMaster.Main.VPackage} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VPackageItemProvider
	extends VPackageableItemProvider
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
	public VPackageItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT);
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
	 * This returns VPackage.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/VPackage"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((VPackage)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_VPackage_type") :
			getString("_UI_VPackage_type") + " " + label;
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

		switch (notification.getFeatureID(VPackage.class)) {
			case MainPackage.VPACKAGE__PACKAGE_ELEMENT:
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
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createVSpecDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createVClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createChoiceResolutuion()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createVInstance()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createFragmentSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createPlacementFragment()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createObjectSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createVariableValueAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createVInterface()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createSlotAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createObjectExistence()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createLinkEndSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createConfigurableUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createCVSpec()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createVConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createLinkExistence()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createOpaqueVariationPoint()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createOVPType()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createVPackage()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createOpaqueConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createSlotValueExistence()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createParametricLinkEndSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createParametricObjectSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createParametricSlotAssignmet()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createChoiceDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createVariableDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createCVSpecDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createConfigurableUnitUsage()));

		newChildDescriptors.add
			(createChildParameter
				(MainPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 MainFactory.eINSTANCE.createBCLConstraint()));
	}

}
