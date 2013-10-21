package cvl.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import cvl.diagram.edit.commands.MultiplicityInterval3CreateCommand;
import cvl.diagram.providers.CVLMetamodelElementTypes;

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
