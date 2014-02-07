package no.sintef.bvr.engine.error;

/**
 * Basic BVR Engine exception
 *
 */
public class BasicBVREngineException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -527394920492914850L;
	private String message;

	public BasicBVREngineException(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	
}
