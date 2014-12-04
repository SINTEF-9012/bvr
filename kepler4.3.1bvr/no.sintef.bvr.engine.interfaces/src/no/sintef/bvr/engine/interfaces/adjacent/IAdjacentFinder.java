package no.sintef.bvr.engine.interfaces.adjacent;

import java.util.HashMap;

import no.sintef.bvr.engine.interfaces.fragment.IFragSubHolder;



public interface IAdjacentFinder {

	public HashMap<IFragSubHolder, IAdjacentFragment> getAdjacentMap();
}
