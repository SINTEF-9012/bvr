package no.sintef.bvr.gmf.vspec.providers;

import no.sintef.bvr.gmf.vspec.edit.parts.BVRMetamodelEditPartFactory;
import no.sintef.bvr.gmf.vspec.edit.parts.ConfigurableUnitEditPart;
import no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class BVRMetamodelEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public BVRMetamodelEditPartProvider() {
		super(new BVRMetamodelEditPartFactory(),
				BVRMetamodelVisualIDRegistry.TYPED_INSTANCE,
				ConfigurableUnitEditPart.MODEL_ID);
	}

}
