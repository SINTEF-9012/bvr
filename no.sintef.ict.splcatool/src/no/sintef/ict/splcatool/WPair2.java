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

import java.util.Map;

public class WPair2 extends Pair2 implements Comparable<WPair2> {
	
	private int weight;
	
	public int getWeight(){
		return weight;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}

	public WPair2(Map<String, Integer> idnr, int weight) {
		super(idnr);
		this.weight = weight;
	}

	@Override
	public int compareTo(WPair2 o) {
		if(o.weight>this.weight) return 1;
		if(o.weight<this.weight) return -1;
		else return 0;
	}

	@Override
	public String toString() {
		return super.toString() + "," + weight;
	}
}
