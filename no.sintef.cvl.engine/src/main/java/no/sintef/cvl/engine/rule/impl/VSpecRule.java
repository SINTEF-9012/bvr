package no.sintef.cvl.engine.rule.impl;

import cvl.VSpec;
import cvl.VSpecResolution;
import no.sintef.cvl.engine.common.VSpecWTreeNode;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.BuildTreeException;

public class VSpecRule extends BasicRule {

	protected int weight = 0;
	
	@Override
	public boolean isApplicable(VSpecWTreeNode node) {
		String prop_name = VSpecWTreeNode.getPropertyNameByClass(cvl.VSpec.class.toString());
		if(prop_name != null && node.var_specs.get(prop_name) == null){
			return true;
		}
		return false;
	}

	@Override
	public void execute(VSpecWTreeNode node) throws BasicCVLEngineException {
		String prop_name = VSpecWTreeNode.allowed_props.get(cvl.VSpecResolution.class.toString());
		VSpecResolution vspecResolution = (VSpecResolution) node.var_specs.get(prop_name);
		if(vspecResolution == null){
			throw new BuildTreeException("Can not find VSpec due to VSpecResolution is not found");
		}
		
		VSpec vspec = vspecResolution.getResolvedVSpec();
		node.addVarSpec(vspec);
	}

}
