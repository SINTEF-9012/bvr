package no.sintef.bvr.tool.controller.command;


import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import bvr.NamedElement;
import bvr.VSpec;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.SelectElement;

public class SelectInstanceCommand implements Command {

    private BVRUIKernel kernel;
    private static SelectElement currentlySelected = null;//only one element can be selected
    
    private SelectElement selectableElement;
    
	public static void unselect() {
		System.out.println("unselect");
		if (currentlySelected != null)
			currentlySelected.setSelected(false);
	}

	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		
		kernel = rootPanel;
		
        if (p instanceof SelectElement) {
        	selectableElement = (SelectElement) p;
        }else{
        	throw new UnsupportedOperationException(p + " not instance of SelectElement");
        }
        return this;
	}

	public JComponent execute() {
		if (currentlySelected != null && currentlySelected != selectableElement) {
            currentlySelected.setSelected(false);
        }
        currentlySelected = selectableElement;
		
		currentlySelected.setSelected(!currentlySelected.isSelected());

        kernel.getEditorPanel().showPropertyFor((JPanel) currentlySelected);


        ((JPanel)currentlySelected).repaint();
        ((JPanel)currentlySelected).revalidate();
        kernel.getModelPanel().repaint();
        kernel.getModelPanel().revalidate();

		return null;
	}
}
