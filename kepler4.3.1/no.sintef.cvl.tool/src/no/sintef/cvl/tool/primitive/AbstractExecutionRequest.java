package no.sintef.cvl.tool.primitive;

import java.util.HashMap;

import javax.swing.JComponent;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

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
