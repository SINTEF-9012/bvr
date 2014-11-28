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
import java.awt.Component;
import java.awt.Dialog;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.Window;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.ui.framework.ParallelogramTitledPanel;
import no.sintef.bvr.ui.framework.SelectElement;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import no.sintef.bvr.ui.framework.elements.BVRModelSymbolPanel;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import no.sintef.bvr.ui.framework.elements.VClassifierPanel;
import no.sintef.bvr.ui.framework.elements.VTypeRootSymbolPanel;
//import no.sintef.bvr.ui.framework.elements.VInstancePanel;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;

import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.painter.CompoundPainter;
import org.jdesktop.swingx.painter.MattePainter;

import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VType;
import bvr.ValueResolution;


public class BVREditorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1055821406124903342L;


	private BVRNotifiableController controller;

    protected BVRUIKernel kernel;

    public BVRUIKernel getKernel() {
        return kernel;
    }

    private JXPanel leftpanel = new JXPanel();


    protected EditableModelPanel editableModelPanel = null;
    protected JSplitPane splitPane = null;
    
    protected SelectElement current;
    

    public BVREditorPanel(BVRUIKernel _kernel, BVRNotifiableController controller) {
    	this.kernel = _kernel;
    	this.controller = controller;
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
    
    public static Window findWindow(Component c) {
        if (c == null) {
            return JOptionPane.getRootFrame();
        } else if (c instanceof Window) {
            return (Window) c;
        } else {
            return findWindow(c.getParent());
        }
    }

    @SuppressWarnings("unchecked")
	public void showPropertyFor(Object p) {
    	if (p instanceof SelectElement) {
    		current = (SelectElement) p;
    	}
    	
        if (p instanceof VClassifierPanel) {
        	VClassifierPanel elem = (VClassifierPanel) p;
			NamedElement object = (NamedElement) controller.getVSpecControllerInterface().getModelObjectByUINode(elem);
			Command okCommand = controller.getVSpecControllerInterface().createUpdateVClassifierCommand(elem);
        	VClassifierPropertyEditor prop = new VClassifierPropertyEditor(kernel, okCommand, (VClassifier) object, elem, controller);
        	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
        }else if (p instanceof ChoicePanel) {
        	ChoicePanel elem = (ChoicePanel)p;
			NamedElement object = (NamedElement) controller.getVSpecControllerInterface().getModelObjectByUINode(elem);
        	Command okCommand = controller.getVSpecControllerInterface().createUpdateChoiceCommand(elem);
        	ChoicePropertyEditor prop = new ChoicePropertyEditor(kernel, okCommand, (Choice) object, elem, controller);
        	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
        }else if (p instanceof ParallelogramTitledPanel) {
        	ParallelogramTitledPanel elem = (ParallelogramTitledPanel)p;
			NamedElement object = (NamedElement) controller.getVSpecControllerInterface().getModelObjectByUINode(elem);
			Command okCommand = controller.getVSpecControllerInterface().createUpdateBCLConstraintCommand(elem);
        	BCLConstraintPropertyEditor prop = new BCLConstraintPropertyEditor(kernel, okCommand, (BCLConstraint) object, elem, controller);
        	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
        }else if (p instanceof BVRModelSymbolPanel) {
        	BVRModelSymbolPanel elem = (BVRModelSymbolPanel) p;
			NamedElement object = (NamedElement) controller.getVSpecControllerInterface().getModelObjectByUINode(p);
			Command okCommand = controller.getVSpecControllerInterface().createUpdateBVRModelCommand(elem);
        	BVRModelPropertyEditor prop = new BVRModelPropertyEditor(kernel, okCommand, (BVRModel) object, elem, controller);        	
            editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
        }else if (p instanceof ChoiceResolutionPanel) {
        	ChoiceResolutionPanel vInstance = (ChoiceResolutionPanel) p;
        	NamedElement object = (NamedElement) controller.getResolutionControllerInterface().getModelObjectByUINode(vInstance);
        	Command okCommand = controller.getResolutionControllerInterface().createUpdateInstanceChoiceResolutionCommand(vInstance);
        	VInstancePropertyEditor prop = new VInstancePropertyEditor(kernel, okCommand, (ChoiceResolution) object, vInstance, controller);
        	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
        }else if (p instanceof VariableAssignmentPanel) {
        	VariableAssignmentPanel elem = (VariableAssignmentPanel) p;
        	NamedElement object = (NamedElement) controller.getResolutionControllerInterface().getModelObjectByUINode(p);
        	Command okCommand = controller.getResolutionControllerInterface().createUpdateVariableResolutionCommand(elem);
        	VariableValueAssignmentPropertyEditor prop = new VariableValueAssignmentPropertyEditor(kernel, okCommand, (ValueResolution) object, elem, controller);
        	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
        } else if (p instanceof VTypeRootSymbolPanel) {
        	VTypeRootSymbolPanel elem = (VTypeRootSymbolPanel) p;
        	NamedElement object = (NamedElement) controller.getVTypeControllerInterface().getModelObjectByUINode(p);
        	Command okCommand = controller.getVTypeControllerInterface().createUpdateVTypeCommand(elem);
        	BVRVTypePropertyEditor prop = new BVRVTypePropertyEditor(kernel, okCommand, (VType) object, elem, controller);
        	editableModelPanel.displayProperties(prop, Context.eINSTANCE.getActiveJApplet(), Dialog.ModalityType.APPLICATION_MODAL);
        }
        else{
        	throw new UnsupportedOperationException("Unsupported: " + p.getClass().getName());
        }
        
        this.invalidate();

    }

    public void unshowPropertyEditor() {
        editableModelPanel.undisplayProperties();
    }
}
