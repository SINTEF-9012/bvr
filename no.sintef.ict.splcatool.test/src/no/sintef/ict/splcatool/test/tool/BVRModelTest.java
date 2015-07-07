/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.ict.splcatool.test.tool;

import static org.junit.Assert.*;

import java.io.File;

import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;

import org.junit.Test;

public class BVRModelTest {

	@Test
	public void testBVRModelFile() {
		BVRToolModel m = new BVRSimpleToolModel(new File("TestData/Artificial/Apl.m.bvr"));
		assertTrue(m != null);
	}

}
