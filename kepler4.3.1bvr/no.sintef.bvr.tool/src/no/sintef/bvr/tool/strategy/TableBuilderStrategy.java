package no.sintef.bvr.tool.strategy;

import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import bvr.BVRModel;
import bvr.PosResolution;

public interface TableBuilderStrategy {

	public SymbolVSpecResolutionTable buildSymbolTable(BVRModel bvrModel, PosResolution posResolution);
}
