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

package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements;

import java.awt.Dialog;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.edit.BCLConstraintPropertyEditor;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.tool.ui.edit.ChoicePropertyEditor;
import no.sintef.bvr.tool.ui.edit.ConfigurableUnitPropertyEditor;
import no.sintef.bvr.tool.ui.edit.VClassifierPropertyEditor;
import no.sintef.bvr.tool.ui.edit.VInstancePropertyEditor;
import no.sintef.bvr.tool.ui.edit.VariableValueAssignmentPropertyEditor;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.framework.ParallelogramTitledPanel;
import no.sintef.bvr.ui.framework.SelectElement;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitSymbolPanel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import no.sintef.bvr.ui.framework.elements.VClassifierPanel;
import no.sintef.bvr.ui.framework.elements.VInstancePanel;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;
import bvr.BCLConstraint;
import bvr.Choice;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VariableValueAssignment;

public class BVREditorPanelV2 extends BVREditorPanel {
	protected EditableModelPanel editableModelPanel = null;
	public BVREditorPanelV2(BVRUIKernel _kernel,
			Map<JComponent, NamedElement> vmMap, BVRView view,
			List<Map<JComponent, NamedElement>> resolutionvmMaps) {
		super(_kernel, vmMap, view, resolutionvmMaps);
        JScrollPane scrollpane = new JScrollPane();
        //IAppWidgetFactory.makeIAppScrollPane(scrollpane);
        editableModelPanel = new EditableModelPanelV2(scrollpane);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1055821406124903342L;

    

    public void showPropertyFor(Object p) {
    	if (p instanceof SelectElement) {
    		current = (SelectElement) p;
    	}
    	
    	//System.out.println("Here!" + p);
    	
        if (p instanceof VClassifierPanel) {
        	VClassifierPanel elem = (VClassifierPanel)p;
        	VClassifierPropertyEditor prop = new VClassifierPropertyEditor(kernel, (VClassifier) vmMap.get(elem), view);
        	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
        }else if (p instanceof ChoicePanel) {
        	ChoicePanel elem = (ChoicePanel)p;
        	ChoicePropertyEditor prop = new ChoicePropertyEditor(kernel, (Choice) vmMap.get(elem), view);
        	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
        	//System.out.println("Here!");
        }else if (p instanceof ParallelogramTitledPanel) {
        	ParallelogramTitledPanel elem = (ParallelogramTitledPanel)p;
        	BCLConstraintPropertyEditor prop = new BCLConstraintPropertyEditor(kernel, (BCLConstraint) vmMap.get(elem), view);
        	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
           // System.out.println("Here!");
        }else if (p instanceof ConfigurableUnitSymbolPanel) {
        	ConfigurableUnitPropertyEditor prop = new ConfigurableUnitPropertyEditor(kernel, view.getCU(), view);        	
            editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
            //System.out.println("Here!");
        }else if (p instanceof VInstancePanel) {
        	VInstancePanel elem = (VInstancePanel)p;
        	VInstance x = null;
        	for(Map<JComponent, NamedElement> z : resolutionvmMaps){
        		if(z.get(elem) != null)
        			x = (VInstance) z.get(elem);
        	}
        	VInstancePropertyEditor prop = new VInstancePropertyEditor(kernel, x, view);
        	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
        	//System.out.println("Here!");
        }else if (p instanceof VariableAssignmentPanel) {
        	VariableAssignmentPanel elem = (VariableAssignmentPanel)p;
        	VariableValueAssignment x = null;
        	for(Map<JComponent, NamedElement> z : resolutionvmMaps){
        		if(z.get(elem) != null)
        			x = (VariableValueAssignment) z.get(elem);
        	}
        	System.out.println("elem is: " + elem);
        	System.out.println("x is " + x);
        	VariableValueAssignmentPropertyEditor prop = new VariableValueAssignmentPropertyEditor(kernel, x, view);
        	((EditableModelPanelV2) editableModelPanel).displayProperties((VariableValueAssignmentPropertyEditor) prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL, elem);
        	
        	
        	
        	
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
