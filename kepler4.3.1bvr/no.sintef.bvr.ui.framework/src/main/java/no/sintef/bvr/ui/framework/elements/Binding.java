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

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import javax.swing.JComponent;

import no.sintef.bvr.ui.framework.AbstractSelectElement;
import no.sintef.bvr.ui.framework.ErrorHighlightableElement;
import no.sintef.bvr.ui.framework.OptionalElement;

/**
 * @author ffouquet
 */
public class Binding extends AbstractSelectElement implements ErrorHighlightableElement, OptionalElement {

    private JComponent from = null;
    private JComponent to = null;
    public Color selectedcolor = null;
    public Color unselectedcolor = null;

    public Boolean isFocused = false;

    private java.util.List<BindingListener> listeners = new ArrayList<BindingListener>();

    public void addListener(BindingListener l) {
        listeners.add(l);
    }

    public void removeListener(BindingListener l) {
        listeners.remove(l);
    }

    public void triggerListeners() {
        for (BindingListener l : listeners) {
            l.clicked();
        }
    }


    private Stroke stroke = null;
    private Stroke focusedStroke = null;
    public Stroke getFocusedStroke() {
        return focusedStroke;
    }
    public Stroke getStroke() {
        return stroke;
    }


    private STATE currentState = STATE.NO_ERROR;

    public void setState(STATE state) {
        currentState = state;
    }

    public STATE getCurrentState() {
        return currentState;
    }

    public Binding(OPTION_STATE t) {
        if (t.equals(OPTION_STATE.MANDATORY)) {
            selectedcolor = new Color(0, 0, 0, 230);
            unselectedcolor = new Color(0, 0, 0, 230);
            stroke = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.CAP_SQUARE);
            focusedStroke  = new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.CAP_SQUARE);
        }
        else if (t.equals(OPTION_STATE.OPTIONAL)) {
        	selectedcolor = new Color(0, 0, 0, 200);
            unselectedcolor = new Color(0, 0, 0, 200);
            float dash1[] = {8.0f};
            stroke = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.CAP_SQUARE, 8, dash1, 0);
            focusedStroke  = new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.CAP_SQUARE, 8, dash1, 0);
        }
    }

    public JComponent getFrom() {
        return from;
    }

    public void setFrom(JComponent fromPort) {
        this.from = fromPort;
    }

    public JComponent getTo() {
        return to;
    }

    public void setTo(JComponent toPort) {
        this.to = toPort;
    }

    public Color getActualColor() {
        return this.isSelected() ? selectedcolor : unselectedcolor;
    }

    private OPTION_STATE optionalState = OPTION_STATE.MANDATORY;
    
	public void setOptionalState(OPTION_STATE state) {
		this.optionalState = state;
	}

	public OPTION_STATE getOptionalState() {
		return optionalState;
	}

}
