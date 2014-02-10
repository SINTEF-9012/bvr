package no.sintef.bvr.tool.primitive.impl;

import java.util.HashMap;
import java.util.Map;

import bvr.ConfigurableUnit;
import bvr.VSpecResolution;
import no.sintef.bvr.tool.primitive.AbstractExecutionRequest;

public class SingleExecutionRequest extends AbstractExecutionRequest {
		
	public SingleExecutionRequest(HashMap<String, Object> keywords){
		data = new HashMap<String, Object>();
		for(Map.Entry<String, Object> item : keywords.entrySet()){
			data.put(item.getKey(), item.getValue());
		}
	}
}
