package org.bangbangbang.cvl.system.vspec.edit.policies;

import org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelElementTypes;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class VSpecChildItemSemanticEditPolicy extends
		CVLMetamodelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public VSpecChildItemSemanticEditPolicy() {
		super(CVLMetamodelElementTypes.VSpecChild_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req) {
			protected CommandResult doExecuteWithResult(
					IProgressMonitor progressMonitor, IAdaptable info)
					throws ExecutionException {
				EObject referencedObject = getReferencedObject();
				Resource resource = referencedObject.eResource();
				CommandResult result = super.doExecuteWithResult(
						progressMonitor, info);
				if (resource != null) {
					resource.getContents().add(referencedObject);
				}
				return result;
			}
		});
	}

}
