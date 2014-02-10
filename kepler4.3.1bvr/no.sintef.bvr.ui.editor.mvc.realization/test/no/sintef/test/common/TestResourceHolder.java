package no.sintef.test.common;

import org.eclipse.core.resources.IFile;

public class TestResourceHolder {
	
	private String source;
	private String target;
	private IFile iFile;

	public TestResourceHolder(String src, String trg){
		setSource(src);
		setTarget(trg);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	} 
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public IFile getiFile() {
		return iFile;
	}

	public void setiFile(IFile iFile) {
		this.iFile = iFile;
	}
}
