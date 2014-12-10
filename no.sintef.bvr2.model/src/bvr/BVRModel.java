/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BVR Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>BVRModel holds the whole BVR model with abstraction layer, realization layer and base models.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.BVRModel#getVariabilityModel <em>Variability Model</em>}</li>
 *   <li>{@link bvr.BVRModel#getResolutionModels <em>Resolution Models</em>}</li>
 *   <li>{@link bvr.BVRModel#getBaseModelBase <em>Base Model Base</em>}</li>
 *   <li>{@link bvr.BVRModel#getBaseModelLibraries <em>Base Model Libraries</em>}</li>
 *   <li>{@link bvr.BVRModel#getRealizationModel <em>Realization Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getBVRModel()
 * @model
 * @generated
 */
public interface BVRModel extends VPackage {
	/**
	 * Returns the value of the '<em><b>Variability Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The variability model (VSpec tree) corresponding to feature models</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variability Model</em>' containment reference.
	 * @see #setVariabilityModel(CompoundNode)
	 * @see bvr.BvrPackage#getBVRModel_VariabilityModel()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	CompoundNode getVariabilityModel();

	/**
	 * Sets the value of the '{@link bvr.BVRModel#getVariabilityModel <em>Variability Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variability Model</em>' containment reference.
	 * @see #getVariabilityModel()
	 * @generated
	 */
	void setVariabilityModel(CompoundNode value);

	/**
	 * Returns the value of the '<em><b>Resolution Models</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.CompoundResolution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Resolution models are defining the configurations of the products</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolution Models</em>' containment reference list.
	 * @see bvr.BvrPackage#getBVRModel_ResolutionModels()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<CompoundResolution> getResolutionModels();

	/**
	 * Returns the value of the '<em><b>Base Model Base</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The base model which will be used as starting point for creating products in the base language</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Model Base</em>' containment reference.
	 * @see #setBaseModelBase(ObjectHandle)
	 * @see bvr.BvrPackage#getBVRModel_BaseModelBase()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getBaseModelBase();

	/**
	 * Sets the value of the '{@link bvr.BVRModel#getBaseModelBase <em>Base Model Base</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Model Base</em>' containment reference.
	 * @see #getBaseModelBase()
	 * @generated
	 */
	void setBaseModelBase(ObjectHandle value);

	/**
	 * Returns the value of the '<em><b>Base Model Libraries</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.ObjectHandle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Base libraries used additively in creating products from the baseModelBase</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Model Libraries</em>' containment reference list.
	 * @see bvr.BvrPackage#getBVRModel_BaseModelLibraries()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ObjectHandle> getBaseModelLibraries();

	/**
	 * Returns the value of the '<em><b>Realization Model</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.VariationPoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The realizationModel consists of the variation points used to respresent the realization of the variabilityModel given the resolutionModel. The variation points define the changes done with the base model to fulfill the configurations specified.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Realization Model</em>' containment reference list.
	 * @see bvr.BvrPackage#getBVRModel_RealizationModel()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VariationPoint> getRealizationModel();

} // BVRModel
