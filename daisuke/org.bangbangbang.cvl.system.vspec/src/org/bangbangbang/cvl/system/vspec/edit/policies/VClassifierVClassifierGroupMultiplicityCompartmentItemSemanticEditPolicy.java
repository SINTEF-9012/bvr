package org.bangbangbang.cvl.system.vspec.edit.policies;

import org.bangbangbang.cvl.system.vspec.edit.commands.MultiplicityInterval4CreateCommand;
import org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class VClassifierVClassifierGroupMultiplicityCompartmentItemSemanticEditPolicy
		extends CVLMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public VClassifierVClassifierGroupMultiplicityCompartmentItemSemanticEditPolicy() {
		super(CVLMetamodelElementTypes.VClassifier_2004);
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
