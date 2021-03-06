/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.model;

import no.sintef.bvr.tool.context.Context;
import bvr.BvrFactory;
import bvr.ChoiceOccurrence;
import bvr.CompoundNode;
import bvr.VClassOccurrence;
import bvr.VType;


public final class VTypeFacade {
	
	final private String defaultName = "newType";
	private static int count = 0;
	
	public static VTypeFacade eINSTANCE = getInstance();
	
	private static VTypeFacade getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new VTypeFacade();
		return eINSTANCE;
	}


	public VType appendVTypeCopoundNode(CompoundNode parent) {
		VType vType = BvrFactory.eINSTANCE.createVType();
		vType.setName(defaultName + count);
		count++;
		Context.eINSTANCE.getEditorCommands().addVTypeCompoundNode(parent, vType);
		return vType;
	}
	
	public void setChoiceOccurenceVType(ChoiceOccurrence choiceOccurence, VType vType) {
		Context.eINSTANCE.getEditorCommands().setChoiceOccurenceVType(choiceOccurence, vType);
	}


	public void setVClassOccurenceVType(VClassOccurrence vclassOccurence, VType vType) {
		Context.eINSTANCE.getEditorCommands().setVClassOccurenceVType(vclassOccurence, vType);
	}
}
