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
import no.sintef.bvr.ui.framework.elements.CustomTextField;

public class SetGroupCustomEvent implements ActionListener {
	private JComponent p;
	private BVRNotifiableController controller;

	public SetGroupCustomEvent(JComponent p, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {

		CustomTextField upperField = new CustomTextField();
		upperField.setColumns(10);
		CustomTextField lowerField = new CustomTextField();
		upperField.setColumns(10);
		JPanel myPanel = new JPanel();
		myPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();

		constraint.anchor = GridBagConstraints.WEST;
		constraint.gridy = 0;
		constraint.gridx = 0;
		myPanel.add(new JLabel("Lower limit:"), constraint);
		constraint.fill = GridBagConstraints.BOTH;
		constraint.gridx = 1;
		myPanel.add(lowerField, constraint);
		constraint.gridy = 1;
		constraint.gridx = 0;
		myPanel.add(new JLabel("Upper limit:"), constraint);
		constraint.gridx = 1;
		myPanel.add(upperField, constraint);

		int result = JOptionPane.showConfirmDialog(p, myPanel, "Please Enter the desired upper and lower limits of the grouping",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			String upper = upperField.getText();
			String lower = lowerField.getText();
			int upperInt = 0;
			int lowerInt = 0;

			try {
				if (upper.equals("*")) {
					upperInt = -1;
				} else {
					upperInt = Integer.parseInt(upper);
				}
				lowerInt = Integer.parseInt(lower);

			} catch (NumberFormatException e) {
				return;
			}
			if (upperInt < -1 || lowerInt < 0) {
				return;
			}
			if (upperInt >= lowerInt)
				controller.getVSpecControllerInterface().setGroupMultiplicityCustom(p, upperInt, lowerInt);
			else {
				JOptionPane.showMessageDialog(null, "lower limit must be <= upper limit");

			}
		}
	}
}
