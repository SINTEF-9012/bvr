package no.sintef.bvr.ui.editor.mvc.resolutionV2.tools;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.BvrFactory;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitveType;
import bvr.Variabletype;

public class PrimitiveTypeGenerator {
	
	
	
	public PrimitveType make(BVRView view, PrimitiveTypeEnum type){
		PrimitveType vt = null;
	for(Variabletype x : view.getCU().getOwnedVariabletype()){
		if(x instanceof PrimitveType){
			PrimitveType pt = (PrimitveType)x;
			if(pt.getType() == type)
				vt = pt;
		}else{
			System.out.println("we should throw here exception COMMENTED OUT");
			throw new UnsupportedOperationException();
		}
	}
	
	// Create type
	if(vt == null){
		vt = BvrFactory.eINSTANCE.createPrimitveType();
		vt.setType(type);
		vt.setName("xx");
		//view.getCU().getOwnedVariabletype().add(vt);
		Context.eINSTANCE.getEditorCommands().addVariableType(view.getCU(), vt);
	}
	return vt;
	}
}
