package org.bangbangbang.cvl.system.vspec.edit.policies;

import org.bangbangbang.cvl.system.vspec.edit.commands.MultiplicityInterval3CreateCommand;
import org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class VClassifierVClassifierInstanceMultiplicityIntervalCompartmentItemSemanticEditPolicy
		extends CVLMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public VClassifierVClassifierInstanceMultiplicityIntervalCompartmentItemSemanticEditPolicy() {
		super(CVLMetamodelElementTypes.VClassifier_2004);
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
