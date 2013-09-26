package no.sintef.cvl.tool.ui.command.event;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import cvl.ConfigurableUnit;
import cvl.CvlFactory;
import cvl.FragmentSubstitution;
import cvl.NamedElement;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;

import no.sintef.cvl.tool.common.Constants;
import no.sintef.cvl.tool.common.LoaderUtility;
import no.sintef.cvl.tool.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.tool.ui.editor.SubstitutionFragmentJTable;
import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.CVLView;
import no.sintef.cvl.tool.ui.model.SubFragTableModel;

public class CreateFragmentSubstitutionEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;
	static int count = 0;

	public CreateFragmentSubstitutionEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views){
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		CVLModel m = models.get(tab);
		
		ConfigurableUnit cu = m.getCU();
		
		if(!LoaderUtility.isVariationPointsPanelInFocus(((JTabbedPane) filePane.getComponentAt(tab)))){
			JOptionPane.showMessageDialog(null, "Tab with variation points is not in focus");
			return;
		}

		JPanel variationPanel = (JPanel) ((JTabbedPane)((JTabbedPane) filePane.getComponentAt(tab)).getSelectedComponent()).getSelectedComponent();
		JTable subFragTable = LoaderUtility.getSibstitutionFragmentTable(variationPanel);
		if(subFragTable == null){
			JOptionPane.showMessageDialog(null, "can not find a table with listed placement/replacement fragments");
			return;
		}
		
		if(subFragTable.getSelectedRows().length != 2){
			JOptionPane.showMessageDialog(null, "two rows should be selected");
			return;
		}
		
		int[] rowIndexes = subFragTable.getSelectedRows();
		SubFragTableModel model = (SubFragTableModel) subFragTable.getModel();
		ArrayList<ArrayList<Object>> data = model.getData();
		
		DataNamedElementItem firstRowDataElement = (DataNamedElementItem) data.get(rowIndexes[0]).get(Constants.SUB_FRAG_FRAG_CLMN);
		DataNamedElementItem secondRowDataElement = (DataNamedElementItem) data.get(rowIndexes[1]).get(Constants.SUB_FRAG_FRAG_CLMN);
		
		HashMap<PlacementFragment, ReplacementFragmentType> tuple = this.isSelectionValid(firstRowDataElement, secondRowDataElement);
		if(tuple == null){
			JOptionPane.showMessageDialog(null, "one placement and one replacement must be selected");
			return;
		}

		count++;
		PlacementFragment placement = tuple.keySet().iterator().next();
		ReplacementFragmentType replacement = tuple.values().iterator().next();
		
		FragmentSubstitution fs = CvlFactory.eINSTANCE.createFragmentSubstitution();
		fs.setName("FragmentSubstititution-" + placement.getName() + "-" + replacement.getName() + "-" + count);
		fs.setPlacement(placement);
		fs.setReplacement(replacement);
		cu.getOwnedVariationPoint().add(fs);
		
		//views.get(tab).notifyRelalizationViewUpdate();
		views.get(tab).getConfigurableUnitSubject().notifyObserver();
	}
	
	private HashMap<PlacementFragment, ReplacementFragmentType> isSelectionValid(DataNamedElementItem d, DataNamedElementItem d1){
		NamedElement fragment = d.getNamedElement();
		NamedElement fragment1 = d1.getNamedElement();
		HashMap<PlacementFragment, ReplacementFragmentType> tuple = new HashMap<PlacementFragment, ReplacementFragmentType>();
		if((fragment instanceof PlacementFragment) && (fragment1 instanceof ReplacementFragmentType)){
			tuple.put((PlacementFragment) fragment, (ReplacementFragmentType) fragment1);
			return tuple;
		}
		if((fragment1 instanceof PlacementFragment) && (fragment instanceof ReplacementFragmentType)){
			tuple.put((PlacementFragment) fragment1, (ReplacementFragmentType) fragment);
			return tuple;
		}
		return null;
	}
}
