package no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractTabFolder implements IFolder {

	protected List<IItem> items = new ArrayList<IItem>();
	
	@Override
	public List<IItem> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IItem> getActiveItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IItem getFocusedItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItem(IItem iItem) {
		items.add(iItem);
	}

	@Override
	public void removeItem(IItem iItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeItem(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addActiveItem(IItem iItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeActiveItem(IItem iItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeActiveItem(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocusedItem() {
		// TODO Auto-generated method stub

	}

}
