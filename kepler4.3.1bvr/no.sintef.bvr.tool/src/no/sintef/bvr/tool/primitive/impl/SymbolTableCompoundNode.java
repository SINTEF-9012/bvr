package no.sintef.bvr.tool.primitive.impl;

import java.util.HashMap;
import java.util.HashSet;















import org.eclipse.emf.common.util.EList;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.SymbolNamedElement;
import no.sintef.bvr.tool.primitive.SymbolTableNamedElement;
import bvr.CompoundNode;
import bvr.NamedElement;
import bvr.Target;
import bvr.VSpec;

public class SymbolTableCompoundNode extends HashSet<SymbolNamedElement> implements SymbolTableNamedElement {
	

	private static final long serialVersionUID = -5197571857964725230L;
	private CompoundNode rootNode;
	private HashMap<String, SymbolTarget> targetsMap;

	public SymbolTableCompoundNode(CompoundNode root) {
		rootNode = root;
		targetsMap = new HashMap<String, SymbolTarget>();
		EList<Target> targets = root.getOwnedTargets();
		for(Target target : targets) {
			String name = target.getName();
			if(name == null || name.equals("")){
				Context.eINSTANCE.logger.warn("target has no name, skipping " + target.toString());
				continue;
			}
			if(targetsMap.get(name) != null){
				Context.eINSTANCE.logger.warn("Two targets have the same name '" + name + "', skipping " + target.toString());
				continue;
			}
			targetsMap.put(name, new SymbolTarget(target));
			
		}
	}
	
	@Override
	public SymbolNamedElement lookup(NamedElement element) {
		return null;
	}

	@Override
	public SymbolTableNamedElement lookupTable(NamedElement element) {
		return null;
	}

	@Override
	public void insert(SymbolNamedElement symbolNamed) {
		super.add(symbolNamed);
		VSpec vSpec = (VSpec) symbolNamed.getSymbol();
		Target target = vSpec.getTarget();
		if(target == null){
			Context.eINSTANCE.logger.warn("Target is not set for " + vSpec.toString());
			return;
		}
		SymbolTarget targetSymbol = targetsMap.get(vSpec.getName());
		if(targetSymbol == null){
			Context.eINSTANCE.logger.warn("Can not find target for " + vSpec.toString() + ". The taget is not under the root : " + rootNode.toString() + " (which defines the scope) or there are few targets with the same name: " + target);
			return;
		}
		if(!targetSymbol.getSymbol().equals(target)){
			Context.eINSTANCE.logger.warn("Referenced target and expected target are different: referenced ->" + target + ", expected -> " + targetSymbol.getSymbol());
			return;
		}
		targetSymbol.addReferencedSymbols(symbolNamed);
	}

	@Override
	public void delete(SymbolNamedElement symbolNamed) {
	}
	
	
}
