package no.sintef.bvr.tool.exception;

public class BatchRethrownException extends RethrownException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1935419948423968521L;
	
	
	public BatchRethrownException(String msg) {
		super(msg);
	}
	
	public BatchRethrownException(Throwable ex) {
		super(ex);
	}
	
	public BatchRethrownException(String msg, Throwable ex) {
		super(msg, ex);
	}

}
