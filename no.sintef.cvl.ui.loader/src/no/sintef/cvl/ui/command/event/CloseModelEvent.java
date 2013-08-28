package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.context.StaticUICommands;
import no.sintef.cvl.ui.loader.CVLModel;

public class CloseModelEvent implements ActionListener {

	private JTabbedPane filePane;

	public CloseModelEvent(JTabbedPane filePane){
		this.filePane = filePane;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selected = filePane.getSelectedIndex();
		CVLModel model = Context.eINSTANCE.getCvlModels().get(selected);

		try{
			int result = JOptionPane.showConfirmDialog(filePane, "Save changes?", "alert", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION){
				File file = StaticUICommands.saveModelToFile(filePane, model, true);
				if(file == null){
					result = JOptionPane.showConfirmDialog(filePane, "Are you sure you want to close this model? Unsaved changes will be lost!", "alert", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.NO_OPTION)
						return;
				}
			}
			filePane.removeTabAt(selected);
			Context.eINSTANCE.getCvlViews().remove(selected);
			Context.eINSTANCE.getCvlModels().remove(selected);
		}catch(Exception e){
			Context.eINSTANCE.logger.error("can not close the model", e);
			JOptionPane.showMessageDialog(filePane, "Error (can not close the model): " + e.getMessage());
		}
	}

}
