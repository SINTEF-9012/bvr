package no.sintef.bvr.tool.primitive;

import java.util.HashMap;

import javax.swing.JComponent;

import bvr.BVRModel;
import bvr.VSpecResolution;

public abstract class AbstractExecutionRequest implements ExecutionRequest {

	protected VSpecResolution vSpecResolution;
	protected SymbolVSpecResolutionTable table;
	protected BVRModel model;
	protected JComponent parentComponent;
	protected HashMap<String, Object> data;
	
	@Override
	public Object getDataField(String name){
		return data.get(name);
	}
	
	@Override
	public void setDataField(String string, Object object) {
		data.put(string, object);
	}
}
