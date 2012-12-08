package no.sintef.cvl.engine.stage.impl;

import no.sintef.cvl.engine.context.Context;
import no.sintef.cvl.engine.stage.Stage;

public abstract class BasicStage implements Stage {

	protected Context context;
	
	public void setContext(Context context){
		this.context = context;
	}

}
