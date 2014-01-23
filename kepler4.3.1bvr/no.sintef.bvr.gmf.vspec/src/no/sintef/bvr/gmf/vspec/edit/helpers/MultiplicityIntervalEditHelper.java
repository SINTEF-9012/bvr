package no.sintef.bvr.gmf.vspec.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import bvr.VClassifier;

/**
 * @generated
 */
public class MultiplicityIntervalEditHelper extends CVLMetamodelBaseEditHelper {
	/**
	 * @generated NOT
	 */
	@Override
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
		if (req.getElementToDestroy().eContainer() instanceof VClassifier
				&& ((VClassifier) req.getElementToDestroy().eContainer())
						.getInstanceMultiplicity() == req.getElementToDestroy()) {
			// Prevents from removing the figure
			return UnexecutableCommand.INSTANCE;
		}
		return super.getDestroyElementCommand(req);
	}
}
