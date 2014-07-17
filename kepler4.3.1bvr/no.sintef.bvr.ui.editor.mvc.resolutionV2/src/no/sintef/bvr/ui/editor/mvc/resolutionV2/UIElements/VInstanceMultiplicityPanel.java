package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements;

/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.command.UpdateVSpec;
import no.sintef.bvr.tool.ui.edit.SpringUtilities;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddMultipleInstanceTreesEvent;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpecResolution;

public class VInstanceMultiplicityPanel extends JPanel {

	/**
		 * 
		 */
	private static final long serialVersionUID = -4949756230330251228L;

	protected BVRViewV2 view;
	int requestedInstances;
	protected JPanel top;
	protected JPanel bottom;

	VSpecResolution parent;

	protected VClassifier c;

	public void addCenter(JComponent p) {
		this.add(p);
	}

	public void pack(int rows, int cols) {
		SpringUtilities.makeCompactGrid(
				top, 
				rows, cols, // rows, cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

	}

	protected Command command;

	protected void init() {
		command = new UpdateVSpec();
		command.init(null, c, null, null, null, null, view);
	}

	public VInstanceMultiplicityPanel(final VClassifier c, final VSpecResolution parent, final BVRViewV2 view) {
		requestedInstances = 0;
		for (VSpecResolution x : parent.getChild()){
			if (x instanceof VInstance){
				if (x.getResolvedVSpec() == c){
					requestedInstances++;
				}
			}
		}
		this.setOpaque(false);
		this.setBorder(null);

		this.c = c;

		init();

		top = new JPanel(new SpringLayout());
		top.setBorder(null);
		top.setOpaque(false);

		bottom = new JPanel();
		bottom.setBorder(null);
		bottom.setOpaque(false);

		this.addCenter(top);
		this.addCenter(bottom);

		final JButton okButton = new JButton();
		okButton.addActionListener(new AddMultipleInstanceTreesEvent(requestedInstances, parent, c, view));
		okButton.setText("ok");

		// Name
		JPanel p = new JPanel(new SpringLayout());
		p.setBorder(null);
		p.setOpaque(false);
		bottom.add(okButton);
		JLabel l = new JLabel(c.getInstanceMultiplicity().getUpper() + "/" + c.getInstanceMultiplicity().getLower(), JLabel.TRAILING);
		//JLabel l2 = new JLabel("upper limit is: " + c.getInstanceMultiplicity().getLower(), JLabel.TRAILING);
		// l.setUI(new HudLabelUI());

		p.add(l);
	//	p.add(l2);
		final JTextField textField = new JTextField(15);

		// textField.setUI(new HudTextFieldUI());

		l.setLabelFor(textField);
		p.add(textField);
		textField.setText(Integer.toString(requestedInstances));

		top.add(p);
		SpringUtilities.makeCompactGrid(p, 1, 2, // rows, cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		pack(1, 1);

		textField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddMultipleInstanceTreesEvent(requestedInstances, parent, c, view).actionPerformed(e);
				
			}
		});
			
		
		textField.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				requestedInstances = Integer.parseInt(textField.getText());
				System.out.println("setting requestedInstances to: "+requestedInstances);
			}

			public void removeUpdate(DocumentEvent e) {
				insertUpdate(e);
			}

			public void changedUpdate(DocumentEvent e) {
				insertUpdate(e);
			}
		});
	}
}
