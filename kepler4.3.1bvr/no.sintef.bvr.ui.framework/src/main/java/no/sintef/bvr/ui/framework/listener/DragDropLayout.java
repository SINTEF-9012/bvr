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

package no.sintef.bvr.ui.framework.listener;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class DragDropLayout implements LayoutManager {

    //private List<Component> l = new ArrayList();
    public void addLayoutComponent(String name, Component comp) {
        //l.add(comp);
    }

    public void removeLayoutComponent(Component comp) {
        //l.remove(comp);
    }

    public Dimension preferredLayoutSize(Container parent) {
        return new Dimension();
    }

    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension();
    }

    public void layoutContainer(Container p) {

        int n = p.getComponents().length;
        for (int i = 0; i < n; i++) {
            Component c = p.getComponent(i);
            if(c.isVisible()){
                Dimension d = c.getPreferredSize();
                c.setSize(d.width, d.height);
                c.setBounds(c.getX(), c.getY(), c.getWidth(), c.getHeight());
            }
        }
    }
}
