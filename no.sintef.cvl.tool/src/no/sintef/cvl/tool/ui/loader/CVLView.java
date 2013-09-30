package no.sintef.cvl.tool.ui.loader;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.demo.TextInBox;
import org.abego.treelayout.demo.TextInBoxNodeExtentProvider;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;

import no.sintef.cvl.tool.common.Constants;
import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.context.ViewChanageManager;
import no.sintef.cvl.tool.exception.CVLModelException;
import no.sintef.cvl.tool.subject.ConfigurableUnitSubject;
import no.sintef.cvl.tool.subject.SelectedFragmentSubstitutionSubject;
import no.sintef.cvl.tool.ui.command.AddBCLConstraint;
import no.sintef.cvl.tool.ui.command.AddChoice;
import no.sintef.cvl.tool.ui.command.AddChoiceResolutuion;
import no.sintef.cvl.tool.ui.command.AddConfigurableUnit;
import no.sintef.cvl.tool.ui.command.AddGroupMultiplicity;
import no.sintef.cvl.tool.ui.command.AddOpaqueConstraint;
import no.sintef.cvl.tool.ui.command.AddVClassifier;
import no.sintef.cvl.tool.ui.command.AddVInstance;
import no.sintef.cvl.tool.ui.command.AddVariableValueAssignment;
import no.sintef.cvl.tool.ui.dropdown.VSpecResDropDownListener;
import no.sintef.cvl.tool.ui.editor.BindingJTable;
import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.editor.FragmentSubstitutionJTable;
import no.sintef.cvl.tool.ui.editor.SubstitutionFragmentJTable;
import no.sintef.cvl.ui.framework.TitledElement;
import no.sintef.cvl.ui.framework.elements.EditableModelPanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;

import com.explodingpixels.macwidgets.IAppWidgetFactory;

import cvl.BCLConstraint;
import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.ConfigurableUnit;
import cvl.Constraint;
import cvl.NamedElement;
import cvl.OpaqueConstraint;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;
import cvl.VSpecResolution;
import cvl.VariableValueAssignment;

public class CVLView {
	private CVLModel m;
	
	private JTabbedPane modelPane;
	
	// VSpec
	private JScrollPane vspecScrollPane;
	private EditableModelPanel vspecEpanel;
	private Map<JComponent, NamedElement> vspecvmMap;
	private List<JComponent> vspecNodes;
	private List<Pair<JComponent, JComponent>> vspecBindings;
	private CVLUIKernel vSpeccvluikernel;
	
	// Resolutions
	private JTabbedPane resPane;
	private List<JScrollPane> resolutionPanes;
	private List<EditableModelPanel> resolutionEpanels;
	private List<CVLUIKernel> resolutionkernels;
	private List<Map<JComponent, NamedElement>> resolutionvmMaps;
	private List<List<JComponent>> resolutionNodes;
	private List<List<Pair<JComponent, JComponent>>> resolutionBindings;
	
	// Realization
	private JTabbedPane realizationPanel;
	private FragmentSubstitutionJTable tableFragmSubst;
	private SubstitutionFragmentJTable tableSubstFragm;
	private BindingJTable bindingEditor;
	
	private SelectedFragmentSubstitutionSubject selectedFS;
	private ConfigurableUnitSubject configurableUnitSubject;

	public CVLUIKernel getKernel() {
		return vSpeccvluikernel;
	}
	
	public CVLView(CVLModel m, JTabbedPane tp) {
		// Alloc
		vspecvmMap = new HashMap<JComponent, NamedElement>();
		vspecNodes = new ArrayList<JComponent>();
		vspecBindings = new ArrayList<Pair<JComponent,JComponent>>();
		
        resolutionPanes = new ArrayList<JScrollPane>();
        resolutionEpanels = new ArrayList<EditableModelPanel>();
        resolutionkernels = new ArrayList<CVLUIKernel>();
    	resolutionvmMaps = new ArrayList<Map<JComponent,NamedElement>>();
    	resolutionNodes = new ArrayList<List<JComponent>>();
    	resolutionBindings = new ArrayList<List<Pair<JComponent,JComponent>>>();
    	
    	//cvlViewSubject = new CVLViewSubject(this);
		
		this.m = m;
		
    	configurableUnitSubject = new ConfigurableUnitSubject(this.getCU());
		
		// Make model pane
		modelPane = new JTabbedPane();
		
		// VSpec pane
		vSpeccvluikernel = new CVLUIKernel(vspecvmMap, this, resolutionvmMaps);
        try {
			loadCVLVSpecView(m.getCVLM().getCU(), vSpeccvluikernel);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
        
        autoLayoutVSpec();
		
		vspecScrollPane = new JScrollPane(vSpeccvluikernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		IAppWidgetFactory.makeIAppScrollPane(vspecScrollPane);
        vspecEpanel = new EditableModelPanel(vspecScrollPane);
        
        tp.addTab(m.getShortFileName(), null, modelPane, m.getLongFileName());
        modelPane.addTab("VSpec", null, vspecEpanel, "");
        
        // Resolution panes
        resPane = new JTabbedPane();
        modelPane.addTab("Resolution", null, resPane, "");
        
        try {
			loadCVLResolutionView(m.getCVLM().getCU(), resolutionkernels, resPane);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
        
        autoLayoutResolutions();
        
        
        // Realization panel
        realizationPanel = new JTabbedPane();
        modelPane.addTab(Constants.REALIZATION_TAB_NAME, null, realizationPanel, "");
        
        try{
        	loadCVLRelalizationView(m.getCVLM().getCU());
        } catch (Exception e){
        	e.printStackTrace();
        }
	}
	
	public ConfigurableUnitSubject getConfigurableUnitSubject(){
		return configurableUnitSubject;
	}

	private void loadCVLRelalizationView(ConfigurableUnit cu) throws Exception {
		selectedFS = new SelectedFragmentSubstitutionSubject(null);
		
		tableFragmSubst = new FragmentSubstitutionJTable();
		JScrollPane scrollPanelFragmSubst = new JScrollPane(tableFragmSubst);
		
		tableSubstFragm = new SubstitutionFragmentJTable();
		JScrollPane scrollPanelSubstFragm = new JScrollPane(tableSubstFragm);
		
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.setName(Constants.REALIZATION_VP_SUBTAB_NAME);
		panel.add(scrollPanelFragmSubst);
		panel.add(scrollPanelSubstFragm);
		realizationPanel.add(panel);
		 
		bindingEditor = new BindingJTable();
		JScrollPane scrollPanelBinding = new JScrollPane(bindingEditor);
		scrollPanelBinding.setName(Constants.BINDING_EDITOR_NAME);
		realizationPanel.add(scrollPanelBinding, realizationPanel.getComponentCount());
		
		Context.eINSTANCE.getViewChangeManager().register(configurableUnitSubject, tableFragmSubst);
		Context.eINSTANCE.getViewChangeManager().register(selectedFS, tableFragmSubst);
		Context.eINSTANCE.getViewChangeManager().register(configurableUnitSubject, tableSubstFragm);
		Context.eINSTANCE.getViewChangeManager().register(selectedFS, tableSubstFragm);
		Context.eINSTANCE.getViewChangeManager().register(configurableUnitSubject, bindingEditor);
		Context.eINSTANCE.getViewChangeManager().register(selectedFS, bindingEditor);
		
		configurableUnitSubject.notifyObserver();
		selectedFS.notifyObserver();
	}
	
	public void notifyRelalizationViewReset(){
		selectedFS.resetSelectedFragmentSubstitution();
		selectedFS.notifyObserver();
		configurableUnitSubject.setConfigurableUnit(getCU());
		configurableUnitSubject.notifyObserver();
	}
	
	private void autoLayoutResolutions() {
		for(int i = 0; i < resolutionPanes.size(); i++){
			Map<JComponent, TextInBox> nodemap = new HashMap<JComponent, TextInBox>();
			Map<TextInBox, JComponent> nodemapr = new HashMap<TextInBox, JComponent>();
			
			for(JComponent c : resolutionNodes.get(i)){
				String title = ((TitledElement)c).getTitle();
				//System.out.println(title);
				TextInBox t = new TextInBox(title, c.getWidth(), c.getHeight());
				nodemap.put(c, t);
				nodemapr.put(t, c);
			}
			
			TextInBox root = nodemap.get(resolutionNodes.get(i).get(0));
	
			DefaultTreeForTreeLayout<TextInBox> tree = new DefaultTreeForTreeLayout<TextInBox>(root);
			
			for(Pair<JComponent, JComponent> p : resolutionBindings.get(i)){
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
			for(JComponent c : resolutionNodes.get(i)){
				TextInBox t = nodemap.get(c);
				Map<TextInBox, Double> x = treeLayout.getNodeBounds();
				Double z = x.get(t);
				c.setBounds((int)z.getX(), (int)z.getY(), (int)z.getWidth(), (int)z.getHeight());
			}
		}
	}
	
	int choiceCount = 1;

	private void loadCVLResolutionView(ConfigurableUnit cu, List<CVLUIKernel> resolutionkernels, JTabbedPane resPane) throws CVLModelException{
		if(cu.getOwnedVSpecResolution().size() == 0) return;
		
		for(VSpecResolution v : cu.getOwnedVSpecResolution()){
			CVLUIKernel resKernel = new CVLUIKernel(vspecvmMap, this, resolutionvmMaps);
			resolutionkernels.add(resKernel);
	        JScrollPane scrollPane = new JScrollPane(resKernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        IAppWidgetFactory.makeIAppScrollPane(scrollPane);
	        EditableModelPanel epanel = new EditableModelPanel(scrollPane);
	        
	        resolutionPanes.add(scrollPane);
	        resolutionEpanels.add(epanel);
	        Map<JComponent, NamedElement> vmMap = new HashMap<JComponent, NamedElement>();
	    	resolutionvmMaps.add(vmMap);
	        List<JComponent> nodes = new ArrayList<JComponent>();
	    	resolutionNodes.add(nodes);
	    	List<Pair<JComponent, JComponent>> bindings = new ArrayList<Pair<JComponent,JComponent>>();
	    	resolutionBindings.add(bindings);
			
			loadCVLResolutionView(v, resKernel, null, cu, vmMap, nodes, bindings);
			String tabtitle = "";
			if(v instanceof ChoiceResolutuion){
				ChoiceResolutuion cr = (ChoiceResolutuion) v;
				String choicename = "null";
				if(cr.getResolvedVSpec() != null){
					choicename = cr.getResolvedVSpec().getName();
				}
				tabtitle = choicename + " " + choiceCount;
				choiceCount++;
			}else if(v instanceof VInstance){
				VInstance vi = (VInstance) v;
				tabtitle = vi.getName() + ":" + vi.getResolvedVSpec().getName();
			}
			resPane.addTab(tabtitle, null, epanel, "");
			resPane.addMouseListener(new VSpecResDropDownListener(cu, v, this));
		}
	}

	private void loadCVLResolutionView(VSpecResolution v, CVLUIKernel cvluikernel, JComponent parent, ConfigurableUnit cu, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings) throws CVLModelException {
		JComponent nextParent = null;
		
		// Add view
		//System.out.println(v.getClass().getSimpleName());
		if(v instanceof VInstance){
			//System.out.println(v + ", " + cvluikernel);
			
			nextParent = new AddVInstance().init(cvluikernel, v, parent, vmMap, nodes, bindings, this).execute();
			
			vmMap.put(nextParent, v);
			
		}else if(v instanceof ChoiceResolutuion){
			//System.out.println(v);
			
			nextParent = new AddChoiceResolutuion().init(cvluikernel, v, parent, vmMap, nodes, bindings, this).execute();
			
			vmMap.put(nextParent, v);
			
		}else if(v instanceof VariableValueAssignment){
			//System.out.println(v);
			
			nextParent = new AddVariableValueAssignment().init(cvluikernel, v, parent, vmMap, nodes, bindings, this).execute();
			
			vmMap.put(nextParent, v);
			
		}else{
			throw new CVLModelException("Unknown element: " + v.getClass());
		}
		
		// Recursive step
		//System.out.println();
		for(VSpecResolution vs : v.getChild()){
			//System.out.println("Treating " + vs.getResolvedVSpec().getName());
			loadCVLResolutionView(vs, cvluikernel, nextParent, cu, vmMap, nodes, bindings);
		}
	}

	private void loadCVLVSpecView(ConfigurableUnit cu, CVLUIKernel model) throws CVLModelException {
		JComponent c = new AddConfigurableUnit().init(cu, model, vspecvmMap, vspecNodes, vspecBindings, this).execute();
		
		for(VSpec v : cu.getOwnedVSpec()){
			loadCVLVSpecView(v, model, c, cu);
		}
		
		// Add context-free constraints
		for(Constraint cs : cu.getOwnedConstraint()){
			if(cs instanceof OpaqueConstraint){
				OpaqueConstraint oc = (OpaqueConstraint) cs;
				if(oc.getContext() == null){
					new AddOpaqueConstraint().init(model, oc, c, vspecvmMap, vspecNodes, vspecBindings, this).execute();
				}
			}
			if(cs instanceof BCLConstraint){
				BCLConstraint bcl = (BCLConstraint) cs;
				if(bcl.getContext() == null){
					JComponent comp = new AddBCLConstraint().init(model, bcl, c, vspecvmMap, vspecNodes, vspecBindings, this).execute();
					vspecvmMap.put(comp, bcl);
				}
			}
		}
	}

	private void loadCVLVSpecView(VSpec v, CVLUIKernel model, JComponent parent, ConfigurableUnit cu) throws CVLModelException {
		JComponent nextParent = null;
		
		if(v instanceof VClassifier){
			JComponent c = new AddVClassifier().init(model, v, parent, vspecvmMap, vspecNodes, vspecBindings, this).execute();
			vspecvmMap.put(c, v);
			nextParent = c;
		}else if(v instanceof Choice){
			JComponent c = new AddChoice().init(model, v, parent, vspecvmMap, vspecNodes, vspecBindings, this).execute();
			vspecvmMap.put(c, v);
			nextParent = c;
		}
		
		if(v.getGroupMultiplicity() != null){
			nextParent = new AddGroupMultiplicity().init(model, v, nextParent, vspecvmMap, vspecNodes, vspecBindings, this).execute();
		}
		
		for(Constraint c : cu.getOwnedConstraint()){
			if(c instanceof OpaqueConstraint){
				OpaqueConstraint oc = (OpaqueConstraint) c;
				if(c.getContext() == v){
					JComponent comp = new AddOpaqueConstraint().init(model, oc, nextParent, vspecvmMap, vspecNodes, vspecBindings, this).execute();
					vspecvmMap.put(comp, c);
				}
			}
			if(c instanceof BCLConstraint){
				BCLConstraint bcl = (BCLConstraint) c;
				if(bcl.getContext() == v){
					JComponent comp = new AddBCLConstraint().init(model, bcl, nextParent, vspecvmMap, vspecNodes, vspecBindings, this).execute();
					vspecvmMap.put(comp, c);
				}
			}
		}
		
		for(VSpec vs : v.getChild()){
			loadCVLVSpecView(vs, model, nextParent, cu);
		}
	}
	
	public void notifyVspecViewUpdate() {
		// Save scroll coordinates
		Point vpos = vspecScrollPane.getViewport().getViewPosition();
		
		// Clear everything
		vSpeccvluikernel.getModelPanel().removeAll();
		vspecScrollPane.remove(vSpeccvluikernel.getModelPanel());
		vspecScrollPane.removeAll();
		
		vspecNodes = new ArrayList<JComponent>();
		vspecBindings = new ArrayList<Pair<JComponent,JComponent>>();
		vspecvmMap = new HashMap<JComponent, NamedElement>();
		
        // Add stuff
		vSpeccvluikernel = new CVLUIKernel(vspecvmMap, this, resolutionvmMaps);
        try {
			loadCVLVSpecView(m.getCVLM().getCU(), vSpeccvluikernel);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
        
        // Automatically Layout Diagram
        autoLayoutVSpec();
        
        // Draw
        vspecScrollPane = new JScrollPane(vSpeccvluikernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        IAppWidgetFactory.makeIAppScrollPane(vspecScrollPane);
        vspecEpanel = new EditableModelPanel(vspecScrollPane);
        
        modelPane.setComponentAt(0, vspecEpanel);
		//jframe.repaint();
        
        // Restore scroll coordinates
        vspecScrollPane.getViewport().setViewPosition(vpos);
        
        configurableUnitSubject.notifyObserver();
	}

	public ConfigurableUnit getCU() {
		return m.getCU();
	}

	public void notifyResolutionViewUpdate() {
		// Save
		boolean isEmpty = resPane.getTabCount() == 0;
		int resmodels = getCU().getOwnedVSpecResolution().size();
		boolean modelIsEmpty = getCU().getOwnedVSpecResolution().size() == 0;
		
		int selected = 0;
		Point pos = null;
		if(!isEmpty){
			selected = resPane.getSelectedIndex();
			pos = resolutionPanes.get(selected).getViewport().getViewPosition();
		}
		
		// Clean up
		resPane.removeAll();
	    resolutionPanes = new ArrayList<JScrollPane>();
	    resolutionEpanels = new ArrayList<EditableModelPanel>();
	    resolutionkernels = new ArrayList<CVLUIKernel>();
		resolutionvmMaps = new ArrayList<Map<JComponent,NamedElement>>();
		resolutionNodes = new ArrayList<List<JComponent>>();
		resolutionBindings = new ArrayList<List<Pair<JComponent,JComponent>>>();
		
		choiceCount = 1;
	    
	    try {
			loadCVLResolutionView(m.getCVLM().getCU(), resolutionkernels, resPane);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
	    
	    autoLayoutResolutions();
	    
	    // Restore positions
	    if(!isEmpty && !modelIsEmpty && selected <= resmodels){
		    resPane.setSelectedIndex(selected);
		    resolutionPanes.get(selected).getViewport().setViewPosition(pos);
	    }
	}
	
	public void notifyAllViews(){
		this.notifyVspecViewUpdate();
		this.notifyResolutionViewUpdate();
		this.notifyRelalizationViewReset();
	}

	private void autoLayoutVSpec() {
		Map<JComponent, TextInBox> nodemap = new HashMap<JComponent, TextInBox>();
		Map<TextInBox, JComponent> nodemapr = new HashMap<TextInBox, JComponent>();
		
		// Add VSpecs
		for(JComponent c : vspecNodes){
			String title = ((TitledElement)c).getTitle();
			//System.out.println(title);
			TextInBox t = new TextInBox(title, c.getWidth(), c.getHeight());
			if(c instanceof GroupPanel){
				t = new TextInBox(title, 17, 15);
			}
			nodemap.put(c, t);
			nodemapr.put(t, c);
		}
		
		TextInBox root = nodemap.get(vspecNodes.get(0));
	
		DefaultTreeForTreeLayout<TextInBox> tree = new DefaultTreeForTreeLayout<TextInBox>(root);
		
		for(Pair<JComponent, JComponent> p : vspecBindings){
			TextInBox a = nodemap.get(p.a);
			if(p.a instanceof GroupPanel){
				for(Pair<JComponent, JComponent> pc : vspecBindings){
					if(pc.b == p.a){
						a = nodemap.get(pc.a);
					}
				}
			}
			TextInBox b = nodemap.get(p.b);
			if(!(p.b instanceof GroupPanel))
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
		for(JComponent c : vspecNodes){
			if(!(c instanceof GroupPanel)){
				TextInBox t = nodemap.get(c);
				Map<TextInBox, Double> x = treeLayout.getNodeBounds();
				Double z = x.get(t);
				c.setBounds((int)z.getX(), (int)z.getY(), (int)z.getWidth(), (int)z.getHeight());
			}else{
				// Find parent
				JComponent p = null;
				for(Pair<JComponent, JComponent> x : vspecBindings){
					if(x.b == c){
						p = x.a;
					}
				}
				
				// Set pos
				c.setBounds(p.getX()-15+(p.getWidth()-20)/2, p.getY()+p.getHeight()-10, c.getWidth(), c.getHeight());
			}
		}
		
	}
}