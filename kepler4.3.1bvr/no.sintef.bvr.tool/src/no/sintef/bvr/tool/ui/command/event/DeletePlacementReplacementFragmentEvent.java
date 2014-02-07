package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import org.eclipse.emf.common.util.EList;

import bvr.ConfigurableUnit;
import bvr.FragmentSubstitution;
import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.VariationPoint;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.model.SubFragTableModel;

public class DeletePlacementReplacementFragmentEvent implements ActionListener {

	
	private JTabbedPane filePane;
	private List<BVRModel> models;
	private List<BVRView> views;

	public DeletePlacementReplacementFragmentEvent(JTabbedPane filePane, List<BVRModel> models, List<BVRView> views){
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		BVRModel m = models.get(tab);
		ConfigurableUnit cu = m.getCU();
		
		if(!LoaderUtility.isVariationPointsPanelInFocus(((JTabbedPane) filePane.getComponentAt(tab)))){
			JOptionPane.showMessageDialog(null, Messages.VARIATION_TAB_NO_FOCUS);
			return;
		}
		JPanel variationPanel = (JPanel) ((JTabbedPane)((JTabbedPane) filePane.getComponentAt(tab)).getSelectedComponent()).getSelectedComponent();
		JTable subFragTable = LoaderUtility.getSibstitutionFragmentTable(variationPanel);
		if(subFragTable == null){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_CAN_NOT_LOCATE_SUB_FRAG_TABLE);
			return;
		}
		if(subFragTable.getSelectedRows().length == 0){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_NO_SELECTION);
			return;
		}
		
		ArrayList<NamedElement> placReplcFragmentsUsed = new ArrayList<NamedElement>();
		EList<VariationPoint> variationPoints = cu.getOwnedVariationPoint();
		for(VariationPoint vp : variationPoints){
			if(vp instanceof FragmentSubstitution){
				placReplcFragmentsUsed.add(((FragmentSubstitution) vp).getPlacement());
				placReplcFragmentsUsed.add(((FragmentSubstitution) vp).getReplacement());
			}
		}
		
		int[] rowIndexes = subFragTable.getSelectedRows();
		SubFragTableModel modelSubFrag = (SubFragTableModel) subFragTable.getModel();
		ArrayList<ArrayList<Object>> dataSubFrag = modelSubFrag.getData();
		ArrayList<NamedElement> placReplcFragmentsNotDeleted = new ArrayList<NamedElement>();
		for(int index : rowIndexes){
			NamedElement fragment = ((DataItem) dataSubFrag.get(index).get(Constants.SUB_FRAG_FRAG_CLMN)).getNamedElement();
			if(placReplcFragmentsUsed.indexOf(fragment) < 0){
				if(fragment instanceof PlacementFragment){
					cu.getOwnedVariationPoint().remove(fragment);
				}else if(fragment instanceof ReplacementFragmentType){
					cu.getOwnedVariabletype().remove(fragment);
				}
			}else{
				placReplcFragmentsNotDeleted.add(fragment);
			}
		}
		
		if(placReplcFragmentsNotDeleted.size() > 0){
			String name = new String(Messages.DIALOG_MSG_CAN_NOT_REMOVE_PLC_RPLC + "\n");
			for(NamedElement element : placReplcFragmentsNotDeleted){
				name+=element.getName() + "\n";
			}
			JOptionPane.showMessageDialog(null, name);
		}
		
		//views.get(tab).notifyRelalizationViewUpdate();
		views.get(tab).getConfigurableUnitSubject().notifyObserver();
	}

}
