package no.sintef.bvr.tool.controller;

import java.awt.Point;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.controller.command.AddChoiceResolutionFromVClassifier;
import no.sintef.bvr.tool.controller.command.AddResolution;
import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.decorator.SimpleExeCommandBatchDecorator;
import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.subject.BVRModelSubject;
import no.sintef.bvr.tool.ui.command.AddChoiceResolution;
//import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
//import no.sintef.bvr.tool.ui.command.AddBCLConstraint;
//import no.sintef.bvr.tool.ui.command.AddGroupMultiplicity;
import no.sintef.bvr.tool.ui.command.AddOpaqueConstraint;
import no.sintef.bvr.tool.ui.dropdown.ResolutionDropdownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRResolutionView;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.ResolutionModelIterator;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.tool.ui.strategy.ResolutionLayoutStrategy;
import no.sintef.bvr.tool.ui.strategy.VSpecLayoutStrategy;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.EditableModelPanelV2;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.GroupPanelWithError;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners.ResV2DropdownListener;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddChoiceResolution;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddErrorGroup;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddChoiceResolutionFromVClassifier;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddValueResolution;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddViolatedBCLConstraint;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddViolatedOpaqueConstraint;
import no.sintef.bvr.ui.framework.TitledElement;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import no.sintef.bvr.ui.framework.elements.GroupPanel;

import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.demo.TextInBox;
import org.abego.treelayout.demo.TextInBoxNodeExtentProvider;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;
import org.eclipse.emf.ecore.EObject;

import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.NegResolution;
import bvr.OpaqueConstraint;
import bvr.VSpec;
import bvr.VSpecResolution;

public class SwingResolutionController<GUI_NODE extends JComponent, MODEL_OBJECT extends EObject> implements
		ResolutionControllerInterface<GUI_NODE, MODEL_OBJECT> {
	private BVRToolModel toolModel;
	private List<Constraint> invalidConstraints;

	public JTabbedPane modelPane;
	private boolean showGroups;
	private boolean showConstraints;

	// Resolutions
	public JTabbedPane resPane;
	private List<JScrollPane> resolutionPanes;
	private List<EditableModelPanel> resolutionEpanels;
	private List<BVRUIKernel> resolutionkernels;
	private List<Map<JComponent, NamedElement>> resolutionvmMaps;
	private List<List<JComponent>> resolutionNodes;
	private List<List<Pair<JComponent, JComponent>>> resolutionBindings;
	private BVRModelSubject bvrModelSubject;
	// private ConfigurableUnitSubject configurableUnitSubject;

	// namecounters
	private int choiceCount = 1;
	private int instanceNameCounter;

	// draw variables
	private List<VSpecResolution> minimized = new ArrayList<VSpecResolution>();
	private List<VSpecResolution> stripped = new ArrayList<VSpecResolution>();

	private ResolutionLayoutStrategy strategy;

	BVRNotifiableController rootController;

	public SwingResolutionController(BVRToolModel model, BVRNotifiableController controller) {
		resolutionPanes = new ArrayList<JScrollPane>();
		resolutionEpanels = new ArrayList<EditableModelPanel>();
		resolutionkernels = new ArrayList<BVRUIKernel>();
		resolutionvmMaps = new ArrayList<Map<JComponent, NamedElement>>();
		resolutionNodes = new ArrayList<List<JComponent>>();
		resolutionBindings = new ArrayList<List<Pair<JComponent, JComponent>>>();
		strategy = new ResolutionLayoutStrategy(resolutionNodes, resolutionBindings, (ArrayList<JScrollPane>) resolutionPanes);
		this.toolModel = model;
		this.rootController = controller;
		this.showGroups = true;
		this.showConstraints = false;
		this.invalidConstraints = new ArrayList<Constraint>();

		bvrModelSubject = new BVRModelSubject(toolModel.getBVRModel());

		// Resolution panes
		resPane = new JTabbedPane();
	}

	private void loadBVRResolutionView(BVRModel bvrModel, List<BVRUIKernel> resolutionkernels) throws BVRModelException {
		resPane.addMouseListener(new ResolutionDropdownListener(rootController, bvrModel, toolModel, resPane, null));

		if (bvrModel.getResolutionModels().size() == 0)
			return;

		for (VSpecResolution v : bvrModel.getResolutionModels()) {

			BVRUIKernel resKernel = new BVRUIKernel(null, rootController, resolutionvmMaps);
			resolutionkernels.add(resKernel);
			JScrollPane scrollPane = new JScrollPane(resKernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.addMouseListener(new ResolutionDropdownListener(rootController, bvrModel, toolModel, resPane, null));
			EditableModelPanel epanel = new EditableModelPanel(scrollPane);

			resolutionPanes.add(scrollPane);
			resolutionEpanels.add(epanel);
			Map<JComponent, NamedElement> vmMap = new HashMap<JComponent, NamedElement>();
			resolutionvmMaps.add(vmMap);
			List<JComponent> nodes = new ArrayList<JComponent>();
			resolutionNodes.add(nodes);
			List<Pair<JComponent, JComponent>> bindings = new ArrayList<Pair<JComponent, JComponent>>();
			resolutionBindings.add(bindings);

			loadBVRResolutionView(v, resKernel, null, bvrModel, vmMap, nodes, bindings, false, false);
			// resKernel.getModelPanel().layoutTreeNodes(strategy);

			String tabtitle = "";
			if (v instanceof ChoiceResolution) {
				ChoiceResolution cr = (ChoiceResolution) v;
				String choicename = "null";
				if (cr.getResolvedVSpec() != null) {
					choicename = cr.getResolvedVSpec().getName();
				}
				tabtitle = choicename + choiceCount;
				choiceCount++;
			} else if (CommonUtility.isVSpecResolutionVClassifier(v)) {
				tabtitle = v.getName() + ":" + ((ChoiceResolution) v).getResolvedVClassifier().getName();
			}

			resPane.addTab(tabtitle, null, epanel, "");
		}
	}

	// printAnyway and secondPrint added for single layer stripped functionality
	// stripped nodes are not drawn.
	private void loadBVRResolutionView(VSpecResolution v, BVRUIKernel bvruikernel, JComponent parent, BVRModel bvrModel,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, boolean printAnyway_,
			boolean secondPrint_) throws BVRModelException {

		JComponent nextParent = null;
		boolean printAnyway = printAnyway_;
		boolean secondPrint = secondPrint_;

		// if (!stripped(v, printAnyway, secondPrint)) {
		// if (printAnyway) {
		// secondPrint = true;
		// }
		// printAnyway = false;
		/*
		 * if (v.getResolvedVSpec() == null) { System.out.println("resolvedVSpec is not set for: " + v); return; }
		 */
		// Add view
		// System.out.println(v.getClass().getSimpleName());
		if (CommonUtility.isVSpecResolutionVClassifier(v)) {
			// System.out.println(v + ", " + bvruikernel);

			nextParent = new AddChoiceResolutionFromVClassifier(minimized.contains(v), childrenStripped(v, printAnyway, secondPrint)).init(
					bvruikernel, v, parent, vmMap, nodes, bindings, rootController).execute();

			vmMap.put(nextParent, v);

		} else if (v instanceof ChoiceResolution) {
			// System.out.println(v);
			nextParent = new AddChoiceResolution(minimized.contains(v), childrenStripped(v, printAnyway, secondPrint)).init(bvruikernel, v, parent,
					vmMap, nodes, bindings, rootController).execute();

			vmMap.put(nextParent, v);

		} /*
		 * 
		 * 
		 * //TODO deal with Variables
		 * 
		 * 
		 * else if (v instanceof VariableValueAssignment) { // System.out.println(v);
		 * 
		 * nextParent = new AddVariableValueAssignmentV2(minimized.contains(v), false) .init(bvruikernel, v, parent, vmMap, nodes, bindings,
		 * this).execute();
		 * 
		 * vmMap.put(nextParent, v);
		 * 
		 * }
		 */else {
			throw new BVRModelException("Unknown element: " + v.getClass());
		}
		if (!minimized.contains(v)) {// TODO add show/hide visuals
			/*
			 * if (showConstraints) { for (Constraint c : bvrModel.getVariabilityModel().getOwnedConstraint()) { /* if (c instanceof OpaqueConstraint)
			 * { if (((OpaqueConstraint) c).getConstraint() == v.getResolvedVSpec()) { if (invalidConstraints.contains(c)) { JComponent con = new
			 * AddViolatedOpaqueConstraint().init(bvruikernel, c, nextParent, vmMap, nodes, bindings, this) .execute(); vmMap.put(con, v); } else {
			 * JComponent con = new AddOpaqueConstraint().init(bvruikernel, c, nextParent, vmMap, nodes, bindings, this) .execute(); vmMap.put(con,
			 * v); } }
			 * 
			 * }
			 */// TODO check if this is correct
			/*
			 * if (c instanceof BCLConstraint) { if (((OpaqueConstraint) c).getName().equals(v.getResolvedVSpec().getName())) { if
			 * (invalidConstraints.contains(c)) { JComponent con = new AddViolatedBCLConstraint().init(bvruikernel, c, nextParent, vmMap, nodes,
			 * bindings, this) .execute(); vmMap.put(con, v); } else { JComponent con = new AddBCLConstraint().init(bvruikernel, c, nextParent, vmMap,
			 * nodes, bindings, this).execute(); vmMap.put(con, v); } } } } }
			 */
			// for debug
			// if(v.getResolvedVSpec()==null)System.err.println(v +
			// "does not contain resolved VSpec");
			// else{
			// System.out.println(v.getResolvedVSpec().getName()
			// +" is beeng drawn");
			// }

			// TODO

			/*
			 * if (showGroups) {
			 * 
			 * if (((CompoundResolution) v).getGroupMultiplicity() != null) { boolean error = findGroupError(v);
			 * 
			 * if (error) { nextParent = new AddErrorGroup().init(bvruikernel, v.getResolvedVSpec(), nextParent, vmMap, nodes, bindings,
			 * this).execute(); if (!secondPrint) printAnyway = true; } else { nextParent = new AddGroupMultiplicity().init(bvruikernel,
			 * v.getResolvedVSpec(), nextParent, vmMap, nodes, bindings, this) .execute();
			 * 
			 * } } }
			 */

		}

		// Recursive step
		// System.out.println();
		if (v instanceof CompoundResolution)
			for (VSpecResolution vs : ((CompoundResolution) v).getMembers()) {
				if (!minimized.contains(v)) {
					loadBVRResolutionView(vs, bvruikernel, nextParent, bvrModel, vmMap, nodes, bindings, printAnyway, secondPrint);

				}
			}

		// }

	}

	public void render() {
		loadBVRResolutionView(toolModel.getBVRModel(), resolutionkernels);
		for (BVRUIKernel resKernel : resolutionkernels) {
			strategy = new ResolutionLayoutStrategy(resolutionNodes, resolutionBindings, (ArrayList<JScrollPane>) resolutionPanes);
			resKernel.getModelPanel().layoutTreeNodes(strategy);
		}
	}

	public void notifyResolutionViewUpdate() {
		// Save
		boolean isEmpty = resPane.getTabCount() == 0;
		int resmodels = toolModel.getBVRModel().getResolutionModels().size();
		boolean modelIsEmpty = toolModel.getBVRModel().getResolutionModels().size() == 0;

		int selected = 0;
		Point pos = null;
		if (!isEmpty) {
			selected = resPane.getSelectedIndex();
			pos = resolutionPanes.get(selected).getViewport().getViewPosition();
		}

		// Clean up
		resPane.removeAll();

		resolutionPanes = new ArrayList<JScrollPane>();
		resolutionEpanels = new ArrayList<EditableModelPanel>();
		resolutionkernels = new ArrayList<BVRUIKernel>();
		resolutionvmMaps = new ArrayList<Map<JComponent, NamedElement>>();
		resolutionNodes = new ArrayList<List<JComponent>>();
		resolutionBindings = new ArrayList<List<Pair<JComponent, JComponent>>>();

		choiceCount = 1;
		render();

		// loadBVRResolutionView(toolModel.getBVRModel(), resolutionkernels);

		// Restore positions
		if (!isEmpty && !modelIsEmpty && selected < resmodels) {
			resPane.setSelectedIndex(selected);
			resolutionPanes.get(selected).getViewport().setViewPosition(pos);
		}

	}

	private boolean stripped(VSpecResolution v, boolean printAnyway, boolean secondPrint) {
		return secondPrint;
		/*
		 * if (v instanceof ChoiceResolution && stripped.contains(v) && !printAnyway) { if (!getCU().getOwnedVSpecResolution().contains(v)) return
		 * !((ChoiceResolution) v).isDecision(); } else if(secondPrint && stripped.contains(v)){ return true; } return false;
		 */
	}

	// returns if children are stripped
	private boolean childrenStripped(VSpecResolution v, boolean printAnyway, boolean secondPrint) {
		return false;
		/*
		 * for (VSpecResolution x : v.getChild()) { if (stripped( x, false, false)) if(!findGroupError(x)) //remove to show stripped mark on stripped
		 * nodes showing all due to group error return true; } return false;
		 */
	}

	private boolean findGroupError(VSpecResolution v) {
		return false;
		/*
		 * if (v.getResolvedVSpec().getGroupMultiplicity() == null) return false; int lower = v.getResolvedVSpec().getGroupMultiplicity().getLower();
		 * int upper = v.getResolvedVSpec().getGroupMultiplicity().getUpper(); int i = 0; for (VSpecResolution x : v.getChild()) { if (x instanceof
		 * ChoiceResolution) { if (((ChoiceResolution) x).isDecision()) i++; if ((i > upper) && (upper != -1)){ return true; } } } if (i < lower)
		 * return true; return false;
		 */
	}

	public JTabbedPane getResolutionPane() {
		return resPane;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void addChoiceResolution(GUI_NODE parent, MODEL_OBJECT resolvedVSpec) {
		VSpecResolution parentNamedElement = null;
		for (Map x : resolutionvmMaps) {
			parentNamedElement = (VSpecResolution) x.get(parent);
			if (parentNamedElement != null) {
				VSpec vSpecToResolve = (VSpec) resolvedVSpec;
				toolModel.addChoiceResolution(vSpecToResolve, parentNamedElement);
				return;
			}
		}
	}

	@Override
	public SimpleExeCommandInterface createResolutionModelCommand() {
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				CompoundResolution compoundResolution = toolModel.createResolution();
				ResolutionModelIterator.getInstance().iterateEmptyOnChildren(rootController, new AddResolution(),
						(VSpec) compoundResolution.getResolvedChoice(), compoundResolution, false);
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
	public SimpleExeCommandInterface RemoveVsSpecResoluton(final GUI_NODE _toDelete) {
		final int resolutionIndex = resPane.getSelectedIndex();
		SimpleExeCommandInterface command = new SimpleExeCommandInterface() {
			NamedElement toDelete = null;
			NamedElement parentNamedElement = null;
			@Override
			public void execute() {
				toDelete = resolutionvmMaps.get(resolutionIndex).get(_toDelete);
				 
				if (toDelete != null) {
					parentNamedElement = ResolutionModelIterator.getInstance().getParent(toolModel.getBVRModel(), (VSpecResolution) toDelete);
					Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution((VSpecResolution) parentNamedElement, toDelete);
				} else {
					System.out.println("could not find node to remove");
				}
			}
			

		};
		return command;
	}
	

	 

}
