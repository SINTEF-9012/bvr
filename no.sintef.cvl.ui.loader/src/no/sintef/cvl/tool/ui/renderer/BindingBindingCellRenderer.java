package no.sintef.cvl.tool.ui.renderer;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import no.sintef.cvl.tool.primitive.DataItem;

public class BindingBindingCellRenderer extends DefaultTableCellRenderer implements
		TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5699053973848281547L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		setText(((DataItem) value).getLabel().getText());
		return renderer;
	}
}
