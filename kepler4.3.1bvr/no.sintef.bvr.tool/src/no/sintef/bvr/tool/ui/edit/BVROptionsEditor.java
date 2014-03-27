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

package no.sintef.bvr.tool.ui.edit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.GradientPaint;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;

import org.jdesktop.swingx.JXPanel;

import com.explodingpixels.macwidgets.IAppWidgetFactory;


public class BVROptionsEditor extends JPanel {

	private static final long serialVersionUID = 2589898459671847493L;

	private JXPanel leftpanel = new JXPanel();

    private EditableModelPanel editableModelPanel = null;
    private JSplitPane splitPane = null;
	private ConfigurableUnitPanel modelPanel;

    public BVROptionsEditor() {
    	modelPanel = new ConfigurableUnitPanel();
    	//this.setBackground(Color.WHITE);


        leftpanel.setOpaque(false);
        
        /*leftpanel.setLayout(new BorderLayout());
        GradientPaint grad = new GradientPaint(new Point(0, 0), new Color(60, 60, 60), new Point(0, getHeight()), new Color(51, 51, 51));
        MattePainter matte = new MattePainter(grad);
        CompoundPainter p = new CompoundPainter(matte);
        leftpanel.setBackgroundPainter(p);*/

        this.setLayout(new BorderLayout());

        JScrollPane scrollpane = new JScrollPane();
        IAppWidgetFactory.makeIAppScrollPane(scrollpane);
        editableModelPanel = new EditableModelPanel(scrollpane);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                leftpanel, editableModelPanel);

        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation(180);
        splitPane.setResizeWeight(0.0);
        splitPane.setBorder(null);
       // splitPane.setBackground(Color.WHITE);


        scrollpane.setOpaque(false);
        scrollpane.getViewport().add(modelPanel);

        this.add(splitPane, BorderLayout.CENTER);


    }

    public void showEditor(){
    	BVROptionEditorPanel prop = new BVROptionEditorPanel();
    	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
    }
    
    public void unshowEditor() {
        editableModelPanel.undisplayProperties();
    }
}
