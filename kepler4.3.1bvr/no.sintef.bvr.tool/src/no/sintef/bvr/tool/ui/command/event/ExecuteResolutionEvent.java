package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;





import bvr.VSpecResolution;
import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.DeriveProduct;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.model.BVREmptyModel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.tool.ui.loader.BVRResolutionView;


public class ExecuteResolutionEvent implements ActionListener {

	private BVRNotifiableController view;
	private Logger logger = Context.eINSTANCE.logger;
	private File destFile;

	public ExecuteResolutionEvent(BVRNotifiableController _view) {
		view =_view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		//final BVRToolModel m = view.getBVRToolModel();
		
/*		if(m.getFile() == null){
			JOptionPane.showMessageDialog(((BVRResolutionView) view).getResolutionPane(), Messages.DIALOG_MSG_SAVE_MODEL);
			return;
		}
		
		final JFileChooser fc = StaticUICommands.getFileChooser(null, null);
		
		int status = fc.showSaveDialog(((BVRResolutionView) view).getResolutionPane());
		if(status == JFileChooser.CANCEL_OPTION)
			return;
		
		destFile = fc.getSelectedFile();
		if(destFile == null) {
			JOptionPane.showMessageDialog(((BVRResolutionView) view).getResolutionPane(), Messages.DIALOG_MSG_NO_FILE_SELECTED);
			return;
		}
		
		TransactionalEditingDomain editingDomain = Context.eINSTANCE.getEditorCommands().testTransactionalEditingDomain();   
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				try {
					File newFile = new File(m.getFile().getAbsolutePath() + "_tmp");
					BVREmptyModel tmpModel = new BVREmptyModel(newFile);
					tmpModel.setCU(m.getCU());
					
					Context.eINSTANCE.writeModelToFile(tmpModel, tmpModel.getFile());
					Context.eINSTANCE.reloadModel(tmpModel);
					executeProduct(tmpModel);
				} catch (Exception e) {
					logger.error("can not cretae a tmp model", e);
					new RethrownException("can not cretae a tmp model", e);
				}
			}
		});*/
		
	}
	
	private void executeProduct(final BVRToolModel tmpModel){
		/*Job job = new Job("Producing products"){

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Status status = new Status(Status.OK, Constants.PLUGIN_ID, "OK!");
				int tab = ((BVRResolutionView) view).getResolutionPane().getSelectedIndex();
				
				ConfigurableUnit cu = tmpModel.getCU();
				VSpecResolution vsr = cu.getOwnedVSpecResolution().get(tab);
				
				HashMap<String, Object> keywords = new HashMap<String, Object>();
				keywords.put("cu", cu);
				keywords.put("vSpecResolution", vsr);
				keywords.put("bvrModel", tmpModel);
				keywords.put("destFile", destFile);
				
				try {
					DeriveProduct deriviator = new DeriveProduct(keywords);
					deriviator.run();
				} catch (Exception error) {
					logger.error("Producing products failed", error);
					status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Producing products failed (see log for more details): " + error.getMessage(), error);
				} finally {
					Context.eINSTANCE.nullSetModel(tmpModel);
				}
				return status;
			}
		};
		
		job.schedule();*/
	}
}
