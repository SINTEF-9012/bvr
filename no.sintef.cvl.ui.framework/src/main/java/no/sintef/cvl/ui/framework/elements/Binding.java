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

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.AbstractSelectElement;
import no.sintef.cvl.ui.framework.ErrorHighlightableElement;

/**
 * @author ffouquet
 */
public class Binding extends AbstractSelectElement implements ErrorHighlightableElement {

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

    @Override
    public void setState(STATE state) {
        currentState = state;
    }

    @Override
    public STATE getCurrentState() {
        return currentState;
    }

    public enum Type {
        input, ouput, groupLink
    }

    public Binding(Type t) {
        if (t.equals(Type.input)) {
            selectedcolor = new Color(254, 238, 100, 180);
            unselectedcolor = new Color(200, 238, 39, 180);
            stroke = new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.CAP_SQUARE);
            focusedStroke  = new BasicStroke(8, BasicStroke.CAP_SQUARE, BasicStroke.CAP_SQUARE);
        }
        if (t.equals(Type.ouput)) {
            selectedcolor = new Color(254, 0, 0, 180);
            unselectedcolor = new Color(200, 0, 0, 180);
            stroke = new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.CAP_SQUARE);
            focusedStroke  = new BasicStroke(8, BasicStroke.CAP_SQUARE, BasicStroke.CAP_SQUARE);
        }
        if (t.equals(Type.groupLink)) {
            selectedcolor = new Color(45, 236, 64, 200);
            unselectedcolor = new Color(45, 236, 64, 200);
            float dash1[] = {8.0f};
            stroke = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 8.0f, dash1, 0.0f);
            focusedStroke = new BasicStroke(8.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 8.0f, dash1, 0.0f);
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
        return this.getSelected() ? selectedcolor : unselectedcolor;
    }

}
