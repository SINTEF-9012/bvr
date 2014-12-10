package no.sintef.bvr.gmf.vspec.edit.policies;

import no.sintef.bvr.gmf.vspec.edit.commands.MultiplicityInterval4CreateCommand;
import no.sintef.bvr.gmf.vspec.providers.BVRMetamodelElementTypes;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class VClassifierMultiplicityIntervalCompartmentItemSemanticEditPolicy
		extends BVRMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public VClassifierMultiplicityIntervalCompartmentItemSemanticEditPolicy() {
		super(BVRMetamodelElementTypes.VClassifier_2017);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (BVRMetamodelElementTypes.MultiplicityInterval_3004 == req
				.getElementType()) {
			return getGEFWrapper(new MultiplicityInterval4CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
