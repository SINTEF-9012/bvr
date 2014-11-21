package no.sintef.bvr.tool.ui.strategy;

import java.awt.geom.Rectangle2D.Double;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.demo.TextInBox;
import org.abego.treelayout.demo.TextInBoxNodeExtentProvider;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;

import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.ui.framework.TitledElement;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import no.sintef.bvr.ui.framework.strategy.LayoutStrategy;

public class VSpecLayoutStrategy implements LayoutStrategy {

	private List<JComponent> vspecNodes;
	private List<Pair<JComponent, JComponent>> vspecBindings;

	public VSpecLayoutStrategy(List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings){
		vspecNodes = nodes;
		vspecBindings = bindings;
	}
	
	@Override
	public void layout() {
		Map<JComponent, TextInBox> nodemap = new HashMap<JComponent, TextInBox>();
		Map<TextInBox, JComponent> nodemapr = new HashMap<TextInBox, JComponent>();
		
		// Add VSpecs
		for(JComponent c : vspecNodes){
			String title = ((TitledElement)c).getTitle();
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
