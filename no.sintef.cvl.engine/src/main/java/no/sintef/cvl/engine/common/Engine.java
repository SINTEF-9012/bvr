package no.sintef.cvl.engine.common;

import no.sintef.cvl.engine.stage.Stage;

public class Engine {

	private Stage buildStage;
	private Stage resolveStage;
	private Stage materializationStage;
	
	public void setBuildStage(Stage buildStage){
		this.buildStage = buildStage;
	}
	
	public void setResolveStage(Stage resolveStage){
		this.resolveStage = resolveStage;
	}
	
	public void setMaterializationStage(Stage materializationStage){
		this.materializationStage = materializationStage;
	}
	
	public void run(){
		
	}
}
