package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;


import bvr.ChoiceResolutuion;
import bvr.VSpecResolution;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.context.StaticUICommands;


public class CalculateCost implements ActionListener {
	private BVRModel m;
	private BVRView v;

	public CalculateCost(BVRModel m, BVRView bvrView) {
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
					 for(VSpecResolution z : x.getCU().getOwnedVSpecResolution()){
						 double d;
						 if(z instanceof ChoiceResolutuion){
							 d = calcCost((ChoiceResolutuion)z);
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

	private double calcCost(ChoiceResolutuion z) {
		String comment = z.getResolvedVSpec().getComment();
		double d = 0;
		try{
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
		}
		
		return d;
	}
}
