package no.sintef.bvr.tool.strategy;

import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;

public interface ScopeResolverStrategy {

	public void resolveScopes(SymbolVSpecResolutionTable table);
}
