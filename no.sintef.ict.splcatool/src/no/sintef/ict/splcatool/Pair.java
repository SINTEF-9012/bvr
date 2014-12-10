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

import splar.core.constraints.BooleanVariableInterface;

class Pair{
	public Pair() {
	}
	
	public Pair(BooleanVariableInterface v, Boolean b) {
		this.v = v;
		this.b = b;
	}

	BooleanVariableInterface v;
	Boolean b;
	
	@Override
	final public int hashCode() {
		return v.hashCode() + b.hashCode();
	}
	
	@Override
	final public boolean equals(Object obj) {
		Pair p = (Pair) obj;
		return(p.v==v && p.b==b);
	}
	
	@Override
	public String toString(){
		return v.getID() + ":" + b;
	}
}