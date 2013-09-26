package no.sintef.cvl.tool.ui.renderer;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import no.sintef.cvl.tool.primitive.DataItem;


public class FragSubVSpecComboboxRenderer extends BasicComboBoxRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8204787709091431635L;

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
	
		DataItem item = (DataItem) value;
		JLabel label = (JLabel) item.getLabel();
		setText(label.getText());
		return this;
	}
}
