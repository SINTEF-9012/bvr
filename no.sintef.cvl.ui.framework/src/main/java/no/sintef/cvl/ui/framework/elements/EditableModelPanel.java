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
package no.sintef.cvl.ui.framework.elements;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.explodingpixels.macwidgets.HudWindow;

/**
 * @author ffouquet
 */
public class EditableModelPanel extends JLayeredPane {

    private JPanel propertiesPanel = null;
    private JButton closeProperties = new JButton("Close");
    private JComponent modelPanel = null;

    public EditableModelPanel(JComponent _modelPanel) {
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
        });

        add(modelPanel, JLayeredPane.DEFAULT_LAYER);
        add(propertiesPanel, JLayeredPane.POPUP_LAYER);
    }

    private JPanel previousPropertiesPanel = null;

    HudWindow hud = new HudWindow("Properties editor");

    public void displayProperties(JPanel prop) {
        hud.getJDialog().setSize(320, 440);
        hud.getJDialog().setLocationRelativeTo(null);
        hud.getJDialog().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hud.setContentPane(prop);
        hud.getJDialog().setVisible(true);
    }

    public void undisplayProperties() {
        hud.getJDialog().setVisible(false);
    }
}
