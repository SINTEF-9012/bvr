package no.sintef.bvr.thirdparty.exception;

import no.sintef.bvr.common.CommonUtility;

public class UnexpectedThirdPartyException extends
		AbstractThirdPartyEditorError {

	private static final long serialVersionUID = 5017329250280437942L;
	
	public UnexpectedThirdPartyException(String msg) {
		super(msg);
	}

	public UnexpectedThirdPartyException(Throwable ex) {
		super(CommonUtility.getStackTraceAsString(ex));
	}

}
