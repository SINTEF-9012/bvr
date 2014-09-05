package no.sintef.bvr.tool.ui.loader;

import bvr.BVRModel;
import no.sintef.bvr.tool.subject.BVRModelSubject;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;


public interface BVRToolView {
	public BVRUIKernel getKernel() ;
	public BVRModelSubject getBVRModelSubject() ;
	public BVRModel getBVRModel();
	public BVRToolModel getBVRToolModel();
	
	public void setMaximized(Object v);
	public void setMinimized(Object v) ;
	
	public void refresh();
}
