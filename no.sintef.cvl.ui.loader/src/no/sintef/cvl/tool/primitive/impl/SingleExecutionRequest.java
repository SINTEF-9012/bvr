package no.sintef.cvl.tool.primitive.impl;

import java.util.HashMap;
import java.util.Map;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;
import no.sintef.cvl.tool.primitive.AbstractExecutionRequest;

public class SingleExecutionRequest extends AbstractExecutionRequest {
		
	public SingleExecutionRequest(HashMap<String, Object> keywords){
		data = new HashMap<String, Object>();
		for(Map.Entry<String, Object> item : keywords.entrySet()){
			data.put(item.getKey(), item.getValue());
		}
	}
}
