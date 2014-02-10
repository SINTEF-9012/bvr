/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation.util;

import org.bangbangbang.cvl.system.cvlsystemrelation.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage
 * @generated
 */
public class RelationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RelationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationSwitch() {
		if (modelPackage == null) {
			modelPackage = RelationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RelationPackage.CVL_REFERENCE: {
				CVLReference cvlReference = (CVLReference)theEObject;
				T result = caseCVLReference(cvlReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationPackage.VSPEC_RELATION: {
				VSpecRelation vSpecRelation = (VSpecRelation)theEObject;
				T result = caseVSpecRelation(vSpecRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationPackage.ABSTRACT_CHOICE_REFERENCE: {
				AbstractChoiceReference abstractChoiceReference = (AbstractChoiceReference)theEObject;
				T result = caseAbstractChoiceReference(abstractChoiceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationPackage.CHOICE_REFERENCE: {
				ChoiceReference choiceReference = (ChoiceReference)theEObject;
				T result = caseChoiceReference(choiceReference);
				if (result == null) result = caseAbstractChoiceReference(choiceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationPackage.CHOICE_GROUP: {
				ChoiceGroup choiceGroup = (ChoiceGroup)theEObject;
				T result = caseChoiceGroup(choiceGroup);
				if (result == null) result = caseAbstractChoiceReference(choiceGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationPackage.VCLASSIFIER_REFERENCE: {
				VClassifierReference vClassifierReference = (VClassifierReference)theEObject;
				T result = caseVClassifierReference(vClassifierReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVL Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVL Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVLReference(CVLReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VSpec Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VSpec Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVSpecRelation(VSpecRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Choice Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Choice Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractChoiceReference(AbstractChoiceReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceReference(ChoiceReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceGroup(ChoiceGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VClassifier Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VClassifier Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVClassifierReference(VClassifierReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //RelationSwitch
