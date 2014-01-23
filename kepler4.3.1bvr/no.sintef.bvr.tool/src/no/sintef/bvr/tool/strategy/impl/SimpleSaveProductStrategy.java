package no.sintef.bvr.tool.strategy.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.strategy.SaveProductStrategy;
import no.sintef.bvr.tool.ui.context.StaticUICommands;

public class SimpleSaveProductStrategy implements SaveProductStrategy {

	@Override
	public void saveProduct(HashMap<String, Object> keywords) {
		JComponent parent = (JComponent) keywords.get("parentComponent");
		
		final JFileChooser fc = StaticUICommands.getFileChooser(null, null);
		
		int status = fc.showSaveDialog(parent);
		if(status == JFileChooser.CANCEL_OPTION)
			return;
		
		File sf = fc.getSelectedFile();
		if(sf == null) return;
		
		Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), sf);
	}
}
