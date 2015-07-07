/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.commands;

public class EditorCommandsFactory {

	public static EditorCommands eINSTANCE = null;
	
	public static EditorCommands Create(boolean transactional){
		if(eINSTANCE == null)
			eINSTANCE = (transactional) ? EditorEMFTransactionalCommands.Get() : EditorMVCCommands.Get();
		return eINSTANCE;
	}
	
	public static EditorCommands Create(){
		if(eINSTANCE == null)
			eINSTANCE = EditorMVCCommands.Get();
		return eINSTANCE;
	}
}
