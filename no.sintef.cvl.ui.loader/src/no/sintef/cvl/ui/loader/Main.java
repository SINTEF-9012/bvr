package no.sintef.cvl.ui.loader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.explodingpixels.macwidgets.IAppWidgetFactory;

import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.Constraint;
import cvl.MultiplicityInterval;
import cvl.OpaqueConstraint;
import cvl.VClassifier;
import cvl.VSpec;

import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.ParallelogramTitledPanel;
import no.sintef.cvl.ui.framework.elements.Binding;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.cvl.ui.framework.elements.ConstraintPanel;
import no.sintef.cvl.ui.framework.elements.EditableModelPanel;
import no.sintef.cvl.ui.framework.elements.FragmentPanel;
import no.sintef.cvl.ui.framework.elements.FragmentPanel.PortType;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import no.sintef.cvl.ui.framework.elements.VClassifierPanel;
import no.sintef.ict.splcatool.CVLModel;

public class Main {

    /**
     * @param args the command line arguments
     * @throws CVLModelException 
     */
    public static void main(String[] args) throws CVLModelException {
    	// 
    	File f = new File(args[0]);
    	System.out.println(f + ", and f exists? " + f.exists());
    	CVLModel cvlm = new CVLModel(f);
    	
    	// Create window
        JFrame jframe = new JFrame("CVL UI");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setPreferredSize(new Dimension(800, 600));
        
        // Add stuff
        ConfigurableUnitPanel model = new ConfigurableUnitPanel();
        loadCVLView(cvlm.cu, model);

        // Done
        JScrollPane scrollPane = new JScrollPane(model, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        IAppWidgetFactory.makeIAppScrollPane(scrollPane);
        EditableModelPanel epanel = new EditableModelPanel(scrollPane);
        jframe.add(epanel, BorderLayout.CENTER);
        jframe.pack();
        jframe.setVisible(true);
    }
    
	private static void loadCVLView(ConfigurableUnit cu, ConfigurableUnitPanel model) throws CVLModelException {
		for(VSpec v : cu.getOwnedVSpec()){
			loadCVLView(v, model, null, cu);
		}
	}

	private static void loadCVLView(VSpec v, ConfigurableUnitPanel model, JComponent parent, ConfigurableUnit cu) throws CVLModelException {
		JComponent currentpanel = null;
		JComponent nextparent = null;
		OPTION_STATE edgetype = OPTION_STATE.MANDATORY;
		
		if(v instanceof VClassifier){
			VClassifier vc = (VClassifier) v;
	        VClassifierPanel c1 = new VClassifierPanel(model);
	        MultiplicityInterval m = vc.getInstanceMultiplicity();
	        if(m == null){
	        	throw new CVLModelException("VClassifier instance must have InstanceMultiplicity");
	        }
	        int l = m.getLower();
	        int u = m.getUpper();
	        c1.setNameAndCardinality(vc.getName(), "[" + l + "," + ((u==-1)?"*":u) + "]");
	        model.addNode(c1);
	        
	        currentpanel = c1;
	        nextparent = currentpanel;
		}else if(v instanceof Choice){
			Choice c = (Choice) v;
	        ChoicePanel cp = new ChoicePanel();
	        cp.setTitle(c.getName());
	        model.addNode(cp);
	        
	        if(c.isIsImpliedByParent()){
	        	edgetype = OPTION_STATE.OPTIONAL;
	        }
	        
	        currentpanel = cp;
	        nextparent = currentpanel;
		}
		
		if(v.getGroupMultiplicity() != null){
			MultiplicityInterval m = v.getGroupMultiplicity();
	        GroupPanel group = new GroupPanel();
	        int l = m.getLower();
	        int u = m.getUpper();
	        group.setCardinality(l, u);
	        model.addNode(group);
	        
		    Binding b4 = new Binding(OPTION_STATE.MANDATORY);
		    b4.setFrom(currentpanel);
		    b4.setTo(group);
		    model.addBinding(b4);
	        
	        nextparent = group;
		}
		
		if(currentpanel != null && parent != null){
			if(parent instanceof GroupPanel){
				edgetype = OPTION_STATE.OPTIONAL;
			}
	        Binding b4 = new Binding(edgetype);
	        b4.setFrom(parent);
	        b4.setTo(currentpanel);
	        model.addBinding(b4);
		}
		
		for(Constraint c : cu.getOwnedConstraint()){
			if(c instanceof OpaqueConstraint){
				OpaqueConstraint oc = (OpaqueConstraint) c;
				if(c.getContext() == v){
			        ConstraintPanel constraint1 = new ConstraintPanel(model);
			        constraint1.setTitle("--------------");
			        constraint1.setConstraint(oc.getConstraint());
			        model.addNode(constraint1);
			        
			        Binding b4 = new Binding(OPTION_STATE.MANDATORY);
			        b4.setFrom(constraint1);
			        b4.setTo(currentpanel);
			        model.addBinding(b4);
				}
			}
		}
		
		for(VSpec vs : v.getChild()){
			loadCVLView(vs, model, nextparent, cu);
		}
	}
}
