package no.sintef.cvl.tool.ui.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.loader.VSpecView;
import no.sintef.cvl.tool.ui.loader.Pair;

import cvl.Choice;
import cvl.CvlFactory;
import cvl.NamedElement;
import cvl.PrimitiveTypeEnum;
import cvl.PrimitveType;
import cvl.VClassifier;
import cvl.VSpec;
import cvl.Variable;
import cvl.Variabletype;

public class UpdateVClassifier extends UpdateVSpec {
	
	protected int lower;
	protected int upper;
	
	Map<Variable, String> varNames = new HashMap<Variable, String>();
	Map<Variable, String> varTypes = new HashMap<Variable, String>();
		
	public void setLower(int lower) {
		this.lower = lower;
	}
	
	public void setUpper(int upper) {
		this.upper = upper;
	}
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, VSpecView view) {
		return super.init(rootPanel, (VSpec) p, parent, vmMap, nodes, bindings, view);
	}

	public JComponent execute() {
		super.execute();
		((VClassifier) vc).getInstanceMultiplicity().setLower(lower);
		((VClassifier) vc).getInstanceMultiplicity().setUpper(upper);
		for(VSpec c : ((VSpec)vc).getChild()){
			if(c instanceof Variable){
				Variable v = (Variable)c;
				
				// Set name
				String newName = varNames.get(v);
				v.setName(newName);
				
				if(newName.equals("")){
					((VSpec)vc).getChild().remove(v);
					break;
				}
				
				// Set Type
				String newType = varTypes.get(v);
				Variabletype tvt = null;
				for(Variabletype vt : view.getCU().getOwnedVariabletype()){
					if(vt.equals(((PrimitveType)vt).getType().getName()))
						tvt = vt;
				}
				if(tvt == null){
					PrimitveType vt = CvlFactory.eINSTANCE.createPrimitveType();
					PrimitiveTypeEnum t = null;
			        for(PrimitiveTypeEnum x : PrimitiveTypeEnum.VALUES){
			        	if(x.getName().equals(newType)){
			        		t = x;
			        	}
			        }
					vt.setType(t);
					vt.setName("xx");
					view.getCU().getOwnedVariabletype().add(vt);
					tvt = vt;
				}
				v.setType(tvt);
			}
		}
		view.notifyVspecViewUpdate();
		return null;
	}

	public void setVar(Variable v, String name, String type) {
		varNames.put(v, name);
		varTypes.put(v, type);
	}

}
