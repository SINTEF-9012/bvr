package cvl.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import cvl.diagram.edit.parts.CVLMetamodelEditPartFactory;
import cvl.diagram.edit.parts.ConfigurableUnitEditPart;
import cvl.diagram.part.CVLMetamodelVisualIDRegistry;

/**
 * @generated
 */
public class CVLMetamodelEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public CVLMetamodelEditPartProvider() {
		super(new CVLMetamodelEditPartFactory(),
				CVLMetamodelVisualIDRegistry.TYPED_INSTANCE,
				ConfigurableUnitEditPart.MODEL_ID);
	}

}
