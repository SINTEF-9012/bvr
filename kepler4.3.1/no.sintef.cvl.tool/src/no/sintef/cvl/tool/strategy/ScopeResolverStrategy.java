package no.sintef.cvl.tool.strategy;

import no.sintef.cvl.tool.primitive.SymbolTable;

public interface ScopeResolverStrategy {

	public void resolveScopes(SymbolTable table);
}
