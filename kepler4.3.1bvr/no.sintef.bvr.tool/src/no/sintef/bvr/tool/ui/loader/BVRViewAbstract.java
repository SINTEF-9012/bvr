package no.sintef.bvr.tool.ui.loader;


abstract public class BVRViewAbstract implements BVRView{
	
	public int choiceCount = 1;
	
	public void setMaximized(Object v) {
		throw new UnsupportedOperationException("not supported for this view"); 
	}
	public void setMinimized(Object v) {
		throw new UnsupportedOperationException("not supported for this view");
	};
	
	public void refresh() {
		throw new UnsupportedOperationException("not supported for this view");
	};
}
