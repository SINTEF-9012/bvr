package org.bangbangbang.cvl.diagram.custom.ocl;

import org.bangbangbang.cvl.CvlPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.helper.OCLHelper;

public class OCLCustomUtil {
	private OCLCustomUtil() {
	}

	public static boolean checkSyntax(String oclString) throws ParserException {
		Constraint invariant = null;

		try {
			// create an OCL instance for Ecore
			OCL<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, Constraint, EClass, EObject> ocl;
			ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);

			// create an OCL helper object
			OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl
					.createOCLHelper();

			// set the OCL context classifier
			helper.setContext(CvlPackage.Literals.VSPEC_RESOLUTION);

			invariant = helper.createInvariant(oclString);
			// record success
			return true;
		} catch (ParserException e) {
			// record failure to parse
			throw e;
		}

	}

}
