package no.sintef.bvr.tool.ui.command.event;

import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;


public class SubFragTableRowSelectionEvent implements ListSelectionListener {

	private BVRNotifiableController controller;
	
	public SubFragTableRowSelectionEvent(BVRNotifiableController _controller){
		controller = _controller;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent event) {		
		if(!event.getValueIsAdjusting()){
            ArrayList<Integer> selectedIndexes = new ArrayList<Integer>();
			ListSelectionModel listSelectionModel = (ListSelectionModel) event.getSource();
            int minIndex = listSelectionModel.getMinSelectionIndex();
            int maxIndex = listSelectionModel.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (listSelectionModel.isSelectedIndex(i)) selectedIndexes.add(i);
            }
            SimpleExeCommandInterface command = controller.getRealizationControllerInterface().createHighlightFragmentElementsCommand(selectedIndexes);
            command.execute();
		}
	}
}
