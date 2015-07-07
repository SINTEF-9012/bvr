/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRRealizationUIKernelInterface;
import no.sintef.bvr.tool.ui.command.event.CreateBindingsEvent;
import no.sintef.bvr.tool.ui.command.event.DeleteFragmentSubstitutionEvent;
import no.sintef.bvr.tool.ui.editor.FragmentSubstitutionJTable;


public class FragmentSubstitutionTableDropDown extends
		FragmentSubstitutionDropDown {

	private static final long serialVersionUID = 2778779861676603393L;
	
	public FragmentSubstitutionTableDropDown(BVRNotifiableController _controller) {
		super(_controller);
		BVRRealizationUIKernelInterface kenrel = controller.getRealizationControllerInterface().getUIKernel();
		FragmentSubstitutionJTable jtable = (FragmentSubstitutionJTable) kenrel.getFragmentSubstitutionTable();
		if(jtable.getSelectedRows().length != 0){
			add(new JSeparator());
			JMenuItem generateBindings = new JMenuItem(Constants.REALIZATION_GENERATE_BINDINGS);
			generateBindings.addActionListener(new CreateBindingsEvent(controller));
			add(generateBindings);
			
			add(new JSeparator());
			JMenuItem deleteFragmentSubstitution = new JMenuItem(Constants.REALIZATION_DL_FS_NAME);
			deleteFragmentSubstitution.addActionListener(new DeleteFragmentSubstitutionEvent(controller));
			add(deleteFragmentSubstitution);
		}
	}

}
