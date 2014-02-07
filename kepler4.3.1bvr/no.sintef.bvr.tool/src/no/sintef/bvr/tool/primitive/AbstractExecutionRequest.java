package no.sintef.bvr.tool.primitive;

import java.util.HashMap;

import javax.swing.JComponent;

import bvr.ConfigurableUnit;
import bvr.VSpecResolution;

public abstract class AbstractExecutionRequest implements ExecutionRequest {

	protected VSpecResolution vSpecResolution;
	protected SymbolTable table;
	protected ConfigurableUnit cu;
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
