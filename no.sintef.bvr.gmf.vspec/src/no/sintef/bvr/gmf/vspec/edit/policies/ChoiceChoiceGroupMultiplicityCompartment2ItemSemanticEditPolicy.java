package no.sintef.bvr.gmf.vspec.edit.policies;

import no.sintef.bvr.gmf.vspec.edit.commands.MultiplicityIntervalCreateCommand;
import no.sintef.bvr.gmf.vspec.providers.BVRMetamodelElementTypes;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ChoiceChoiceGroupMultiplicityCompartment2ItemSemanticEditPolicy
		extends BVRMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ChoiceChoiceGroupMultiplicityCompartment2ItemSemanticEditPolicy() {
		super(BVRMetamodelElementTypes.Choice_2005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (BVRMetamodelElementTypes.MultiplicityInterval_3002 == req
				.getElementType()) {
			return getGEFWrapper(new MultiplicityIntervalCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
