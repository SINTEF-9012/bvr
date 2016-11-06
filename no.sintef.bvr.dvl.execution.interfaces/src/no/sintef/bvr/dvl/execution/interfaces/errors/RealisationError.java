package no.sintef.bvr.dvl.execution.interfaces.errors;

public class RealisationError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7804809885074565927L;

	public RealisationError(String message, Throwable original) {
		super(message, original);
	}
}
