package no.sintef.bvr.tool.exception;

public class MalformedVarModelException extends AbstractError {

	private static final long serialVersionUID = 2249366393531823611L;

	public MalformedVarModelException(String message, Throwable ex) {
		super(message, ex);
	}

	public MalformedVarModelException(String message) {
		super(message);
	}

}
