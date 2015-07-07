/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Placement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * FromPlacement is the kind of boundary element that defines the outwards boundary of the owning placement fragment. The
 * outsideBoundaryElement refers to the model elements on the outside of the placement fragment. In a fragment substitution
 * these have to be referred by model elements within the replacement fragment.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.FromPlacement#getFromReplacement <em>From Replacement</em>}</li>
 *   <li>{@link bvr.FromPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 *   <li>{@link bvr.FromPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getFromPlacement()
 * @model
 * @generated
 */
public interface FromPlacement extends PlacementBoundaryElement {
	/**
	 * Returns the value of the '<em><b>From Replacement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link bvr.FromReplacement#getFromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to a FromReplacement in a containing replacement fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From Replacement</em>' reference.
	 * @see #setFromReplacement(FromReplacement)
	 * @see bvr.BvrPackage#getFromPlacement_FromReplacement()
	 * @see bvr.FromReplacement#getFromPlacement
	 * @model opposite="fromPlacement" ordered="false"
	 * @generated
	 */
	FromReplacement getFromReplacement();

	/**
	 * Sets the value of the '{@link bvr.FromPlacement#getFromReplacement <em>From Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Replacement</em>' reference.
	 * @see #getFromReplacement()
	 * @generated
	 */
	void setFromReplacement(FromReplacement value);

	/**
	 * Returns the value of the '<em><b>Outside Boundary Element</b></em>' reference list.
	 * The list contents are of type {@link bvr.ObjectHandle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Outside Model Elements are element that are referred by the model elements inside the placement fragment (but which are themselves not inside the placement fragment).</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outside Boundary Element</em>' reference list.
	 * @see bvr.BvrPackage#getFromPlacement_OutsideBoundaryElement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ObjectHandle> getOutsideBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Inside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Insiude boundary elements refer to elements inside the fragment.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inside Boundary Element</em>' reference.
	 * @see #setInsideBoundaryElement(ObjectHandle)
	 * @see bvr.BvrPackage#getFromPlacement_InsideBoundaryElement()
	 * @model ordered="false"
	 * @generated
	 */
	ObjectHandle getInsideBoundaryElement();

	/**
	 * Sets the value of the '{@link bvr.FromPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inside Boundary Element</em>' reference.
	 * @see #getInsideBoundaryElement()
	 * @generated
	 */
	void setInsideBoundaryElement(ObjectHandle value);

} // FromPlacement
