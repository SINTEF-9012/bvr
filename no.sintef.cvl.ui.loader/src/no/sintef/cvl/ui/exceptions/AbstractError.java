package no.sintef.cvl.ui.exceptions;

public abstract class AbstractError extends Exception {

	private static final long serialVersionUID = -3557729112973873095L;

	public AbstractError(String msg){
		super(msg);
	}
}
