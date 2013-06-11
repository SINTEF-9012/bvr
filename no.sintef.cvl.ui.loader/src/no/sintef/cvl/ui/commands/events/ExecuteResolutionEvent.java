package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.swing.JTabbedPane;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

import no.sintef.cvl.ui.common.DeriveProduct;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.primitives.impl.VSpecResolutionSymbolTable;
import no.sintef.cvl.ui.strategies.impl.RRComposerStrategy;

public class ExecuteResolutionEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public ExecuteResolutionEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		JTabbedPane x = (JTabbedPane) ((JTabbedPane)filePane.getSelectedComponent()).getSelectedComponent();
		int i = x.getSelectedIndex();
		CVLModel m = models.get(tab);
		ConfigurableUnit cu = m.getCU();
		VSpecResolution vsr = cu.getOwnedVSpecResolution().get(i);
		
		try {
			DeriveProduct deriviator = new DeriveProduct(cu, vsr);
			deriviator.run();
		} catch (AbstractError error) {
			error.printStackTrace();
		}
		
		Resource baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("E:/GitHub/cvl/TestData/Artificial/node9-7/base.node"), false);
		baseModel.setURI(URI.createFileURI("E:/GitHub/cvl/TestData/Artificial/node9-7/base_new.node"));
		try {
			baseModel.save(Collections.EMPTY_MAP);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Executed");
	}
}
