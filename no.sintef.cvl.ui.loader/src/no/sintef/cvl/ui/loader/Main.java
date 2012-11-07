package no.sintef.cvl.ui.loader;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D.Double;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.demo.TextInBox;
import org.abego.treelayout.demo.TextInBoxNodeExtentProvider;
import org.abego.treelayout.demo.swing.TextInBoxTreePane;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;

import no.sintef.cvl.ui.commands.AddChoice;
import no.sintef.cvl.ui.commands.AddGroupMultiplicity;
import no.sintef.cvl.ui.commands.AddOpaqueConstraint;
import no.sintef.cvl.ui.commands.AddVClassifier;
import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.TitledElement;
import no.sintef.cvl.ui.framework.elements.EditableModelPanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import no.sintef.ict.splcatool.CVLModel;

import com.explodingpixels.macwidgets.IAppWidgetFactory;

import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.Constraint;
import cvl.OpaqueConstraint;
import cvl.VClassifier;
import cvl.VSpec;

public class Main {
	public static List<JComponent> nodes = new ArrayList<JComponent>();
	public static List<Pair<JComponent, JComponent>> bindings;
	public static Map<JComponent, VSpec> vmMap;
	private static JFrame jframe;
	private static CVLModel cvlm;
	private static EditableModelPanel epanel;
	private static JScrollPane scrollPane;
	
	public static List<String> openFiles;
	private static CVLUIKernel model;
	private static JTabbedPane modelPane;
	public static VSpec vSpecCut;

    public static void main(String[] args) throws CVLModelException {
    	// 
    	File f = new File(args[0]);
    	//System.out.println(f + ", and f exists? " + f.exists());
    	cvlm = new CVLModel(f);
    	openFiles = new ArrayList<String>();
    	openFiles.add(args[0]);
    	
    	// Create window
        jframe = new JFrame("CVL UI");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setPreferredSize(new Dimension(1000, 800));
        
		// Clear everything
		nodes = new ArrayList<JComponent>();
		bindings = new ArrayList<Pair<JComponent,JComponent>>();
		vmMap = new HashMap<JComponent, VSpec>();
		
        // Add stuff
        model = new CVLUIKernel();
        try {
			loadCVLView(cvlm.cu, model);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
        
        // Automatically Layout Diagram
        autoLayout();

        // Done
        JTabbedPane filePane = new JTabbedPane();
        modelPane = new JTabbedPane();
        
        scrollPane = new JScrollPane(model.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        IAppWidgetFactory.makeIAppScrollPane(scrollPane);
        epanel = new EditableModelPanel(scrollPane);
        
        filePane.addTab(new File(openFiles.get(0)).getName(), null, modelPane, openFiles.get(0));
        modelPane.addTab("VSpec", null, epanel, "");
        
        JScrollPane scrollPane2 = new JScrollPane(null, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        IAppWidgetFactory.makeIAppScrollPane(scrollPane2);
        EditableModelPanel epanel2 = new EditableModelPanel(scrollPane2);
        modelPane.addTab("Resolution", null, epanel2, "");
        
        jframe.add(filePane, BorderLayout.CENTER);
        jframe.pack();
        jframe.repaint();
        jframe.setVisible(true);
    }
    
	private static void autoLayout() {
		Map<JComponent, TextInBox> nodemap = new HashMap<JComponent, TextInBox>();
		Map<TextInBox, JComponent> nodemapr = new HashMap<TextInBox, JComponent>();
		for(JComponent c : nodes){
			String title = ((TitledElement)c).getTitle();
			//System.out.println(title);
			TextInBox t = new TextInBox(title, c.getWidth(), c.getHeight());
			if(c instanceof GroupPanel){
				t = new TextInBox(title, 17, 15);
			}
			nodemap.put(c, t);
			nodemapr.put(t, c);
		}
		
		TextInBox root = nodemap.get(nodes.get(0));

		DefaultTreeForTreeLayout<TextInBox> tree = new DefaultTreeForTreeLayout<TextInBox>(root);
		
		for(Pair<JComponent, JComponent> p : bindings){
			TextInBox a = nodemap.get(p.a);
			if(p.a instanceof GroupPanel){
				for(Pair<JComponent, JComponent> pc : bindings){
					if(pc.b == p.a){
						a = nodemap.get(pc.a);
					}
				}
			}
			TextInBox b = nodemap.get(p.b);
			tree.addChild(a, b);
		}
		
		// setup the tree layout configuration
		double gapBetweenLevels = 50;
		double gapBetweenNodes = 10;
		DefaultConfiguration<TextInBox> configuration = new DefaultConfiguration<TextInBox>(gapBetweenLevels, gapBetweenNodes);

		// create the NodeExtentProvider for TextInBox nodes
		TextInBoxNodeExtentProvider nodeExtentProvider = new TextInBoxNodeExtentProvider();
		TreeLayout<TextInBox> treeLayout = new TreeLayout<TextInBox>(tree, nodeExtentProvider, configuration);
		
		// Set positions
		for(JComponent c : nodes){
			TextInBox t = nodemap.get(c);
			Map<TextInBox, Double> x = treeLayout.getNodeBounds();
			Double z = x.get(t);
			c.setBounds((int)z.getX(), (int)z.getY(), (int)z.getWidth(), (int)z.getHeight());
		}
		
		for(JComponent c : nodes){
			if(c instanceof GroupPanel){
				// Find parent
				JComponent p = null;
				for(Pair<JComponent, JComponent> x : bindings){
					if(x.b == c){
						p = x.a;
					}
				}
				
				// Set pos
				c.setBounds(p.getX()-15+(p.getWidth()-20)/2, p.getY()+p.getHeight()-10, c.getWidth(), c.getHeight());
			}
		}
		
		// Print
/*		TextInBoxTreePane panel = new TextInBoxTreePane(treeLayout);
		//return panel;
		JDialog dialog = new JDialog();
		Container contentPane = dialog.getContentPane();
		((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder(
				10, 10, 10, 10));
		contentPane.add(panel);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
*/	}

	private static void loadCVLView(ConfigurableUnit cu, CVLUIKernel model) throws CVLModelException {
		for(VSpec v : cu.getOwnedVSpec()){
			loadCVLView(v, model, null, cu);
		}
	}

	private static void loadCVLView(VSpec v, CVLUIKernel model, JComponent parent, ConfigurableUnit cu) throws CVLModelException {
		JComponent nextParent = null;
		
		if(v instanceof VClassifier){
			JComponent c = new AddVClassifier().init(model, v, parent, Main.vmMap).execute();
			vmMap.put(c, v);
			nextParent = c;
		}else if(v instanceof Choice){
			JComponent c = new AddChoice().init(model, v, parent, Main.vmMap).execute();
			vmMap.put(c, v);
			nextParent = c;
		}
		
		if(v.getGroupMultiplicity() != null){
			nextParent = new AddGroupMultiplicity().init(model, v, nextParent, Main.vmMap).execute();
		}
		
		for(Constraint c : cu.getOwnedConstraint()){
			if(c instanceof OpaqueConstraint){
				OpaqueConstraint oc = (OpaqueConstraint) c;
				if(c.getContext() == v){
					new AddOpaqueConstraint().init(model, oc, nextParent, Main.vmMap).execute();
				}
			}
		}
		
		for(VSpec vs : v.getChild()){
			loadCVLView(vs, model, nextParent, cu);
		}
	}

	public static void notifyViewUpdate() {
		// Clear everything
/*		model.getModelPanel().removeAll();
		scrollPane.remove(model.getModelPanel());
		scrollPane.removeAll();
*/		
		nodes = new ArrayList<JComponent>();
		bindings = new ArrayList<Pair<JComponent,JComponent>>();
		vmMap = new HashMap<JComponent, VSpec>();
		
        // Add stuff
		model = new CVLUIKernel();
        try {
			loadCVLView(cvlm.cu, model);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
        
        // Automatically Layout Diagram
        autoLayout();
        
        // Draw
        scrollPane = new JScrollPane(model.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        IAppWidgetFactory.makeIAppScrollPane(scrollPane);
        epanel = new EditableModelPanel(scrollPane);
        
        modelPane.setComponentAt(0, epanel);
		//jframe.repaint();
	}
}


