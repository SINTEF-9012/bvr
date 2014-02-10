/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation.util;

import org.bangbangbang.cvl.system.cvlsystemrelation.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage
 * @generated
 */
public class RelationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RelationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RelationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationSwitch<Adapter> modelSwitch =
		new RelationSwitch<Adapter>() {
			@Override
			public Adapter caseCVLReference(CVLReference object) {
				return createCVLReferenceAdapter();
			}
			@Override
			public Adapter caseVSpecRelation(VSpecRelation object) {
				return createVSpecRelationAdapter();
			}
			@Override
			public Adapter caseAbstractChoiceReference(AbstractChoiceReference object) {
				return createAbstractChoiceReferenceAdapter();
			}
			@Override
			public Adapter caseChoiceReference(ChoiceReference object) {
				return createChoiceReferenceAdapter();
			}
			@Override
			public Adapter caseChoiceGroup(ChoiceGroup object) {
				return createChoiceGroupAdapter();
			}
			@Override
			public Adapter caseVClassifierReference(VClassifierReference object) {
				return createVClassifierReferenceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference <em>CVL Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference
	 * @generated
	 */
	public Adapter createCVLReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.VSpecRelation <em>VSpec Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.VSpecRelation
	 * @generated
	 */
	public Adapter createVSpecRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.AbstractChoiceReference <em>Abstract Choice Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.AbstractChoiceReference
	 * @generated
	 */
	public Adapter createAbstractChoiceReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference <em>Choice Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceReference
	 * @generated
	 */
	public Adapter createChoiceReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup <em>Choice Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.ChoiceGroup
	 * @generated
	 */
	public Adapter createChoiceGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference <em>VClassifier Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bangbangbang.cvl.system.cvlsystemrelation.VClassifierReference
	 * @generated
	 */
	public Adapter createVClassifierReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RelationAdapterFactory
