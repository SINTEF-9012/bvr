package no.sintef.cvl.ui.loader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

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
        
        // Tabbed pane
        JTabbedPane filePane = new JTabbedPane();
        
        // Add menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu filemenu = new JMenu("File");
        filemenu.add(new JMenuItem("New"));
        JMenuItem openfile = new JMenuItem("Open...");
        openfile.addActionListener(new OpenModelEvent(filePane, models, views));
        filemenu.add(openfile);
        filemenu.add(new JMenuItem("Save"));
        filemenu.add(new JMenuItem("Save as..."));
        filemenu.add(new JMenuItem("Close"));
        menuBar.add(filemenu);
        jframe.setJMenuBar(menuBar);
        
        // Done
        jframe.add(filePane, BorderLayout.CENTER);
        jframe.pack();
        jframe.repaint();
        jframe.setVisible(true);
    }
}


