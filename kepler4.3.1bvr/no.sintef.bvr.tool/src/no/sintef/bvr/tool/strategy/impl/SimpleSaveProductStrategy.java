package no.sintef.bvr.tool.strategy.impl;

import java.io.File;
import java.util.HashMap;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.strategy.SaveProductStrategy;

public class SimpleSaveProductStrategy implements SaveProductStrategy {

	@Override
	public void saveProduct(HashMap<String, Object> keywords) {
		File sf = (File) keywords.get("destFile");
		
		if(sf == null) return;
		
		Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), sf);
	}
}
