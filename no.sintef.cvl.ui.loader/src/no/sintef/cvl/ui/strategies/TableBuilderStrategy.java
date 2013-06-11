package no.sintef.cvl.ui.strategies;

import no.sintef.cvl.ui.primitives.SymbolTable;
import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public interface TableBuilderStrategy {

	public SymbolTable buildSymbolTable(ConfigurableUnit cu, VSpecResolution vSpecResolution);
}
