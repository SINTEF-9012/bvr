package no.sintef.bvr.tool.chain.impl;

import java.util.HashMap;

import javax.swing.JComponent;

import bvr.ConfigurableUnit;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.strategy.SaveProductStrategy;
import no.sintef.bvr.tool.strategy.impl.SimpleSaveProductStrategy;
import no.sintef.bvr.tool.ui.loader.CVLModel;

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
		JComponent parentComponent = (JComponent) request.getDataField("parentComponent");
		CVLModel model =  (CVLModel) request.getDataField("bvrModel");
		
		if(cu == null || parentComponent == null || model == null){
			throw new UnexpectedException("require conifuration unit, parent jcomponent, and bvr model to handle this request");
		}
		
		HashMap<String, Object> keywords = new HashMap<String, Object>();
		keywords.put("cu", cu);
		keywords.put("parentComponent", parentComponent);
		keywords.put("bvrModel", model);
		
		defaultStrategy.saveProduct(keywords);
		
		if(successor != null)
			successor.handleRequest(request);
	}
}
