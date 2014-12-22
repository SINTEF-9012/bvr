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
/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.ui.framework.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//import com.explodingpixels.macwidgets.HudWindow;

/**
 * @author ffouquet
 */
public class EditableModelPanel extends JLayeredPane {

	private static final long serialVersionUID = 7573336297061006849L;

	private JPanel propertiesPanel = null;
	private JButton closeProperties = new JButton("Close");
	public JComponent modelPanel = null;
	public JDialog dialog = null;

	public EditableModelPanel(JComponent _modelPanel) {
		this.setBackground(Color.WHITE);
		modelPanel = _modelPanel;
		closeProperties.setOpaque(false);
		closeProperties.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent me) {
				undisplayProperties();
			}
		});
		propertiesPanel = new JPanel();
		propertiesPanel.setLayout(new BorderLayout());
		propertiesPanel.setOpaque(false);
		this.setOpaque(false);

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				modelPanel.setBounds(0, 0, getWidth(), getHeight());
				propertiesPanel.setBounds(0, 0, getWidth(), getHeight());
				doLayout();
				repaint();
				revalidate();
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// System.out.println("   hidden!");
				undisplayProperties();
			}
		});

		add(modelPanel, JLayeredPane.DEFAULT_LAYER);
		add(propertiesPanel, JLayeredPane.POPUP_LAYER);
	}

	// HudWindow hud = new HudWindow("Properties editor");

	public void displayProperties(JPanel prop) {
		/*
		 * hud.getJDialog().setSize(320, 440); hud.getJDialog().setLocationRelativeTo(null); hud.getJDialog().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); hud.setContentPane(prop);
		 * hud.getJDialog().setVisible(true);
		 */
		if (dialog != null)
			dialog.dispose();

		dialog = new JDialog();
		dialog.setTitle("Properties editor");
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setContentPane(prop);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);

	}

	public void displayProperties(JPanel content, Component parent, Dialog.ModalityType mode) {
		if (dialog != null)
			dialog.dispose();
		Window parentWindow = findWindow(parent);
		dialog = new JDialog(parentWindow, "Properties editor", mode);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setContentPane(content);
		
		dialog.pack();
		dialog.setLocationRelativeTo(parentWindow);
	
		dialog.addWindowFocusListener(new WindowFocusListener() {
		
			public void windowLostFocus(WindowEvent e) {

			}

			public void windowGainedFocus(WindowEvent e) {
				setFocusRec(dialog);
			}
		});
		dialog.setVisible(true);
	}

	public void undisplayProperties() {
		if (dialog != null)

			dialog.dispose();
		// hud.getJDialog().setVisible(false);
		// SelectInstanceCommand.unselect();
	}

	public static Window findWindow(Component c) {
		if (c == null) {
			return JOptionPane.getRootFrame();
		} else if (c instanceof Window) {
			return (Window) c;
		} else {
			return findWindow(c.getParent());
		}
	}

	private boolean setFocusRec(final Container p) {
		if (p == null) {
			return false;
		}
		for(Component c : p.getComponents()){
			if (c instanceof CustomTextField){
				c.requestFocusInWindow();
				return true;
			}
			else{
				if (setFocusRec((Container) c)){
					return true;
				}
			}
		}
		for (int i = 0; i < p.getComponentCount(); i++) {
				if (setFocusRec((Container) p.getComponent(i))) {
					return true;
				}
			}
		
		return false;
	}


}
