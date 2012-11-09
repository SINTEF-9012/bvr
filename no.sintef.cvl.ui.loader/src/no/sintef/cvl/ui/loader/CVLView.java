package no.sintef.cvl.ui.loader;

import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.demo.TextInBox;
import org.abego.treelayout.demo.TextInBoxNodeExtentProvider;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;

import no.sintef.cvl.ui.commands.AddChoice;
import no.sintef.cvl.ui.commands.AddChoiceResolutuion;
import no.sintef.cvl.ui.commands.AddGroupMultiplicity;
import no.sintef.cvl.ui.commands.AddOpaqueConstraint;
import no.sintef.cvl.ui.commands.AddVClassifier;
import no.sintef.cvl.ui.commands.AddVInstance;
import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.TitledElement;
import no.sintef.cvl.ui.framework.elements.EditableModelPanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;

import com.explodingpixels.macwidgets.IAppWidgetFactory;

import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.ConfigurableUnit;
import cvl.Constraint;
import cvl.OpaqueConstraint;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;
import cvl.VSpecResolution;

public class CVLView {
	private CVLModel m;
	
	private JTabbedPane modelPane;
	
	// VSpec
	private JScrollPane vspecScrollPane;
	private EditableModelPanel vspecEpanel;
	private Map<JComponent, VSpec> vspecvmMap;
	private List<JComponent> vspecNodes;
	private List<Pair<JComponent, JComponent>> vspecBindings;
	private CVLUIKernel vSpeccvluikernel;
	
	// Resolutions
	private List<JScrollPane> resolutionPanes;
	private List<EditableModelPanel> resolutionEpanels;
	private List<CVLUIKernel> resolutionkernels;
	private List<Map<JComponent, VSpec>> resolutionvmMaps;
	private List<List<JComponent>> resolutionNodes;
	private List<List<Pair<JComponent, JComponent>>> resolutionBindings;

	public CVLView(CVLModel m, JTabbedPane tp) {
		vspecvmMap = new HashMap<JComponent, VSpec>();
		vspecNodes = new ArrayList<JComponent>();
		vspecBindings = new ArrayList<Pair<JComponent,JComponent>>();
		
		this.m = m;
		
		// Make model pane
		modelPane = new JTabbedPane();
		
		// VSpec pane
		vSpeccvluikernel = new CVLUIKernel(vspecvmMap, this);
        try {
			loadCVLVSpecView(m.getCVLM().cu, vSpeccvluikernel);
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
        JTabbedPane resPane = new JTabbedPane();
        modelPane.addTab("Resolution", null, resPane, "");
        
        resolutionPanes = new ArrayList<JScrollPane>();
        resolutionEpanels = new ArrayList<EditableModelPanel>();
        resolutionkernels = new ArrayList<CVLUIKernel>();
    	resolutionvmMaps = new ArrayList<Map<JComponent,VSpec>>();
    	resolutionNodes = new ArrayList<List<JComponent>>();
    	resolutionBindings = new ArrayList<List<Pair<JComponent,JComponent>>>();
        
        try {
			loadCVLResolutionView(m.getCVLM().cu, resolutionkernels, resPane);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
        
        autoLayoutResolutions();
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

	private void loadCVLResolutionView(ConfigurableUnit cu, List<CVLUIKernel> resolutionkernels, JTabbedPane resPane) throws CVLModelException{
		if(cu.getOwnedVSpecResolution().size() == 0) return;
		
		for(VSpecResolution v : cu.getOwnedVSpecResolution()){
			CVLUIKernel resKernel = new CVLUIKernel(vspecvmMap, this);
			resolutionkernels.add(resKernel);
	        JScrollPane scrollPane = new JScrollPane(resKernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        IAppWidgetFactory.makeIAppScrollPane(scrollPane);
	        EditableModelPanel epanel = new EditableModelPanel(scrollPane);
	        
	        resolutionPanes.add(scrollPane);
	        resolutionEpanels.add(epanel);
	        Map<JComponent, VSpec> vmMap = new HashMap<JComponent,VSpec>();
	    	resolutionvmMaps.add(vmMap);
	        List<JComponent> nodes = new ArrayList<JComponent>();
	    	resolutionNodes.add(nodes);
	    	List<Pair<JComponent, JComponent>> bindings = new ArrayList<Pair<JComponent,JComponent>>();
	    	resolutionBindings.add(bindings);
			
			loadCVLResolutionView(v, resKernel, null, cu, vmMap, nodes, bindings);
			resPane.addTab(v.getName(), null, epanel, "");
		}
	}

	private void loadCVLResolutionView(VSpecResolution v, CVLUIKernel cvluikernel, JComponent parent, ConfigurableUnit cu, Map<JComponent, VSpec> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings) throws CVLModelException {
		JComponent nextParent = null;
		
		// Add view
		if(v instanceof VInstance){
			System.out.println(v + ", " + cvluikernel);
			
			nextParent = new AddVInstance().init(cvluikernel, v, parent, vmMap, nodes, bindings, this).execute();
			
		}else if(v instanceof ChoiceResolutuion){
			System.out.println(v);
			
			nextParent = new AddChoiceResolutuion().init(cvluikernel, v, parent, vmMap, nodes, bindings, this).execute();
			
		}else{
			throw new CVLModelException("Unknown element: " + v.getClass());
		}
		
		// Recursive step
		for(VSpecResolution vs : v.getChild()){
			loadCVLResolutionView(vs, cvluikernel, nextParent, cu, vmMap, nodes, bindings);
		}
	}

	private void loadCVLVSpecView(ConfigurableUnit cu, CVLUIKernel model) throws CVLModelException {
		for(VSpec v : cu.getOwnedVSpec()){
			loadCVLVSpecView(v, model, null, cu);
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
					new AddOpaqueConstraint().init(model, oc, nextParent, vspecvmMap, vspecNodes, vspecBindings, this).execute();
				}
			}
		}
		
		for(VSpec vs : v.getChild()){
			loadCVLVSpecView(vs, model, nextParent, cu);
		}
	}
	
	private void autoLayoutVSpec() {
		Map<JComponent, TextInBox> nodemap = new HashMap<JComponent, TextInBox>();
		Map<TextInBox, JComponent> nodemapr = new HashMap<TextInBox, JComponent>();
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



	public void notifyVspecViewUpdate() {
		// Clear everything
		vSpeccvluikernel.getModelPanel().removeAll();
		vspecScrollPane.remove(vSpeccvluikernel.getModelPanel());
		vspecScrollPane.removeAll();
		
		vspecNodes = new ArrayList<JComponent>();
		vspecBindings = new ArrayList<Pair<JComponent,JComponent>>();
		vspecvmMap = new HashMap<JComponent, VSpec>();
		
        // Add stuff
		vSpeccvluikernel = new CVLUIKernel(vspecvmMap, this);
        try {
			loadCVLVSpecView(m.getCVLM().cu, vSpeccvluikernel);
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
	}
}
