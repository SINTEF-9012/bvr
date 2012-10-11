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

package no.sintef.cvl.ui.framework.elements;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.SwingConstants;

import no.sintef.cvl.ui.framework.ErrorHighlightableElement;
import no.sintef.cvl.ui.framework.SelectElement;
import no.sintef.cvl.ui.framework.ThreePartRectanglePanel;
import no.sintef.cvl.ui.framework.TitledElement;

import org.jdesktop.swingx.JXTitledSeparator;

public class VClassifierPanel extends ThreePartRectanglePanel implements VSpecPanel, SelectElement, TitledElement, ErrorHighlightableElement {
	
    JXTitledSeparator name = new JXTitledSeparator();
    JXTitledSeparator separatorbar = new JXTitledSeparator();
    Map<String, JXTitledSeparator> attributesbar = new HashMap<String, JXTitledSeparator>();
    
    ConfigurableUnitPanel model;

    public VClassifierPanel(ConfigurableUnitPanel model) {
    	this.model = model;
    	
        name.setForeground(Color.WHITE);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        separatorbar.setForeground(Color.WHITE);
        separatorbar.setTitle("");
        separatorbar.setHorizontalAlignment(SwingConstants.CENTER);
        separatorbar.setVisible(true);
        
        addCenter(name);
        addCenter(separatorbar);
    }
    
    public void addVSpec(VSpecPanel vspec) {
        Binding b = new Binding(Binding.Type.input);
        b.setSelected(false);
        b.setFrom(this);
        b.setTo((JComponent)vspec);
        model.addBinding(b);
        
        System.out.println(((JComponent)vspec).getX() + ", " + ((JComponent)vspec).getX()); 
        
        ((JComponent)vspec).move(getX(), getY()+getHeight()+50);
        
        System.out.println(((JComponent)vspec).getX() + ", " + ((JComponent)vspec).getX());
    }

    public void addAttribute(String name, String type) {
    	JXTitledSeparator att = new JXTitledSeparator();
    	
    	att.setForeground(Color.WHITE);
        att.setTitle(name + " : " + type);
        att.setHorizontalAlignment(SwingConstants.CENTER);
        att.setVisible(true);

        attributesbar.put(name, att);
        addCenter(att);
    }
    
    public void removeAttribute(String name) {
    	
    }
    
    public void setNameAndCardinality(String name, String cardinality) {
    	setTitle(name + " : " + cardinality);
    }
    
    @Override
    public void setTitle(String title) {
        name.setTitle(title);
        this.setToolTipText("VClassifier "+title);
    }

    private Boolean selected = false;

    @Override
    public void setSelected(Boolean _selected) {
        selected = _selected;
        active = _selected;
    }

    @Override
    public Boolean getSelected() {
        return selected;
    }

    private STATE _state = STATE.NO_ERROR;

    @Override
    public void setState(STATE state) {
        _state = state;
        if (_state.equals(STATE.IN_ERROR)) {
            this.setBackground(new Color(239, 50, 50, 150));
        } else {
            this.setBackground(new Color(0, 0, 0, 200));
        }
    }

    @Override
    public STATE getCurrentState() {
        return _state;
    }

}
