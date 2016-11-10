/**
 */
package realop.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import realop.RealopFactory;
import realop.RealopPackage;
import realop.XorExp;

/**
 * This is the item provider adapter for a {@link realop.XorExp} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class XorExpItemProvider extends ExpressionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XorExpItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(RealopPackage.Literals.XOR_EXP__LEFT);
			childrenFeatures.add(RealopPackage.Literals.XOR_EXP__RIGHT);
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
	 * This returns XorExp.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/XorExp"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_XorExp_type");
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

		switch (notification.getFeatureID(XorExp.class)) {
			case RealopPackage.XOR_EXP__LEFT:
			case RealopPackage.XOR_EXP__RIGHT:
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
				(RealopPackage.Literals.XOR_EXP__LEFT,
				 RealopFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__LEFT,
				 RealopFactory.eINSTANCE.createOrExp()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__LEFT,
				 RealopFactory.eINSTANCE.createAndExp()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__LEFT,
				 RealopFactory.eINSTANCE.createXorExp()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__LEFT,
				 RealopFactory.eINSTANCE.createNotExp()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__LEFT,
				 RealopFactory.eINSTANCE.createIsRealised()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__LEFT,
				 RealopFactory.eINSTANCE.createIsPositive()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__LEFT,
				 RealopFactory.eINSTANCE.createIsNegative()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__RIGHT,
				 RealopFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__RIGHT,
				 RealopFactory.eINSTANCE.createOrExp()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__RIGHT,
				 RealopFactory.eINSTANCE.createAndExp()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__RIGHT,
				 RealopFactory.eINSTANCE.createXorExp()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__RIGHT,
				 RealopFactory.eINSTANCE.createNotExp()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__RIGHT,
				 RealopFactory.eINSTANCE.createIsRealised()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__RIGHT,
				 RealopFactory.eINSTANCE.createIsPositive()));

		newChildDescriptors.add
			(createChildParameter
				(RealopPackage.Literals.XOR_EXP__RIGHT,
				 RealopFactory.eINSTANCE.createIsNegative()));
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
			childFeature == RealopPackage.Literals.XOR_EXP__LEFT ||
			childFeature == RealopPackage.Literals.XOR_EXP__RIGHT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
