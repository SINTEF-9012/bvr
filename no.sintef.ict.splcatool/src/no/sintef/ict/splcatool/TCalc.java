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

import java.util.List;

import org.apache.commons.math.util.MathUtils;

public class TCalc {
	
	/**
	 *  How many t-tuples does a row cover
	 * @param n
	 * @param t
	 * @return
	 */
	public static long tsTotal(int n, int t) {
		return MathUtils.binomialCoefficient(2*n, t);
	}

	/**
	 *  How many t-tuples does a row cover
	 * @param n
	 * @param t
	 * @return
	 */
	public static long tsCovered(int n, int t) {
		if(n<t) return 0;
		return MathUtils.binomialCoefficient(n, t);
	}

	/**
	 *  How many t-tuples does both rows cover?
	 * @param a
	 * @param b
	 * @param t
	 * @return
	 */
	public static long tsAOverlapB(List<Boolean> a, List<Boolean> b, int t) {
		int c = 0;
		int n = a.size();
		for(int i = 0;i<n;i++)
			if(a.get(i) == b.get(i))
				c++;
		return tsCovered(c, t);
	}

	/** How many t-tuples does (a U b) and c cover?
	 * 
	 * Set up a venn diagram to verify this
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param t
	 * @return
	 */
	public static long tsAuBOverlapC(List<Boolean> a, List<Boolean> b, List<Boolean> c, int t) {
		return tsAOverlapB(a, c, t) + tsAOverlapB(b, c, t) - tsAOverlapB(a, b, t);
	}

}
