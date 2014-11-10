package no.sintef.bvr.tool.controller;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.controller.command.AddChoiceResolution;
import no.sintef.bvr.tool.controller.command.AddMissingResolutions;
import no.sintef.bvr.tool.controller.command.AddResolution;
import no.sintef.bvr.tool.controller.command.AddVariableResolution;
import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.controller.command.UpdateVariableValueAssignment;
import no.sintef.bvr.tool.decorator.SimpleExeCommandBatchDecorator;
import no.sintef.bvr.tool.decorator.UpdateVarValAssigBatchCmdDecorator;
import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.exception.UserInputError;
import no.sintef.bvr.tool.filter.PNGFilter;
import no.sintef.bvr.tool.subject.BVRModelSubject;
import no.sintef.bvr.tool.ui.command.AddChoiceResolutionFromVClassifier;
//import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
//import no.sintef.bvr.tool.ui.command.AddBCLConstraint;
//import no.sintef.bvr.tool.ui.command.AddGroupMultiplicity;
import no.sintef.bvr.tool.ui.command.AddOpaqueConstraint;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.tool.ui.dropdown.ResolutionDropdownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRResolutionView;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.ChangeChoiceFacade;
import no.sintef.bvr.tool.model.CloneResFacade;
import no.sintef.bvr.tool.model.InheritanceFacade;
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
import bvr.PosResolution;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.ValueResolution;
import bvr.Variable;

public class SwingResolutionController<GUI_NODE extends JComponent, MODEL_OBJECT extends EObject, SERIALIZABLE extends Serializable> implements
		ResolutionControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE> {
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
	
	private List<VSpecResolution> stripped = new ArrayList<VSpecResolution>();

	private ResolutionLayoutStrategy strategy;

	BVRNotifiableController rootController;
	private static final String PNG_EXT = "." + PNGFilter.PNG_EXT;

	public SwingResolutionController(BVRToolModel model, BVRNotifiableController controller) {
		controller.setCommonControllerInterface(this);
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
		resPane.addMouseListener(new ResolutionDropdownListener(rootController));

		if (bvrModel.getResolutionModels().size() == 0)
			return;

		for (VSpecResolution v : bvrModel.getResolutionModels()) {

			BVRUIKernel resKernel = new BVRUIKernel(null, rootController, resolutionvmMaps);
			resolutionkernels.add(resKernel);
			JScrollPane scrollPane = new JScrollPane(resKernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.addMouseListener(new ResolutionDropdownListener(rootController));
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
			nextParent = new AddChoiceResolutionFromVClassifier(toolModel.isVSpecResolutionMinimized(v), childrenStripped(v, printAnyway, secondPrint)).init(
					bvruikernel, v, parent, vmMap, nodes, bindings, rootController).execute();
		} else if (v instanceof ChoiceResolution) {
			nextParent = new AddChoiceResolution(toolModel.isVSpecResolutionMinimized(v), childrenStripped(v, printAnyway, secondPrint)).init(bvruikernel, v, parent,
					vmMap, nodes, bindings, rootController).execute();
		} else if (v instanceof ValueResolution) {
			new AddVariableResolution().init(bvruikernel, v, parent,
					vmMap, nodes, bindings, rootController).execute();
		}
		/*
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
		if (!toolModel.isVSpecResolutionMinimized(v)) {// TODO add show/hide visuals
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
				if (!toolModel.isVSpecResolutionMinimized(v)) {
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

	@Override
	public void addChoiceOrVClassifierResolution(GUI_NODE parent, MODEL_OBJECT resolvedVSpec) {
		NamedElement parentNamedElement = getElementInCurrentPane(parent);
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
		final int resolutionIndex = resPane.getSelectedIndex();
		SimpleExeCommandInterface command = new SimpleExeCommandInterface() {
			NamedElement toDelete = null;

			@Override
			public void execute() {
				toDelete = resolutionvmMaps.get(resolutionIndex).get(_toDelete);
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
		NamedElement toToggle = getElementInCurrentPane(_toToggle);
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.toggleChoice(toToggle);
			}
		});
		return command;
	}

	private NamedElement getElementInCurrentPane(JComponent toFind) {
		return resolutionvmMaps.get(resPane.getSelectedIndex()).get(toFind);
	}
	
	@Override
	public SimpleExeCommandInterface createResolveSubtreeCommand(GUI_NODE _parent) {
		final VSpecResolution parent = (VSpecResolution) getElementInCurrentPane(_parent);
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
		NamedElement element = getElementInCurrentPane(node);
		toolModel.minimaizeVSpecResolution((VSpecResolution) element);
		notifyResolutionViewUpdate();
	}

	@Override
	public void maximizeNode(GUI_NODE node) {
		NamedElement element = getElementInCurrentPane(node);
		toolModel.maximizeVSpecResolution((VSpecResolution) element);
		notifyResolutionViewUpdate();
	}

	@Override
	public SimpleExeCommandInterface createVariableResolutionCommand(GUI_NODE parent,
			MODEL_OBJECT _variable) {
		CompoundResolution compountResolution = (CompoundResolution) getElementInCurrentPane(parent);
		Variable variable = (Variable) _variable;
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
		int resolutionIndex = resPane.getSelectedIndex();
		return (MODEL_OBJECT) resolutionvmMaps.get(resolutionIndex).get(node);
	}

	@Override
	public Command createUpdateVariableResolutionCommand(GUI_NODE elem) {
		Command command = new UpdateVarValAssigBatchCmdDecorator(new UpdateVariableValueAssignment());
		command.init(resolutionkernels.get(resPane.getSelectedIndex()),
				getElementInCurrentPane(elem), elem,
				resolutionvmMaps.get(resPane.getSelectedIndex()),
				resolutionNodes.get(resPane.getSelectedIndex()),
				resolutionBindings.get(resPane.getSelectedIndex()), rootController);
		return command;
	}

	@Override
	public void setValueResolutionValue(GUI_NODE parent, String value) {
		NamedElement namedElement = getElementInCurrentPane(parent);
		toolModel.setValueResolution((ValueResolution) namedElement, value);
	}

	@Override
	public void setValueResolutionName(GUI_NODE parent, String name) {
		NamedElement namedElement = getElementInCurrentPane(parent);
		toolModel.setValueResolutionName((ValueResolution) namedElement, name);
	}

	@Override
	public String getValueReolutionStringValue(GUI_NODE node) {
		NamedElement namedElement = getElementInCurrentPane(node);
		return toolModel.getValueResolutionAsString((ValueResolution) namedElement);
	}
	
	@Override
	public int getReslovedVClassifierCount(GUI_NODE node, MODEL_OBJECT vclassifier) {
		NamedElement namedElement = getElementInCurrentPane(node);
		return toolModel.getResolvedVClassifierCount((CompoundResolution) namedElement, (VClassifier) vclassifier);
	}

	@Override
	public SimpleExeCommandInterface createResolveNVSpecCommand(GUI_NODE panel,
			MODEL_OBJECT vspec, int instancesToResolve) {
		NamedElement parentNamedElement = getElementInCurrentPane(panel);
		VSpec vSpecToResolve = (VSpec) vspec;
		SimpleExeCommandInterface command = new SimpleExeCommandBatchDecorator(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				toolModel.addChoiceOrVClassifierResolution(vSpecToResolve, (VSpecResolution) parentNamedElement, instancesToResolve);
			}
		});
		return command;
	}

}
