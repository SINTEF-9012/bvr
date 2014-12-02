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

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import no.sintef.bvr.ui.framework.ErrorHighlightableElement;
import no.sintef.bvr.ui.framework.SelectElement;
import no.sintef.bvr.ui.framework.ThreePartRectanglePanel;
import no.sintef.bvr.ui.framework.TitledElement;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTitledSeparator;

public class VClassOccurencePanel extends ThreePartRectanglePanel implements VSpecPanel, SelectElement, TitledElement, ErrorHighlightableElement {
	
	JXLabel display_name = new JXLabel();
    JXTitledSeparator separatorbar = null;
    JXTitledSeparator separatorbartype = null;
    Map<String, JXLabel> attributesbar = new HashMap<String, JXLabel>();

	public String getName() {
		return display_name.getName();
	}
	

	public void setName(String name) {
		setTitle(name);
	}
    
    public VClassOccurencePanel() {
        display_name.setForeground(Color.BLACK);
        display_name.setHorizontalAlignment(SwingConstants.CENTER);
        addCenter(display_name);
               
        setOptionalState(OPTION_STATE.MANDATORY);
        
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
	
    private void addSepBarVType() {
    	separatorbartype = new JXTitledSeparator();
    	separatorbartype.setForeground(Color.BLACK);
    	separatorbartype.setTitle("");
    	separatorbartype.setHorizontalAlignment(SwingConstants.LEFT);
    	separatorbartype.setVisible(true);
	    addCenter(separatorbartype);   	
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
    
    public JLabel addAttribute(String name) {
    	if(separatorbartype == null)
    		addSepBarVType();
    	
    	JXLabel att = new JXLabel();
    	att.setForeground(Color.BLACK);
    	att.setText(name);
        att.setHorizontalAlignment(SwingConstants.LEFT);
        att.setVisible(true);
        att.setFont(new Font(null, Font.PLAIN, 11));

        attributesbar.put(name, att);
        addCenter(att);
        return att;
    }
    
    public void setNameTypeCardinality(String name, String type, int lower, int upper) {
    	setTitle(name + "[" + lower + ", " + ((upper==-1)?"*":upper) + "] : " + type);
    }
    
    @Override
    public void setTitle(String title) {
    	this.display_name.setText(title);
        this.setToolTipText("VClassifier "+title);
    }

    private Boolean selected = false;

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
            this.setBackground(new Color(239, 50, 50, 180));
        } else {
            setOptionalState(optionalState);
        }
    }

    public STATE getCurrentState() {
        return _state;
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
