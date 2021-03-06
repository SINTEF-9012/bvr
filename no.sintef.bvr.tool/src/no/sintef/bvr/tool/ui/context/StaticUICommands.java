/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.context;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.filter.BVRFilter;
import no.sintef.bvr.tool.filter.FMFilter;
import no.sintef.bvr.tool.model.BVRToolModel;

import com.google.common.collect.Lists;

public class StaticUICommands {

	public static File saveModelToFile(JComponent parent, BVRToolModel model, boolean trydirectsave) {
		try {
			final String BVR_EXT = "." + BVRFilter.BVR_EXT;
			if (trydirectsave) {
				if (model.getFile() != null) {
					try {
						Context.eINSTANCE.writeModelToFile(model, model.getFile());
					} catch (UnsupportedOperationException e) {
						StaticUICommands.showMessageErrorDialog(parent, e, "Error writing file: ");
						return null;
					}
					return model.getFile();
				}
			}

			final JFileChooser fc = Context.eINSTANCE.getFileChooser();

			int isCanceled = fc.showSaveDialog(parent);
			if (isCanceled == JFileChooser.CANCEL_OPTION)
				return null;

			File sf = fc.getSelectedFile();
			if (sf == null)
				return null;

			if (!sf.getAbsolutePath().endsWith(BVR_EXT))
				sf = new File(sf.getAbsolutePath() + BVR_EXT);

			if (sf.exists()) {
				int result = JOptionPane.showConfirmDialog(parent, "File already exist, overwrite?", "alert", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION)
					return null;
			}
			Context.eINSTANCE.writeModelToFile(model, sf);
			return sf;
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public static JFileChooser getFileChooser(FileFilter[] filters, FileFilter defaultFilter) {
		JFileChooser fc = Context.eINSTANCE.getFileChooser();
		if (filters != null) {
			for (FileFilter filer : filters)
				fc.addChoosableFileFilter(filer);
			if (defaultFilter != null && Lists.newArrayList(filters).indexOf(defaultFilter) >= 0)
				fc.setFileFilter(defaultFilter);
		}
		return fc;
	}

	public static JFileChooser getBVRFileChooser() {
		JFileChooser fc = Context.eINSTANCE.getFileChooser();
		fc.addChoosableFileFilter(new FMFilter());
		BVRFilter bvrFilter = new BVRFilter();
		fc.addChoosableFileFilter(bvrFilter);
		fc.setFileFilter(bvrFilter);
		return fc;
	}

	public static void showMessageErrorDialog(Container parent, Throwable e, String message) {
		message = (message != null && !message.isEmpty()) ? message + " '" + e.getMessage() + "'\n" + CommonUtility.getStackTraceAsString(e) : e.getMessage()
				+ "\n" + CommonUtility.getStackTraceAsString(e);
		JTextArea textArea = new JTextArea(message);
		JScrollPane scrollPane = new JScrollPane(textArea) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(480, 320);
			};
		};
		JOptionPane.showMessageDialog(parent, scrollPane, Messages.DIALOG_MSG_GENERAL_ERROR, JOptionPane.ERROR_MESSAGE);
	}

	public static void showMessageInformationDialog(Container parent, String message) {
		JTextArea textArea = new JTextArea(message);
		JScrollPane scrollPane = new JScrollPane(textArea) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(480, 320);
			};
		};
		JOptionPane.showMessageDialog(parent, scrollPane, Messages.DIALOG_MSG_GENERAL_INFO, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void saveLayeredPaneAsPNGImage(JLayeredPane draw, File sf) {
		try {
			Dimension size = draw.getSize();
			BufferedImage bi = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
			final Graphics2D g2 = bi.createGraphics();
			draw.paintComponents(g2);
			draw.paint(g2);
			ImageIO.write(bi, "PNG", sf);
			Context.eINSTANCE.getConfig().saveLastLocation(sf.getAbsolutePath());
		} catch (Exception ex) {
			throw new RethrownException("can not export a model as PNG image", ex);
		}
	}

	public static boolean showConfirmationDialog(Container parent, String title, String message) {
		int result = JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION);
		return (result == JOptionPane.YES_OPTION) ? true : false;
	}
}
