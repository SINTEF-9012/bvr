package no.sintef.cvl.gmf.vspec.providers;

import no.sintef.cvl.gmf.vspec.edit.parts.CVLMetamodelEditPartFactory;
import no.sintef.cvl.gmf.vspec.edit.parts.ConfigurableUnitEditPart;
import no.sintef.cvl.gmf.vspec.part.CVLMetamodelVisualIDRegistry;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

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
