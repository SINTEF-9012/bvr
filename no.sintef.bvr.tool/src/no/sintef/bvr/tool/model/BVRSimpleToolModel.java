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

public class BVRSimpleToolModel extends BVRToolModel {

	public BVRSimpleToolModel(File file, SPLCABVRModel bvrm) {
		super(file, bvrm);
	}

	public BVRSimpleToolModel(File file, String platformPath, boolean platform) {
		super(file, platformPath, platform);
	}

	public BVRSimpleToolModel(File f) {
		super(f);
	}

}
