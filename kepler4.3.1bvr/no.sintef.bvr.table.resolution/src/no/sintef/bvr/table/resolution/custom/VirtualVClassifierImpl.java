/**
 */
package no.sintef.bvr.table.resolution.custom;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import bvr.BvrPackage;
import bvr.VSpecResolution;
import bvr.impl.VSpecResolutionImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>VirtualVClassifier</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link no.sintef.bvr.model.impl.VInstanceImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated NOT
 */
public class VirtualVClassifierImpl extends VSpecResolutionImpl implements
		VirtualVClassifier {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated NOT
	 * @ordered
	 */
	protected VSpecResolution parent;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected VirtualVClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	protected EClass eStaticClass() {
		// This class is not in Bvr Model
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VSpecResolution getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) parent;
			parent = (VSpecResolution) eResolveProxy(oldType);
			if (parent != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BvrPackage.VINSTANCE__TYPE, oldType, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VSpecResolution basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(VSpecResolution newParent) {
		parent = newParent;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void eSet(int featureID, Object newValue) {

		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void eUnset(int featureID) {

		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {

		return super.eIsSet(featureID);
	}

} // VirtualVClassifierImpl
