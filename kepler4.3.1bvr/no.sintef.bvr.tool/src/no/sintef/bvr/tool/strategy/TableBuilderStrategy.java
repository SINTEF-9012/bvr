package no.sintef.bvr.tool.strategy;

import no.sintef.bvr.tool.primitive.SymbolTable;
import bvr.BVRModel;
import bvr.PosResolution;

public interface TableBuilderStrategy {

	public SymbolTable buildSymbolTable(BVRModel bvrModel, PosResolution posResolution);
}
