package no.sintef.bvr.dvl.execution.interfaces.errors;

public class PlannerError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5226661272335249410L;
	
	public PlannerError(String message, Throwable original) {
		super(message, original);
	}

}
