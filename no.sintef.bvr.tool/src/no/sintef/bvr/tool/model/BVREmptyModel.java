/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.model;

import java.io.File;

import no.sintef.ict.splcatool.SPLCABVRModel;
import bvr.BVRModel;


public class BVREmptyModel extends BVRToolModel {

		
	public BVREmptyModel(File sf) {
		f = sf;
		bvrm = new BVRInnerModel();
		loadFilename = sf.getAbsolutePath();
		saved = false;
	}

	@Override
	public SPLCABVRModel getSPLCABVRModel() {
		return bvrm;
	}

	@Override
	public BVRModel getBVRModel() {
		return bvrm.getRootBVRModel();
	}
	
	public void setBVRModel(BVRModel bvrModel){
		((BVRInnerModel) bvrm).setBVRModel(bvrModel);
	}

	@Override
	public File getFile() {
		return f;
	}
	
	private class BVRInnerModel extends SPLCABVRModel {
		
		public void setBVRModel(BVRModel _model){
			loaded_model =_model;
			init();
		}

	}
}
