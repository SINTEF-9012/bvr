package no.sintef.bvr.tool.controller;

public interface EditorsCommonControllerInterface<SERIALIZABLE> {

	default public void exportAsPNGImage(SERIALIZABLE file) {
		throw new UnsupportedOperationException("not implemented");
	};

	default public String getModelFileLocation() {
		throw new UnsupportedOperationException("not implemented");
	};
}
