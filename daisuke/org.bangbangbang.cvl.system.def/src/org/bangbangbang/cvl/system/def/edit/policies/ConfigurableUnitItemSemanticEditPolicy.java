package org.bangbangbang.cvl.system.def.edit.policies;

import org.bangbangbang.cvl.system.def.edit.commands.CVSpecCreateCommand;
import org.bangbangbang.cvl.system.def.edit.commands.Choice2CreateCommand;
import org.bangbangbang.cvl.system.def.edit.commands.ChoiceCreateCommand;
import org.bangbangbang.cvl.system.def.edit.commands.OpaqueConstraintCreateCommand;
import org.bangbangbang.cvl.system.def.edit.commands.VClassifierCreateCommand;
import org.bangbangbang.cvl.system.def.edit.commands.VariableCreateCommand;
import org.bangbangbang.cvl.system.def.providers.CVLMetamodelElementTypes;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
 * @generated
 */
public class ConfigurableUnitItemSemanticEditPolicy extends
		CVLMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ConfigurableUnitItemSemanticEditPolicy() {
		super(CVLMetamodelElementTypes.ConfigurableUnit_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CVLMetamodelElementTypes.Choice_2001 == req.getElementType()) {
			return getGEFWrapper(new ChoiceCreateCommand(req));
		}
		if (CVLMetamodelElementTypes.Choice_2002 == req.getElementType()) {
			return getGEFWrapper(new Choice2CreateCommand(req));
		}
		if (CVLMetamodelElementTypes.Variable_2003 == req.getElementType()) {
			return getGEFWrapper(new VariableCreateCommand(req));
		}
		if (CVLMetamodelElementTypes.VClassifier_2004 == req.getElementType()) {
			return getGEFWrapper(new VClassifierCreateCommand(req));
		}
		if (CVLMetamodelElementTypes.OpaqueConstraint_2005 == req
				.getElementType()) {
			return getGEFWrapper(new OpaqueConstraintCreateCommand(req));
		}
		if (CVLMetamodelElementTypes.CVSpec_2006 == req.getElementType()) {
			return getGEFWrapper(new CVSpecCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
