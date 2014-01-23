package no.sintef.bvr.gmf.vspec.providers;

import no.sintef.bvr.gmf.vspec.edit.parts.CVLMetamodelEditPartFactory;
import no.sintef.bvr.gmf.vspec.edit.parts.ConfigurableUnitEditPart;
import no.sintef.bvr.gmf.vspec.part.CVLMetamodelVisualIDRegistry;

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
