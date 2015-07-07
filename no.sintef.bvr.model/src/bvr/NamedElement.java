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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>An named element is an element identifiable by name.</p><p>Names are composed of letters, numbers, the underscore sign "_" and the dollar sign "$". The first character of a name must be a letter, an underscore or a dollar sign. Reserved keywords of the constraint language cannot be used as identifiers.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link bvr.NamedElement#getNote <em>Note</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The name of the element. Names are composed of letters, numbers, the underscore sign "_"  and the dollar sign "$". The first character of a name must be a letter, an underscore or a dollar sign.  Reserved keywords of the constraint language cannot be used as identifiers.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see bvr.BvrPackage#getNamedElement_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link bvr.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Note</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.Note}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The note is some additional information about this element. It can be anything and it will not be interpreted as significant by the BVR language, but different tooling can interpret the information ad lib.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Note</em>' containment reference list.
	 * @see bvr.BvrPackage#getNamedElement_Note()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Note> getNote();

} // NamedElement
