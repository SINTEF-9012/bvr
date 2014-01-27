package no.sintef.bvr.gmf.vspec.edit.policies;

import no.sintef.bvr.gmf.vspec.edit.commands.MultiplicityInterval3CreateCommand;
import no.sintef.bvr.gmf.vspec.providers.BVRMetamodelElementTypes;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ChoiceChoiceGroupMultiplicityCompartmentItemSemanticEditPolicy
		extends BVRMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ChoiceChoiceGroupMultiplicityCompartmentItemSemanticEditPolicy() {
		super(BVRMetamodelElementTypes.Choice_2015);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (BVRMetamodelElementTypes.MultiplicityInterval_3003 == req
				.getElementType()) {
			return getGEFWrapper(new MultiplicityInterval3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
