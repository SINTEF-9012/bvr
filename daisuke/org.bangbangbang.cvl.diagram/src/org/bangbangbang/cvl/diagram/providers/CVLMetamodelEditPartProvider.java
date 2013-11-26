package org.bangbangbang.cvl.diagram.providers;

import org.bangbangbang.cvl.diagram.edit.parts.CVLMetamodelEditPartFactory;
import org.bangbangbang.cvl.diagram.edit.parts.ConfigurableUnitEditPart;
import org.bangbangbang.cvl.diagram.part.CVLMetamodelVisualIDRegistry;
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
