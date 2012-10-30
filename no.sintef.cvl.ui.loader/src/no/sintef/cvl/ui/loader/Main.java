package no.sintef.cvl.ui.loader;

import java.awt.BorderLayout;
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
	public static List<Pair<JComponent, JComponent>> bindings = new ArrayList<Pair<JComponent,JComponent>>();
	
    public static void main(String[] args) throws CVLModelException {
    	// 
    	File f = new File(args[0]);
    	System.out.println(f + ", and f exists? " + f.exists());
    	CVLModel cvlm = new CVLModel(f);
    	
    	// Create window
        JFrame jframe = new JFrame("CVL UI");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setPreferredSize(new Dimension(800, 600));
        
        // Add stuff
        CVLUIKernel model = new CVLUIKernel();
        loadCVLView(cvlm.cu, model);
        
        // Automatically Layout Diagram
        autoLayout();

        // Done
        JScrollPane scrollPane = new JScrollPane(model.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        IAppWidgetFactory.makeIAppScrollPane(scrollPane);
        EditableModelPanel epanel = new EditableModelPanel(scrollPane);
        jframe.add(epanel, BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
    }
    
	private static void autoLayout() {
		Map<JComponent, TextInBox> nodemap = new HashMap<JComponent, TextInBox>();
		Map<TextInBox, JComponent> nodemapr = new HashMap<TextInBox, JComponent>();
		for(JComponent c : nodes){
			String title = ((TitledElement)c).getTitle();
			//System.out.println(title);
			TextInBox t = new TextInBox(title, c.getWidth(), c.getHeight());
			nodemap.put(c, t);
			nodemapr.put(t, c);
		}
		
		TextInBox root = nodemap.get(nodes.get(0));

		DefaultTreeForTreeLayout<TextInBox> tree = new DefaultTreeForTreeLayout<TextInBox>(root);
		
		for(Pair<JComponent, JComponent> p : bindings){
			TextInBox a = nodemap.get(p.a);
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
			nextParent = new AddVClassifier().init(model, v, parent).execute();
		}else if(v instanceof Choice){
			nextParent = new AddChoice().init(model, v, parent).execute();
		}
		
		if(v.getGroupMultiplicity() != null){
			nextParent = new AddGroupMultiplicity().init(model, v, nextParent).execute();
		}
		
		for(Constraint c : cu.getOwnedConstraint()){
			if(c instanceof OpaqueConstraint){
				OpaqueConstraint oc = (OpaqueConstraint) c;
				if(c.getContext() == v){
					new AddOpaqueConstraint().init(model, oc, nextParent).execute();
				}
			}
		}
		
		for(VSpec vs : v.getChild()){
			loadCVLView(vs, model, nextParent, cu);
		}
	}
}


