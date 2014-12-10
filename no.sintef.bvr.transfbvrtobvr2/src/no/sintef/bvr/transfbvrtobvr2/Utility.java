package no.sintef.bvr.transfbvrtobvr2;


import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class Utility {

	
	static FileDialog getFileDialog(Shell shell){
		return new FileDialog(shell);
	}
}
