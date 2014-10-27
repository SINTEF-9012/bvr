package no.sintef.bvr.tool.ui.command.event;


import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;


public class FragSubTableEvent implements TableModelListener {

	private BVRNotifiableController controller;

	public FragSubTableEvent(BVRNotifiableController _controller) {
		controller = _controller;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		if(TableModelEvent.UPDATE == e.getType()){
			if(e.getColumn() >= 0){
				if(e.getLastRow() == e.getFirstRow()){
					int rowIndex = e.getLastRow();
					int columnIndex = e.getColumn();
					SimpleExeCommandInterface command = controller.getRealizationControllerInterface().createUpdateFragmentSubstitutionCommand(rowIndex, columnIndex);
					command.execute();
				}else{
					throw new UnsupportedOperationException("Few rows were updated - not implemented");
				}
			}
		}
	}
}
