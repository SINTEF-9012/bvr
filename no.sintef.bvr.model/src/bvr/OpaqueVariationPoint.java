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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opaque Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>An OpaqueVariationPoint is an executable, domain-specific variation point whose semantics is not defined by BVR. It is the responsibility of the specific domain to execute this kind of variation point.<br><br>If bound to a choice then an OpaqueVariation point will be executed upon a positive decision. If bound to a VClassifier then it will be executed once for each instance created from it. If bound to a variable then it will be executed when a value is assigned to it, also providing the value as parameter for the execution.<br></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.OpaqueVariationPoint#getPlaceHolder <em>Place Holder</em>}</li>
 *   <li>{@link bvr.OpaqueVariationPoint#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getOpaqueVariationPoint()
 * @model
 * @generated
 */
public interface OpaqueVariationPoint extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Place Holder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The place holder of the OpaqueVariationPoint.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Place Holder</em>' containment reference.
	 * @see #setPlaceHolder(ObjectHandle)
	 * @see bvr.BvrPackage#getOpaqueVariationPoint_PlaceHolder()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getPlaceHolder();

	/**
	 * Sets the value of the '{@link bvr.OpaqueVariationPoint#getPlaceHolder <em>Place Holder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Place Holder</em>' containment reference.
	 * @see #getPlaceHolder()
	 * @generated
	 */
	void setPlaceHolder(ObjectHandle value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The transformation used by the opaque variation point.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(OVPType)
	 * @see bvr.BvrPackage#getOpaqueVariationPoint_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OVPType getType();

	/**
	 * Sets the value of the '{@link bvr.OpaqueVariationPoint#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(OVPType value);

} // OpaqueVariationPoint
