package org.bangbangbang.cvl.system.def.edit.helpers;

import org.bangbangbang.cvl.VClassifier;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * @generated
 */
public class MultiplicityIntervalEditHelper extends CVLMetamodelBaseEditHelper {
	/**
	 * Change: Override getDestroyElementCommand for disable delete at VClassifier's instance multiplicity
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
