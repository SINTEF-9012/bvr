package no.sintef.bvr.tool.exception;

public abstract class AbstractError extends RuntimeException {

	private static final long serialVersionUID = -3557729112973873095L;

	public AbstractError(String msg){
		super(msg);
	}
}
