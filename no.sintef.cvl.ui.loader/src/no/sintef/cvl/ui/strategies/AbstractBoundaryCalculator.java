package no.sintef.cvl.ui.strategies;

import no.sintef.cvl.ui.logging.Logger;
import no.sintef.cvl.ui.logging.impl.Logging;


import org.eclipse.emf.ecore.EStructuralFeature;

public class AbstractBoundaryCalculator {
	
	protected Logger LOGGER = Logging.getLogger(); 

	protected boolean isReferenceToCut(EStructuralFeature property){
		boolean yes = true;
		/*The value of a derived feature is computed from other
		features, so it doesn't represent any additional object
		state. Framework classes, such as EcoreUtil.Copier,
		that copy model objects will not attempt to copy such
		features. The generated code is unaffected by the value
		of the derived flag. Derived features are typically also
		marked volatile and transient.*/
		Boolean isDerived = (Boolean) property.eGet(property.eClass().getEStructuralFeature("derived"));
		if(isDerived){
			yes = false;
			LOGGER.warn("property is derived, skip it: " + property);
		}
		/*Transient features are used to declare (modeled) data
		whose lifetime never spans application invocations and
		therefore doesn't need to be persisted. The (default XMI)
		serializer will not save features that are declared to be
		transient.*/
		Boolean isTransient = (Boolean) property.eGet(property.eClass().getEStructuralFeature("transient"));
		if(isTransient){
			yes = false;
			LOGGER.warn("property is transient, skip it: " + property);
		}
		return yes;
	}
}
