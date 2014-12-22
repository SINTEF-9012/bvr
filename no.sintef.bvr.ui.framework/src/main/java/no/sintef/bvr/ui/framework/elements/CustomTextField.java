package no.sintef.bvr.ui.framework.elements;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;

public class CustomTextField extends JTextField {
private FocusListener fl;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		setFocus();
	}

	public CustomTextField() {
		super();
		setFocus();
	}

	public CustomTextField(int columns) {
		super(columns);
		setFocus();
	}

	public CustomTextField(String text, int columns) {
		super(text, columns);
		setFocus();
	}

	public CustomTextField(String text) {
		super(text);
		setFocus();
	}

	private void setFocus() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CustomTextField.this.addFocusListener(new FocusListener() {

					public void focusGained(FocusEvent e) {
						CustomTextField.this.selectAll();
					}

					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub

					}
				});
			}
		});
	}
	public FocusListener getFocusListner(){
		return fl;
	}
}
