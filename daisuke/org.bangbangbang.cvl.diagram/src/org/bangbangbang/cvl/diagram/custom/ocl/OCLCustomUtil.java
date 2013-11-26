package org.bangbangbang.cvl.diagram.custom.ocl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bangbangbang.cvl.Choice;
import org.bangbangbang.cvl.ConfigurableUnit;
import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.OpaqueConstraint;
import org.bangbangbang.cvl.VClassifier;
import org.bangbangbang.cvl.VSpec;
import org.bangbangbang.cvl.Variable;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;

public class OCLCustomUtil {
	public static OCLCustomUtil instance;
	public final static String[] LOGICAL_OPERATOR = { "and", "or", "xor",
			"implies" };
	public final static String[] OCL_TYPE = { "Integer", "Real", "String",
			"Boolean", "OclExpression", "OclType", "OclAny" };
	public final static String[] COLLECTION_OPERATOR = { "asSequence",
			"sortBy", "size", "isEmpty", "count", "sum", "select", "reject",
			"collect", "forAll", "exists", "includes", "excludes", "union",
			"intersection", "including", "excluding" };
	public final static String[] OCL_OPERATOR = { "oclIsKindOf", "oclIsTypeOf",
			"oclAsType", "oclInState" };
	public final static String[] CVL_TYPE = { "ChoiceResolutuion", "VInstance",
			"type", "resolvedChoice", "decision", "resolvedVariable",
			"VariableValueAssignment", "ValueSpecification", "value",
			"expression", "StringLiteralExp", "string", "BooleanLiteralExp",
			"bool", "RealLiteralExp", "real", "UnlimitedLiteralExp",
			"unlimited", "IntegerLiteralExp", "integer" };

	private static List<String> keywordsInModel;

	private OCLCustomUtil() {
		keywordsInModel = new ArrayList<String>();
	}

	public static OCLCustomUtil getInstance() {
		if (instance == null) {
			instance = new OCLCustomUtil();
		}
		return instance;
	}

	public static List<String> getKeyword(String pref) {
		List<String> keywords = new ArrayList<String>();
		for (String s : LOGICAL_OPERATOR) {
			keywords.add(s);
		}
		for (String s : OCL_TYPE) {
			keywords.add(s);
		}
		for (String s : COLLECTION_OPERATOR) {
			keywords.add(s);
		}
		for (String s : CVL_TYPE) {
			keywords.add(s);
		}
		for (String s : keywordsInModel) {
			keywords.add(s);
		}

		if (pref.equals("")) {
			return new ArrayList<String>();
		} else {
			for (Iterator<String> i = keywords.iterator(); i.hasNext();) {
				if (!i.next().startsWith(pref)) {
					i.remove();
				}
			}
			return keywords;
		}

	}

	public static List<String> getKeyword(String pref,
			OpaqueConstraint constraint) {
		Set<String> keywords = new HashSet<String>();
		// create an OCL instance for Ecore
		OCL<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, Constraint, EClass, EObject> ocl;
		ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);

		// create an OCL helper object
		OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();

		// set the OCL context classifier
		if (constraint.getContext() == null) {
			// return empty list
			return new ArrayList<String>();
		}
		if (constraint.getContext() instanceof Choice) {
			helper.setContext(CvlPackage.Literals.CHOICE_RESOLUTUION);
		} else if (constraint.getContext() instanceof VClassifier) {
			helper.setContext(CvlPackage.Literals.VINSTANCE);
		} else if (constraint.getContext() instanceof Variable) {
			helper.setContext(CvlPackage.Literals.VARIABLE_VALUE_ASSIGNMENT);
		} else {
			helper.setContext(CvlPackage.Literals.VSPEC_RESOLUTION);
		}

		List<org.eclipse.ocl.helper.Choice> choices = helper.getSyntaxHelp(
				ConstraintKind.INVARIANT, pref);
		for (org.eclipse.ocl.helper.Choice next : choices) {
			switch (next.getKind()) {
			case OPERATION:
			case SIGNAL:
				// the description is already complete
				keywords.add(next.getDescription());
				break;
			case PROPERTY:
			case ENUMERATION_LITERAL:
			case VARIABLE:
				keywords.add(next.getName());
				break;
			default:
				keywords.add(next.getName());
				break;
			}
		}
		keywords.addAll(getKeyword(pref));
		if (pref.equals("")) {
			return new ArrayList<String>(keywords);
		} else {
			for (Iterator<String> i = keywords.iterator(); i.hasNext();) {
				if (!i.next().startsWith(pref)) {
					i.remove();
				}
			}
			return new ArrayList<String>(keywords);
		}
	}

	public static boolean checkSyntax(String oclString,
			OpaqueConstraint constraint) throws ParserException {

		try {
			// create an OCL instance for Ecore
			OCL<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, Constraint, EClass, EObject> ocl;
			ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);

			// create an OCL helper object
			OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl
					.createOCLHelper();

			// set the OCL context classifier
			if (constraint.getContext() == null) {
				return false;
			}
			if (constraint.getContext() instanceof Choice) {
				helper.setContext(CvlPackage.Literals.CHOICE_RESOLUTUION);
			} else if (constraint.getContext() instanceof VClassifier) {
				helper.setContext(CvlPackage.Literals.VINSTANCE);
			} else if (constraint.getContext() instanceof Variable) {
				helper.setContext(CvlPackage.Literals.VARIABLE_VALUE_ASSIGNMENT);
			} else {
				helper.setContext(CvlPackage.Literals.VSPEC_RESOLUTION);
			}

			helper.createInvariant(oclString);
			// record success
			return true;
		} catch (ParserException e) {
			// record failure to parse
			throw e;
		}

	}

	public void setKeywordInModel(ConfigurableUnit root) {
		EObject node;
		keywordsInModel.clear();
		for (TreeIterator<EObject> iterator = root.eAllContents(); iterator
				.hasNext();) {
			node = (EObject) iterator.next();
			if (node instanceof VSpec && !((VSpec) node).getName().equals("")) {
				keywordsInModel.add(((VSpec) node).getName());
			}
		}
	}

	public String[] getKeywordInModel() {
		return keywordsInModel.toArray(new String[keywordsInModel.size()]);
	}
}
