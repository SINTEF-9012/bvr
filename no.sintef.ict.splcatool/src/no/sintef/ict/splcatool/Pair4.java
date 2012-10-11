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

import splar.core.constraints.BooleanVariableInterface;

class Pair4{
	@Override
	public int hashCode() {
		return v1.hashCode() + b1.hashCode() + v2.hashCode() + b2.hashCode() + v3.hashCode() + b3.hashCode() + v4.hashCode() + b4.hashCode();
	}

	private Map<String, Integer> idnr;

	public Pair4(Map<String, Integer> idnr){
		this.idnr = idnr;
	}
	
	BooleanVariableInterface v1, v2, v3, v4;
	Boolean b1, b2, b3, b4;
	
	public String toString(){
		return idnr.get(v1.getID()) + ":" + b1 + "," + idnr.get(v2.getID()) + ":" + b2 + "," + idnr.get(v3.getID()) + ":" + b3 + "," + idnr.get(v4.getID()) + ":" + b4;
	}

	@Override
	public boolean equals(Object obj) {
		Pair4 op = (Pair4) obj;
		if(this.b1 != op.b1) return false;
		if(this.b2 != op.b2) return false;
		if(this.b3 != op.b3) return false;
		if(this.b4 != op.b4) return false;
		if(this.v1 != op.v1) return false;
		if(this.v2 != op.v2) return false;
		if(this.v3 != op.v3) return false;
		if(this.v4 != op.v4) return false;
		return true;
	}
}
