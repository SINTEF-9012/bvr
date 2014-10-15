package no.sintef.bvr.tool.controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.ui.command.AddBCLConstraint;
import no.sintef.bvr.tool.ui.command.AddBVRModel;
import no.sintef.bvr.tool.ui.command.AddChoice;
import no.sintef.bvr.tool.ui.command.AddGroupMultiplicity;
import no.sintef.bvr.tool.ui.command.AddVClassifier;
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

public class SwingVSpecController<GIU_NODE extends JComponent> implements VSpecControllerInterface<GIU_NODE> {

	public JScrollPane vspecScrollPane;
	public EditableModelPanel vspecEpanel;
	private BVRUIKernel vSpecbvruikernel;
	
	private Map<JComponent, NamedElement> vspecvmMap;
	private List<JComponent> vspecNodes;
	private List<Pair<JComponent, JComponent>> vspecBindings;
	private BVRToolModel toolModel;
	private BVRNotifiableController rootController;
	
	
	public SwingVSpecController(BVRToolModel model, BVRNotifiableController controller) {
		toolModel = model;
		vspecvmMap = new HashMap<JComponent, NamedElement>();
		vspecNodes = new ArrayList<JComponent>();
		vspecBindings = new ArrayList<Pair<JComponent,JComponent>>();
		rootController = controller;
		
		vSpecbvruikernel = new BVRUIKernel(vspecvmMap, rootController, null);
		loadBVRVSpecView(model.getBVRModel(), vSpecbvruikernel);
        
        
        LayoutStrategy strategy = new VSpecLayoutStrategy(vspecNodes, vspecBindings);
        vSpecbvruikernel.getModelPanel().layoutTreeNodes(strategy);
		
		vspecScrollPane = new JScrollPane(vSpecbvruikernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        vspecEpanel = new EditableModelPanel(vspecScrollPane);
	}
	
	private void loadBVRVSpecView(BVRModel cu, BVRUIKernel model) throws BVRModelException {
		model.getModelPanel().addMouseListener(new VSpecDropDownListener(toolModel, rootController));
		
		JComponent c = new AddBVRModel().init(cu, model, vspecvmMap, vspecNodes, vspecBindings, rootController).execute();
		
		CompoundNode vspec = cu.getVariabilityModel();
		loadBVRVSpecView(vspec, model, c, cu);
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
	
	

}
