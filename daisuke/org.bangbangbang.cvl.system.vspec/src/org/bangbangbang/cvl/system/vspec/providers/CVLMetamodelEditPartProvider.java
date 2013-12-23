package org.bangbangbang.cvl.system.vspec.providers;

import org.bangbangbang.cvl.system.vspec.edit.parts.CVLMetamodelEditPartFactory;
import org.bangbangbang.cvl.system.vspec.edit.parts.VInterfaceEditPart;
import org.bangbangbang.cvl.system.vspec.part.CVLMetamodelVisualIDRegistry;
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
				VInterfaceEditPart.MODEL_ID);
	}

}
