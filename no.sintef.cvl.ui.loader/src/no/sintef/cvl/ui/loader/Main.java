package no.sintef.cvl.ui.loader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.commands.events.NewResolutionEvent;
import cvl.VSpec;

public class Main {
	private JFrame jframe;
	public static VSpec vSpecCut;
	private List<CVLView> views;
	private List<CVLModel> models;

	public static void main(String[] args) throws CVLModelException {
		new Main().main();
	}

	private void main(){
		views = new ArrayList<CVLView>();
		models = new ArrayList<CVLModel>();

		// Create window
		jframe = new JFrame("CVL UI");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setPreferredSize(new Dimension(1000, 800));
		jframe.setBackground(Color.WHITE);

		// Tabbed pane
		JTabbedPane filePane = new JTabbedPane();

		// Add menu bar
		JMenuBar menuBar = new JMenuBar();
		jframe.setJMenuBar(menuBar);

		// File
		JMenu filemenu = new JMenu("File");
		JMenuItem x = new JMenuItem("New");
		x.addActionListener(new NewModelEvent(models, views, filePane));
		filemenu.add(x);
		JMenuItem openfile = new JMenuItem("Open ...");
		openfile.addActionListener(new OpenModelEvent(filePane, models, views));
		filemenu.add(openfile);
		filemenu.add(new JSeparator());
		JMenuItem save = new JMenuItem("Save");
		filemenu.add(save);
		save.addActionListener(new SaveModelAsEvent(filePane, models, views, true));
		filemenu.add(new JMenuItem("Save all"));
		JMenuItem saveas = new JMenuItem("Save as ...");
		saveas.addActionListener(new SaveModelAsEvent(filePane, models, views, false));

		JMenuItem saveasImage = new JMenuItem("Save as Image ...");
		filemenu.add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(views, filePane));
	
		

		filemenu.add(saveas);
		filemenu.add(new JMenuItem("Close"));
		filemenu.add(new JSeparator());
		filemenu.add(new JMenuItem("Exit"));
		menuBar.add(filemenu);

		// VSpec
		JMenu vsmenu = new JMenu("VSpec");
		JMenuItem importvspec = new JMenuItem("Import ...");
		importvspec.addActionListener(new ImportVSpecEvent(filePane, models, views));
		vsmenu.add(importvspec);
		vsmenu.add(new JMenuItem("Export ..."));
		vsmenu.add(new JMenuItem("Count Solutions"));
		menuBar.add(vsmenu);

		// Resolutions
		JMenu camenu = new JMenu("Resolutions");
		JMenuItem newres = new JMenuItem("New");
		newres.addActionListener(new NewResolutionEvent(filePane, models, views));
		camenu.add(newres);
		camenu.add(new JSeparator());
		JMenuItem importres = new JMenuItem("Import ...");
		importres.addActionListener(new ImportResolutions(filePane, models, views));
		camenu.add(importres);
		camenu.add(new JMenuItem("Export ..."));
		JMenuItem genca = new JMenuItem("Generate Covering Array ...");
		genca.addActionListener(new GenerateCoveringArray(filePane, models, views));
		camenu.add(genca);
		camenu.add(new JMenuItem("Calculate Coverage ..."));
		menuBar.add(camenu);

		// Done
		jframe.add(filePane, BorderLayout.CENTER);
		jframe.pack();
		jframe.repaint();
		jframe.setVisible(true);
	}
}


