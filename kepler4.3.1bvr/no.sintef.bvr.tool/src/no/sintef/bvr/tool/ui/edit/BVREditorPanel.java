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
import java.awt.GradientPaint;
import java.awt.Point;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import no.sintef.bvr.tool.ui.command.SelectInstanceCommand;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.framework.ParallelogramTitledPanel;
import no.sintef.bvr.ui.framework.SelectElement;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitSymbolPanel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import no.sintef.bvr.ui.framework.elements.VClassifierPanel;
import no.sintef.bvr.ui.framework.elements.VInstancePanel;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;

import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.painter.CompoundPainter;
import org.jdesktop.swingx.painter.MattePainter;

import bvr.BCLConstraint;
import bvr.Choice;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VariableValueAssignment;

public class BVREditorPanel extends JPanel {

	private Map<JComponent, NamedElement> vmMap;
	private BVRView view;
	
    private BVRUIKernel kernel/* = new BVRUIKernel()*/;

    public BVRUIKernel getKernel() {
        return kernel;
    }

    private JXPanel leftpanel = new JXPanel();


    private EditableModelPanel editableModelPanel = null;
    private JSplitPane splitPane = null;
    
    private SelectElement current;
	private List<Map<JComponent, NamedElement>> resolutionvmMaps;

    public BVREditorPanel(BVRUIKernel _kernel, Map<JComponent, NamedElement> vmMap, BVRView view, List<Map<JComponent, NamedElement>> resolutionvmMaps) {
    	this.vmMap = vmMap;
    	this.resolutionvmMaps = resolutionvmMaps;
    	this.kernel = _kernel;
    	this.view = view;
    	this.setBackground(Color.WHITE);
        kernel.setEditorPanel(this);

        leftpanel.setOpaque(false);
        
        leftpanel.setLayout(new BorderLayout());
        GradientPaint grad = new GradientPaint(new Point(0, 0), new Color(60, 60, 60), new Point(0, getHeight()), new Color(51, 51, 51));
        MattePainter matte = new MattePainter(grad);
        CompoundPainter p = new CompoundPainter(matte);
        leftpanel.setBackgroundPainter(p);

        this.setLayout(new BorderLayout());

        JScrollPane scrollpane = new JScrollPane();
        //IAppWidgetFactory.makeIAppScrollPane(scrollpane);
        editableModelPanel = new EditableModelPanel(scrollpane);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                leftpanel, editableModelPanel);

        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation(180);
        splitPane.setResizeWeight(0.0);
        splitPane.setBorder(null);
        splitPane.setBackground(Color.WHITE);


        scrollpane.setOpaque(false);
        scrollpane.getViewport().add(kernel.getModelPanel());

        this.add(splitPane, BorderLayout.CENTER);


    }

    public void showPropertyFor(Object p) {
    	if (p instanceof SelectElement) {
    		current = (SelectElement) p;
    	}
    	
    	//System.out.println("Here!" + p);
    	
        if (p instanceof VClassifierPanel) {
        	VClassifierPanel elem = (VClassifierPanel)p;
        	VClassifierPropertyEditor prop = new VClassifierPropertyEditor(kernel, (VClassifier) vmMap.get(elem), view);
            editableModelPanel.displayProperties(prop);
        }else if (p instanceof ChoicePanel) {
        	ChoicePanel elem = (ChoicePanel)p;
        	ChoicePropertyEditor prop = new ChoicePropertyEditor(kernel, (Choice) vmMap.get(elem), view);
            editableModelPanel.displayProperties(prop);
        	//System.out.println("Here!");
        }else if (p instanceof ParallelogramTitledPanel) {
        	ParallelogramTitledPanel elem = (ParallelogramTitledPanel)p;
        	BCLConstraintPropertyEditor prop = new BCLConstraintPropertyEditor(kernel, (BCLConstraint) vmMap.get(elem), view);
            editableModelPanel.displayProperties(prop);
           // System.out.println("Here!");
        }else if (p instanceof ConfigurableUnitSymbolPanel) {
        	ConfigurableUnitSymbolPanel elem = (ConfigurableUnitSymbolPanel)p;
        	ConfigurableUnitPropertyEditor prop = new ConfigurableUnitPropertyEditor(kernel, view.getCU(), view);
            editableModelPanel.displayProperties(prop);
            //System.out.println("Here!");
        }else if (p instanceof VInstancePanel) {
        	VInstancePanel elem = (VInstancePanel)p;
        	VInstance x = null;
        	for(Map<JComponent, NamedElement> z : resolutionvmMaps){
        		if(z.get(elem) != null)
        			x = (VInstance) z.get(elem);
        	}
        	VInstancePropertyEditor prop = new VInstancePropertyEditor(kernel, x, view);
            editableModelPanel.displayProperties(prop);
        	//System.out.println("Here!");
        }else if (p instanceof VariableAssignmentPanel) {
        	VariableAssignmentPanel elem = (VariableAssignmentPanel)p;
        	VariableValueAssignment x = null;
        	for(Map<JComponent, NamedElement> z : resolutionvmMaps){
        		if(z.get(elem) != null)
        			x = (VariableValueAssignment) z.get(elem);
        	}
        	VariableValueAssignmentPropertyEditor prop = new VariableValueAssignmentPropertyEditor(kernel, x, view);
            editableModelPanel.displayProperties(prop);
        	//System.out.println("Here!");
        }else{
        	throw new UnsupportedOperationException("Unsupported: " + p.getClass().getName());
        }
        
        this.invalidate();

    }

    public void unshowPropertyEditor() {
        editableModelPanel.undisplayProperties();
    }
}
