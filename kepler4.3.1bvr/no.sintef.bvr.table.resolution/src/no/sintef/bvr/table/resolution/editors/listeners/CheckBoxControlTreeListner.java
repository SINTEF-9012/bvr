package no.sintef.bvr.table.resolution.editors.listeners;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.VSpec;

/**
 * @author daisuke This listner handle the Check event of checkboxes on the
 *         tree. If check event happen on ChoiceResolution, it change state.
 *         Other case is ignored(set on -> set off ).
 */
public class CheckBoxControlTreeListner implements Listener {
	private final Tree tree;

	public CheckBoxControlTreeListner(Tree tree) {
		this.tree = tree;
	}

	public void handleEvent(Event event) {
		if (event.detail == SWT.CHECK) {

			VSpec resolved = null;
			if (event.item.getData() instanceof ChoiceResolutuion
					&& ((ChoiceResolutuion) event.item.getData())
							.getResolvedChoice() != null) {
				resolved = ((ChoiceResolutuion) event.item.getData())
						.getResolvedChoice();
			} else {
				resolved = ((ChoiceResolutuion) event.item.getData())
						.getResolvedVSpec();
			}
			if (!(event.item.getData() instanceof ChoiceResolutuion)
					|| ((event.item.getData() instanceof ChoiceResolutuion) && ((Choice) resolved)
							.isIsImpliedByParent())) {
				event.detail = SWT.NONE;
				event.type = SWT.None;
				event.doit = false;
				try {
					tree.setRedraw(false);
					TreeItem item = (TreeItem) event.item;
					item.setChecked(!item.getChecked());
				} finally {
					tree.setRedraw(true);
				}
			}
		}
	}
}
