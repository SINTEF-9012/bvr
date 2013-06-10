package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.parsers.impl.ResolutionRealizationComposer;
import no.sintef.cvl.ui.primitives.impl.VSpecResolutionSymbolTable;

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
		
		ResolutionRealizationComposer composer = new ResolutionRealizationComposer(cu);
		VSpecResolutionSymbolTable composedResolution = (VSpecResolutionSymbolTable) composer.buildSymbolTable(vsr);
		System.out.println(composedResolution);
		System.out.println(composedResolution.getSymbols());
		System.out.println(composedResolution.getChildren());
		System.out.println(composedResolution.getParent());
	}
}
