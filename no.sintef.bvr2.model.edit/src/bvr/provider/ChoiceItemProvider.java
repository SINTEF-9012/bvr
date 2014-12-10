/**
 */
package bvr.provider;


import bvr.BvrFactory;
import bvr.BvrPackage;
import bvr.Choice;

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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link bvr.Choice} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ChoiceItemProvider
	extends VSpecItemProvider
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
	public ChoiceItemProvider(AdapterFactory adapterFactory) {
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

			addDefaultResolutionPropertyDescriptor(object);
			addIsImpliedByParentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Default Resolution feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultResolutionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Choice_defaultResolution_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Choice_defaultResolution_feature", "_UI_Choice_type"),
				 BvrPackage.Literals.CHOICE__DEFAULT_RESOLUTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Implied By Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsImpliedByParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Choice_isImpliedByParent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Choice_isImpliedByParent_feature", "_UI_Choice_type"),
				 BvrPackage.Literals.CHOICE__IS_IMPLIED_BY_PARENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(BvrPackage.Literals.VNODE__GROUP_MULTIPLICITY);
			childrenFeatures.add(BvrPackage.Literals.VNODE__OWNED_CONSTRAINT);
			childrenFeatures.add(BvrPackage.Literals.VNODE__VARIABLE);
			childrenFeatures.add(BvrPackage.Literals.COMPOUND_NODE__MEMBER);
			childrenFeatures.add(BvrPackage.Literals.COMPOUND_NODE__OWNED_TARGETS);
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
	 * This returns Choice.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Choice"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Choice)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Choice_type") :
			getString("_UI_Choice_type") + " " + label;
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

		switch (notification.getFeatureID(Choice.class)) {
			case BvrPackage.CHOICE__DEFAULT_RESOLUTION:
			case BvrPackage.CHOICE__IS_IMPLIED_BY_PARENT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case BvrPackage.CHOICE__GROUP_MULTIPLICITY:
			case BvrPackage.CHOICE__OWNED_CONSTRAINT:
			case BvrPackage.CHOICE__VARIABLE:
			case BvrPackage.CHOICE__MEMBER:
			case BvrPackage.CHOICE__OWNED_TARGETS:
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
				(BvrPackage.Literals.VNODE__GROUP_MULTIPLICITY,
				 BvrFactory.eINSTANCE.createMultiplicityInterval()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.VNODE__OWNED_CONSTRAINT,
				 BvrFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.VNODE__OWNED_CONSTRAINT,
				 BvrFactory.eINSTANCE.createOpaqueConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.VNODE__OWNED_CONSTRAINT,
				 BvrFactory.eINSTANCE.createBCLConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.VNODE__VARIABLE,
				 BvrFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.COMPOUND_NODE__MEMBER,
				 BvrFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.COMPOUND_NODE__MEMBER,
				 BvrFactory.eINSTANCE.createVClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.COMPOUND_NODE__MEMBER,
				 BvrFactory.eINSTANCE.createChoiceOccurrence()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.COMPOUND_NODE__MEMBER,
				 BvrFactory.eINSTANCE.createVType()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.COMPOUND_NODE__MEMBER,
				 BvrFactory.eINSTANCE.createVClassOccurrence()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.COMPOUND_NODE__OWNED_TARGETS,
				 BvrFactory.eINSTANCE.createTarget()));
	}

}
