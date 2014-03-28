package no.sintef.bvr.tool.chain.impl;

import java.io.File;
import java.util.HashMap;

import bvr.ConfigurableUnit;
import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.strategy.SaveProductStrategy;
import no.sintef.bvr.tool.strategy.impl.SimpleSaveProductStrategy;
import no.sintef.bvr.tool.ui.loader.BVRModel;

public class SaveProductExecutionHandler implements ExecutionHandler {

	private ExecutionHandler successor;
	private SaveProductStrategy defaultStrategy;

	public SaveProductExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		this.defaultStrategy = new SimpleSaveProductStrategy();
	}
	
	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		ConfigurableUnit cu = (ConfigurableUnit) request.getDataField("cu");
		File destFile = (File) request.getDataField("destFile");
		BVRModel model =  (BVRModel) request.getDataField("bvrModel");
		
		if(cu == null || destFile == null || model == null){
			throw new UnexpectedException("require conifuration unit, destinition file, and bvr model to handle this request");
		}
		
		HashMap<String, Object> keywords = new HashMap<String, Object>();
		keywords.put("cu", cu);
		keywords.put("destFile", destFile);
		keywords.put("bvrModel", model);
		
		defaultStrategy.saveProduct(keywords);
		
		if(successor != null)
			successor.handleRequest(request);
	}
}
