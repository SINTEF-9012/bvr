/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.common;

public interface IBVRTypeEditorInput<VTYPE> {

	public VTYPE getVType();
	
	public void setVType(VTYPE vType);
}
