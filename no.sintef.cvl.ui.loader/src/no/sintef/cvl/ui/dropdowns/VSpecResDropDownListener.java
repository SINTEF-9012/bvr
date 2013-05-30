package no.sintef.cvl.ui.dropdowns;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.commands.DelAllResEvent;
import no.sintef.cvl.ui.commands.DelResEvent;
import no.sintef.cvl.ui.commands.events.AddChoiceEvent;
import no.sintef.cvl.ui.commands.events.AddClassifierEvent;
import no.sintef.cvl.ui.commands.events.RemoveChoiceEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToAltEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToNoneEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToOrEvent;
import no.sintef.cvl.ui.framework.elements.VClassifierPanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;
import cvl.ConfigurableUnit;
import cvl.VSpec;
import cvl.VSpecResolution;

public class VSpecResDropDownListener extends MouseAdapter {
	private VSpecResolution v;
	private CVLView cvlView;
	private ConfigurableUnit cu;

	public VSpecResDropDownListener(ConfigurableUnit cu, VSpecResolution v,	CVLView cvlView) {
		this.cu = cu;
		this.v = v;
		this.cvlView = cvlView;
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
    	VSpecResDropdown menu = new VSpecResDropdown(cu, v, cvlView);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VSpecResDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VSpecResDropdown(ConfigurableUnit cu, VSpecResolution v, CVLView cvlView){
    	/*JMenuItem del = new JMenuItem("delete");
    	del.addActionListener(new DelResEvent(cu, v, cvlView));
		add(del);
		*/
		JMenuItem delall = new JMenuItem("remove all");
		delall.addActionListener(new DelAllResEvent(cu, cvlView));
		add(delall);
    }
}