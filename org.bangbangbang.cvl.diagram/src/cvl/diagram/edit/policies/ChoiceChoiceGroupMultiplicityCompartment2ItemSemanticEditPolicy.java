package cvl.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import cvl.diagram.edit.commands.MultiplicityIntervalCreateCommand;
import cvl.diagram.providers.CVLMetamodelElementTypes;

/**
 * @generated
 */
public class ChoiceChoiceGroupMultiplicityCompartment2ItemSemanticEditPolicy
		extends CVLMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ChoiceChoiceGroupMultiplicityCompartment2ItemSemanticEditPolicy() {
		super(CVLMetamodelElementTypes.Choice_2005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CVLMetamodelElementTypes.MultiplicityInterval_3002 == req
				.getElementType()) {
			return getGEFWrapper(new MultiplicityIntervalCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
