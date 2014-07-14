package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddMultipleInstanceTreesEvent implements ActionListener {
	int currentInstances;
	int instancesRequested;
	VSpecResolution parent;
	VSpec target;
	BVRView view;
	
	//parent er choice o.l. over 
	public AddMultipleInstanceTreesEvent(int instancesRequested, VSpecResolution parent, VSpec target, BVRView view) {
		super();
		this.instancesRequested = instancesRequested;
		this.currentInstances = 0;
		this.parent = parent;
		this.target = target;
		this.view = view;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("running addmultipleinstancetreesevent");
		if(currentInstances <0){
			return;
		}
		for (VSpecResolution x : parent.getChild()){
			if (x instanceof VInstance){
				if (x.getResolvedVSpec() == target){
					currentInstances++;
				}
			}
		}
		while(currentInstances < instancesRequested){
			new AddVInstanceTreeEvent( parent,  target, view).actionPerformed(e);
			 currentInstances++;
		}
	}

}
