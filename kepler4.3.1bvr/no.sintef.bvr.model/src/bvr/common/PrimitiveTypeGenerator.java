package bvr.common;


import bvr.BvrFactory;
import bvr.ConfigurableUnit;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitveType;
import bvr.Variabletype;

public class PrimitiveTypeGenerator {
	
	
	
	public PrimitveType make(ConfigurableUnit cu, PrimitiveTypeEnum type){
		PrimitveType vt = null;
	for(Variabletype x : cu.getOwnedVariabletype()){
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
		//Context.eINSTANCE.getEditorCommands().addVariableType(cu, vt);
	}
	return vt;
	}
}
