package no.sintef.bvr.tool.ui.command.event;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;

public class SetGroupCustomEvent implements ActionListener {
	private JComponent p;
	private BVRNotifiableController controller;

	public SetGroupCustomEvent(JComponent p, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
		numberFormat.setParseIntegerOnly(true);
		JFormattedTextField xField = new JFormattedTextField(numberFormat);
		xField.setColumns(10);
		JFormattedTextField yField = new JFormattedTextField(numberFormat);
		xField.setColumns(10);
		JPanel myPanel = new JPanel();
		myPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		
		constraint.anchor = GridBagConstraints.WEST;
		constraint.gridy = 0;
		constraint.gridx = 0;
		myPanel.add(new JLabel("Lower limit:"), constraint);
		constraint.fill = GridBagConstraints.BOTH;
		constraint.gridx = 1;
		constraint.gridwidth = 2;
		myPanel.add(xField, constraint);
		//constraint.gridx = 2; 
		//myPanel.add(Box.createHorizontalStrut(2), constraint); // a spacer
		constraint.gridy = 1;
		constraint.gridx = 0;
		myPanel.add(new JLabel("Upper limit:"), constraint);
		constraint.gridx = 1;
		myPanel.add(yField, constraint);
		constraint.gridx = 0;
		constraint.gridy = 2;
		myPanel.add(new JLabel("set limit to -1 to mean infinite"), constraint);
		
		int result = JOptionPane.showConfirmDialog(p, myPanel, "Please Enter the desired upper and lower limits of the grouping", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION && !xField.getText().equals("") && !yField.getText().equals("")) {
				int x = Integer.parseInt(xField.getText());
				int y = Integer.parseInt(yField.getText());
				if ((x <= y) || (y==-1))
					controller.getVSpecControllerInterface().setGroupMultiplicityCustom(p, x, y);
				else {
					JOptionPane.showMessageDialog(null, "lower limit must be >= upper limit");
				
			}
		}
	}
}
