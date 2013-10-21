package cvl.diagram.providers;

import cvl.diagram.part.CVLMetamodelDiagramEditorPlugin;

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
		ElementInitializers cached = CVLMetamodelDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			CVLMetamodelDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
