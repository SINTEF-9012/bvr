/**
 */
package cvl.impl;

import cvl.ConfigurableUnit;
import cvl.Constraint;
import cvl.CvlPackage;
import cvl.ObjectHandle;
import cvl.VInterface;
import cvl.VSpec;
import cvl.VSpecDerivation;
import cvl.VSpecResolution;
import cvl.Variabletype;
import cvl.VariationPoint;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configurable Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cvl.impl.ConfigurableUnitImpl#getOwnedVSpec <em>Owned VSpec</em>}</li>
 *   <li>{@link cvl.impl.ConfigurableUnitImpl#getOwnedVariationPoint <em>Owned Variation Point</em>}</li>
 *   <li>{@link cvl.impl.ConfigurableUnitImpl#getOwnedConstraint <em>Owned Constraint</em>}</li>
 *   <li>{@link cvl.impl.ConfigurableUnitImpl#getConfigurableContainerObject <em>Configurable Container Object</em>}</li>
 *   <li>{@link cvl.impl.ConfigurableUnitImpl#getOwnedVSpecResolution <em>Owned VSpec Resolution</em>}</li>
 *   <li>{@link cvl.impl.ConfigurableUnitImpl#getUnitInterface <em>Unit Interface</em>}</li>
 *   <li>{@link cvl.impl.ConfigurableUnitImpl#getOwnedVSpecDerivation <em>Owned VSpec Derivation</em>}</li>
 *   <li>{@link cvl.impl.ConfigurableUnitImpl#getOwnedVariabletype <em>Owned Variabletype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurableUnitImpl extends CompositeVariationPointImpl implements ConfigurableUnit {
	/**
	 * The cached value of the '{@link #getOwnedVSpec() <em>Owned VSpec</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVSpec()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpec> ownedVSpec;

	/**
	 * The cached value of the '{@link #getOwnedVariationPoint() <em>Owned Variation Point</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVariationPoint()
	 * @generated
	 * @ordered
	 */
	protected EList<VariationPoint> ownedVariationPoint;

	/**
	 * The cached value of the '{@link #getOwnedConstraint() <em>Owned Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> ownedConstraint;

	/**
	 * The cached value of the '{@link #getConfigurableContainerObject() <em>Configurable Container Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurableContainerObject()
	 * @generated
	 * @ordered
	 */
	protected ObjectHandle configurableContainerObject;

	/**
	 * The cached value of the '{@link #getOwnedVSpecResolution() <em>Owned VSpec Resolution</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVSpecResolution()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpecResolution> ownedVSpecResolution;

	/**
	 * The cached value of the '{@link #getOwnedVSpecDerivation() <em>Owned VSpec Derivation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVSpecDerivation()
	 * @generated
	 * @ordered
	 */
	protected EList<VSpecDerivation> ownedVSpecDerivation;

	/**
	 * The cached value of the '{@link #getOwnedVariabletype() <em>Owned Variabletype</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVariabletype()
	 * @generated
	 * @ordered
	 */
	protected EList<Variabletype> ownedVariabletype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurableUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.CONFIGURABLE_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpec> getOwnedVSpec() {
		if (ownedVSpec == null) {
			ownedVSpec = new EObjectContainmentEList<VSpec>(VSpec.class, this, CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC);
		}
		return ownedVSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariationPoint> getOwnedVariationPoint() {
		if (ownedVariationPoint == null) {
			ownedVariationPoint = new EObjectContainmentEList<VariationPoint>(VariationPoint.class, this, CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT);
		}
		return ownedVariationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getOwnedConstraint() {
		if (ownedConstraint == null) {
			ownedConstraint = new EObjectContainmentEList<Constraint>(Constraint.class, this, CvlPackage.CONFIGURABLE_UNIT__OWNED_CONSTRAINT);
		}
		return ownedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectHandle getConfigurableContainerObject() {
		return configurableContainerObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfigurableContainerObject(ObjectHandle newConfigurableContainerObject, NotificationChain msgs) {
		ObjectHandle oldConfigurableContainerObject = configurableContainerObject;
		configurableContainerObject = newConfigurableContainerObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT, oldConfigurableContainerObject, newConfigurableContainerObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurableContainerObject(ObjectHandle newConfigurableContainerObject) {
		if (newConfigurableContainerObject != configurableContainerObject) {
			NotificationChain msgs = null;
			if (configurableContainerObject != null)
				msgs = ((InternalEObject)configurableContainerObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT, null, msgs);
			if (newConfigurableContainerObject != null)
				msgs = ((InternalEObject)newConfigurableContainerObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT, null, msgs);
			msgs = basicSetConfigurableContainerObject(newConfigurableContainerObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT, newConfigurableContainerObject, newConfigurableContainerObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpecResolution> getOwnedVSpecResolution() {
		if (ownedVSpecResolution == null) {
			ownedVSpecResolution = new EObjectContainmentEList<VSpecResolution>(VSpecResolution.class, this, CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION);
		}
		return ownedVSpecResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VInterface getUnitInterface() {
		VInterface unitInterface = basicGetUnitInterface();
		return unitInterface != null && unitInterface.eIsProxy() ? (VInterface)eResolveProxy((InternalEObject)unitInterface) : unitInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VInterface basicGetUnitInterface() {
		// TODO: implement this method to return the 'Unit Interface' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		//throw new UnsupportedOperationException();
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitInterface(VInterface newUnitInterface) {
		// TODO: implement this method to set the 'Unit Interface' reference
		// Ensure that you remove @generated or mark it @generated NOT
		//throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VSpecDerivation> getOwnedVSpecDerivation() {
		if (ownedVSpecDerivation == null) {
			ownedVSpecDerivation = new EObjectContainmentEList<VSpecDerivation>(VSpecDerivation.class, this, CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION);
		}
		return ownedVSpecDerivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variabletype> getOwnedVariabletype() {
		if (ownedVariabletype == null) {
			ownedVariabletype = new EObjectContainmentEList<Variabletype>(Variabletype.class, this, CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE);
		}
		return ownedVariabletype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC:
				return ((InternalEList<?>)getOwnedVSpec()).basicRemove(otherEnd, msgs);
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT:
				return ((InternalEList<?>)getOwnedVariationPoint()).basicRemove(otherEnd, msgs);
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_CONSTRAINT:
				return ((InternalEList<?>)getOwnedConstraint()).basicRemove(otherEnd, msgs);
			case CvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT:
				return basicSetConfigurableContainerObject(null, msgs);
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION:
				return ((InternalEList<?>)getOwnedVSpecResolution()).basicRemove(otherEnd, msgs);
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION:
				return ((InternalEList<?>)getOwnedVSpecDerivation()).basicRemove(otherEnd, msgs);
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE:
				return ((InternalEList<?>)getOwnedVariabletype()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC:
				return getOwnedVSpec();
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT:
				return getOwnedVariationPoint();
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_CONSTRAINT:
				return getOwnedConstraint();
			case CvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT:
				return getConfigurableContainerObject();
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION:
				return getOwnedVSpecResolution();
			case CvlPackage.CONFIGURABLE_UNIT__UNIT_INTERFACE:
				if (resolve) return getUnitInterface();
				return basicGetUnitInterface();
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION:
				return getOwnedVSpecDerivation();
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE:
				return getOwnedVariabletype();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC:
				getOwnedVSpec().clear();
				getOwnedVSpec().addAll((Collection<? extends VSpec>)newValue);
				return;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT:
				getOwnedVariationPoint().clear();
				getOwnedVariationPoint().addAll((Collection<? extends VariationPoint>)newValue);
				return;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_CONSTRAINT:
				getOwnedConstraint().clear();
				getOwnedConstraint().addAll((Collection<? extends Constraint>)newValue);
				return;
			case CvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT:
				setConfigurableContainerObject((ObjectHandle)newValue);
				return;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION:
				getOwnedVSpecResolution().clear();
				getOwnedVSpecResolution().addAll((Collection<? extends VSpecResolution>)newValue);
				return;
			case CvlPackage.CONFIGURABLE_UNIT__UNIT_INTERFACE:
				setUnitInterface((VInterface)newValue);
				return;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION:
				getOwnedVSpecDerivation().clear();
				getOwnedVSpecDerivation().addAll((Collection<? extends VSpecDerivation>)newValue);
				return;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE:
				getOwnedVariabletype().clear();
				getOwnedVariabletype().addAll((Collection<? extends Variabletype>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC:
				getOwnedVSpec().clear();
				return;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT:
				getOwnedVariationPoint().clear();
				return;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_CONSTRAINT:
				getOwnedConstraint().clear();
				return;
			case CvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT:
				setConfigurableContainerObject((ObjectHandle)null);
				return;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION:
				getOwnedVSpecResolution().clear();
				return;
			case CvlPackage.CONFIGURABLE_UNIT__UNIT_INTERFACE:
				setUnitInterface((VInterface)null);
				return;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION:
				getOwnedVSpecDerivation().clear();
				return;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE:
				getOwnedVariabletype().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC:
				return ownedVSpec != null && !ownedVSpec.isEmpty();
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIATION_POINT:
				return ownedVariationPoint != null && !ownedVariationPoint.isEmpty();
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_CONSTRAINT:
				return ownedConstraint != null && !ownedConstraint.isEmpty();
			case CvlPackage.CONFIGURABLE_UNIT__CONFIGURABLE_CONTAINER_OBJECT:
				return configurableContainerObject != null;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_RESOLUTION:
				return ownedVSpecResolution != null && !ownedVSpecResolution.isEmpty();
			case CvlPackage.CONFIGURABLE_UNIT__UNIT_INTERFACE:
				return basicGetUnitInterface() != null;
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VSPEC_DERIVATION:
				return ownedVSpecDerivation != null && !ownedVSpecDerivation.isEmpty();
			case CvlPackage.CONFIGURABLE_UNIT__OWNED_VARIABLETYPE:
				return ownedVariabletype != null && !ownedVariabletype.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConfigurableUnitImpl
