/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.editor;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.VNode;
import bvr.VSpec;
import bvr.Variable;
import no.sintef.bvr.tool.common.NullVSpec;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.observer.Observer;
import no.sintef.bvr.tool.observer.Subject;
import no.sintef.bvr.tool.primitive.impl.DataNamedElementItem;
import no.sintef.bvr.tool.primitive.impl.DataVSpecItem;
import no.sintef.bvr.tool.subject.BVRModelSubject;
import no.sintef.bvr.tool.subject.SelectedFragmentSubstitutionSubject;
import no.sintef.bvr.tool.ui.command.event.FragSubTableEvent;
import no.sintef.bvr.tool.ui.command.event.FragSubTableRowSelectionEvent;
import no.sintef.bvr.tool.ui.model.FragSubTableModel;
import no.sintef.bvr.tool.ui.renderer.FragSubTableCellRenderer;

public class FragmentSubstitutionJTable extends JTable implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6490422017472288712L;
	private FragSubTableModel tableModel;
	private BVRNotifiableController controller;
	
	public FragmentSubstitutionJTable(BVRNotifiableController _controller) {
		controller = _controller;
		tableModel = new FragSubTableModel();
		setModel(tableModel);
		
		setDefaultEditor(DataNamedElementItem.class, new FragSubTextTabelCellEditor());
		
		setDefaultRenderer(DataVSpecItem.class, new FragSubTableCellRenderer());
		setDefaultRenderer(DataNamedElementItem.class, new FragSubTableCellRenderer());
		setDefaultEditor(DataVSpecItem.class, new FragSubVSpecTableCellEditor());
		
		tableModel.addTableModelListener(new FragSubTableEvent(controller));
		getSelectionModel().addListSelectionListener(new FragSubTableRowSelectionEvent(controller));
		getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
	}

	@Override
	public void update(Subject subject) {
		if(subject instanceof BVRModelSubject){
			BVRModel model = ((BVRModelSubject) subject).getBVRModel();
			CompoundNode root = model.getVariabilityModel();
			EList<VSpec> vSpecs = getAllVSpec(root.getMember(), new BasicEList<VSpec>());
			vSpecs.add((VSpec) root);
			
			ArrayList<DataVSpecItem> vSpecMap = new ArrayList<DataVSpecItem>();
			
			NullVSpec nullVSpec = new NullVSpec();
			DataVSpecItem nullDataVSpecItem = new DataVSpecItem(new JLabel(nullVSpec.getName()), nullVSpec);
			vSpecMap.add(nullDataVSpecItem);
			
			for(VSpec spec : vSpecs){
				if(!(spec instanceof Variable)){
					DataVSpecItem map = new DataVSpecItem(new JLabel(spec.getName()), spec);
					vSpecMap.add(map);
				}
			}
			
			tableModel.setData(model.getRealizationModel(), vSpecMap);
			FragSubVSpecTableCellEditor editor = (FragSubVSpecTableCellEditor) getDefaultEditor(DataVSpecItem.class);
			editor.setData(vSpecMap);
		}
		if(subject instanceof SelectedFragmentSubstitutionSubject){
			if(((SelectedFragmentSubstitutionSubject) subject).getSelectedFragmentSubstitution() == null){
				tableModel.fireTableDataChanged();
			}
		}
	}
	
	private EList<VSpec> getAllVSpec(EList<VNode> vNodeList, EList<VSpec> result){
		for(VNode vNode : vNodeList){
			if(vNode instanceof VSpec && vNode instanceof CompoundNode){
				result.add((VSpec) vNode);
				result = getAllVSpec(((CompoundNode) vNode).getMember(), result);
			}
		}
		return result;
	}
}
