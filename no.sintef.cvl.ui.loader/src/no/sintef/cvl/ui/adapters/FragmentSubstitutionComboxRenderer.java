package no.sintef.cvl.ui.adapters;

import java.awt.Component;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import cvl.NamedElement;

public class FragmentSubstitutionComboxRenderer extends BasicComboBoxRenderer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7004215123288387411L;

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
		@SuppressWarnings("unchecked")
		HashMap<JComponent, NamedElement> item = (HashMap<JComponent, NamedElement>) value;
		JLabel label = (JLabel) item.keySet().iterator().next();
		setText(label.getText());
		return this;
	}

}
