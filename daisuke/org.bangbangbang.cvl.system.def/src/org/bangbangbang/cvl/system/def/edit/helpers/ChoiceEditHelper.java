package org.bangbangbang.cvl.system.def.edit.helpers;

import org.bangbangbang.cvl.ConfigurableUnit;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * @generated
 */
public class ChoiceEditHelper extends CVLMetamodelBaseEditHelper {
	/**
	 * Change: override getDestroyElementCommand for disable delete root choice
	 * @generated NOT
	 */
	@Override
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
		if (req.getElementToDestroy().eContainer() instanceof ConfigurableUnit) {
			// Prevents from removing the figure
			return UnexecutableCommand.INSTANCE;
		}
		return super.getDestroyElementCommand(req);
	}

}
