package org.bangbangbang.cvl.diagram.edit.policies;

import org.bangbangbang.cvl.diagram.edit.commands.MultiplicityInterval4CreateCommand;
import org.bangbangbang.cvl.diagram.providers.CVLMetamodelElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class VClassifierMultiplicityIntervalCompartmentItemSemanticEditPolicy
		extends CVLMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public VClassifierMultiplicityIntervalCompartmentItemSemanticEditPolicy() {
		super(CVLMetamodelElementTypes.VClassifier_2017);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CVLMetamodelElementTypes.MultiplicityInterval_3004 == req
				.getElementType()) {
			return getGEFWrapper(new MultiplicityInterval4CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
