package no.sintef.bvr.ui.editor.mvc.multipagetype.editor;


import no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction.AbstractTabFolder;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tracker;
import org.eclipse.ui.internal.dnd.DragUtil;
import org.eclipse.ui.internal.dnd.IDragOverListener;
import org.eclipse.ui.internal.dnd.IDropTarget;


@SuppressWarnings("restriction")
public class DragableCTabFolder extends AbstractTabFolder {

	private CTabFolder folder;
	private Composite container;
	
	public DragableCTabFolder(Composite parent) {
		container = parent;
		container.setLayout(new FillLayout());
		folder = new CTabFolder(container, SWT.BOTTOM | SWT.FLAT | SWT.CLOSE);
		folder.addDragDetectListener(new DragDetectListener() {
			
			@Override
			public void dragDetected(DragDetectEvent e) {
				Tracker tracker = new Tracker(folder, SWT.NONE);
				tracker.setRectangles(new Rectangle [] {
						new Rectangle(e.x, e.y, 100, 100),
				});
				tracker.open();
			}
		});
		
		DropTarget dropTarget = new DropTarget(folder, SWT.NONE);
		dropTarget.addDropListener(new FolderDropListener());
		
		initDrag(folder);
	}
	
	public CTabFolder getCTabFolder() {
		return folder;
	}
	
	public DragableCTabItemFolder creatTabItem(Control container) {
		DragableCTabItemFolder item = new DragableCTabItemFolder(this);
		item.createPartControl(container);
		addItem(item);
		return item;
	}
	
	private void initDrag(Composite container) {
		DragUtil.addDragTarget(container, dragOverListener);
	}
	
	IDragOverListener dragOverListener = new IDragOverListener() {
		
		@Override
		public IDropTarget drag(Control currentControl, Object draggedObject,
				Point position, Rectangle dragRectangle) {
			System.out.println("Control " + currentControl + " Object" + draggedObject + " Point " + position + "Rectangle" + dragRectangle);
			return null;
		}
	};
	
	class FolderDropListener implements DropTargetListener {

		@Override
		public void dragEnter(DropTargetEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dragLeave(DropTargetEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dragOperationChanged(DropTargetEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dragOver(DropTargetEvent event) {
			System.out.println("FolderDropListener dragOver");
			
		}

		@Override
		public void drop(DropTargetEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dropAccept(DropTargetEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
