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

class Pair2{
	@Override
	final public int hashCode() {
		return v1.hashCode() + b1.hashCode() + v2.hashCode() + b2.hashCode();
	}

	private Map<String, Integer> idnr;

	public Pair2(Map<String, Integer> idnr){
		this.idnr = idnr;
	}
	
	BooleanVariableInterface v1;
	Boolean b1;
	BooleanVariableInterface v2;
	Boolean b2;
	
	public String toString(){
		return idnr.get(v1.getID()) + ":" + b1 + "," + idnr.get(v2.getID()) + ":" + b2;
	}

	@Override
	final public boolean equals(Object obj) {
		Pair2 op = (Pair2) obj;
		
		if( this.b1 == op.b1 &&
			this.b2 == op.b2 &&
			this.v1 == op.v1 &&
			this.v2 == op.v2
		) return true;
		
		if( this.b1 == op.b2 &&
			this.b2 == op.b1 &&
			this.v1 == op.v2 &&
			this.v2 == op.v1
		) return true;
		
		return false;
	}
}