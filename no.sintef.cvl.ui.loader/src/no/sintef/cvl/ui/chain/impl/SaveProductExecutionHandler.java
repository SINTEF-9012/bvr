package no.sintef.cvl.ui.chain.impl;

import java.util.HashMap;

import javax.swing.JComponent;

import cvl.ConfigurableUnit;

import no.sintef.cvl.ui.chain.ExecutionHandler;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.UnexpectedException;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.primitive.ExecutionRequest;
import no.sintef.cvl.ui.strategy.SaveProductStrategy;
import no.sintef.cvl.ui.strategy.impl.SimpleSaveProductStrategy;

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
