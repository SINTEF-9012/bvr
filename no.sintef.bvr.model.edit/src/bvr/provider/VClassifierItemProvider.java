/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
/**
 */
package bvr.provider;


import bvr.BvrFactory;
import bvr.BvrPackage;
import bvr.VClassifier;

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
 * This is the item provider adapter for a {@link bvr.VClassifier} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VClassifierItemProvider
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
	public VClassifierItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(BvrPackage.Literals.VNODE__GROUP_MULTIPLICITY);
			childrenFeatures.add(BvrPackage.Literals.VNODE__OWNED_CONSTRAINT);
			childrenFeatures.add(BvrPackage.Literals.VNODE__VARIABLE);
			childrenFeatures.add(BvrPackage.Literals.COMPOUND_NODE__MEMBER);
			childrenFeatures.add(BvrPackage.Literals.COMPOUND_NODE__OWNED_TARGETS);
			childrenFeatures.add(BvrPackage.Literals.VCLASSIFIER__INSTANCE_MULTIPLICITY);
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
	 * This returns VClassifier.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/VClassifier"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((VClassifier)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_VClassifier_type") :
			getString("_UI_VClassifier_type") + " " + label;
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

		switch (notification.getFeatureID(VClassifier.class)) {
			case BvrPackage.VCLASSIFIER__GROUP_MULTIPLICITY:
			case BvrPackage.VCLASSIFIER__OWNED_CONSTRAINT:
			case BvrPackage.VCLASSIFIER__VARIABLE:
			case BvrPackage.VCLASSIFIER__MEMBER:
			case BvrPackage.VCLASSIFIER__OWNED_TARGETS:
			case BvrPackage.VCLASSIFIER__INSTANCE_MULTIPLICITY:
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

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.VCLASSIFIER__INSTANCE_MULTIPLICITY,
				 BvrFactory.eINSTANCE.createMultiplicityInterval()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == BvrPackage.Literals.VNODE__GROUP_MULTIPLICITY ||
			childFeature == BvrPackage.Literals.VCLASSIFIER__INSTANCE_MULTIPLICITY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
