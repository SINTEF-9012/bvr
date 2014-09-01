/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A VPacakge (Variability Package) is the packaging mechanism of BVR.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.VPackage#getPackageElement <em>Package Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVPackage()
 * @model
 * @generated
 */
public interface VPackage extends VPackageable {
	/**
	 * Returns the value of the '<em><b>Package Element</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.VPackageable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Elements contained in this VPackage.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Package Element</em>' containment reference list.
	 * @see bvr.BvrPackage#getVPackage_PackageElement()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VPackageable> getPackageElement();

} // VPackage
