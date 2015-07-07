/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
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

	default boolean isSubstitutionEngineInitialized() {
		throw new UnsupportedOperationException("not implemented");
	};
}
