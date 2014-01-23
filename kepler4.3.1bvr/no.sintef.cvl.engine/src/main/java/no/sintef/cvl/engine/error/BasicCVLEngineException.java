package no.sintef.cvl.engine.error;

/**
 * Basic CVL Engine exception
 *
 */
public class BasicCVLEngineException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -527394920492914850L;
	private String message;

	public BasicCVLEngineException(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	
}
