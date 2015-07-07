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
 * A representation of the model object '<em><b>Object Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An ObjectSpecification specifies a value which is an object of the base mode through an object handle.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ObjectSpecification#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getObjectSpecification()
 * @model
 * @generated
 */
public interface ObjectSpecification extends ValueSpecification {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The object specified.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(ObjectHandle)
	 * @see bvr.BvrPackage#getObjectSpecification_Object()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getObject();

	/**
	 * Sets the value of the '{@link bvr.ObjectSpecification#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(ObjectHandle value);

} // ObjectSpecification
