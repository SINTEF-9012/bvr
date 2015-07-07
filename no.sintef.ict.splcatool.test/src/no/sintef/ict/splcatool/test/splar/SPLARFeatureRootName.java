/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.ict.splcatool.test.splar;

import static org.junit.Assert.*;

import org.junit.Test;

import splar.core.constraints.PropositionalFormula;

public class SPLARFeatureRootName {

	@Test
	public void testAtInTheName() {
		Boolean flag = true;
		String name = "A@1";
		try {
			PropositionalFormula pr = new PropositionalFormula("needroot", name);
		} catch (Exception e) {
			flag = false;
		}
		assertTrue("This name should be allowed '" + name + "'", flag);
	}
	
	@Test
	public void testNotAllowedSymbol() {
		Boolean flag = true;
		String name = "A@ 1";
		try {
			PropositionalFormula pr = new PropositionalFormula("needroot", name);
		} catch (Exception e) {
			flag = false;
		}
		assertFalse("This name should not be allowed '" + name + "'", flag);
	}

}
