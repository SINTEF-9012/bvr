package no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction;

public interface IItem {

	public IFolder getFolder();
	
	public IPanel getPage();
	
	public void setFolder(IFolder iFolder);
	
	public void setPage(IPanel iPage);
}
