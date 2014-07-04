package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.command.AddGroupMultiplicity;
import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.VSpecResolution;
public class AddGroupMulToRes extends AddGroupMultiplicity implements Command {

	private VSpecResolution vsr;
		@Override
		public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRView view) {
			if(p instanceof VSpec){
				this.rootPanel = rootPanel;
				this.vsr = (VSpecResolution) p;
				this.v = vsr.getResolvedVSpec();
				this.parent = parent;
			}
			
			this.nodes = nodes;
			this.bindings = bindings;
			
			return this;
		}
	}
