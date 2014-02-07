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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTitledSeparator;

/**
 * @author ffouquet
 */
public class IconPanel extends JPanel implements SelectElement, TitledElement, ErrorHighlightableElement {

    JXLabel titlebar = new JXLabel();
    private BufferedImage image;

    public IconPanel(String imgPath) {
        setLayout(new BorderLayout());
        try {
        	InputStream x = IconPanel.class.getResourceAsStream(imgPath);
        	if(x == null) throw new IOException("File not found: " + imgPath);
            image = ImageIO.read(x);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        titlebar.setForeground(Color.BLACK);
        titlebar.setHorizontalAlignment(SwingConstants.CENTER);
        setSize(image.getWidth(), image.getHeight());
        setPreferredSize(getSize());
        add(titlebar,BorderLayout.EAST);
    }

    public void setTitle(String title) {
        titlebar.setText(title);
        this.setToolTipText("Component "+title);
    }

    private Boolean selected = false;
    private Boolean active = false;

    public void setSelected(Boolean _selected) {
        selected = _selected;
        active = _selected;
    }

    public Boolean isSelected() {
        return selected;
    }

    private STATE _state = STATE.NO_ERROR;

    public void setState(STATE state) {
        _state = state;
        if (_state.equals(STATE.IN_ERROR)) {
            this.setBackground(new Color(239, 50, 50, 150));
        } else {
            this.setBackground(new Color(0, 0, 0, 200));
        }
    }

    public STATE getCurrentState() {
        return _state;
    }


    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

	public String getTitle() {
		return titlebar.getText();
	}

}
