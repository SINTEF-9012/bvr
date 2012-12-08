package no.sintef.cvl.engine.context.impl;

import java.util.HashMap;
import org.eclipse.emf.common.util.EList;

import cvl.ConfigurableUnitUsage;
import cvl.VSpecResolution;
import no.sintef.cvl.engine.common.VSpecWTreeNode;
import no.sintef.cvl.engine.context.Context;
import no.sintef.cvl.engine.rule.RuleContainer;

public class EngineContext implements Context {

	public ConfigurableUnitUsage cuu;
	public HashMap<VSpecResolution, VSpecWTreeNode> resModels;
	public VSpecWTreeNode currentModel;
	public RuleContainer buildRuleContainer;
	
	public void setBuildRuleContainer(RuleContainer buildRuleContainer){
		this.buildRuleContainer = buildRuleContainer;
	}
	
	@Override
	public void init(ConfigurableUnitUsage confUnitUsage) {
		this.cuu = confUnitUsage;
		this.resModels = new HashMap<VSpecResolution, VSpecWTreeNode>();
		this.initResolutionModels();
	}
	
	private void initResolutionModels(){
		EList<VSpecResolution> vspecreslist = this.cuu.getUsedUnit().getOwnedVSpecResolution();
		for(VSpecResolution vsr : vspecreslist){
			VSpecWTreeNode vswtn = new VSpecWTreeNode(vsr);
			this.resModels.put(vsr, vswtn);
		}
	}
}
