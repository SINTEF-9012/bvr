package no.sintef.cvl.tool.primitive.impl;

import java.util.HashMap;

import no.sintef.cvl.tool.primitive.Keywords;

public class ObserverDataBulk implements Keywords {

	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	@Override
	public Object getDataField(String name) {
		return data.get(name);
	}

	@Override
	public void setDataField(String name, Object object) {
		data.put(name, object);
	}
	
	public boolean isFieldSet(String name){
		if(data.keySet().contains(name))
			return true;
		return false;
	}

}
