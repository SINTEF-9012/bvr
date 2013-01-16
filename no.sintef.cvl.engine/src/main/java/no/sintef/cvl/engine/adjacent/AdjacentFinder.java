package no.sintef.cvl.engine.adjacent;

import java.util.HashMap;

import no.sintef.cvl.engine.fragment.FragSubHolder;

public interface AdjacentFinder {

	public HashMap<FragSubHolder, AdjacentFragment> getAdjacentMap(); 
}
