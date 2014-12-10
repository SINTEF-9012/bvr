/*******************************************************************************
 * Copyright (c) 2011, 2012 SINTEF, Martin F. Johansen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SINTEF, Martin F. Johansen - the implementation
 *******************************************************************************/

package no.sintef.ict.splcatool;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;

import org.junit.Test;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class GUIDSLTest {
	@Test
	public void loadSaveTest() throws UnsupportedModelException, IOException{
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			if(!file.endsWith(".m")) continue;
			System.out.println("Test loading and saving of GUIDSL file: " + file);
			GUIDSL m1 = new GUIDSL(new File(file));
			m1.writeToFile("test.dat");
			GUIDSL m2 = new GUIDSL(new File("test.dat"));
			assertTrue(file, m1.equals(m2));
		}
	}
}
