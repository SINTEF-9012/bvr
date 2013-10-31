package org.bangbangbang.cvl.resolution.editors;

import java.util.List;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ResolutionTableLabelProvider implements ITableLabelProvider,
		ITableColorProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {

	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof List<?>) {
			return ((List<String>) element).get(columnIndex);
		}
		return "n/a";
	}

	@Override
	public Color getForeground(Object element, int columnIndex) {
		return null;
	}

	@Override
	public Color getBackground(Object element, int columnIndex) {
		if (getColumnText(element, columnIndex).equals("-")
				|| getColumnText(element, columnIndex).equals("n/a")) {
			return Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
		}
		return null;
	}

}
