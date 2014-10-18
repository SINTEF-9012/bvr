package no.sintef.bvr.tool.controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.decorator.UpdateChoiceBatchCommandDecorator;
import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.ui.command.AddBCLConstraint;
import no.sintef.bvr.tool.ui.command.AddBVRModel;
import no.sintef.bvr.tool.ui.command.AddChoice;
import no.sintef.bvr.tool.ui.command.AddGroupMultiplicity;
import no.sintef.bvr.tool.ui.command.AddVClassifier;
import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.command.UpdateChoice;
import no.sintef.bvr.tool.ui.dropdown.VSpecDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.tool.ui.strategy.VSpecLayoutStrategy;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import no.sintef.bvr.ui.framework.strategy.LayoutStrategy;
import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.Variable;

public class SwingVSpecController<
		GIU_NODE extends JComponent,
		MODEL_OBJECT extends EObject> 
	implements VSpecControllerInterface<GIU_NODE, MODEL_OBJECT> {

	public JScrollPane vspecScrollPane;
	public EditableModelPanel vspecEpanel;
	private BVRUIKernel vSpecbvruikernel;
	
	private Map<JComponent, NamedElement> vspecvmMap;
	private List<JComponent> vspecNodes;
	private List<Pair<JComponent, JComponent>> vspecBindings;
	private BVRToolModel toolModel;
	private BVRNotifiableController rootController;
	
	
	public SwingVSpecController(BVRToolModel _model, BVRNotifiableController controller) {
		toolModel = _model;
		vspecvmMap = new HashMap<JComponent, NamedElement>();
		vspecNodes = new ArrayList<JComponent>();
		vspecBindings = new ArrayList<Pair<JComponent,JComponent>>();
		rootController = controller;
		
		vSpecbvruikernel = new BVRUIKernel(vspecvmMap, rootController, null);
		loadBVRVSpecView(toolModel.getBVRModel(), vSpecbvruikernel);
        
        
        LayoutStrategy strategy = new VSpecLayoutStrategy(vspecNodes, vspecBindings);
        vSpecbvruikernel.getModelPanel().layoutTreeNodes(strategy);
		
		vspecScrollPane = new JScrollPane(vSpecbvruikernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        vspecEpanel = new EditableModelPanel(vspecScrollPane);
	}
	
	private void loadBVRVSpecView(BVRModel model, BVRUIKernel uikernel) throws BVRModelException {
		uikernel.getModelPanel().addMouseListener(new VSpecDropDownListener(vSpecbvruikernel, toolModel, rootController));
		
		JComponent c = new AddBVRModel().init(model, uikernel, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
		
		CompoundNode vspec = model.getVariabilityModel();
		loadBVRVSpecView(vspec, uikernel, c, model);
	}

	private void loadBVRVSpecView(CompoundNode v, BVRUIKernel model, JComponent parent, BVRModel cu) throws BVRModelException {
		if(v == null) return;
		
		JComponent nextParent = null;
		
		if(v instanceof VClassifier){
			JComponent c = new AddVClassifier(toolModel.isVSpecMinimized((VSpec) v)).init(model, v, parent, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
			vspecvmMap.put(c, (VSpec)v);
			nextParent = c;
		}else if(v instanceof Choice){
			JComponent c = new AddChoice(toolModel.isVSpecMinimized((VSpec) v)).init(model, v, parent, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
			vspecvmMap.put(c, (VSpec)v);
			nextParent = c;
		}
		
		if(!toolModel.isVSpecMinimized((VSpec) v)){
			if(v.getGroupMultiplicity() != null){
				nextParent = new AddGroupMultiplicity().init(model, v, nextParent, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
			}
		
		
			for(Constraint c : ((VNode) v).getOwnedConstraint()){
				/*if(c instanceof OpaqueConstraint){
					OpaqueConstraint oc = (OpaqueConstraint) c;
					if(c.getContext() == v){
						JComponent comp = new AddOpaqueConstraint().init(model, oc, nextParent, vspecvmMap, vspecNodes, vspecBindings, this).execute();
						vspecvmMap.put(comp, v);
					}
				}*/
				if(c instanceof BCLConstraint){
					BCLConstraint bcl = (BCLConstraint) c;
					
					JComponent comp = new AddBCLConstraint().init(model, bcl, nextParent, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
					vspecvmMap.put(comp, c);

				}
			}
			
			for(VNode vs : ((CompoundNode) v).getMember()){
				if(vs instanceof CompoundNode){
					loadBVRVSpecView((CompoundNode) vs, model, nextParent, cu);
				}
			}
		}
	}
	
	public void notifyVspecViewUpdate() {
		// Save scroll coordinates
		Point vpos = vspecScrollPane.getViewport().getViewPosition();
				
		// Clear everything
		BVRModelPanel cup = vSpecbvruikernel.getModelPanel();
		cup.clear();

		vspecNodes.clear();
		vspecBindings.clear();
		vspecvmMap.clear();
		
	    // Add stuff

		loadBVRVSpecView(toolModel.getBVRModel(), vSpecbvruikernel);

	    
	    // Automatically Layout Diagram
		LayoutStrategy strategy = new VSpecLayoutStrategy(vspecNodes, vspecBindings);
        vSpecbvruikernel.getModelPanel().layoutTreeNodes(strategy);
	    
	    // Restore scroll coordinates
	    vspecScrollPane.getViewport().setViewPosition(vpos);
	    
	}
	
	public EditableModelPanel getEditorRoolPanel(){
		return vspecEpanel;
	}


	@Override
	public void addChoice(GIU_NODE parent) {
		VSpec parentVSpec = (VSpec) vspecvmMap.get(parent);
		toolModel.addChoice(parentVSpec);
	}

	@Override
	public void minimizeNode(GIU_NODE node) {
		VSpec vspec = (VSpec) vspecvmMap.get(node);
		toolModel.minimaizeVSpec(vspec);
		notifyVspecViewUpdate();
	}

	@Override
	public void maximizeNode(GIU_NODE node) {
		VSpec vspec = (VSpec) vspecvmMap.get(node);
		toolModel.maximizeVSpec(vspec);
		notifyVspecViewUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public MODEL_OBJECT getModelObjectByUINode(GIU_NODE node) {
		return (MODEL_OBJECT) vspecvmMap.get(node);
	}

	@Override
	public Command createUpdateChoiceCommand(GIU_NODE node) {
		Command command = new UpdateChoiceBatchCommandDecorator(new UpdateChoice());
    	command.init(vSpecbvruikernel, (VSpec) vspecvmMap.get(node), node, vspecvmMap, vspecNodes, vspecBindings, rootController);
		return command;
	}

	@Override
	public void updateVariable(MODEL_OBJECT variable, String name, String typeName) {
		toolModel.updateVariable((Variable) variable, name, typeName);
	}

	@Override
	public void setNodeComment(GIU_NODE node, String comment) {
		NamedElement namedElement = (VSpec) vspecvmMap.get(node);
		toolModel.updateComment(namedElement, comment);
	}

	@Override
	public void setNodeName(GIU_NODE node, String name) {
		NamedElement namedElement = (VSpec) vspecvmMap.get(node);
		toolModel.updateName(namedElement, name);
	}

	@Override
	public String getNodesCommentText(GIU_NODE node) {
		NamedElement namedElement = (VSpec) vspecvmMap.get(node);
		return toolModel.getNodesCommentText(namedElement);
	}

	@Override
	public void enableBatchCommandProcessing() {
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
	}

	@Override
	public void disableBatchCommandProcessing() {
		Context.eINSTANCE.getEditorCommands().disableBatchProcessing();
	}

	@Override
	public void executeCommandBatch() {
		Context.eINSTANCE.getEditorCommands().executeBatch();
	}
	
}
