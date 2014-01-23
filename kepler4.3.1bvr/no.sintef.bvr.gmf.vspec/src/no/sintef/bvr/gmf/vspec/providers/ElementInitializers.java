package no.sintef.bvr.gmf.vspec.providers;

import no.sintef.bvr.gmf.vspec.part.BVRMetamodelDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = BVRMetamodelDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			BVRMetamodelDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
