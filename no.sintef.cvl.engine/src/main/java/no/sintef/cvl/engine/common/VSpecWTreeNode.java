package no.sintef.cvl.engine.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import no.sintef.cvl.engine.logging.Logger;

import cvl.VPackageable;
import cvl.VSpec;
import cvl.VSpecResolution;

public class VSpecWTreeNode {
	
	public VSpecWTreeNode parent = null;
	public ArrayList<VSpecWTreeNode> children = new ArrayList<VSpecWTreeNode>();
		
	public final static HashMap<String, String> allowed_props = new HashMap<String, String>(){
		private static final long serialVersionUID = 1L;

		{
			put(VSpec.class.toString(), "VSpec");
			put(VSpecResolution.class.toString(), "VSpecResolution");
		}
	};
	
	public HashMap<String, VPackageable> var_specs;
	
	public VSpecWTreeNode(){
	}
	
	public VSpecWTreeNode(VPackageable node){
		this.addVarSpec(node);
	}
	
	public void addVarSpec(VPackageable var_spec){
		if(isAllowed(var_spec)){
			this.var_specs.put(allowed_props.get(var_spec.getClass().getName()), var_spec);
		}
	}
	
	public static boolean isAllowed(VPackageable element){
		return (element != null && allowed_props.get(element.getClass().getName()) != null) ? true : false;
	}
	
	public String toString(){
		return super.toString() + "[" + this.var_specs.toString() + "]";
	}
	
	public static String getPropertyNameByClass(String className){
		String prop_name = allowed_props.get(className);
		return prop_name;
	}
}
