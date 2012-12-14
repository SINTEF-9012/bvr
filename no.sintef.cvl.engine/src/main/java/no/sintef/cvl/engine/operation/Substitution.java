package no.sintef.cvl.engine.operation;

import no.sintef.cvl.engine.fragment.impl.PlacementElementHolder;
import no.sintef.cvl.engine.fragment.impl.ReplacementElementHolder;

public interface Substitution extends Operation{

	public void substitute(PlacementElementHolder placement, ReplacementElementHolder replacement, boolean replace);
}
