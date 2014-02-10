package no.sintef.bvr.engine.adjacent;

import java.util.HashMap;

import no.sintef.bvr.engine.fragment.FragSubHolder;

public interface AdjacentFinder {

	public HashMap<FragSubHolder, AdjacentFragment> getAdjacentMap();
}
