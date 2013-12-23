package org.bangbangbang.cvl.system.vspec.edit.policies;

import org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class ConstraintContextItemSemanticEditPolicy extends
		CVLMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ConstraintContextItemSemanticEditPolicy() {
		super(CVLMetamodelElementTypes.ConstraintContext_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
