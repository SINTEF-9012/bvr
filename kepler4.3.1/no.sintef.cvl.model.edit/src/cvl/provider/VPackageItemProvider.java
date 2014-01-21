/**
 */
package cvl.provider;


import cvl.CvlFactory;
import cvl.CvlPackage;
import cvl.VPackage;

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
 * This is the item provider adapter for a {@link cvl.VPackage} object.
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
			childrenFeatures.add(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT);
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
			case CvlPackage.VPACKAGE__PACKAGE_ELEMENT:
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
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createVSpecDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createVClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createChoiceResolutuion()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createVInstance()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createFragmentSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createPlacementFragment()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createVariabletype()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createReplacementFragmentType()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createObjectSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createVariableValueAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createPrimitveType()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createObjectType()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createVInterface()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createSlotAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createObjectExistence()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createLinkEndSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createConfigurableUnit()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createCVSpec()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createVConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createLinkExistence()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createOpaqueVariationPoint()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createOVPType()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createVPackage()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createOpaqueConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createSlotValueExistence()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createParametricLinkEndSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createParametricObjectSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createParametricSlotAssignmet()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createChoiceDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createVariableDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createCVSpecDerivation()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createConfigurableUnitUsage()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.VPACKAGE__PACKAGE_ELEMENT,
				 CvlFactory.eINSTANCE.createBCLConstraint()));
	}

}
