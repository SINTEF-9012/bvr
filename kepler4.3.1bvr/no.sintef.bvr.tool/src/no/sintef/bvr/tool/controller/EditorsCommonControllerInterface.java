package no.sintef.bvr.tool.controller;

import no.sintef.bvr.tool.context.Context;

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
	
	default public void enableBatchCommandProcessing() {
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
	};
	
	default public void disableBatchCommandProcessing() {
		Context.eINSTANCE.getEditorCommands().disableBatchProcessing();
	};
	
	default public void executeCommandBatch() {
		Context.eINSTANCE.getEditorCommands().executeBatch();
	};	
}
