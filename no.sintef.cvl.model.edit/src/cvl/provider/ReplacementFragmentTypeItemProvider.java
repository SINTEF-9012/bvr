/**
 */
package cvl.provider;


import cvl.CvlFactory;
import cvl.CvlPackage;
import cvl.ReplacementFragmentType;

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
 * This is the item provider adapter for a {@link cvl.ReplacementFragmentType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReplacementFragmentTypeItemProvider
	extends VariabletypeItemProvider
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
	public ReplacementFragmentTypeItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(CvlPackage.Literals.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT);
			childrenFeatures.add(CvlPackage.Literals.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT);
			childrenFeatures.add(CvlPackage.Literals.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT);
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
	 * This returns ReplacementFragmentType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ReplacementFragmentType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ReplacementFragmentType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ReplacementFragmentType_type") :
			getString("_UI_ReplacementFragmentType_type") + " " + label;
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

		switch (notification.getFeatureID(ReplacementFragmentType.class)) {
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT:
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT:
			case CvlPackage.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT:
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
				(CvlPackage.Literals.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT,
				 CvlFactory.eINSTANCE.createToReplacement()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.REPLACEMENT_FRAGMENT_TYPE__REPLACEMENT_BOUNDARY_ELEMENT,
				 CvlFactory.eINSTANCE.createFromReplacement()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.REPLACEMENT_FRAGMENT_TYPE__PLACEMENT_FRAGMENT,
				 CvlFactory.eINSTANCE.createPlacementFragment()));

		newChildDescriptors.add
			(createChildParameter
				(CvlPackage.Literals.REPLACEMENT_FRAGMENT_TYPE__SOURCE_OBJECT,
				 CvlFactory.eINSTANCE.createObjectHandle()));
	}

}
