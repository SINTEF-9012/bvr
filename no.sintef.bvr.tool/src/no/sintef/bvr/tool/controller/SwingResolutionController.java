/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.controller;


import java.awt.Component;
import java.awt.Point;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.AddChoiceResolution;
import no.sintef.bvr.tool.controller.command.AddChoiceResolutionFromVClassifier;
import no.sintef.bvr.tool.controller.command.ShowInValidConstraintsResolution;
import no.sintef.bvr.tool.controller.command.ShowMultiplicityTriangleResolution;
import no.sintef.bvr.tool.controller.command.AddVariableResolution;
import no.sintef.bvr.tool.controller.command.UpdateVInstance;
import no.sintef.bvr.tool.controller.command.UpdateVariableValueAssignment;
import no.sintef.bvr.tool.decorator.SimpleExeCommandBatchDecorator;
import no.sintef.bvr.tool.decorator.UpdateVInstanceBatchCmdDecorator;
import no.sintef.bvr.tool.decorator.UpdateVarValAssigBatchCmdDecorator;
import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.exception.UserInputError;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.ResolutionControllerInterface;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.tool.ui.dropdown.ResolutionDropdownListener;
import no.sintef.bvr.tool.ui.dropdown.ResolutionPanDropdownListener;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.strategy.ResolutionLayoutStrategy;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.ValueResolution;
import bvr.Variable;


public class SwingResolutionController<GUI_NODE extends JComponent, MODEL_OBJECT extends EObject, SERIALIZABLE extends Serializable> implements
		ResolutionControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE> {
	
	private BVRNotifiableController rootController;
	
	private BVRToolModel toolModel;

	// Resolutions
	public JTabbedPane resPane;
	private List<EditableModelPanel> resolutionEpanels;
	private Map<JComponent, JScrollPane> resolutionPanesMap;
	private Map<JComponent, BVRUIKernel<BVREditorPanel, BVRModelPanel>> resolutionkernelsMap;
	private Map<JComponent, Map<JComponent, NamedElement>> resolutionvmMapsMap;
	private Map<JComponent, List<JComponent>> resolutionNodesMap;
	private Map<JComponent, List<Pair<JComponent, JComponent>>> resolutionBindingsMap;
	private HashMap<VSpecResolution, JComponent> resolutionSubTabMap;


	public SwingResolutionController(BVRToolModel model, BVRNotifiableController controller) {
		controller.setCommonControllerInterface(this);
		
		resolutionPanesMap = new HashMap<JComponent, JScrollPane>();
		resolutionkernelsMap = new HashMap<JComponent, BVRUIKernel<BVREditorPanel, BVRModelPanel>>();
		resolutionvmMapsMap = new HashMap<JComponent, Map<JComponent, NamedElement>>();
		resolutionNodesMap = new HashMap<JComponent, List<JComponent>>();
		resolutionBindingsMap = new HashMap<JComponent, List<Pair<JComponent, JComponent>>>();
		resolutionEpanels = new ArrayList<EditableModelPanel>();
		resolutionSubTabMap = new HashMap<VSpecResolution, JComponent>();
		
		toolModel = model;
		rootController = controller;
		resPane = new JTabbedPane();
		resPane.addMouseListener(new ResolutionDropdownListener(rootController));
	}

	private void loadBVRResolutionView() throws BVRModelException {
		BVRModel bvrModel = toolModel.getBVRModel();
		if (bvrModel.getResolutionModels().size() == 0)
			return;
		
		for (VSpecResolution v : bvrModel.getResolutionModels()) {
			JComponent subtab = resolutionSubTabMap.get(v);
			if(subtab == null) {
				BVRUIKernel<BVREditorPanel, BVRModelPanel> resKernel = new BVRUIKernel<BVREditorPanel, BVRModelPanel>(rootController);
				JScrollPane scrollPane = new JScrollPane(resKernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane.addMouseListener(new ResolutionPanDropdownListener(rootController));
				EditableModelPanel epanel = new EditableModelPanel(scrollPane);
				Map<JComponent, NamedElement> vmMap = new HashMap<JComponent, NamedElement>();
				List<JComponent> nodes = new ArrayList<JComponent>();
				List<Pair<JComponent, JComponent>> bindings = new ArrayList<Pair<JComponent, JComponent>>();
				
				loadBVRResolutionView(v, resKernel, null, bvrModel, vmMap, nodes, bindings);
	
				String tabtitle = (v.getName() != null) ? v.getName() : "null";
	
				resPane.addTab(tabtitle, epanel);
				resolutionEpanels.add(epanel);			
				resolutionkernelsMap.put(epanel, resKernel);
				resolutionPanesMap.put(epanel, scrollPane);
				
				resolutionvmMapsMap.put(epanel, vmMap);
				resolutionNodesMap.put(epanel, nodes);
				resolutionBindingsMap.put(epanel, bindings);
				resolutionSubTabMap.put(v, epanel);
			} else {
				BVRUIKernel<BVREditorPanel, BVRModelPanel> resKernel = resolutionkernelsMap.get(subtab);
				Map<JComponent, NamedElement> vmMap = resolutionvmMapsMap.get(subtab);
				List<JComponent> nodes = resolutionNodesMap.get(subtab);
				List<Pair<JComponent, JComponent>> bindings = resolutionBindingsMap.get(subtab);
				loadBVRResolutionView(v, resKernel, null, bvrModel, vmMap, nodes, bindings);
			}
		}

		updateTabsTitles();
	}

	
	private void loadBVRResolutionView(VSpecResolution v, BVRUIKernel<BVREditorPanel, BVRModelPanel> bvruikernel, JComponent parent, BVRModel bvrModel,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings) throws BVRModelException {

		JComponent nextParent = null;

		if (CommonUtility.isVSpecResolutionVClassifier(v)) {
			nextParent = new AddChoiceResolutionFromVClassifier<BVREditorPanel, BVRModelPanel>(toolModel.isVSpecResolutionMinimized(v)).init(
					bvruikernel, v, parent, vmMap, nodes, bindings, rootController).execute();
		} else if (v instanceof ChoiceResolution) {
			nextParent = new AddChoiceResolution<BVREditorPanel, BVRModelPanel>(toolModel.isVSpecResolutionMinimized(v)).init(bvruikernel, v, parent,
					vmMap, nodes, bindings, rootController).execute();
			if(toolModel.showGrouping())
				nextParent = new ShowMultiplicityTriangleResolution<BVREditorPanel, BVRModelPanel>().init(bvruikernel, v, nextParent,
					vmMap, nodes, bindings, rootController).execute();
			if(toolModel.showConstraints())
				new ShowInValidConstraintsResolution<BVREditorPanel, BVRModelPanel>().init(bvruikernel, v, nextParent,
						vmMap, nodes, bindings, rootController).execute();
		} else if (v instanceof ValueResolution) {
			new AddVariableResolution<BVREditorPanel, BVRModelPanel>().init(bvruikernel, v, parent,
					vmMap, nodes, bindings, rootController).execute();
		} else {
			throw new BVRModelException("Unknown element: " + v.getClass());
		}

		if (v instanceof CompoundResolution) {
			for (VSpecResolution vs : ((CompoundResolution) v).getMembers()) {
				if (!toolModel.isVSpecResolutionMinimized(v)) {
					loadBVRResolutionView(vs, bvruikernel, nextParent, bvrModel, vmMap, nodes, bindings);
				}
			}
		}
	}
	
	private void updateTabsTitles() {
		int count = resPane.getTabCount();
		for(int i = 0; i < count; i++) {
			Component editablePanel = resPane.getComponentAt(i);
			Iterator<Entry<VSpecResolution, JComponent>> it = resolutionSubTabMap.entrySet().iterator();
			VSpecResolution resolution = null;
			while(it.hasNext()) {
				Entry<VSpecResolution, JComponent> item = it.next();
				if(item.getValue().equals(editablePanel)) {
					resolution = item.getKey();
					break;
				}
			}
			
			if(resolution != null) 
				resPane.setTitleAt(i, resolution.getName());
		}
	}

	public void render() {
		loadBVRResolutionView();
		for(EditableModelPanel panel : resolutionEpanels) {
			ResolutionLayoutStrategy strategy = new ResolutionLayoutStrategy(resolutionNodesMap.get(panel), resolutionBindingsMap.get(panel));
			resolutionkernelsMap.get(panel).getModelPanel().layoutTreeNodes(strategy);
		}
	}

	public void notifyResolutionViewUpdate() {
		// Clean
		Iterator<Entry<VSpecResolution, JComponent>> it = resolutionSubTabMap.entrySet().iterator();
		EList<CompoundResolution> resolutions = toolModel.getBVRModel().getResolutionModels();
		while(it.hasNext()){
			Entry<VSpecResolution, JComponent> item = it.next();
			JComponent subTabResolution = item.getValue();
			if(!resolutions.contains(item.getKey())) {
				resolutionEpanels.remove(subTabResolution);	
				resolutionkernelsMap.remove(subTabResolution);
				resolutionPanesMap.remove(subTabResolution);
				resolutionvmMapsMap.remove(subTabResolution);
				resolutionNodesMap.remove(subTabResolution);
				resolutionBindingsMap.remove(subTabResolution);
				resPane.remove(subTabResolution);
				it.remove();
			} else {
				resolutionvmMapsMap.get(subTabResolution).clear();
				resolutionNodesMap.get(subTabResolution).clear();
				resolutionBindingsMap.get(subTabResolution).clear();
				resolutionkernelsMap.get(subTabResolution).getModelPanel().clear();
			}
		}
		
		// Save
		Point position = null;
		Component selectedComponent = null;
		if (resolutionEpanels.contains(resPane.getSelectedComponent())) {
			selectedComponent = resPane.getSelectedComponent();
			position = resolutionPanesMap.get(selectedComponent).getViewport().getViewPosition();
		}
		
		render();

		// Restore positions
		if (selectedComponent != null) {
			resPane.setSelectedComponent(selectedComponent);
			resolutionPanesMap.get(selectedComponent).getViewport().setViewPosition(position);
		}

	}

	@Override
	public boolean findGroupError(MODEL_OBJECT compoundResolution) {
		return toolModel.checkGroupError((CompoundResolution) compoundResolution);
	}

	public JTabbedPane getResolutionPane() {
		return resPane;
	}

	@Override
	public void addChoiceOrVClassifierResolution(GUI_NODE parent, MODEL_OBJECT resolvedVSpec) {
		NamedElement parentNamedElement = getNamedElementByJComponent(parent);
		if (parentNamedElement != null) {
			VSpec vSpecToResolve = (VSpec) resolvedVSpec;
			toolModel.addChoiceOrVClassifierResolution(vSpecToResolve, (VSpecResolution) parentNamedElement);
		}
	}

	@Override
	public SimpleExeCommandInterface createResolutionModelCommand() {
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				CompoundResolution compoundResolution = toolModel.createResolution();
				toolModel.addResolutionModel(compoundResolution);
			}
		});
		return command;
	}

	@Override
	public SimpleExeCommandInterface createRemoveRootResolutionCommand() {
		final int resolutionIndex = resPane.getSelectedIndex();
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.removeRootResolution(resolutionIndex);
			}
		});
		return command;
	}

	@Override
	public SimpleExeCommandInterface createGenerateAllProductsCommand() {
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.removeAllResolutions();
				toolModel.generatAllProducts();
			}
		});
		return command;
	}

	@Override
	public SimpleExeCommandInterface createRemoveVSpecResolutionCommand(final GUI_NODE _toDelete) {
		final NamedElement toDelete = getNamedElementByJComponent(_toDelete);
		SimpleExeCommandInterface command = new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.removeVSpecResolution(toDelete);
			}

		};
		return command;
	}

	public boolean performSATValidation() {
		return toolModel.performSATValidation();
	}

	@Override
	public List<String> getSATValidationMessage() {
		return toolModel.getSATValidationMessage();
	}

	@Override
	public Integer calculateCoverage(int t) {
		return toolModel.calculateCoverage(t);
	}

	@Override
	public SimpleExeCommandInterface createGenerateCoveringArrayCommand(int t) {
		final int xWise = t;
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.generateCoveringArray(xWise);
			}
		});
		return command;
	}

	@Override
	public SimpleExeCommandInterface createToggleChoiceCommand(GUI_NODE _toToggle) {
		final NamedElement toToggle = getNamedElementByJComponent(_toToggle);
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.toggleChoice(toToggle);
			}
		});
		return command;
	}

	private NamedElement getNamedElementByJComponent(JComponent toFind) {
		NamedElement foundNamedElement  = null;
		if(resPane.getSelectedIndex() >= 0){
			foundNamedElement = resolutionvmMapsMap.get(resPane.getSelectedComponent()).get(toFind);
		} else {
			for(Map<JComponent, NamedElement> map : resolutionvmMapsMap.values()){
				foundNamedElement = map.get(toFind);
				if(foundNamedElement != null)
					break;
			}
		}
		return foundNamedElement;
	}
	
	@Override
	public SimpleExeCommandInterface createResolveSubtreeCommand(GUI_NODE _parent) {
		final VSpecResolution parent = (VSpecResolution) getNamedElementByJComponent(_parent);
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.resolveSubtree(parent);
			}
		});
		return command;
	}

	@Override
	public void importResolution(SERIALIZABLE _file) {
		if(!(_file instanceof File))
			throw new UserInputError("Expect file to import");
		File file = (File) _file;
		toolModel.importResolutionFromFile(file);
	}

	@Override
	public String calculateCosts() {
		return toolModel.calculateCosts();
	}

	@Override
	public void exportAsPNGImage(SERIALIZABLE _file) {
		if(!(_file instanceof File))
			throw new UserInputError("Expect file to import");
		File file = (File) _file;
		EditableModelPanel draw = (EditableModelPanel) resPane.getSelectedComponent();
		JScrollPane draw2 = (JScrollPane) draw.modelPanel;
		JLayeredPane layeredPanel = (JLayeredPane) draw2.getViewport().getView();
		StaticUICommands.saveLayeredPaneAsPNGImage(layeredPanel, file);
	}

	@Override
	public String getModelFileLocation() {
		return (toolModel.getFile() != null) ? toolModel.getFile().getName() : null;
	}

	@Override
	public void toggleShowConstraints() {
		toolModel.toggleShowConstraints();
		notifyResolutionViewUpdate();
	}

	@Override
	public boolean isResolutionModelSet() {
		return toolModel.isResolutionModelSet();
	}

	@Override
	public void minimizeNode(GUI_NODE node) {
		NamedElement element = getNamedElementByJComponent(node);
		toolModel.minimaizeVSpecResolution((VSpecResolution) element);
		notifyResolutionViewUpdate();
	}

	@Override
	public void maximizeNode(GUI_NODE node) {
		NamedElement element = getNamedElementByJComponent(node);
		toolModel.maximizeVSpecResolution((VSpecResolution) element);
		notifyResolutionViewUpdate();
	}

	@Override
	public SimpleExeCommandInterface createVariableResolutionCommand(GUI_NODE parent,
			MODEL_OBJECT _variable) {
		final CompoundResolution compountResolution = (CompoundResolution) getNamedElementByJComponent(parent);
		final Variable variable = (Variable) _variable;
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.resolveVariable(compountResolution, variable);
			}
		});
		return command;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public MODEL_OBJECT getModelObjectByUINode(GUI_NODE node) {
		return (MODEL_OBJECT) getNamedElementByJComponent(node);
	}

	@Override
	public Command<?,?> createUpdateVariableResolutionCommand(GUI_NODE elem) {
		Component resolutionTab = resPane.getSelectedComponent();
		Command<BVREditorPanel, BVRModelPanel> command = new UpdateVarValAssigBatchCmdDecorator<BVREditorPanel, BVRModelPanel>(
				new UpdateVariableValueAssignment<BVREditorPanel, BVRModelPanel>());
		command.init(resolutionkernelsMap.get(resolutionTab),
				getNamedElementByJComponent(elem), elem,
				resolutionvmMapsMap.get(resolutionTab),
				resolutionNodesMap.get(resolutionTab),
				resolutionBindingsMap.get(resolutionTab), rootController);
		return command;
	}

	@Override
	public void setValueResolutionValue(GUI_NODE parent, String value) {
		NamedElement namedElement = getNamedElementByJComponent(parent);
		toolModel.setValueResolution((ValueResolution) namedElement, value);
	}

	@Override
	public void setValueResolutionName(GUI_NODE parent, String name) {
		NamedElement namedElement = getNamedElementByJComponent(parent);
		toolModel.setValueResolutionName((ValueResolution) namedElement, name);
	}

	@Override
	public String getValueReolutionStringValue(GUI_NODE node) {
		NamedElement namedElement = getNamedElementByJComponent(node);
		return toolModel.getValueResolutionAsString((ValueResolution) namedElement);
	}
	
	@Override
	public int getReslovedVClassifierCount(GUI_NODE node, MODEL_OBJECT vclassifier) {
		NamedElement namedElement = getNamedElementByJComponent(node);
		return toolModel.getResolvedVClassifierCount((CompoundResolution) namedElement, (VClassifier) vclassifier);
	}

	@Override
	public SimpleExeCommandInterface createResolveNVSpecCommand(GUI_NODE panel,
			MODEL_OBJECT vspec, int instancesToResolve) {
		final NamedElement parentNamedElement = getNamedElementByJComponent(panel);
		final VSpec vSpecToResolve = (VSpec) vspec;
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.addChoiceOrVClassifierResolution(vSpecToResolve, (VSpecResolution) parentNamedElement, instancesToResolve);
			}
		});
		return command;
	}

	@Override
	public Command<?,?> createUpdateInstanceChoiceResolutionCommand(
			GUI_NODE vInstance) {
		Component resolutionTab = resPane.getSelectedComponent();
		Command<BVREditorPanel, BVRModelPanel> command =
				new UpdateVInstanceBatchCmdDecorator<BVREditorPanel, BVRModelPanel>(
						new UpdateVInstance<BVREditorPanel, BVRModelPanel>());
		command.init(resolutionkernelsMap.get(resolutionTab),
				getNamedElementByJComponent(vInstance), vInstance,
				resolutionvmMapsMap.get(resolutionTab),
				resolutionNodesMap.get(resolutionTab),
				resolutionBindingsMap.get(resolutionTab), rootController);
		return command;
	}
	
	@Override
	public void setNodeName(GUI_NODE node, String name) {
		NamedElement namedElement = getNamedElementByJComponent(node);
		toolModel.updateName(namedElement, name);
	}

	@Override
	public void toggleShowGrouping() {
		toolModel.showGrouping(!toolModel.showGrouping());
		notifyResolutionViewUpdate();
	}

	@Override
	public List<Constraint> getInvalidConstraints() {
		return toolModel.getInvalidConstraints();
	}

	@Override
	public String getBCLConstraintString(GUI_NODE node) {
		BCLConstraint constraint = (BCLConstraint) getNamedElementByJComponent(node);
		return toolModel.getBCLConstraintString(constraint);
	}

	@Override
	public List<String> validateResolutionNode(GUI_NODE component) {
		VSpecResolution vSpecResolution = (VSpecResolution)  getNamedElementByJComponent(component);
		return toolModel.validateChoiceResolution(vSpecResolution);
	}

	@Override
	public void executeProduct(SERIALIZABLE destFile) {
		int index = resPane.getSelectedIndex();
		toolModel.executeResolution((File) destFile, index);
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
	public boolean isSubstitutionEngineInitialized() {
		return (Context.eINSTANCE.getSubEngine() == null) ? false : true;
	}

	@Override
	public SimpleExeCommandInterface createRemoveAllResolutionsCommand() {
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.removeAllResolutions();
			}
		});
		return command;
	}
	@Override
	public void removeUncontainedResolutions(GUI_NODE parent) {
		VSpecResolution vSpecResolution = (VSpecResolution)  getNamedElementByJComponent(parent);
		toolModel.removeUncontainedResolutions(vSpecResolution);
	}

	@Override
	public boolean performSATValidationSingleResolution() {
		Iterator<Entry<VSpecResolution, JComponent>> it = resolutionSubTabMap.entrySet().iterator();
		VSpecResolution resoluion = null;
		while (it.hasNext()) {
			Map.Entry<VSpecResolution, JComponent> entry = (Entry<VSpecResolution, JComponent>) it.next();
			if(entry.getValue().equals(resPane.getSelectedComponent())) {
				resoluion = entry.getKey();
				break;
			}
		}
		
		if(resoluion == null)
			throw new UnexpectedException("can not find resolution to validate!");
	
		return toolModel.performSATValidation(resoluion);
	}

	@Override
	public SimpleExeCommandInterface createRenameResolutionCommand(String name) {
		Iterator<Entry<VSpecResolution, JComponent>> it = resolutionSubTabMap.entrySet().iterator();
		VSpecResolution resoluion = null;
		while (it.hasNext()) {
			Map.Entry<VSpecResolution, JComponent> entry = (Entry<VSpecResolution, JComponent>) it.next();
			if(entry.getValue().equals(resPane.getSelectedComponent())) {
				resoluion = entry.getKey();
				break;
			}
		}
		
		if(resoluion == null)
			throw new UnexpectedException("can not find resolution to rename!");
		
		final NamedElement resToRename = resoluion;
		final String newName = name;
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.updateName(resToRename, newName);
			}
		});		
		
		return command;
	}
}
