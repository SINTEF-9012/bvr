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

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

import splar.core.fm.FeatureModelException;
import splar.plugins.reasoners.bdd.javabdd.BDDExceededBuildingTimeException;

public class CalcNumberOfProductsTest {
	@Test
	public void testCalcJplug() throws FeatureModelException, BDDExceededBuildingTimeException{
		String file = "TestData/Artificial/Jplug-fm.xml";
		SXFM fm = new SXFM(file);
		assertEquals(80, (long)fm.getNrOfProducts());
	}
	
	@Test
	public void testCalcEclipse() throws UnsupportedModelException, IOException, FeatureModelException, BDDExceededBuildingTimeException{
		String file = "TestData/Artificial/EclipseSPL.m";
		GUIDSL m = new GUIDSL(new File(file));
		SXFM fm = m.getSXFM();
		assertEquals(1024, (long)fm.getNrOfProducts());
	}
}
