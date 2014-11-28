package no.sintef.bvr.tool.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import org.eclipse.emf.ecore.EObject;

import bvr.NamedElement;
import bvr.VType;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.VTypeControllerInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.strategy.VSpecLayoutStrategy;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;

public class SwingVTypeController<GUI_NODE extends JComponent, MODEL_OBJECT extends EObject, SERIALIZABLE extends Serializable>
		implements
		VTypeControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE> {

	private EditableModelPanel vtypeEpanel;
	private BVRToolModel toolModel;
	private HashMap<JComponent, NamedElement> vtypeMap;
	private ArrayList<JComponent> vtypeNodes;
	private ArrayList<Pair<JComponent, JComponent>> vtypeBindings;
	private BVRNotifiableController rootController;
	private BVRUIKernel<BVREditorPanel, BVRModelPanel> vtypebvruikernel;
	private VSpecLayoutStrategy strategy;
	private JScrollPane vtypeScrollPane;

	public SwingVTypeController(BVRToolModel _model, VType vType,
			BVRNotifiableController controller) {
		controller.setCommonControllerInterface(this);

		toolModel = _model;
		vtypeMap = new HashMap<JComponent, NamedElement>();
		vtypeNodes = new ArrayList<JComponent>();
		vtypeBindings = new ArrayList<Pair<JComponent, JComponent>>();
		rootController = controller;

		vtypebvruikernel = new BVRUIKernel<BVREditorPanel, BVRModelPanel>(
				rootController);

		strategy = new VSpecLayoutStrategy(vtypeNodes, vtypeBindings);
		vtypeScrollPane = new JScrollPane(vtypebvruikernel.getModelPanel(),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		vtypeEpanel = new EditableModelPanel(vtypeScrollPane);
	}

	public void render() {

	}

	public EditableModelPanel getEditorRoolPanel() {
		return vtypeEpanel;
	}

}
