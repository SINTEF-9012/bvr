package no.sintef.bvr.tool.strategy;

import no.sintef.bvr.tool.primitive.SymbolTable;

public interface ScopeResolverStrategy {

	public void resolveScopes(SymbolTable table);
}
