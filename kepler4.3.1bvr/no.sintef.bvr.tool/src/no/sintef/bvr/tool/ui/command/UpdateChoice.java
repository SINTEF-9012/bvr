package no.sintef.bvr.tool.ui.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.Choice;
import bvr.BvrFactory;
import bvr.NamedElement;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitveType;
import bvr.VSpec;
import bvr.Variable;
import bvr.Variabletype;

public class UpdateChoice extends UpdateVSpec {
	
	Map<Variable, String> varNames = new HashMap<Variable, String>();
	Map<Variable, String> varTypes = new HashMap<Variable, String>();

	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, view);
	}

	@Override
	public JComponent execute() {
		super.execute();
		/*for(VSpec c : ((Choice)vc).getChild()){
			if(c instanceof Variable){
				Variable v = (Variable)c;
				
				// Set name
				String newName = varNames.get(v);
				Context.eINSTANCE.getEditorCommands().setName(v, newName);
				
				if(newName.equals("")){
					Context.eINSTANCE.getEditorCommands().removeVSpecVariable((VSpec)vc, v);
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
					PrimitveType vt = BvrFactory.eINSTANCE.createPrimitveType();
					PrimitiveTypeEnum t = null;
			        for(PrimitiveTypeEnum x : PrimitiveTypeEnum.VALUES){
			        	if(x.getName().equals(newType)){
			        		t = x;
			        	}
			        }
					vt.setType(t);
					vt.setName(t.getLiteral());
					Context.eINSTANCE.getEditorCommands().addVariableType(view.getCU(), vt);
					tvt = vt;
				}
				Context.eINSTANCE.getEditorCommands().setTypeForVariable(v, tvt);
			}
		}*/
		return null;
	}

	public void setVar(Variable v, String name, String type) {
		varNames.put(v, name);
		varTypes.put(v, type);
	}
}
