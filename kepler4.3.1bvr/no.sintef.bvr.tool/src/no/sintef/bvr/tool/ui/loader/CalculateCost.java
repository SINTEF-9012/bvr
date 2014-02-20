package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import bvr.ChoiceResolutuion;
import bvr.VSpecResolution;
import splar.core.fm.FeatureModelException;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.ict.splcatool.CALib;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.BVRException;
import no.sintef.ict.splcatool.CoveringArray;

public class CalculateCost implements ActionListener {
	private BVRModel m;
	private BVRView v;

	public CalculateCost(BVRModel m, BVRView bvrView) {
		this.m = m;
		this.v = bvrView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		no.sintef.ict.splcatool.BVRModel x = m.getBVRM();
		
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
		
        JOptionPane.showMessageDialog(null, cstr, "Costs", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(cstr);
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
