package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import bvr.BVRModel;
import bvr.BvrFactory;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;

public class NewResolutionEvent implements ActionListener {
	private BVRModel cu;
	private BVRToolView v;

	public NewResolutionEvent(BVRModel cu, BVRToolView bvrView) {
		this.cu = cu;
		this.v = bvrView;
	}

	public void actionPerformed(ActionEvent arg0) {
	
		//ChoiceResolutuion cr = BvrFactory.eINSTANCE.createChoiceResolutuion();
		//cu.getOwnedVSpecResolution().add(cr);
		//Context.eINSTANCE.getEditorCommands().createNewResolution(cr, cu);
		
		//v.notifyResolutionViewUpdate();
	}

}
