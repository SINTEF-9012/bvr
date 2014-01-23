package no.sintef.bvr.gmf.vspec.edit.policies;

import no.sintef.bvr.gmf.vspec.edit.commands.MultiplicityInterval3CreateCommand;
import no.sintef.bvr.gmf.vspec.providers.CVLMetamodelElementTypes;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ChoiceChoiceGroupMultiplicityCompartmentItemSemanticEditPolicy
		extends CVLMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ChoiceChoiceGroupMultiplicityCompartmentItemSemanticEditPolicy() {
		super(CVLMetamodelElementTypes.Choice_2015);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CVLMetamodelElementTypes.MultiplicityInterval_3003 == req
				.getElementType()) {
			return getGEFWrapper(new MultiplicityInterval3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
