/**
 */
package cvl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * <p>Enumerates operations available in basic constraint language: logNot (logical negation), logAnd (logical conjunction), logOr (logical disjunction), logImplies (logical implication), logXor (logical exclusive-or), arithPlus (arithmetic addition), arithMinus (arithmetic subtraction), arithNeg (arithmetic negation), arithMult (arithmetic multiplication), arithDiv (arithmetic division), strConc (string concatenation), eq (equality), lte (less than or equal), gte (greater than or equal), lt (less than), gt (greater than), isDefined (checks if value is not bottom), isUndefined (checks if value is bottom)</p>
 * <!-- end-model-doc -->
 * @see cvl.cvlPackage#getOperation()
 * @model
 * @generated
 */
public enum Operation implements Enumerator {
	/**
	 * The '<em><b>Log Not</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_NOT_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_NOT(0, "logNot", "logNot"),

	/**
	 * The '<em><b>Log And</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_AND_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_AND(1, "logAnd", "logAnd"),

	/**
	 * The '<em><b>Log Or</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_OR_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_OR(2, "logOr", "logOr"),

	/**
	 * The '<em><b>Log Implies</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_IMPLIES_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_IMPLIES(3, "logImplies", "logImplies"),

	/**
	 * The '<em><b>Log Xor</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_XOR_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_XOR(4, "logXor", "logXor"),

	/**
	 * The '<em><b>Log Iff</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_IFF_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_IFF(5, "logIff", "logIff"),

	/**
	 * The '<em><b>Arith Plus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARITH_PLUS_VALUE
	 * @generated
	 * @ordered
	 */
	ARITH_PLUS(6, "arithPlus", "arithPlus"),

	/**
	 * The '<em><b>Arith Minus</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARITH_MINUS_VALUE
	 * @generated
	 * @ordered
	 */
	ARITH_MINUS(7, "arithMinus", "arithMinus"),

	/**
	 * The '<em><b>Arith Neg</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARITH_NEG_VALUE
	 * @generated
	 * @ordered
	 */
	ARITH_NEG(8, "arithNeg", "arithNeg"),

	/**
	 * The '<em><b>Arith Mult</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARITH_MULT_VALUE
	 * @generated
	 * @ordered
	 */
	ARITH_MULT(9, "arithMult", "arithMult"),

	/**
	 * The '<em><b>Arith Dev</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARITH_DEV_VALUE
	 * @generated
	 * @ordered
	 */
	ARITH_DEV(10, "arithDev", "arithDev"),

	/**
	 * The '<em><b>Str Conc</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STR_CONC_VALUE
	 * @generated
	 * @ordered
	 */
	STR_CONC(11, "strConc", "strConc"),

	/**
	 * The '<em><b>Eq</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQ_VALUE
	 * @generated
	 * @ordered
	 */
	EQ(12, "eq", "eq"),

	/**
	 * The '<em><b>Lte</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LTE_VALUE
	 * @generated
	 * @ordered
	 */
	LTE(13, "lte", "lte"),

	/**
	 * The '<em><b>Gte</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GTE_VALUE
	 * @generated
	 * @ordered
	 */
	GTE(14, "gte", "gte"),

	/**
	 * The '<em><b>Lt</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LT_VALUE
	 * @generated
	 * @ordered
	 */
	LT(15, "lt", "lt"),

	/**
	 * The '<em><b>Gt</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GT_VALUE
	 * @generated
	 * @ordered
	 */
	GT(16, "gt", "gt"),

	/**
	 * The '<em><b>Is Defined</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IS_DEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	IS_DEFINED(17, "isDefined", "isDefined"),

	/**
	 * The '<em><b>Is Undefined</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IS_UNDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	IS_UNDEFINED(18, "isUndefined", "isUndefined");

	/**
	 * The '<em><b>Log Not</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Logical not</p>
	 * <!-- end-model-doc -->
	 * @see #LOG_NOT
	 * @model name="logNot"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_NOT_VALUE = 0;

	/**
	 * The '<em><b>Log And</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Logical and</p>
	 * <!-- end-model-doc -->
	 * @see #LOG_AND
	 * @model name="logAnd"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_AND_VALUE = 1;

	/**
	 * The '<em><b>Log Or</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Logical or</p>
	 * <!-- end-model-doc -->
	 * @see #LOG_OR
	 * @model name="logOr"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_OR_VALUE = 2;

	/**
	 * The '<em><b>Log Implies</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Logical implies</p>
	 * <!-- end-model-doc -->
	 * @see #LOG_IMPLIES
	 * @model name="logImplies"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_IMPLIES_VALUE = 3;

	/**
	 * The '<em><b>Log Xor</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Logical xor</p>
	 * <!-- end-model-doc -->
	 * @see #LOG_XOR
	 * @model name="logXor"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_XOR_VALUE = 4;

	/**
	 * The '<em><b>Log Iff</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Logical if and only if</p>
	 * <!-- end-model-doc -->
	 * @see #LOG_IFF
	 * @model name="logIff"
	 * @generated
	 * @ordered
	 */
	public static final int LOG_IFF_VALUE = 5;

	/**
	 * The '<em><b>Arith Plus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Arithmetic addition</p>
	 * <!-- end-model-doc -->
	 * @see #ARITH_PLUS
	 * @model name="arithPlus"
	 * @generated
	 * @ordered
	 */
	public static final int ARITH_PLUS_VALUE = 6;

	/**
	 * The '<em><b>Arith Minus</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Arithmetic subtraction</p>
	 * <!-- end-model-doc -->
	 * @see #ARITH_MINUS
	 * @model name="arithMinus"
	 * @generated
	 * @ordered
	 */
	public static final int ARITH_MINUS_VALUE = 7;

	/**
	 * The '<em><b>Arith Neg</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Arithmetic negation</p>
	 * <!-- end-model-doc -->
	 * @see #ARITH_NEG
	 * @model name="arithNeg"
	 * @generated
	 * @ordered
	 */
	public static final int ARITH_NEG_VALUE = 8;

	/**
	 * The '<em><b>Arith Mult</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Arithmetic multiplication</p>
	 * <!-- end-model-doc -->
	 * @see #ARITH_MULT
	 * @model name="arithMult"
	 * @generated
	 * @ordered
	 */
	public static final int ARITH_MULT_VALUE = 9;

	/**
	 * The '<em><b>Arith Dev</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Arithmetic division</p>
	 * <!-- end-model-doc -->
	 * @see #ARITH_DEV
	 * @model name="arithDev"
	 * @generated
	 * @ordered
	 */
	public static final int ARITH_DEV_VALUE = 10;

	/**
	 * The '<em><b>Str Conc</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>String concatenation</p>
	 * <!-- end-model-doc -->
	 * @see #STR_CONC
	 * @model name="strConc"
	 * @generated
	 * @ordered
	 */
	public static final int STR_CONC_VALUE = 11;

	/**
	 * The '<em><b>Eq</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Equal</p>
	 * <!-- end-model-doc -->
	 * @see #EQ
	 * @model name="eq"
	 * @generated
	 * @ordered
	 */
	public static final int EQ_VALUE = 12;

	/**
	 * The '<em><b>Lte</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Logical less than or equal</p>
	 * <!-- end-model-doc -->
	 * @see #LTE
	 * @model name="lte"
	 * @generated
	 * @ordered
	 */
	public static final int LTE_VALUE = 13;

	/**
	 * The '<em><b>Gte</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Greater than or equal</p>
	 * <!-- end-model-doc -->
	 * @see #GTE
	 * @model name="gte"
	 * @generated
	 * @ordered
	 */
	public static final int GTE_VALUE = 14;

	/**
	 * The '<em><b>Lt</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Logical less than</p>
	 * <!-- end-model-doc -->
	 * @see #LT
	 * @model name="lt"
	 * @generated
	 * @ordered
	 */
	public static final int LT_VALUE = 15;

	/**
	 * The '<em><b>Gt</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Greater than</p>
	 * <!-- end-model-doc -->
	 * @see #GT
	 * @model name="gt"
	 * @generated
	 * @ordered
	 */
	public static final int GT_VALUE = 16;

	/**
	 * The '<em><b>Is Defined</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Checks if the value is defined.</p>
	 * <!-- end-model-doc -->
	 * @see #IS_DEFINED
	 * @model name="isDefined"
	 * @generated
	 * @ordered
	 */
	public static final int IS_DEFINED_VALUE = 17;

	/**
	 * The '<em><b>Is Undefined</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Check if the value is undefined.</p>
	 * <!-- end-model-doc -->
	 * @see #IS_UNDEFINED
	 * @model name="isUndefined"
	 * @generated
	 * @ordered
	 */
	public static final int IS_UNDEFINED_VALUE = 18;

	/**
	 * An array of all the '<em><b>Operation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Operation[] VALUES_ARRAY =
		new Operation[] {
			LOG_NOT,
			LOG_AND,
			LOG_OR,
			LOG_IMPLIES,
			LOG_XOR,
			LOG_IFF,
			ARITH_PLUS,
			ARITH_MINUS,
			ARITH_NEG,
			ARITH_MULT,
			ARITH_DEV,
			STR_CONC,
			EQ,
			LTE,
			GTE,
			LT,
			GT,
			IS_DEFINED,
			IS_UNDEFINED,
		};

	/**
	 * A public read-only list of all the '<em><b>Operation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Operation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Operation</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Operation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Operation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operation</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Operation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Operation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operation</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Operation get(int value) {
		switch (value) {
			case LOG_NOT_VALUE: return LOG_NOT;
			case LOG_AND_VALUE: return LOG_AND;
			case LOG_OR_VALUE: return LOG_OR;
			case LOG_IMPLIES_VALUE: return LOG_IMPLIES;
			case LOG_XOR_VALUE: return LOG_XOR;
			case LOG_IFF_VALUE: return LOG_IFF;
			case ARITH_PLUS_VALUE: return ARITH_PLUS;
			case ARITH_MINUS_VALUE: return ARITH_MINUS;
			case ARITH_NEG_VALUE: return ARITH_NEG;
			case ARITH_MULT_VALUE: return ARITH_MULT;
			case ARITH_DEV_VALUE: return ARITH_DEV;
			case STR_CONC_VALUE: return STR_CONC;
			case EQ_VALUE: return EQ;
			case LTE_VALUE: return LTE;
			case GTE_VALUE: return GTE;
			case LT_VALUE: return LT;
			case GT_VALUE: return GT;
			case IS_DEFINED_VALUE: return IS_DEFINED;
			case IS_UNDEFINED_VALUE: return IS_UNDEFINED;
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
	private Operation(int value, String name, String literal) {
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
	
} //Operation
