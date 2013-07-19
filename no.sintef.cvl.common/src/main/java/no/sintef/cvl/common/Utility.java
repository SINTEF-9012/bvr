package no.sintef.cvl.common;

import com.google.common.base.Throwables;

public final class Utility {
	
	public static String getStackTraceAsString(Throwable throwable){
		return Throwables.getStackTraceAsString(throwable);
	}

}
