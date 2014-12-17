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
package no.sintef.bvr.tool.controller;

import java.awt.Point;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.AddBCLConstraint;
import no.sintef.bvr.tool.controller.command.AddBVRModel;
import no.sintef.bvr.tool.controller.command.AddChoice;
import no.sintef.bvr.tool.controller.command.AddChoiceOccurence;
import no.sintef.bvr.tool.controller.command.AddGroupMultiplicity;
import no.sintef.bvr.tool.controller.command.AddVClassOccurence;
import no.sintef.bvr.tool.controller.command.AddVClassifier;
import no.sintef.bvr.tool.controller.command.UpdateBCLConstraint;
import no.sintef.bvr.tool.controller.command.UpdateBVRModel;
import no.sintef.bvr.tool.controller.command.UpdateChoice;
import no.sintef.bvr.tool.controller.command.UpdateChoiceOccurence;
import no.sintef.bvr.tool.controller.command.UpdateVClassOccurence;
import no.sintef.bvr.tool.controller.command.UpdateVClassifier;
import no.sintef.bvr.tool.decorator.UpdateChoiceBatchCommandDecorator;
import no.sintef.bvr.tool.decorator.UpdateChoiceOccurenceBatchCommandDecorator;
import no.sintef.bvr.tool.decorator.UpdateConstraintBatchCommandDecorator;
import no.sintef.bvr.tool.decorator.UpdateVClassOccurenceBatchCommandDecorator;
import no.sintef.bvr.tool.decorator.UpdateVClassifierBatchCommandDecorator;
import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.exception.UserInputError;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.VSpecControllerInterface;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.tool.ui.dropdown.VSpecDropDownListener;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.strategy.VSpecLayoutStrategy;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.ChoiceVSpec;
import bvr.CompoundNode;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.VClassOccurrence;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.VType;
import bvr.Variable;


public class SwingVSpecController<
		GUI_NODE extends JComponent,
		MODEL_OBJECT extends EObject,
		SERIALIZABLE extends Serializable> 
	implements VSpecControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE> {

	public JScrollPane vspecScrollPane;
	public EditableModelPanel vspecEpanel;
	protected BVRUIKernel<BVREditorPanel, BVRModelPanel> vSpecbvruikernel;
	
	protected Map<JComponent, NamedElement> vspecvmMap;
	protected List<JComponent> vspecNodes;
	protected List<Pair<JComponent, JComponent>> vspecBindings;
	protected BVRToolModel toolModel;
	protected BVRNotifiableController rootController;
	protected VSpecLayoutStrategy strategy;
	
	
	public SwingVSpecController(BVRToolModel _model, BVRNotifiableController controller) {
		controller.setCommonControllerInterface(this);
		toolModel = _model;
		vspecvmMap = new HashMap<JComponent, NamedElement>();
		vspecNodes = new ArrayList<JComponent>();
		vspecBindings = new ArrayList<Pair<JComponent,JComponent>>();
		rootController = controller;
		
		vSpecbvruikernel = new BVRUIKernel<BVREditorPanel, BVRModelPanel>(rootController);
		
        strategy = new VSpecLayoutStrategy(vspecNodes, vspecBindings);
		vspecScrollPane = new JScrollPane(vSpecbvruikernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        vspecEpanel = new EditableModelPanel(vspecScrollPane);
	}
	
	protected void loadBVRView(BVRModel model, BVRUIKernel<BVREditorPanel, BVRModelPanel> uikernel) throws BVRModelException {
		uikernel.getModelPanel().addMouseListener(new VSpecDropDownListener(vSpecbvruikernel, toolModel, rootController));
		
		JComponent rootComponent = new AddBVRModel<BVREditorPanel, BVRModelPanel>().init(uikernel, model, null, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
		
		CompoundNode vspec = model.getVariabilityModel();
		loadBVRView((VSpec) vspec, uikernel, rootComponent, model);
		
		vSpecbvruikernel.getModelPanel().layoutTreeNodes(strategy);
	}

	protected void loadBVRView(VSpec v, BVRUIKernel<BVREditorPanel, BVRModelPanel> kernel, JComponent parent, BVRModel model) throws BVRModelException {
		if(v == null) return;
		
		JComponent nextParent = null;
		
		if(v instanceof VClassifier){
			JComponent c = new AddVClassifier<BVREditorPanel, BVRModelPanel>(toolModel.isVSpecMinimized((VSpec) v)).init(kernel, v, parent, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
			nextParent = c;
		}else if(v instanceof Choice){
			JComponent c = new AddChoice<BVREditorPanel, BVRModelPanel>(toolModel.isVSpecMinimized((VSpec) v)).init(kernel, v, parent, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
			nextParent = c;
		}else if(v instanceof ChoiceOccurrence) {
			JComponent c = new AddChoiceOccurence<BVREditorPanel, BVRModelPanel>(toolModel.isVSpecMinimized((VSpec) v)).init(kernel, v, parent, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
			nextParent = c;
		} else if(v instanceof VClassOccurrence) {
			JComponent c = new AddVClassOccurence<BVREditorPanel, BVRModelPanel>(toolModel.isVSpecMinimized((VSpec) v)).init(kernel, v, parent, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
			nextParent = c;			
		}
		
		if((v instanceof VSpec) && !toolModel.isVSpecMinimized((VSpec) v)){
			for(Constraint c : ((VNode) v).getOwnedConstraint()){
				if(c instanceof BCLConstraint){
					BCLConstraint bcl = (BCLConstraint) c;
					new AddBCLConstraint<BVREditorPanel, BVRModelPanel>().init(kernel, bcl, nextParent, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
				}
			}
			
			if(v instanceof CompoundNode) {
				if(((CompoundNode) v).getGroupMultiplicity() != null)
					nextParent = new AddGroupMultiplicity<BVREditorPanel, BVRModelPanel>().init(kernel, v, nextParent, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();

				for(VNode vs : ((CompoundNode) v).getMember()){
					if(vs instanceof VSpec){
						loadBVRView((VSpec) vs, kernel, nextParent, model);
					}
				}
			}
		}
	}
	
	public void render() {
		loadBVRView(toolModel.getBVRModel(), vSpecbvruikernel);
	}
	
	public void notifyViewUpdate() {
		// Save scroll coordinates
		Point vpos = vspecScrollPane.getViewport().getViewPosition();

		// Clear everything
		BVRModelPanel cup = vSpecbvruikernel.getModelPanel();
		cup.clear();

		vspecNodes.clear();
		vspecBindings.clear();
		vspecvmMap.clear();
		
	    // Add stuff

		render();

	    // Restore scroll coordinates
	    vspecScrollPane.getViewport().setViewPosition(vpos);
	    
	}
	
	public EditableModelPanel getEditorRoolPanel(){
		return vspecEpanel;
	}


	@Override
	public void addChoice(GUI_NODE parent) {
		NamedElement parentNamedElement = (NamedElement) vspecvmMap.get(parent);
		toolModel.addChoice(parentNamedElement);
	}

	@Override
	public void minimizeNode(GUI_NODE node) {
		VSpec vspec = (VSpec) vspecvmMap.get(node);
		toolModel.minimaizeVSpec(vspec);
		notifyViewUpdate();
	}

	@Override
	public void maximizeNode(GUI_NODE node) {
		VSpec vspec = (VSpec) vspecvmMap.get(node);
		toolModel.maximizeVSpec(vspec);
		notifyViewUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public MODEL_OBJECT getModelObjectByUINode(GUI_NODE node) {
		return (MODEL_OBJECT) vspecvmMap.get(node);
	}

	@Override
	public Command<?,?> createUpdateChoiceCommand(GUI_NODE node) {
		Command<BVREditorPanel, BVRModelPanel> command = new UpdateChoiceBatchCommandDecorator<BVREditorPanel, BVRModelPanel>(new UpdateChoice<BVREditorPanel, BVRModelPanel>());
    	command.init(vSpecbvruikernel, (VSpec) vspecvmMap.get(node), node, vspecvmMap, vspecNodes, vspecBindings, rootController);
		return command;
	}

	@Override
	public void updateVariable(MODEL_OBJECT variable, String name, String typeName) {
		toolModel.updateVariable((Variable) variable, name, typeName);
	}

	@Override
	public void setNodeComment(GUI_NODE node, String comment) {
		NamedElement namedElement = (VSpec) vspecvmMap.get(node);
		toolModel.updateComment(namedElement, comment);
	}

	@Override
	public void setNodeName(GUI_NODE node, String name) {
		NamedElement namedElement = (NamedElement) vspecvmMap.get(node);
		toolModel.updateName(namedElement, name);
	}

	@Override
	public String getNodesCommentText(GUI_NODE node) {
		NamedElement namedElement = (VSpec) vspecvmMap.get(node);
		return toolModel.getNodesCommentText(namedElement);
	}
	
	@Override
	public void addVariable(GUI_NODE node) {
		VNode vNode = (VNode) vspecvmMap.get(node);
		toolModel.addVariable(vNode);
	}

	@Override
	public Command<?,?> createUpdateVClassifierCommand(GUI_NODE node) {
		Command<BVREditorPanel, BVRModelPanel> command = new UpdateVClassifierBatchCommandDecorator<BVREditorPanel, BVRModelPanel>(new UpdateVClassifier<BVREditorPanel, BVRModelPanel>());
    	command.init(vSpecbvruikernel, (VSpec) vspecvmMap.get(node), node, vspecvmMap, vspecNodes, vspecBindings, rootController);
		return command;
	}

	@Override
	public void setVClassifierGroupMultiplicityUpperBound(GUI_NODE node,
			int upperBound) {
		VClassifier vClassifier = (VClassifier) vspecvmMap.get(node);
		toolModel.setVClassifierUpperBound(vClassifier, upperBound);
	}

	@Override
	public void setVClassifierGroupMultiplicityLowerBound(GUI_NODE node,
			int lowerBound) {
		VClassifier vClassifier = (VClassifier) vspecvmMap.get(node);
		toolModel.setVClassifierLowerBound(vClassifier, lowerBound);
	}

	@Override
	public void addVClassifier(GUI_NODE node) {
		NamedElement parentNamedElement = (NamedElement) vspecvmMap.get(node);
		toolModel.addVClassifier(parentNamedElement);
	}

	@Override
	public void addBCLConstraint(GUI_NODE node) {
		VNode parentVSpec = (VNode) vspecvmMap.get(node);
		toolModel.addBCLConstraint(parentVSpec);
	}

	@Override
	public Command<?,?> createUpdateBCLConstraintCommand(GUI_NODE node) {
		Command<BVREditorPanel, BVRModelPanel> command = new UpdateConstraintBatchCommandDecorator<BVREditorPanel, BVRModelPanel>(new UpdateBCLConstraint<BVREditorPanel, BVRModelPanel>());
    	command.init(vSpecbvruikernel, vspecvmMap.get(node), node, vspecvmMap, vspecNodes, vspecBindings, rootController);
		return command;
	}

	@Override
	public void updateBCLConstraint(GUI_NODE node, String strConstr) {
		BCLConstraint constraint = (BCLConstraint) vspecvmMap.get(node);
		toolModel.updateBCLConstraint(constraint, strConstr);
	}

	@Override
	public void toggleChoiceOptionalMandotary(GUI_NODE node) {
		ChoiceVSpec choice = (ChoiceVSpec) vspecvmMap.get(node);
		toolModel.toggleChoiceOptionalMandotary(choice);
	}

	@Override
	public void cutNamedElement(GUI_NODE node) {
		NamedElement namedElement = (NamedElement) vspecvmMap.get(node);
		toolModel.cutNamedElement(namedElement);
	}

	@Override
	public void pastNamedElementAsChild(GUI_NODE node) {
		NamedElement parent = (NamedElement) vspecvmMap.get(node);
		toolModel.pastNamedElementAsChild(parent);
	}

	@Override
	public void pastNamedElementAsSibling(GUI_NODE node) {
		NamedElement sibling = (NamedElement) vspecvmMap.get(node);
		toolModel.pastNamedElementAsSibling(sibling);
	}

	@Override
	public void setGroupMultiplicityAlternative(GUI_NODE node) {
		VNode parent = (VNode) vspecvmMap.get(node);
		toolModel.setGroupMultiplicity(parent, 1, 1);	
	}

	@Override
	public void setGroupMultiplicityNone(GUI_NODE node) {
		VNode parent = (VNode) vspecvmMap.get(node);
		toolModel.removeGroupMultiplicity(parent);
		
	}

	@Override
	public void setGroupMultiplicityOr(GUI_NODE node) {
		VNode parent = (VNode) vspecvmMap.get(node);
		toolModel.setGroupMultiplicity(parent, 1, -1);
	}

	@Override
	public void setGroupMultiplicityCustom(GUI_NODE node, int lowerBound, int upperBound) {
		VNode parent = (VNode) vspecvmMap.get(node);
		toolModel.setGroupMultiplicity(parent, lowerBound, upperBound);
	}

	@Override
	public Command<?,?> createUpdateBVRModelCommand(GUI_NODE node) {
		Command<BVREditorPanel, BVRModelPanel> command = new UpdateBVRModel<BVREditorPanel, BVRModelPanel>();
    	command.init(vSpecbvruikernel, vspecvmMap.get(node), node, vspecvmMap, vspecNodes, vspecBindings, rootController);
		return command;
	}

	@Override
	public String getBCLConstraintString(GUI_NODE node) {
		BCLConstraint constraint = (BCLConstraint) vspecvmMap.get(node);
		return toolModel.getBCLConstraintString(constraint);
	}

	@Override
	public void removeNamedElement(GUI_NODE node) {
		NamedElement element = (NamedElement) vspecvmMap.get(node);
		toolModel.removeNamedElement(element);
	}
	
	@Override
	public void exportAsPNGImage(SERIALIZABLE _file) {
		if(!(_file instanceof File))
			throw new UserInputError("Expect file to import");
		File file = (File) _file;
		JLayeredPane layeredPanel = (JLayeredPane) vSpecbvruikernel.getModelPanel();
		StaticUICommands.saveLayeredPaneAsPNGImage(layeredPanel, file);
	}
	
	@Override
	public String getModelFileLocation() {
		return (toolModel.getFile() != null) ? toolModel.getFile().getName() : null;
	}
	
	@Override
	public void enableBatchCommandProcessing() {
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
	}
	
	@Override
	public void disableBatchCommandProcessing() {
		Context.eINSTANCE.getEditorCommands().disableBatchProcessing();
	}
	
	public void executeCommandBatch() {
		Context.eINSTANCE.getEditorCommands().executeBatch();
	}

	@Override
	public void editVType(MODEL_OBJECT vNode, MODEL_OBJECT vType) {
		toolModel.modifyVType((VNode) vNode, (VType) vType);
	}

	@Override
	public void addVType(GUI_NODE node) {
		CompoundNode parent = (CompoundNode) vspecvmMap.get(node);
		toolModel.addVType(parent);
	}

	@Override
	public Command createUpdateChoiceOccurenceCommand(GUI_NODE node) {
		Command<BVREditorPanel, BVRModelPanel> command = new UpdateChoiceOccurenceBatchCommandDecorator<BVREditorPanel, BVRModelPanel>(new UpdateChoiceOccurence<BVREditorPanel, BVRModelPanel>());
    	command.init(vSpecbvruikernel, (VSpec) vspecvmMap.get(node), node, vspecvmMap, vspecNodes, vspecBindings, rootController);
		return command;
	}

	@Override
	public void setChoiceOccurenceType(GUI_NODE node, String strType) {
		ChoiceOccurrence choiceOccurence = (ChoiceOccurrence) vspecvmMap.get(node);
		toolModel.setChoiceOccurenceType(choiceOccurence, strType);
	}

	@Override
	public Command createUpdateVClassOccurenceCommand(GUI_NODE elem) {
		Command<BVREditorPanel, BVRModelPanel> command = new UpdateVClassOccurenceBatchCommandDecorator<BVREditorPanel, BVRModelPanel>(new UpdateVClassOccurence<BVREditorPanel, BVRModelPanel>());
    	command.init(vSpecbvruikernel, (VSpec) vspecvmMap.get(elem), elem, vspecvmMap, vspecNodes, vspecBindings, rootController);
		return command;
	}

	@Override
	public void setVClassOccurenceType(GUI_NODE elem, String typeName) {
		VClassOccurrence vclassOccurence = (VClassOccurrence) vspecvmMap.get(elem);
		toolModel.setVClassOccurenceType(vclassOccurence, typeName);
	}
	
	@Override
	public void setVClassOccurenceGroupMultiplicityUpperBound(GUI_NODE node,
			int upperBound) {
		VClassOccurrence vClassOccur = (VClassOccurrence) vspecvmMap.get(node);
		toolModel.setVClassOccurenceUpperBound(vClassOccur, upperBound);
	}

	@Override
	public void setVClassOccurenceGroupMultiplicityLowerBound(GUI_NODE node,
			int lowerBound) {
		VClassOccurrence vClassOccur = (VClassOccurrence) vspecvmMap.get(node);
		toolModel.setVClassOccurenceLowerBound(vClassOccur, lowerBound);
	}

	@Override
	public void addChoiceOccurence(GUI_NODE parent) {
		CompoundNode compoundNode = (CompoundNode) vspecvmMap .get(parent);
		toolModel.addChoiceOccurence(compoundNode);	
	}
	
	@Override
	public void addVClassOccurence(GUI_NODE parent) {
		CompoundNode compoundNode = (CompoundNode) vspecvmMap .get(parent);
		toolModel.addVClassOccurence(compoundNode);	
	}
}
