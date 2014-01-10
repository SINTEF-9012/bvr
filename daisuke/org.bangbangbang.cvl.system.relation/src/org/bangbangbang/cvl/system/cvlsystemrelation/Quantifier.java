/**
 */
package org.bangbangbang.cvl.system.cvlsystemrelation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Quantifier</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bangbangbang.cvl.system.cvlsystemrelation.RelationPackage#getQuantifier()
 * @model
 * @generated
 */
public enum Quantifier implements Enumerator {
	/**
	 * The '<em><b>For All</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOR_ALL_VALUE
	 * @generated
	 * @ordered
	 */
	FOR_ALL(0, "forAll", "forAll"),

	/**
	 * The '<em><b>Exist</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXIST_VALUE
	 * @generated
	 * @ordered
	 */
	EXIST(1, "exist", "exist");

	/**
	 * The '<em><b>For All</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>For All</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOR_ALL
	 * @model name="forAll"
	 * @generated
	 * @ordered
	 */
	public static final int FOR_ALL_VALUE = 0;

	/**
	 * The '<em><b>Exist</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Exist</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXIST
	 * @model name="exist"
	 * @generated
	 * @ordered
	 */
	public static final int EXIST_VALUE = 1;

	/**
	 * An array of all the '<em><b>Quantifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Quantifier[] VALUES_ARRAY =
		new Quantifier[] {
			FOR_ALL,
			EXIST,
		};

	/**
	 * A public read-only list of all the '<em><b>Quantifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Quantifier> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Quantifier</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Quantifier get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Quantifier result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Quantifier</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Quantifier getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Quantifier result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Quantifier</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Quantifier get(int value) {
		switch (value) {
			case FOR_ALL_VALUE: return FOR_ALL;
			case EXIST_VALUE: return EXIST;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Quantifier(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Quantifier
