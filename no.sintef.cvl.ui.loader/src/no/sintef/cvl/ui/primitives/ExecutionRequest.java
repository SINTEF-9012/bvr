package no.sintef.cvl.ui.primitives;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public interface ExecutionRequest extends Request {

	public ConfigurableUnit getConfigurableUnit();
	
	public void setConfigurableUnit(ConfigurableUnit cu);
	
	public VSpecResolution getProductRoot();
	
	public void setProductRoot(VSpecResolution vSpec);
	
	public SymbolTable getProductTable();
	
	public void setProductTable(SymbolTable table);
}
