package no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction;

import java.util.List;

public interface IFolder {

	public List<IItem> getItems();
	
	public List<IItem> getActiveItems();
	
	public IItem getFocusedItem();
	
	public void addItem(IItem iItem);
	
	public void removeItem(IItem iItem);
	
	public void removeItem(int index);
	
	public void addActiveItem(IItem iItem);
	
	public void removeActiveItem(IItem iItem);
	
	public void removeActiveItem(int index);
	
	public void setFocusedItem();
}
