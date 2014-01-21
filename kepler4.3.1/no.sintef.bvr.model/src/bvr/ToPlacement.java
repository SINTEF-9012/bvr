/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>To Placement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>ToPlacement is the kind of boundary element that defines the boundary between the owning placement fragment and the rest of the base model. The insideBoundaryElements denote the ModelElements of owning fragment that are referred to by outside model elements. The outsideBoundaryElement together with the propertyName denotes the attributes of model elements on the outside of the placement fragment that refer to the inside boundary model elements.</p><p>Constraints:</p><p>insideBoundaryElement = outsideRef.insideBoundaryElement outsideBoundaryElement != null xor outsideRef != null</p><p>####CVLSemanticStart####</p><p>Invariant :</p><p > Constraint : </p><p >1) self.outsideBoudaryElement &lt;&gt; null xor outsideRef != null</p><p >2) All outsideBoundaryElement point on insideBoundaryElement</p><p>OCL :</p><p>-- ToPlacement</p><p>-- The outsideBoundaryElement together with the propertyName denotes the attributes of model elements outside of the placement fragment that refer to the inside boundary model elements</p><p>-- Constraint : </p><p>-- 1) self.outsideBoudaryElement &lt;&gt; null xor outsideRef != null</p><p>--  2) All outsideBoundaryElement point on insideBoundaryElement</p><p>context ToPlacement :</p><p> inv insideBoundaryElements_outsideRef :</p><p>                -- 1) self.outsideBoudaryElement &lt;&gt; null</p><p>                (not self.outsideBoundaryElement-&gt;isEmpty()</p><p>        xor self.outsideBoundaryElement.getPropertyValue(self.propertyName) &lt;&gt; null)</p><p>        and</p><p>                --  2) All outsideBoundaryElement point on insideBoundaryElement</p><p>                self.outsideBoundaryElement.getPropertyValue(self.propertyName)-&gt;forAll( val | self.insideBoundaryElement-&gt;includes(val.oclAsType(ObjectHandle) ))</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ToPlacement#getToReplacement <em>To Replacement</em>}</li>
 *   <li>{@link bvr.ToPlacement#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link bvr.ToPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link bvr.ToPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getToPlacement()
 * @model
 * @generated
 */
public interface ToPlacement extends PlacementBoundaryElement {
	/**
	 * Returns the value of the '<em><b>To Replacement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link bvr.ToReplacement#getToPlacement <em>To Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to a ToReplacement in a containing replacement fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To Replacement</em>' reference.
	 * @see #setToReplacement(ToReplacement)
	 * @see bvr.BvrPackage#getToPlacement_ToReplacement()
	 * @see bvr.ToReplacement#getToPlacement
	 * @model opposite="toPlacement" ordered="false"
	 * @generated
	 */
	ToReplacement getToReplacement();

	/**
	 * Sets the value of the '{@link bvr.ToPlacement#getToReplacement <em>To Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Replacement</em>' reference.
	 * @see #getToReplacement()
	 * @generated
	 */
	void setToReplacement(ToReplacement value);

	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of the attribute to be changed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see bvr.BvrPackage#getToPlacement_PropertyName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link bvr.ToPlacement#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Inside Boundary Element</b></em>' reference list.
	 * The list contents are of type {@link bvr.ObjectHandle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Model elements that are referred to by outside model elements. Used to distinguish miltiplicity references.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inside Boundary Element</em>' reference list.
	 * @see bvr.BvrPackage#getToPlacement_InsideBoundaryElement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ObjectHandle> getInsideBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Outside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Outside model elements that refer model elements inside the fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outside Boundary Element</em>' reference.
	 * @see #setOutsideBoundaryElement(ObjectHandle)
	 * @see bvr.BvrPackage#getToPlacement_OutsideBoundaryElement()
	 * @model ordered="false"
	 * @generated
	 */
	ObjectHandle getOutsideBoundaryElement();

	/**
	 * Sets the value of the '{@link bvr.ToPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outside Boundary Element</em>' reference.
	 * @see #getOutsideBoundaryElement()
	 * @generated
	 */
	void setOutsideBoundaryElement(ObjectHandle value);

} // ToPlacement
