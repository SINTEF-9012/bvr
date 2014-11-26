package no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction;

import java.util.List;

public interface ISashFormContainer {

	public List<IFolder> getFolderList();
	
	public void addFolder(IFolder iFolder);
	
	public void removeFolder(IFolder iFolder);
	
}
