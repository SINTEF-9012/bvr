package no.sintef.cvl.ui.edit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import com.explodingpixels.macwidgets.plaf.HudButtonUI;

import no.sintef.cvl.ui.command.Command;
import no.sintef.cvl.ui.loader.CVLView;

public class JCommandButton extends JButton {

	protected Command command;
	
    public JCommandButton(final String title, final Command command){
    	this.command = command;
        this.setText(title);
        this.setOpaque(false);
        this.setUI(new HudButtonUI());
        this.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
        		command.execute();
            }
        });

    }
}
