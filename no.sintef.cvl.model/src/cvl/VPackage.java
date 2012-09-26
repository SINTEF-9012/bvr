/**
 */
package cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A VPacakge (Variability Package) is the packaging mechanism of CVL.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.VPackage#getPackageElement <em>Package Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getVPackage()
 * @model
 * @generated
 */
public interface VPackage extends VPackageable {
	/**
	 * Returns the value of the '<em><b>Package Element</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.VPackageable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Elements contained in this VPackage.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Package Element</em>' containment reference list.
	 * @see cvl.cvlPackage#getVPackage_PackageElement()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VPackageable> getPackageElement();

} // VPackage
