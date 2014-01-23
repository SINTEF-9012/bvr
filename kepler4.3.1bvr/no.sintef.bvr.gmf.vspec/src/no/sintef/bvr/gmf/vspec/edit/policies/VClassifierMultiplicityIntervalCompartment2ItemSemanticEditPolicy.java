package no.sintef.bvr.gmf.vspec.edit.policies;

import no.sintef.bvr.gmf.vspec.edit.commands.MultiplicityInterval2CreateCommand;
import no.sintef.bvr.gmf.vspec.providers.CVLMetamodelElementTypes;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class VClassifierMultiplicityIntervalCompartment2ItemSemanticEditPolicy
		extends CVLMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public VClassifierMultiplicityIntervalCompartment2ItemSemanticEditPolicy() {
		super(CVLMetamodelElementTypes.VClassifier_2017);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CVLMetamodelElementTypes.MultiplicityInterval_3001 == req
				.getElementType()) {
			return getGEFWrapper(new MultiplicityInterval2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
