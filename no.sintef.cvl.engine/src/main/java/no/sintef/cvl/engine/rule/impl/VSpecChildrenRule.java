package no.sintef.cvl.engine.rule.impl;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;

import cvl.VSpec;
import cvl.VSpecResolution;
import no.sintef.cvl.engine.common.VSpecWTreeNode;
import no.sintef.cvl.engine.error.BasicCVLEngineException;
import no.sintef.cvl.engine.error.BuildTreeException;

public class VSpecChildrenRule extends BasicRule {

	protected int weight = 10;
	
	@Override
	public boolean isApplicable(VSpecWTreeNode node) {
		String propVspecResol = VSpecWTreeNode.getPropertyNameByClass(cvl.VSpecResolution.class.toString());
		String propNameVspec = VSpecWTreeNode.getPropertyNameByClass(cvl.VSpec.class.toString());
		if(node.children.isEmpty() && propNameVspec != null && propVspecResol != null){
			return true;
		}
		return false;
	}

	@Override
	public void execute(VSpecWTreeNode node) throws BasicCVLEngineException {
		String propVspecResol = VSpecWTreeNode.getPropertyNameByClass(cvl.VSpecResolution.class.toString());
		String propNameVspec = VSpecWTreeNode.getPropertyNameByClass(cvl.VSpec.class.toString());
		VSpec vspec = (VSpec) node.var_specs.get(propNameVspec);
		VSpecResolution vspecReolution = (VSpecResolution) node.var_specs.get(propVspecResol);

		if(vspec == null){
			throw new BuildTreeException("can not find VSpec, VSpecRule has not been run probabbly");
		}
		
		EList<VSpec> childrenVSpec = vspec.getChild();
		EList<VSpecResolution> childrenVSpecResol = (vspecReolution != null) ? vspecReolution.getChild() : null;
		
		if(childrenVSpecResol != null && childrenVSpecResol.size() > childrenVSpec.size() ){
			for(VSpecResolution vspecRes : childrenVSpecResol){
				if(childrenVSpec.indexOf(vspecRes.getResolvedVSpec()) >= 0){
					this.attachToNode(node, vspecRes.getResolvedVSpec(), vspecRes);
				}else{
					throw new BuildTreeException("VSpec of a VSpecResolution is not in the list of vspecReolution from the node");
				}
			}
		}else{
			for(VSpec vSpec : childrenVSpec){
				VSpecResolution vspecRes = this.getVSpecReolutionByVSpec(vSpec, childrenVSpecResol);
				this.attachToNode(node, vSpec, vspecRes);
			}
		}
	}
	
	private void attachToNode(VSpecWTreeNode node, VSpec vspec, VSpecResolution vspecRes){
		VSpecWTreeNode newChild = new VSpecWTreeNode();
		newChild.addVarSpec(vspec);
		newChild.addVarSpec(vspecRes);
		
		newChild.parent = node;
		node.children.add(newChild);
	}
	
	private VSpecResolution getVSpecReolutionByVSpec(VSpec vspec, EList<VSpecResolution> vspecResol){
		for(VSpecResolution vspecR : vspecResol){
			if(vspecR.getResolvedVSpec().equals(vspec)){
				return vspecR;
			}
		}
		return null;
	}
}
