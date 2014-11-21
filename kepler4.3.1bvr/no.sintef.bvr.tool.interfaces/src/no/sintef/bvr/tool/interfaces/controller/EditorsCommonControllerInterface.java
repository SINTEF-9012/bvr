package no.sintef.bvr.tool.interfaces.controller;


public interface EditorsCommonControllerInterface<SERIALIZABLE, GUI_NODE, MODEL_OBJECT> {

	default public void exportAsPNGImage(SERIALIZABLE file) {
		throw new UnsupportedOperationException("not implemented");
	}

	default public String getModelFileLocation() {
		throw new UnsupportedOperationException("not implemented");
	}

	default public MODEL_OBJECT getModelObjectByUINode(GUI_NODE node) {
		throw new UnsupportedOperationException("not implemented");
	}
	
	default public void enableBatchCommandProcessing() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	default public void disableBatchCommandProcessing() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	default public void executeCommandBatch() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	default public void setNodeName(GUI_NODE node, String name) {
		throw new UnsupportedOperationException("not implemented");
	}
}
