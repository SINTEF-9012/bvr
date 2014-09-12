package no.sintef.bvr.tool.chain.impl;

import bvr.BVRModel;
import bvr.PosResolution;
import bvr.VSpecResolution;
import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.strategy.TableBuilderStrategy;
import no.sintef.bvr.tool.strategy.impl.RRComposerStrategy;

public class ParserExecutionHandler implements ExecutionHandler {

	private ExecutionHandler successor;
	private TableBuilderStrategy defaultTableBuilder;

	public ParserExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		this.defaultTableBuilder = new RRComposerStrategy();
	}
	
	public ParserExecutionHandler(ExecutionHandler successor, TableBuilderStrategy tableBuilder){
		this.successor = successor;
		this.defaultTableBuilder = tableBuilder;
	}
	
	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		
		BVRModel bvrModel = (BVRModel) request.getDataField("model");
		PosResolution posResolution = (PosResolution) request.getDataField("PosResolution");
		
		if(bvrModel == null || posResolution == null){
			throw new UnexpectedException("bvr model or root vspec resolution is not set");
		}
		
		SymbolVSpecResolutionTable table = this.defaultTableBuilder.buildSymbolTable(bvrModel, posResolution);
		request.setDataField("productSymbolTable", table);
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
