/**
 */
package org.bangbangbang.cvl.resolution.custom;

import org.bangbangbang.cvl.ChoiceResolutuion;
import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.provider.ChoiceResolutuionItemProvider;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link cvl.ChoiceResolutuion} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class CustomChoiceResolutuionItemProvider extends
		ChoiceResolutuionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CustomChoiceResolutuionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns ChoiceResolutuion.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/ChoiceResolutuion"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((ChoiceResolutuion) object).getResolvedChoice()
				.getName();
		if (((ChoiceResolutuion) object).getName() != null
				&& ((ChoiceResolutuion) object).getName().length() != 0) {
			label = ((ChoiceResolutuion) object).getName()
					+ " : "
					+ getString("_UI_Choice_type")
					+ " "
					+ ((ChoiceResolutuion) object).getResolvedChoice()
							.getName();
			return label;
		} else {
			return label == null || label.length() == 0 ? getString("_UI_Choice_type")
					: getString("_UI_Choice_type") + " " + label;
		}
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ChoiceResolutuion.class)) {
		case CvlPackage.CHOICE_RESOLUTUION__DECISION:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

}
