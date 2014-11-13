package no.sintef.bvr.tool.ui.strategy;

import java.awt.geom.Rectangle2D.Double;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.TitledElement;
import no.sintef.bvr.ui.framework.elements.GroupPanel;
import no.sintef.bvr.ui.framework.elements.GroupPanelWithError;
import no.sintef.bvr.ui.framework.strategy.LayoutStrategy;

import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.demo.TextInBox;
import org.abego.treelayout.demo.TextInBoxNodeExtentProvider;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;

public class ResolutionLayoutStrategy implements LayoutStrategy {

	private List<JComponent> resolutionNodes;
	private List<Pair<JComponent, JComponent>> resolutionBindings;

	/**
	 * 
	 * @param resolutionNodes
	 * @param bindings
	 * @param resolutionPanes
	 */
	public ResolutionLayoutStrategy(List<JComponent> resolutionNodes,
			List<Pair<JComponent, JComponent>> bindings) {
		this.resolutionNodes = resolutionNodes;
		this.resolutionBindings = bindings;
	}

	public void layout() {// TODO
		Map<JComponent, TextInBox> nodemap = new HashMap<JComponent, TextInBox>();
		Map<TextInBox, JComponent> nodemapr = new HashMap<TextInBox, JComponent>();
		// System.out.println(resolutionNodes);
		for (JComponent c : resolutionNodes) {
			String title = ((TitledElement) c).getTitle();
			// System.out.println(title);
			TextInBox t = new TextInBox(title, c.getWidth(), c.getHeight());
			nodemap.put(c, t);
			nodemapr.put(t, c);
		}

		TextInBox root = nodemap.get(resolutionNodes.get(0));

		DefaultTreeForTreeLayout<TextInBox> tree = new DefaultTreeForTreeLayout<TextInBox>(
				root);

		for (Pair<JComponent, JComponent> p : resolutionBindings) {
			TextInBox a = nodemap.get(p.a);
			TextInBox b = nodemap.get(p.b);
			tree.addChild(a, b);
		}

		// setup the tree layout configuration
		double gapBetweenLevels = 30;
		double gapBetweenNodes = 10;
		DefaultConfiguration<TextInBox> configuration = new DefaultConfiguration<TextInBox>(
				gapBetweenLevels, gapBetweenNodes);

		// create the NodeExtentProvider for TextInBox nodes
		TextInBoxNodeExtentProvider nodeExtentProvider = new TextInBoxNodeExtentProvider();
		TreeLayout<TextInBox> treeLayout = new TreeLayout<TextInBox>(tree,
				nodeExtentProvider, configuration);

		// Set positions
		for (JComponent c : resolutionNodes) {
			if (!((c instanceof GroupPanel) || (c instanceof GroupPanelWithError))) {
				TextInBox t = nodemap.get(c);
				Map<TextInBox, Double> x = treeLayout.getNodeBounds();
				Double z = x.get(t);
				c.setBounds((int) z.getX(), (int) z.getY(), (int) z.getWidth(),
						(int) z.getHeight());
			} else {
				// Find parent
				JComponent p = null;
				for (Pair<JComponent, JComponent> x : resolutionBindings) {
					if (x.b == c) {
						p = x.a;
					}
				}

				// Set pos
				c.setBounds(p.getX() - 15 + (p.getWidth() - 20) / 2, p.getY()
						+ p.getHeight() - 10, c.getWidth(), c.getHeight());
			}
		}
	}
}
