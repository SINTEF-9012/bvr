/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.interfaces.ui.editor;

public class Pair<T, S>{
	public T a;
	public S b;
	
	public Pair(T from, S to) {
		a = from;
		b = to;
	}
}
