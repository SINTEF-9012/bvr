package no.sintef.cvl.gmf.vspec.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import cvl.ConfigurableUnit;

/**
 * @generated
 */
public class ChoiceEditHelper extends CVLMetamodelBaseEditHelper {

	/**
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
