package no.sintef.bvr.gmf.vspec.edit.policies;

import no.sintef.bvr.gmf.vspec.edit.commands.Choice2CreateCommand;
import no.sintef.bvr.gmf.vspec.edit.commands.ChoiceCreateCommand;
import no.sintef.bvr.gmf.vspec.edit.commands.OpaqueConstraintCreateCommand;
import no.sintef.bvr.gmf.vspec.edit.commands.VClassifierCreateCommand;
import no.sintef.bvr.gmf.vspec.edit.commands.VariableCreateCommand;
import no.sintef.bvr.gmf.vspec.providers.BVRMetamodelElementTypes;

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
		BVRMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ConfigurableUnitItemSemanticEditPolicy() {
		super(BVRMetamodelElementTypes.ConfigurableUnit_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (BVRMetamodelElementTypes.Choice_2005 == req.getElementType()) {
			return getGEFWrapper(new ChoiceCreateCommand(req));
		}
		if (BVRMetamodelElementTypes.Choice_2015 == req.getElementType()) {
			return getGEFWrapper(new Choice2CreateCommand(req));
		}
		if (BVRMetamodelElementTypes.Variable_2016 == req.getElementType()) {
			return getGEFWrapper(new VariableCreateCommand(req));
		}
		if (BVRMetamodelElementTypes.VClassifier_2017 == req.getElementType()) {
			return getGEFWrapper(new VClassifierCreateCommand(req));
		}
		if (BVRMetamodelElementTypes.OpaqueConstraint_2014 == req
				.getElementType()) {
			return getGEFWrapper(new OpaqueConstraintCreateCommand(req));
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
