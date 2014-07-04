package no.sintef.bvr.ui.editor.mvc.vspec;

import java.awt.Point;
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

import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.command.AddBCLConstraint;
import no.sintef.bvr.tool.ui.command.AddChoice;
import no.sintef.bvr.tool.ui.command.AddConfigurableUnit;
import no.sintef.bvr.tool.ui.command.AddGroupMultiplicity;
import no.sintef.bvr.tool.ui.command.AddOpaqueConstraint;
import no.sintef.bvr.tool.ui.command.AddVClassifier;
import no.sintef.bvr.tool.ui.dropdown.VSpecDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRViewAbstract;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.TitledElement;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import bvr.BCLConstraint;
import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.OpaqueConstraint;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VSpecResolution;

public class VSpecView extends BVRViewAbstract {
	private BVRModel m;
	
	public JTabbedPane modelPane;
	
	// VSpec
	public JScrollPane vspecScrollPane;
	public EditableModelPanel vspecEpanel;
	private Map<JComponent, NamedElement> vspecvmMap;
	private List<JComponent> vspecNodes;
	private List<Pair<JComponent, JComponent>> vspecBindings;
	private BVRUIKernel vSpecbvruikernel;
	
	// Resolutions
	private List<Map<JComponent, NamedElement>> resolutionvmMaps;
	
	// Realization
	private ConfigurableUnitSubject configurableUnitSubject;


	public BVRUIKernel getKernel() {
		return vSpecbvruikernel;
	}
	
	public VSpecView(BVRModel m) {
	
		// Alloc
		vspecvmMap = new HashMap<JComponent, NamedElement>();
		vspecNodes = new ArrayList<JComponent>();
		vspecBindings = new ArrayList<Pair<JComponent,JComponent>>();
    	
    	//bvrViewSubject = new BVRViewSubject(this);
		
		this.m = m;
		
    	configurableUnitSubject = new ConfigurableUnitSubject(this.getCU());
	
		
		// VSpec pane
		vSpecbvruikernel = new BVRUIKernel(vspecvmMap, this, resolutionvmMaps);
		loadBVRVSpecView(m.getBVRM().getCU(), vSpecbvruikernel);
        
        autoLayoutVSpec();
		
		vspecScrollPane = new JScrollPane(vSpecbvruikernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        vspecEpanel = new EditableModelPanel(vspecScrollPane);
	}
	
	private void loadBVRVSpecView(ConfigurableUnit cu, BVRUIKernel model) throws BVRModelException {
		model.getModelPanel().addMouseListener(new VSpecDropDownListener(m, cu, this));
		
		JComponent c = new AddConfigurableUnit().init(cu, model, vspecvmMap, vspecNodes, vspecBindings, this).execute();
		
		for(VSpec v : cu.getOwnedVSpec()){
			loadBVRVSpecView(v, model, c, cu);
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

	void loadBVRVSpecView(VSpec v, BVRUIKernel model, JComponent parent, ConfigurableUnit cu) throws BVRModelException {
		JComponent nextParent = null;
		
		if(v instanceof VClassifier){
			JComponent c = new AddVClassifier(minimized.contains(v)).init(model, v, parent, vspecvmMap, vspecNodes, vspecBindings, this).execute();
			vspecvmMap.put(c, v);
			nextParent = c;
		}else if(v instanceof Choice){
			JComponent c = new AddChoice(minimized.contains(v)).init(model, v, parent, vspecvmMap, vspecNodes, vspecBindings, this).execute();
			vspecvmMap.put(c, v);
			nextParent = c;
		}
		
		if(!minimized.contains(v)){
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
					loadBVRVSpecView(vs, model, nextParent, cu);
			}
		}
	}

	public ConfigurableUnitSubject getConfigurableUnitSubject(){
		return configurableUnitSubject;
	}

	public void notifyVspecViewUpdate() {
		// Save scroll coordinates
		Point vpos = vspecScrollPane.getViewport().getViewPosition();
				
		// Clear everything
		ConfigurableUnitPanel cup = vSpecbvruikernel.getModelPanel();
		cup.clear();

		vspecNodes.clear();
		vspecBindings.clear();
		vspecvmMap.clear();
		
	    // Add stuff

		loadBVRVSpecView(m.getBVRM().getCU(), vSpecbvruikernel);

	    
	    // Automatically Layout Diagram
	    autoLayoutVSpec();
	    
	    // Restore scroll coordinates
	    vspecScrollPane.getViewport().setViewPosition(vpos);
	    
	    // Mark dirty
	    //m.markNotSaved();
	    //ep.notifyProbeDirty();
	}

	@Override
	public ConfigurableUnit getCU() {
		return m.getCU();
	}

	@Override
	public BVRModel getModel() {
		return m;
	}
	
	int choiceCount = 1;

	public void notifyAllViews(){
		throw new UnsupportedOperationException();
	}

	void autoLayoutVSpec() {
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
	
	List<VSpec> minimized = new ArrayList<VSpec>();

	public void setMinimized(Object v) {
		minimized.add((VSpec)v);
		refresh();
	}
	
	public void setMaximized(Object v) {
		minimized.remove(v);
		refresh();
	}

	@Override
	public void refresh() {
		notifyVspecViewUpdate();
	}

	//implement to use striped functionality, else ignore
	@Override
	public void setUnstripped(VSpecResolution vsr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStripped(VSpecResolution vsr) {
		// TODO Auto-generated method stub
		
	}
}
