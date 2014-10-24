package no.sintef.bvr.ui.editor.mvc.resolutionV2;

import java.awt.Point;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.subject.BVRModelSubject;
//import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.command.AddBCLConstraint;
import no.sintef.bvr.tool.ui.command.AddGroupMultiplicity;
import no.sintef.bvr.tool.ui.command.AddOpaqueConstraint;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRResolutionView;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.EditableModelPanelV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.GroupPanelWithError;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners.ResV2DropdownListener;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddChoiceResolutuionV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddErrorGroup;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddVInstanceV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddVariableValueAssignmentV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddViolatedBCLConstraint;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.AddViolatedOpaqueConstraint;
import no.sintef.bvr.ui.framework.TitledElement;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import no.sintef.bvr.ui.framework.elements.GroupPanel;

import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.demo.TextInBox;
import org.abego.treelayout.demo.TextInBoxNodeExtentProvider;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;

import bvr.BCLConstraint;
import bvr.BVRModel;
//import bvr.ChoiceResolutuion;
//import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.OpaqueConstraint;
//import bvr.VInstance;
import bvr.VSpecResolution;
//import bvr.VariableValueAssignment;

public class ResolutionToolView extends BVRToolAbstractController implements BVRResolutionToolView {
	private BVRToolModel m;
	private List<Constraint> invalidConstraints;
	public void setInvalidConstraints(List<Constraint> invalidConstraints) {
		this.invalidConstraints = invalidConstraints;
	}

	public JTabbedPane modelPane;
	private boolean showGroups;
	private boolean showConstraints;
	// VSpec
	public JScrollPane vspecScrollPane;
	public EditableModelPanelV2 vspecEpanel;
	private Map<JComponent, NamedElement> vspecvmMap;
	private BVRUIKernel vSpecbvruikernel;

	// Resolutions
	public JTabbedPane resPane;
	private List<JScrollPane> resolutionPanes;
	private List<EditableModelPanel> resolutionEpanels;
	private List<BVRUIKernel> resolutionkernels;
	private List<Map<JComponent, NamedElement>> resolutionvmMaps;
	private List<List<JComponent>> resolutionNodes;
	private List<List<Pair<JComponent, JComponent>>> resolutionBindings;

//	private ConfigurableUnitSubject configurableUnitSubject;

	// namecounters
	private int choiceCount = 1;
	private int instanceNameCounter;

	// draw variables
	private List<VSpecResolution> minimized = new ArrayList<VSpecResolution>();
	private List<VSpecResolution> stripped = new ArrayList<VSpecResolution>();

	// tools

	public ResolutionToolView(BVRToolModel m) {
		super();

		resolutionPanes = new ArrayList<JScrollPane>();
		resolutionEpanels = new ArrayList<EditableModelPanel>();
		resolutionkernels = new ArrayList<BVRUIKernel>();
		resolutionvmMaps = new ArrayList<Map<JComponent, NamedElement>>();
		resolutionNodes = new ArrayList<List<JComponent>>();
		resolutionBindings = new ArrayList<List<Pair<JComponent, JComponent>>>();

		this.m = m;
		this.showGroups = true;
		this.showConstraints = false;
		this.invalidConstraints = new ArrayList<Constraint>();

//		configurableUnitSubject = new ConfigurableUnitSubject(this.getCU());

		vSpecbvruikernel = new BVRUIKernel(vspecvmMap,  this, resolutionvmMaps);

		vspecScrollPane = new JScrollPane(vSpecbvruikernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		vspecEpanel = new EditableModelPanelV2(vspecScrollPane);

		// Resolution panes
		resPane = new JTabbedPane();

		loadBVRResolutionView(/*m.getBVRM().getCU(),*/ resolutionkernels, resPane);
		autoLayoutResolutions();
	}

	public BVRUIKernel getKernel() {
		return vSpecbvruikernel;
	}

//	@Override
	public JTabbedPane getResolutionPane() {
		return resPane;
	}

	
	public boolean isDirty() {
		return m.isNotSaved();
	}
/*
	@Override
	public ConfigurableUnitSubject getConfigurableUnitSubject() {
		return configurableUnitSubject;
	}

	@Override
	public ConfigurableUnit getCU() {
		return m.getCU();
	}

	@Override
	public BVRModel getModel() {
		return m;
	}*/

	protected void autoLayoutResolutions() {// TODO
		for (int i = 0; i < resolutionPanes.size(); i++) {
			Map<JComponent, TextInBox> nodemap = new HashMap<JComponent, TextInBox>();
			Map<TextInBox, JComponent> nodemapr = new HashMap<TextInBox, JComponent>();

			for (JComponent c : resolutionNodes.get(i)) {
				String title = ((TitledElement) c).getTitle();
				// System.out.println(title);
				TextInBox t = new TextInBox(title, c.getWidth(), c.getHeight());
				nodemap.put(c, t);
				nodemapr.put(t, c);
			}

			TextInBox root = nodemap.get(resolutionNodes.get(i).get(0));

			DefaultTreeForTreeLayout<TextInBox> tree = new DefaultTreeForTreeLayout<TextInBox>(root);

			for (Pair<JComponent, JComponent> p : resolutionBindings.get(i)) {
				TextInBox a = nodemap.get(p.a);
				TextInBox b = nodemap.get(p.b);
				tree.addChild(a, b);
			}

			// setup the tree layout configuration
			double gapBetweenLevels = 30;
			double gapBetweenNodes = 10;
			DefaultConfiguration<TextInBox> configuration = new DefaultConfiguration<TextInBox>(gapBetweenLevels, gapBetweenNodes);

			// create the NodeExtentProvider for TextInBox nodes
			TextInBoxNodeExtentProvider nodeExtentProvider = new TextInBoxNodeExtentProvider();
			TreeLayout<TextInBox> treeLayout = new TreeLayout<TextInBox>(tree, nodeExtentProvider, configuration);

			// Set positions
			for (JComponent c : resolutionNodes.get(i)) {
				if (!((c instanceof GroupPanel) || (c instanceof GroupPanelWithError))) {
					TextInBox t = nodemap.get(c);
					Map<TextInBox, Double> x = treeLayout.getNodeBounds();
					Double z = x.get(t);
					c.setBounds((int) z.getX(), (int) z.getY(), (int) z.getWidth(), (int) z.getHeight());
				} else {
					// Find parent
					JComponent p = null;
					for (Pair<JComponent, JComponent> x : resolutionBindings.get(i)) {
						if (x.b == c) {
							p = x.a;
						}
					}

					// Set pos
					c.setBounds(p.getX() - 15 + (p.getWidth() - 20) / 2, p.getY() + p.getHeight() - 10, c.getWidth(), c.getHeight());
				}
			}
		}
	}

	/*
	 * save Selected index and current position, clean view, load resolutionview and call autoLayout. restore current position.
	 */
	public void notifyResolutionViewUpdate() {/*
		// Save
		boolean isEmpty = resPane.getTabCount() == 0;
		int resmodels = getCU().getOwnedVSpecResolution().size();
		boolean modelIsEmpty = getCU().getOwnedVSpecResolution().size() == 0;

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

		loadBVRResolutionView(m.getBVRM().getCU(), resolutionkernels, resPane);

		autoLayoutResolutions();

		// Restore positions
		if (!isEmpty && !modelIsEmpty && selected < resmodels) {
			resPane.setSelectedIndex(selected);
			resolutionPanes.get(selected).getViewport().setViewPosition(pos);
		}*/
	}

	/*
 * 
 */

	protected void loadBVRResolutionView(/*ConfigurableUnit cu,*/ List<BVRUIKernel> resolutionkernels, JTabbedPane resPane) throws BVRModelException {
		resPane.addMouseListener(new ResV2DropdownListener((BVRResolutionToolView) this, /*cu,*/ m, resPane, vspecvmMap));

/*		if (cu.getOwnedVSpecResolution().size() == 0)
			return;

		for (VSpecResolution v : cu.getOwnedVSpecResolution()) {
			BVRUIKernel resKernel = new BVRUIKernel(vspecvmMap, this, resolutionvmMaps);
			resolutionkernels.add(resKernel);
			JScrollPane scrollPane = new JScrollPane(resKernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.addMouseListener(new ResV2DropdownListener(this, cu, m, resPane, vspecvmMap));
			EditableModelPanel epanel = new EditableModelPanel(scrollPane);

			resolutionPanes.add(scrollPane);
			resolutionEpanels.add(epanel);
			Map<JComponent, NamedElement> vmMap = new HashMap<JComponent, NamedElement>();
			resolutionvmMaps.add(vmMap);
			List<JComponent> nodes = new ArrayList<JComponent>();
			resolutionNodes.add(nodes);
			List<Pair<JComponent, JComponent>> bindings = new ArrayList<Pair<JComponent, JComponent>>();
			resolutionBindings.add(bindings);

			loadBVRResolutionView(v, resKernel, null, cu, vmMap, nodes, bindings, false, false);

			String tabtitle = "";
			if (v instanceof ChoiceResolutuion) {
				ChoiceResolutuion cr = (ChoiceResolutuion) v;
				String choicename = "null";
				if (cr.getResolvedVSpec() != null) {
					choicename = cr.getResolvedVSpec().getName();
				}
				tabtitle = choicename + choiceCount;
				choiceCount++;
			} else if (v instanceof VInstance) {
				VInstance vi = (VInstance) v;
				tabtitle = vi.getName() + ":" + vi.getResolvedVSpec().getName();
			}

			resPane.addTab(tabtitle, null, epanel, "");
		}
	*/}

	// printAnyway and secondPrint added for single layer stripped functionality
	// stripped nodes are not drawn. 
	protected void loadBVRResolutionView(VSpecResolution v, BVRUIKernel bvruikernel, JComponent parent,/* ConfigurableUnit cu,*/
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, boolean printAnyway_,
			boolean secondPrint_) throws BVRModelException {
		/*
		JComponent nextParent = null;
		boolean printAnyway = printAnyway_;
		boolean secondPrint = secondPrint_;

		if (!stripped(v, printAnyway, secondPrint)) {
			if (printAnyway) {
				secondPrint = true;
			}
			printAnyway = false;
			if (v.getResolvedVSpec() == null)
				return;
			// Add view
			// System.out.println(v.getClass().getSimpleName());
			if (v instanceof VInstance) {
				// System.out.println(v + ", " + bvruikernel);

				nextParent = new AddVInstanceV2(minimized.contains(v), childrenStripped(v, printAnyway, secondPrint)).init(bvruikernel, v, parent,
						vmMap, nodes, bindings, this).execute();

				vmMap.put(nextParent, v);

			} else if (v instanceof ChoiceResolutuion) {
				// System.out.println(v);
				nextParent = new AddChoiceResolutuionV2(minimized.contains(v), childrenStripped(v, printAnyway, secondPrint)).init(bvruikernel, v,
						parent, vmMap, nodes, bindings, this).execute();

				vmMap.put(nextParent, v);

			} else if (v instanceof VariableValueAssignment) {
				// System.out.println(v);

				nextParent = new AddVariableValueAssignmentV2(minimized.contains(v), false)
						.init(bvruikernel, v, parent, vmMap, nodes, bindings, this).execute();

				vmMap.put(nextParent, v);

			} else {
				throw new BVRModelException("Unknown element: " + v.getClass());
			}
			if (!minimized.contains(v)) {// TODO add show/hide visuals
				if (showConstraints) {
					for (Constraint c : cu.getOwnedConstraint()) {
						if (c instanceof OpaqueConstraint) {
							if (((OpaqueConstraint) c).getContext() == v.getResolvedVSpec()) {
								if (invalidConstraints.contains(c)) {
									JComponent con = new AddViolatedOpaqueConstraint().init(bvruikernel, c, nextParent, vmMap, nodes, bindings, this)
											.execute();
									vmMap.put(con, v);
								} else {
									JComponent con = new AddOpaqueConstraint().init(bvruikernel, c, nextParent, vmMap, nodes, bindings, this)
											.execute();
									vmMap.put(con, v);
								}
							}

						}
						if (c instanceof BCLConstraint) {
							if (((BCLConstraint) c).getContext() == v.getResolvedVSpec()) {
								if (invalidConstraints.contains(c)) {
									JComponent con = new AddViolatedBCLConstraint().init(bvruikernel, c, nextParent, vmMap, nodes, bindings, this)
											.execute();
									vmMap.put(con, v);
								} else {
									JComponent con = new AddBCLConstraint().init(bvruikernel, c, nextParent, vmMap, nodes, bindings, this).execute();
									vmMap.put(con, v);
								}
							}
						}
					}
				}
				// for debug
				// if(v.getResolvedVSpec()==null)System.err.println(v + "does not contain resolved VSpec");
				// else{
				// System.out.println(v.getResolvedVSpec().getName() +" is beeng drawn");
				// }
				if (showGroups) {
					if ((v.getResolvedVSpec().getGroupMultiplicity() != null)) {
						boolean error = findGroupError(v);

						if (error) {
							nextParent = new AddErrorGroup().init(bvruikernel, v.getResolvedVSpec(), nextParent, vmMap, nodes, bindings, this)
									.execute();
							if (!secondPrint)
								printAnyway = true;
						} else {
							nextParent = new AddGroupMultiplicity().init(bvruikernel, v.getResolvedVSpec(), nextParent, vmMap, nodes, bindings, this)
									.execute();

						}
					}
				}
			}

			// Recursive step
			// System.out.println();

			for (VSpecResolution vs : v.getChild()) {
				if (!minimized.contains(v)) {
					loadBVRResolutionView(vs, bvruikernel, nextParent, cu, vmMap, nodes, bindings, printAnyway, secondPrint);

				}
			}

		}
		*/
	}



	public boolean isShowConstraints() {
		return showConstraints;
	}

	public void setShowConstraints(boolean showConstraints) {
		this.showConstraints = showConstraints;
	}

	
	public void setMaximized(Object v) {
		minimized.remove(v);
		refresh();
	}

	
	public void setMinimized(Object v) {
		minimized.add((VSpecResolution) v);
		refresh();
	}

	public void setStripped(Object v) {
		stripped.add((VSpecResolution) v);
		// refresh();
	}

	public void setUnstripped(Object v) {
		if(v != null && stripped.contains(v))
		stripped.remove(v);
		// refresh();
	}

	@Override
	public void refresh() {
		// System.out.println("refreshing");
		notifyResolutionViewUpdate();
	}

	// strips if node is stripped choice node, or secondPrint is set
	private boolean stripped(VSpecResolution v, boolean printAnyway, boolean secondPrint) {
		return secondPrint;
	/*	if (v instanceof ChoiceResolutuion && stripped.contains(v) && !printAnyway) {
			if (!getCU().getOwnedVSpecResolution().contains(v))
				return !((ChoiceResolutuion) v).isDecision();
		}
		else if(secondPrint && stripped.contains(v)){
			return true;
		}
		return false;*/
	}

	// returns if children are stripped
	private boolean childrenStripped(VSpecResolution v, boolean printAnyway, boolean secondPrint) {
		return false;
	/*	for (VSpecResolution x : v.getChild()) {
			if (stripped( x,  false,  false))
				if(!findGroupError(x)) //remove to show stripped mark on stripped nodes showing all due to group error
				return true;
			}
		return false;*/
	}
	
	private boolean findGroupError(VSpecResolution v) {
		return false;
/*
		if (v.getResolvedVSpec().getGroupMultiplicity() == null)
			return false;
		int lower = v.getResolvedVSpec().getGroupMultiplicity().getLower();
		int upper = v.getResolvedVSpec().getGroupMultiplicity().getUpper();
		int i = 0;
		for (VSpecResolution x : v.getChild()) {
			if (x instanceof ChoiceResolutuion) {
				if (((ChoiceResolutuion) x).isDecision())
					i++;
				if ((i > upper) && (upper != -1)){
					return true;
				}
			}
		}
		if (i < lower)
			return true;
		return false;
		*/
	}
	@Override
	public boolean showGrouping() {

		return this.showGroups;
	}

	@Override
	public void setGrouping(boolean group) {
		this.showGroups = group;

	}

//	@Override
	public List<Constraint> getInvalidConstraints() {

		return this.invalidConstraints;
	}

//	@Override
	public synchronized int getIncrementedNameCounter() {
		instanceNameCounter++;
		return instanceNameCounter;
	}

//	@Override
	public List<VSpecResolution> getStripped() {
		return this.stripped;
	}


}
