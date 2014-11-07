package no.sintef.bvr.tool.controller;

public interface EditorsCommonControllerInterface<SERIALIZABLE, GUI_NODE, MODEL_OBJECT> {

	default public void exportAsPNGImage(SERIALIZABLE file) {
		throw new UnsupportedOperationException("not implemented");
	};

	default public String getModelFileLocation() {
		throw new UnsupportedOperationException("not implemented");
	};

	default public MODEL_OBJECT getModelObjectByUINode(GUI_NODE node) {
		throw new UnsupportedOperationException("not implemented");
	};
}
