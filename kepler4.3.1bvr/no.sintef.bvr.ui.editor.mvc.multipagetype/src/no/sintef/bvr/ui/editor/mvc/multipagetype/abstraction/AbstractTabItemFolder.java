package no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction;

abstract public class AbstractTabItemFolder implements IItem {

	protected IFolder folder;
	
	@Override
	public IFolder getFolder() {
		return folder;
	}

	@Override
	public IPanel getPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFolder(IFolder iFolder) {
		folder = iFolder;
	}

	@Override
	public void setPage(IPanel iPage) {
		// TODO Auto-generated method stub

	}

}
