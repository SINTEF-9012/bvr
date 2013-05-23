package no.sintef.cvl.ui.editor;

import javax.swing.JTable;

import no.sintef.cvl.ui.loader.CVLView;
import cvl.ConfigurableUnit;

public class BindingJTable extends JTable {

	private CVLView view;
	private ConfigurableUnit cu;

	public BindingJTable(ConfigurableUnit cu, CVLView view){
		this.cu = cu;
		this.view = view;
	}
}
