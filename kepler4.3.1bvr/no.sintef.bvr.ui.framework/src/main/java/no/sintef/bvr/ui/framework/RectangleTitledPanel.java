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
package no.sintef.bvr.ui.framework;

import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTitledSeparator;

/**
 *
 * @author ffouquet
 */
public class RectangleTitledPanel extends RectanglePanel implements TitledElement {

    private JPanel contentPanel = new JPanel();
    private JPanel layoutPanel = new JPanel();
    private JXLabel title = new JXLabel();

    public RectangleTitledPanel() {
        contentPanel.setOpaque(false);
        layoutPanel.setOpaque(false);
        layoutPanel.setLayout(new BorderLayout());
        super.add(layoutPanel);
        layoutPanel.add(title, BorderLayout.NORTH);
        layoutPanel.add(contentPanel, BorderLayout.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.WHITE);

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
    }

    @Override
    public Component add(Component comp) {
        return contentPanel.add(comp);
    }

    @Override
    public void remove(Component comp) {
        contentPanel.remove(comp);
    }

    public void setTitle(String _title) {
        title.setText(_title);
    }

    public String getTitle(){
        return title.getText();
    }
}
