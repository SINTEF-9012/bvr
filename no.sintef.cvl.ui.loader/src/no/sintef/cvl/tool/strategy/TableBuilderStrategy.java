package no.sintef.cvl.tool.strategy;

import no.sintef.cvl.tool.primitive.SymbolTable;
import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public interface TableBuilderStrategy {

	public SymbolTable buildSymbolTable(ConfigurableUnit cu, VSpecResolution vSpecResolution);
}
