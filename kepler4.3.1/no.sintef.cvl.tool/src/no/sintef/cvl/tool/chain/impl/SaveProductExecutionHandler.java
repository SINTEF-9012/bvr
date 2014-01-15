package no.sintef.cvl.tool.chain.impl;

import java.util.HashMap;

import javax.swing.JComponent;

import cvl.ConfigurableUnit;

import no.sintef.cvl.tool.chain.ExecutionHandler;
import no.sintef.cvl.tool.exception.AbstractError;
import no.sintef.cvl.tool.exception.UnexpectedException;
import no.sintef.cvl.tool.primitive.ExecutionRequest;
import no.sintef.cvl.tool.strategy.SaveProductStrategy;
import no.sintef.cvl.tool.strategy.impl.SimpleSaveProductStrategy;
import no.sintef.cvl.tool.ui.loader.CVLModel;

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
		CVLModel model =  (CVLModel) request.getDataField("cvlModel");
		
		if(cu == null || parentComponent == null || model == null){
			throw new UnexpectedException("require conifuration unit, parent jcomponent, and cvl model to handle this request");
		}
		
		HashMap<String, Object> keywords = new HashMap<String, Object>();
		keywords.put("cu", cu);
		keywords.put("parentComponent", parentComponent);
		keywords.put("cvlModel", model);
		
		defaultStrategy.saveProduct(keywords);
		
		if(successor != null)
			successor.handleRequest(request);
	}
}
