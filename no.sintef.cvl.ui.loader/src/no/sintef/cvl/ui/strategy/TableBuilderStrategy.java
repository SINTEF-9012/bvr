package no.sintef.cvl.ui.strategy;

import no.sintef.cvl.ui.primitive.SymbolTable;
import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public interface TableBuilderStrategy {

	public SymbolTable buildSymbolTable(ConfigurableUnit cu, VSpecResolution vSpecResolution);
}
