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
 * A representation of the model object '<em><b>VNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p class="MsoNormal"><span style="font-size:8pt;font-family:Tahoma;"></span><span style="font-size:8pt;font-family:Tahoma;"> VNodes define the trees structures representing implicit logical constraints on the resolution of the children. </span></p><p><span style="font-size:8pt;font-family:Tahoma;">Choice, ChoiceOccurrence, VClassifier and VClassOccurrence are all both VNode and VSpec, while a Variable is a VSpec, but not a VNode. VNodes own Variables, however.</span></p><p>A VNode may optionally have a group multiplicity specifying upper and lower multiplicities against its children. The meaning of this is that each positive resolution (PosResolution) against a VSpec which is also a VNode must have a number of positive child resolutions conforming to the multiplicity interval.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.VNode#getGroupMultiplicity <em>Group Multiplicity</em>}</li>
 *   <li>{@link bvr.VNode#getOwnedConstraint <em>Owned Constraint</em>}</li>
 *   <li>{@link bvr.VNode#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVNode()
 * @model abstract="true"
 * @generated
 */
public interface VNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Group Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The group multiplicity of the VNode. If the corresponding VSpec is resolved positively and has a group multiplicity then the number of<br>its children resolved positively must conform to the specified multiplicity interval.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Group Multiplicity</em>' containment reference.
	 * @see #setGroupMultiplicity(MultiplicityInterval)
	 * @see bvr.BvrPackage#getVNode_GroupMultiplicity()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	MultiplicityInterval getGroupMultiplicity();

	/**
	 * Sets the value of the '{@link bvr.VNode#getGroupMultiplicity <em>Group Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Multiplicity</em>' containment reference.
	 * @see #getGroupMultiplicity()
	 * @generated
	 */
	void setGroupMultiplicity(MultiplicityInterval value);

	/**
	 * Returns the value of the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.Constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Constraints&nbsp;over&nbsp;the&nbsp;VSPecs&nbsp;over&nbsp;this&nbsp;VInterface
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Constraint</em>' containment reference list.
	 * @see bvr.BvrPackage#getVNode_OwnedConstraint()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Constraint> getOwnedConstraint();

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.Variable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Owned variables.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see bvr.BvrPackage#getVNode_Variable()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Variable> getVariable();

} // VNode
