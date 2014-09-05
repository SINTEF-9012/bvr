package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;


import bvr.ChoiceResolution;
import bvr.VSpecResolution;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.context.StaticUICommands;


public class CalculateCost implements ActionListener {
	private BVRToolModel m;
	private BVRToolView v;

	public CalculateCost(BVRToolModel m, BVRToolView bvrView) {
		this.m = m;
		this.v = bvrView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Job job = new Job("Calculating Costs...") {	
			 @Override
			 protected IStatus run(IProgressMonitor monitor) {
				 try {
					 no.sintef.ict.splcatool.SPLCABVRModel x = m.getBVRM();	
					 String cstr = "";
						
					 int i = 0;
					 for(VSpecResolution z : x.getRootBVRModel().getResolutionModels()){
						 double d;
						 if(z instanceof ChoiceResolution){
							 d = calcCost((ChoiceResolution)z);
						 }else{
							 d = Double.NaN;
						 }
							
						 i++;
						 cstr += i + " : " + d + "\n";
					 }
					 Context.eINSTANCE.logger.info(cstr);
					 StaticUICommands.showMessageInformationDialog(Context.eINSTANCE.getActiveJApplet(), cstr);
				 } catch (Exception e) {
					 Context.eINSTANCE.logger.error("Calculating Costs failed:", e);
					 Status status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Calculating Costs failed (see log for more details): " + e.getMessage(), e);
					 return status;
				 }
				 return Status.OK_STATUS;
			 }
		};
		job.schedule();
	}

	private double calcCost(ChoiceResolution z) {
		//String comment = z.getResolvedVSpec().getComment();
		double d = 111111111;
		/*try{
			if(z.isDecision())
				d += Double.parseDouble(comment);
		}catch(NumberFormatException n){
			d = Double.NaN;
		}
		
		for(VSpecResolution c : z.getChild()){
			if(c instanceof ChoiceResolutuion){
				d += calcCost((ChoiceResolutuion)c);
			}else{
				d = Double.NaN;
			}
		}*/
		
		return d;
	}
}
