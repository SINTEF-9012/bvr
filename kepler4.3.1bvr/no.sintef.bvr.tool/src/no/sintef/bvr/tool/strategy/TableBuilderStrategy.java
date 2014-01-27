package no.sintef.bvr.tool.strategy;

import no.sintef.bvr.tool.primitive.SymbolTable;
import bvr.ConfigurableUnit;
import bvr.VSpecResolution;

public interface TableBuilderStrategy {

	public SymbolTable buildSymbolTable(ConfigurableUnit cu, VSpecResolution vSpecResolution);
}
