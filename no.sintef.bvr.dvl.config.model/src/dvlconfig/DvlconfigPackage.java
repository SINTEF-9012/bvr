/**
 */
package dvlconfig;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dvlconfig.DvlconfigFactory
 * @model kind="package"
 * @generated
 */
public interface DvlconfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dvlconfig";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://dvlconfig.ecore/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dvlconfig";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DvlconfigPackage eINSTANCE = dvlconfig.impl.DvlconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link dvlconfig.impl.ConfigImpl <em>Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dvlconfig.impl.ConfigImpl
	 * @see dvlconfig.impl.DvlconfigPackageImpl#getConfig()
	 * @generated
	 */
	int CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__OPERATORS = 0;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__RESOURCES = 1;

	/**
	 * The feature id for the '<em><b>Original</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__ORIGINAL = 2;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__GOALS = 3;

	/**
	 * The feature id for the '<em><b>Realop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG__REALOP = 4;

	/**
	 * The number of structural features of the '<em>Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dvlconfig.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dvlconfig.impl.OperatorImpl
	 * @see dvlconfig.impl.DvlconfigPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dvlconfig.impl.LocatableImpl <em>Locatable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dvlconfig.impl.LocatableImpl
	 * @see dvlconfig.impl.DvlconfigPackageImpl#getLocatable()
	 * @generated
	 */
	int LOCATABLE = 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATABLE__LOCATION = 0;

	/**
	 * The number of structural features of the '<em>Locatable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Locatable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dvlconfig.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dvlconfig.impl.ResourceImpl
	 * @see dvlconfig.impl.DvlconfigPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__LOCATION = LOCATABLE__LOCATION;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = LOCATABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = LOCATABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dvlconfig.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dvlconfig.impl.StateImpl
	 * @see dvlconfig.impl.DvlconfigPackageImpl#getState()
	 * @generated
	 */
	int STATE = 6;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__LOCATION = LOCATABLE__LOCATION;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = LOCATABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = LOCATABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dvlconfig.impl.OriginalImpl <em>Original</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dvlconfig.impl.OriginalImpl
	 * @see dvlconfig.impl.DvlconfigPackageImpl#getOriginal()
	 * @generated
	 */
	int ORIGINAL = 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINAL__LOCATION = STATE__LOCATION;

	/**
	 * The number of structural features of the '<em>Original</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINAL_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Original</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGINAL_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dvlconfig.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dvlconfig.impl.GoalImpl
	 * @see dvlconfig.impl.DvlconfigPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__LOCATION = STATE__LOCATION;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dvlconfig.impl.RealopImpl <em>Realop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dvlconfig.impl.RealopImpl
	 * @see dvlconfig.impl.DvlconfigPackageImpl#getRealop()
	 * @generated
	 */
	int REALOP = 7;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALOP__LOCATION = LOCATABLE__LOCATION;

	/**
	 * The number of structural features of the '<em>Realop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALOP_FEATURE_COUNT = LOCATABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Realop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALOP_OPERATION_COUNT = LOCATABLE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link dvlconfig.Config <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config</em>'.
	 * @see dvlconfig.Config
	 * @generated
	 */
	EClass getConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link dvlconfig.Config#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operators</em>'.
	 * @see dvlconfig.Config#getOperators()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Operators();

	/**
	 * Returns the meta object for the containment reference list '{@link dvlconfig.Config#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see dvlconfig.Config#getResources()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Resources();

	/**
	 * Returns the meta object for the containment reference '{@link dvlconfig.Config#getOriginal <em>Original</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Original</em>'.
	 * @see dvlconfig.Config#getOriginal()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Original();

	/**
	 * Returns the meta object for the containment reference list '{@link dvlconfig.Config#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goals</em>'.
	 * @see dvlconfig.Config#getGoals()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Goals();

	/**
	 * Returns the meta object for the containment reference '{@link dvlconfig.Config#getRealop <em>Realop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Realop</em>'.
	 * @see dvlconfig.Config#getRealop()
	 * @see #getConfig()
	 * @generated
	 */
	EReference getConfig_Realop();

	/**
	 * Returns the meta object for class '{@link dvlconfig.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see dvlconfig.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the attribute '{@link dvlconfig.Operator#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see dvlconfig.Operator#getKey()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Key();

	/**
	 * Returns the meta object for the attribute '{@link dvlconfig.Operator#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dvlconfig.Operator#getValue()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Value();

	/**
	 * Returns the meta object for class '{@link dvlconfig.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see dvlconfig.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for class '{@link dvlconfig.Original <em>Original</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Original</em>'.
	 * @see dvlconfig.Original
	 * @generated
	 */
	EClass getOriginal();

	/**
	 * Returns the meta object for class '{@link dvlconfig.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see dvlconfig.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for class '{@link dvlconfig.Locatable <em>Locatable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Locatable</em>'.
	 * @see dvlconfig.Locatable
	 * @generated
	 */
	EClass getLocatable();

	/**
	 * Returns the meta object for the attribute '{@link dvlconfig.Locatable#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see dvlconfig.Locatable#getLocation()
	 * @see #getLocatable()
	 * @generated
	 */
	EAttribute getLocatable_Location();

	/**
	 * Returns the meta object for class '{@link dvlconfig.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see dvlconfig.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for class '{@link dvlconfig.Realop <em>Realop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realop</em>'.
	 * @see dvlconfig.Realop
	 * @generated
	 */
	EClass getRealop();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DvlconfigFactory getDvlconfigFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dvlconfig.impl.ConfigImpl <em>Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dvlconfig.impl.ConfigImpl
		 * @see dvlconfig.impl.DvlconfigPackageImpl#getConfig()
		 * @generated
		 */
		EClass CONFIG = eINSTANCE.getConfig();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__OPERATORS = eINSTANCE.getConfig_Operators();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__RESOURCES = eINSTANCE.getConfig_Resources();

		/**
		 * The meta object literal for the '<em><b>Original</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__ORIGINAL = eINSTANCE.getConfig_Original();

		/**
		 * The meta object literal for the '<em><b>Goals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__GOALS = eINSTANCE.getConfig_Goals();

		/**
		 * The meta object literal for the '<em><b>Realop</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG__REALOP = eINSTANCE.getConfig_Realop();

		/**
		 * The meta object literal for the '{@link dvlconfig.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dvlconfig.impl.OperatorImpl
		 * @see dvlconfig.impl.DvlconfigPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__KEY = eINSTANCE.getOperator_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__VALUE = eINSTANCE.getOperator_Value();

		/**
		 * The meta object literal for the '{@link dvlconfig.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dvlconfig.impl.ResourceImpl
		 * @see dvlconfig.impl.DvlconfigPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '{@link dvlconfig.impl.OriginalImpl <em>Original</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dvlconfig.impl.OriginalImpl
		 * @see dvlconfig.impl.DvlconfigPackageImpl#getOriginal()
		 * @generated
		 */
		EClass ORIGINAL = eINSTANCE.getOriginal();

		/**
		 * The meta object literal for the '{@link dvlconfig.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dvlconfig.impl.GoalImpl
		 * @see dvlconfig.impl.DvlconfigPackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

		/**
		 * The meta object literal for the '{@link dvlconfig.impl.LocatableImpl <em>Locatable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dvlconfig.impl.LocatableImpl
		 * @see dvlconfig.impl.DvlconfigPackageImpl#getLocatable()
		 * @generated
		 */
		EClass LOCATABLE = eINSTANCE.getLocatable();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATABLE__LOCATION = eINSTANCE.getLocatable_Location();

		/**
		 * The meta object literal for the '{@link dvlconfig.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dvlconfig.impl.StateImpl
		 * @see dvlconfig.impl.DvlconfigPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '{@link dvlconfig.impl.RealopImpl <em>Realop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dvlconfig.impl.RealopImpl
		 * @see dvlconfig.impl.DvlconfigPackageImpl#getRealop()
		 * @generated
		 */
		EClass REALOP = eINSTANCE.getRealop();

	}

} //DvlconfigPackage
