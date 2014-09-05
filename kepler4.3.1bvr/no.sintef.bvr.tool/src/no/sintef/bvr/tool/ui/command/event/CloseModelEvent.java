package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;

public class CloseModelEvent implements ActionListener {

	private JTabbedPane filePane;

	public CloseModelEvent(JTabbedPane filePane){
		this.filePane = filePane;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selected = filePane.getSelectedIndex();
		BVRToolModel model = Context.eINSTANCE.getBvrModels().get(selected);

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
			Context.eINSTANCE.getBvrViews().remove(selected);
			Context.eINSTANCE.getBvrModels().remove(selected);
		}catch(Exception e){
			Context.eINSTANCE.logger.error("can not close the model", e);
			StaticUICommands.showMessageErrorDialog(filePane, e, "Error (can not close the model):");
		}
	}

}
