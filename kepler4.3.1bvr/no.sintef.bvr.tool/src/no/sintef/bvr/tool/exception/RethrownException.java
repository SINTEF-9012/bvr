package no.sintef.bvr.tool.exception;

public class RethrownException extends AbstractError {


	private static final long serialVersionUID = 180309706713428656L;
	
	public RethrownException(String msg) {
		super(msg);
	}
	
	public RethrownException(String message, Throwable ex){
		super(message, ex);
	}
}
