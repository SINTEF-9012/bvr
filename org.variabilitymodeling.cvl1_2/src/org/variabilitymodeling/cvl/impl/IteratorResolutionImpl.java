/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl.impl;



import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.variabilitymodeling.cvl.CvlPackage;
import org.variabilitymodeling.cvl.Iterator;
import org.variabilitymodeling.cvl.IteratorResolution;
import org.variabilitymodeling.cvl.ResolutionElement;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator Resolution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.impl.IteratorResolutionImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.impl.IteratorResolutionImpl#getChoice <em>Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IteratorResolutionImpl extends ResolutionSpecificationImpl implements IteratorResolution {
	/**
	 * The cached value of the '{@link #getIterator() <em>Iterator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterator()
	 * @generated
	 * @ordered
	 */
	protected Iterator iterator;

	/**
	 * The cached value of the '{@link #getChoice() <em>Choice</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoice()
	 * @generated
	 * @ordered
	 */
	protected EList<ResolutionElement> choice;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IteratorResolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CvlPackage.Literals.ITERATOR_RESOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterator getIterator() {
		if (iterator != null && iterator.eIsProxy()) {
			InternalEObject oldIterator = (InternalEObject)iterator;
			iterator = (Iterator)eResolveProxy(oldIterator);
			if (iterator != oldIterator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CvlPackage.ITERATOR_RESOLUTION__ITERATOR, oldIterator, iterator));
			}
		}
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterator basicGetIterator() {
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterator(Iterator newIterator) {
		Iterator oldIterator = iterator;
		iterator = newIterator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CvlPackage.ITERATOR_RESOLUTION__ITERATOR, oldIterator, iterator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResolutionElement> getChoice() {
		if (choice == null) {
			choice = new EObjectContainmentEList<ResolutionElement>(ResolutionElement.class, this, CvlPackage.ITERATOR_RESOLUTION__CHOICE);
		}
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitIteratorResolution(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CvlPackage.ITERATOR_RESOLUTION__CHOICE:
				return ((InternalEList<?>)getChoice()).basicRemove(otherEnd, msgs);
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
			case CvlPackage.ITERATOR_RESOLUTION__ITERATOR:
				if (resolve) return getIterator();
				return basicGetIterator();
			case CvlPackage.ITERATOR_RESOLUTION__CHOICE:
				return getChoice();
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
			case CvlPackage.ITERATOR_RESOLUTION__ITERATOR:
				setIterator((Iterator)newValue);
				return;
			case CvlPackage.ITERATOR_RESOLUTION__CHOICE:
				getChoice().clear();
				getChoice().addAll((Collection<? extends ResolutionElement>)newValue);
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
			case CvlPackage.ITERATOR_RESOLUTION__ITERATOR:
				setIterator((Iterator)null);
				return;
			case CvlPackage.ITERATOR_RESOLUTION__CHOICE:
				getChoice().clear();
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
			case CvlPackage.ITERATOR_RESOLUTION__ITERATOR:
				return iterator != null;
			case CvlPackage.ITERATOR_RESOLUTION__CHOICE:
				return choice != null && !choice.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IteratorResolutionImpl
