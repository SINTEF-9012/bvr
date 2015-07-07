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


import bvr.BVRModel;
import bvr.BvrFactory;
import bvr.BvrPackage;

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
 * This is the item provider adapter for a {@link bvr.BVRModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BVRModelItemProvider
	extends VPackageItemProvider
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
	public BVRModelItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(BvrPackage.Literals.BVR_MODEL__VARIABILITY_MODEL);
			childrenFeatures.add(BvrPackage.Literals.BVR_MODEL__RESOLUTION_MODELS);
			childrenFeatures.add(BvrPackage.Literals.BVR_MODEL__BASE_MODEL_BASE);
			childrenFeatures.add(BvrPackage.Literals.BVR_MODEL__BASE_MODEL_LIBRARIES);
			childrenFeatures.add(BvrPackage.Literals.BVR_MODEL__REALIZATION_MODEL);
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
	 * This returns BVRModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BVRModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((BVRModel)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_BVRModel_type") :
			getString("_UI_BVRModel_type") + " " + label;
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

		switch (notification.getFeatureID(BVRModel.class)) {
			case BvrPackage.BVR_MODEL__VARIABILITY_MODEL:
			case BvrPackage.BVR_MODEL__RESOLUTION_MODELS:
			case BvrPackage.BVR_MODEL__BASE_MODEL_BASE:
			case BvrPackage.BVR_MODEL__BASE_MODEL_LIBRARIES:
			case BvrPackage.BVR_MODEL__REALIZATION_MODEL:
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
				(BvrPackage.Literals.BVR_MODEL__VARIABILITY_MODEL,
				 BvrFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__VARIABILITY_MODEL,
				 BvrFactory.eINSTANCE.createVClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__VARIABILITY_MODEL,
				 BvrFactory.eINSTANCE.createVType()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__RESOLUTION_MODELS,
				 BvrFactory.eINSTANCE.createPosResolution()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__RESOLUTION_MODELS,
				 BvrFactory.eINSTANCE.createResolutionLiteralDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__BASE_MODEL_BASE,
				 BvrFactory.eINSTANCE.createObjectHandle()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__BASE_MODEL_LIBRARIES,
				 BvrFactory.eINSTANCE.createObjectHandle()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__REALIZATION_MODEL,
				 BvrFactory.eINSTANCE.createStagedVariationPoint()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__REALIZATION_MODEL,
				 BvrFactory.eINSTANCE.createFragmentSubstitution()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__REALIZATION_MODEL,
				 BvrFactory.eINSTANCE.createPlacementFragment()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__REALIZATION_MODEL,
				 BvrFactory.eINSTANCE.createSlotAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__REALIZATION_MODEL,
				 BvrFactory.eINSTANCE.createOpaqueVariationPoint()));

		newChildDescriptors.add
			(createChildParameter
				(BvrPackage.Literals.BVR_MODEL__REALIZATION_MODEL,
				 BvrFactory.eINSTANCE.createParametricSlotAssignment()));
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
			childFeature == BvrPackage.Literals.VPACKAGE__PACKAGE_ELEMENT ||
			childFeature == BvrPackage.Literals.BVR_MODEL__VARIABILITY_MODEL ||
			childFeature == BvrPackage.Literals.BVR_MODEL__BASE_MODEL_BASE ||
			childFeature == BvrPackage.Literals.BVR_MODEL__BASE_MODEL_LIBRARIES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
