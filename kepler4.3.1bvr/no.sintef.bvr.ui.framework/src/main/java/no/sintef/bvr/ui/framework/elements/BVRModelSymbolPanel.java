/*******************************************************************************
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
 ******************************************************************************/
package no.sintef.bvr.ui.framework.elements;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;

import no.sintef.bvr.ui.framework.ErrorHighlightableElement;
import no.sintef.bvr.ui.framework.SelectElement;
import no.sintef.bvr.ui.framework.ThreePartRectanglePanel;
import no.sintef.bvr.ui.framework.TitledElement;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTitledSeparator;

public class BVRModelSymbolPanel extends ThreePartRectanglePanel implements VSpecPanel, SelectElement, TitledElement, ErrorHighlightableElement {
	private static final long serialVersionUID = -3463243889276205974L;
	
	JXLabel display_name = new JXLabel();
    JXTitledSeparator separatorbar = new JXTitledSeparator();
    Map<String, JXLabel> attributesbar = new HashMap<String, JXLabel>();
    
    BVRModelPanel model;
    
    public BVRModelSymbolPanel(BVRModelPanel model) {
    	this.model = model;
    	
        display_name.setForeground(Color.BLACK);
        display_name.setHorizontalAlignment(SwingConstants.CENTER);
        
        addCenter(display_name);
        
        setOptionalState(OPTION_STATE.MANDATORY);
        
        setBackground(Color.WHITE);
    }
    
    public void addAttribute(String name, String type) {
    	JXLabel att = new JXLabel();
    	
    	att.setForeground(Color.BLACK);
        att.setText(name + " : " + type);
        att.setHorizontalAlignment(SwingConstants.LEFT);
        att.setVisible(true);
        att.setFont(new Font(null, Font.PLAIN, 11));

        attributesbar.put(name, att);
        addCenter(att);
    }
        
    public void setNameAndCardinality(String name, int lower, int upper) {
    	setTitle(name + " : [" + lower + ", " + ((upper==-1)?"*":upper) + "]");
    }
    
    @Override
    public void setTitle(String title) {
    	this.display_name.setText(title + " : BVRModel");
        this.setToolTipText("bvrModel" + title + " : BVRModel");
    }
    
    @Override
    public String getTitle() {
    	return display_name.getText();
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
