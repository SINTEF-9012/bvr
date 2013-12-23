package org.bangbangbang.cvl.system.vspec.edit.policies;

import org.bangbangbang.cvl.system.vspec.edit.commands.MultiplicityInterval2CreateCommand;
import org.bangbangbang.cvl.system.vspec.edit.commands.MultiplicityIntervalCreateCommand;
import org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ChoiceChoiceGroupMultiplicityCompartment2ItemSemanticEditPolicy
		extends CVLMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ChoiceChoiceGroupMultiplicityCompartment2ItemSemanticEditPolicy() {
		super(CVLMetamodelElementTypes.Choice_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CVLMetamodelElementTypes.MultiplicityInterval_3001 == req
				.getElementType()) {
			return getGEFWrapper(new MultiplicityIntervalCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
