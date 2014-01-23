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

package no.sintef.bvr.ui.framework.elements;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;

import no.sintef.bvr.ui.framework.SelectElement;
import no.sintef.bvr.ui.framework.ThreePartRoundedPanel;
import no.sintef.bvr.ui.framework.TitledElement;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTitledSeparator;

public class ChoicePanel extends ThreePartRoundedPanel implements VSpecPanel, SelectElement, TitledElement {
	private static final long serialVersionUID = 1L;
	
	JXLabel titlebar = null;
    JXTitledSeparator separatorbar = null;
    
    Map<String, JXLabel> attributesbar = new HashMap<String, JXLabel>();

    public ChoicePanel() {
    	titlebar = new JXLabel();
        titlebar.setForeground(Color.BLACK);
        titlebar.setHorizontalAlignment(SwingConstants.CENTER);
        addCenter(titlebar);
        
        setBackground(Color.WHITE);
    }
    
	private void addSepBar() {
		separatorbar = new JXTitledSeparator();
		separatorbar.setForeground(Color.BLACK);
	    separatorbar.setTitle("");
	    separatorbar.setHorizontalAlignment(SwingConstants.LEFT);
	    separatorbar.setVisible(true);
	    addCenter(separatorbar);
	}
    
    public void addAttribute(String name, String type) {
    	if(separatorbar == null)
    		addSepBar();
    	
    	JXLabel att = new JXLabel();
    	
    	att.setForeground(Color.BLACK);
        att.setText(name + " : " + type);
        att.setHorizontalAlignment(SwingConstants.LEFT);
        att.setVisible(true);
        att.setFont(new Font(null, Font.PLAIN, 11));

        attributesbar.put(name, att);
        addCenter(att);
    }
    
    public void removeAttribute(String name) {
    	
    }

    @Override
    public void setTitle(String title) {
        titlebar.setText(title);
        this.setToolTipText("Component "+title);
    }
    
    @Override
    public String getTitle(){
    	return titlebar.getText();
    }

    private Boolean selected = false;

    public void setSelected(Boolean _selected) {
        selected = _selected;
        active = _selected;
    }

    public Boolean isSelected() {
        return selected;
    }

    private OPTION_STATE optionalState = OPTION_STATE.MANDATORY;
    
	public void setOptionalState(OPTION_STATE state) {
		this.optionalState = state;
		
        if (optionalState.equals(OPTION_STATE.MANDATORY)) {
            this.setBackground(new Color(0, 0, 0, 25));
        } else {
        	this.setBackground(new Color(0, 0, 0, 5));
        }
	}

	public OPTION_STATE getOptionalState() {
		return optionalState;
	}
}
