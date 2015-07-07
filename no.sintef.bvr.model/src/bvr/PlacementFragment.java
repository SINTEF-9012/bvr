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
 * A representation of the model object '<em><b>Placement Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A PlacementFragment defines a fragment (set of model elements) of the base model that will be replaced by a
 * ReplacementFragment during the variability transformation. The set of model elements of the fragment will be deleted.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.PlacementFragment#getPlacementBoundaryElement <em>Placement Boundary Element</em>}</li>
 *   <li>{@link bvr.PlacementFragment#getSourceObject <em>Source Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getPlacementFragment()
 * @model
 * @generated
 */
public interface PlacementFragment extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Placement Boundary Element</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.PlacementBoundaryElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The boundary elements captures all the relations from and to the fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Placement Boundary Element</em>' containment reference list.
	 * @see bvr.BvrPackage#getPlacementFragment_PlacementBoundaryElement()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PlacementBoundaryElement> getPlacementBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Source Object</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.ObjectHandle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Object</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Object</em>' containment reference list.
	 * @see bvr.BvrPackage#getPlacementFragment_SourceObject()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ObjectHandle> getSourceObject();

} // PlacementFragment
