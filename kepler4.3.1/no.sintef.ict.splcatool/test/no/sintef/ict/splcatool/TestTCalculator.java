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

import java.util.ArrayList;
import java.util.List;

import no.sintef.ict.splcatool.TCalc;

import org.junit.Test;


public class TestTCalculator {
	@Test
	public void testTsCovered(){
		assertEquals(1, TCalc.tsCovered(2, 2));
		assertEquals(3, TCalc.tsCovered(3, 2));
		assertEquals(36, TCalc.tsCovered(9, 2));
		assertEquals(84, TCalc.tsCovered(9, 3));
	}
	
	@Test
	public void testTsOverlap(){
		List<Boolean> a = new ArrayList<Boolean>();
		a.add(true);a.add(true);a.add(true);a.add(true);a.add(true);
		List<Boolean> b = new ArrayList<Boolean>();
		b.add(true);b.add(true);b.add(true);b.add(true);b.add(true);
		assertEquals(10, TCalc.tsAOverlapB(a, b, 2));
		a.add(false);
		b.add(true);
		assertEquals(10, TCalc.tsAOverlapB(a, b, 2));
		a.add(true);
		b.add(true);
		assertEquals(15, TCalc.tsAOverlapB(a, b, 2));
		a.add(false);
		b.add(true);
		assertEquals(15, TCalc.tsAOverlapB(a, b, 2));
	}
	
	@Test
	public void testTsGroupOverlap(){
		List<Boolean> a = new ArrayList<Boolean>();
		a.add(true);a.add(true);a.add(true);a.add(true);a.add(true);
		List<Boolean> b = new ArrayList<Boolean>();
		b.add(true);b.add(true);b.add(true);b.add(true);b.add(true);
		List<Boolean> c = new ArrayList<Boolean>();
		c.add(true);c.add(true);c.add(true);c.add(true);c.add(true);
		assertEquals(10, TCalc.tsAuBOverlapC(a, b, c, 2));
	}
}
