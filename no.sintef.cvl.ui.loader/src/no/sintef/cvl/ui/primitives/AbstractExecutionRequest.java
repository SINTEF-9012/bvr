package no.sintef.cvl.ui.primitives;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public abstract class AbstractExecutionRequest implements ExecutionRequest {

	protected VSpecResolution vSpecResolution;
	protected SymbolTable table;
	protected ConfigurableUnit cu;

	@Override
	public VSpecResolution getProductRoot() {
		return this.vSpecResolution;
	}

	@Override
	public void setProductRoot(VSpecResolution vSpec) {
		this.vSpecResolution = vSpec;
	}

	@Override
	public SymbolTable getProductTable() {
		return this.table;
	}

	@Override
	public void setProductTable(SymbolTable table) {
		this.table = table;
	}
	
	@Override
	public ConfigurableUnit getConfigurableUnit() {
		return this.cu;
	}
	
	@Override
	public void setConfigurableUnit(ConfigurableUnit cu) {
		this.cu = cu;
	}

}
