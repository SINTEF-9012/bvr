package no.sintef.cvl.ui.loader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import no.sintef.cvl.ui.commands.AddChoice;
import no.sintef.cvl.ui.commands.AddGroupMultiplicity;
import no.sintef.cvl.ui.commands.AddOpaqueConstraint;
import no.sintef.cvl.ui.commands.AddVClassifier;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.cvl.ui.framework.elements.EditableModelPanel;
import no.sintef.ict.splcatool.CVLModel;

import com.explodingpixels.macwidgets.IAppWidgetFactory;

import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.Constraint;
import cvl.OpaqueConstraint;
import cvl.VClassifier;
import cvl.VSpec;

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
		JComponent nextParent = null;
		
		if(v instanceof VClassifier){
			nextParent = new AddVClassifier().init(model, v, parent).execute();
		}else if(v instanceof Choice){
			nextParent = new AddChoice().init(model, v, parent).execute();
		}
		
		if(v.getGroupMultiplicity() != null){
			nextParent = new AddGroupMultiplicity().init(model, v, nextParent).execute();
		}
		
		for(Constraint c : cu.getOwnedConstraint()){
			if(c instanceof OpaqueConstraint){
				OpaqueConstraint oc = (OpaqueConstraint) c;
				if(c.getContext() == v){
					new AddOpaqueConstraint().init(model, oc, nextParent).execute();
				}
			}
		}
		
		for(VSpec vs : v.getChild()){
			loadCVLView(vs, model, nextParent, cu);
		}
	}
}
