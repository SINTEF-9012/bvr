package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import no.sintef.bvr.tool.ui.loader.BVRView;


public class BindingEditorDropDownListener extends MouseAdapter {

	BVRView view;
	
	public BindingEditorDropDownListener(BVRView _view) {
		view = _view;
	}

	public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e){
    	BindingEditorDropDown menu = new BindingEditorDropDown(view);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}
