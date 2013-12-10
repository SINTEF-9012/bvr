package org.bangbangbang.cvl.system.def.providers;

import org.bangbangbang.cvl.system.def.edit.parts.CVLMetamodelEditPartFactory;
import org.bangbangbang.cvl.system.def.edit.parts.ConfigurableUnitEditPart;
import org.bangbangbang.cvl.system.def.part.CVLMetamodelVisualIDRegistry;
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
