package no.sintef.bvr.tool.ui.command.event;


import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;


public class SubFragTableEvent implements TableModelListener {

	private BVRNotifiableController controller;

	public SubFragTableEvent(BVRNotifiableController _controller){
		controller = _controller;
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		if(TableModelEvent.UPDATE == e.getType()){
			//when column is less than zero then the update event in a model was triggered by for example filtering not users selection 
			if(e.getColumn() >= 0){
				if(e.getLastRow() == e.getFirstRow()){
					int rowIndex = e.getLastRow();
					int columnIndex = e.getColumn();
					SimpleExeCommandInterface command = controller.getRealizationControllerInterface().createUpdateSubstitutionFragmentCommand(rowIndex, columnIndex);
					command.execute();
				}else{
					throw new UnsupportedOperationException("Few rows were updated - not implemented");
				}
			}
		}

	}

}
