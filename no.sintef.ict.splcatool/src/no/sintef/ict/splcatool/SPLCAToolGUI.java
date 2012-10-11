/*******************************************************************************
 * Copyright (c) 2011, 2012 SINTEF, Martin F. Johansen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SINTEF, Martin F. Johansen - the implementation
 *******************************************************************************/

package no.sintef.ict.splcatool;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import splar.core.fm.FeatureModelException;

public class SPLCAToolGUI {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		new SPLCAToolGUI().mainObj(args);
	}

	private JPanel fpanel;
	private JPanel cabpanel;
	private JPanel wpanel;
	private JPanel opanel;
	private JPanel sfpanel;
	private JPanel tpanel;
	private JPanel spanel;
	private JPanel clpanel;
	private JPanel sllpanel;
	private JPanel wcpanel;
	private JPanel allPanel;
	private JPanel tsPanel;
	private JButton cs;
	private JButton ts;
	private JButton vs;
	private JButton ws;
	private JButton gca;
	private JButton cc;
	private JButton si;
	private JPanel csPanel;
	private JPanel vsPanel;
	private JPanel wsPanel;
	private JPanel gcaPanel;
	private JPanel ccPanel;
	private JPanel siPanel;
	private JButton fic;
	private JPanel ficPanel;
	
	public void mainObj(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		JFrame frame = new JFrame("PL Covering Array Tool v0.4 (MODELS 2012)");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setSize(550, 500);
		
		// Select feature model
		JLabel fmlabel = new JLabel("Feature Model: ");
		fmlabel.setPreferredSize(new Dimension(100, 10));
		JTextField fml = new JTextField(40);
		JButton fmb = new JButton("Browse...");
		fmb.addActionListener(new SelectFileAction(frame, fml));
		
		// Select weights
		JLabel wlabel = new JLabel("Weights: ");
		wlabel.setPreferredSize(new Dimension(100, 10));
		JTextField wl = new JTextField(40);
		JButton wb = new JButton("Browse...");
		wb.addActionListener(new SelectFileAction(frame, wl));
		
		// Select covering array
		JLabel cablabel = new JLabel("Covering Array: ");
		cablabel.setPreferredSize(new Dimension(100, 10));
		JTextField cal = new JTextField(40);
		JButton cab = new JButton("Browse...");
		cab.addActionListener(new SelectFileAction(frame, cal));
		
		// Select order
		JLabel olabel = new JLabel("Ordering File: ");
		olabel.setPreferredSize(new Dimension(100, 10));
		JTextField ol = new JTextField(40);
		JButton ob = new JButton("Browse...");
		ob.addActionListener(new SelectFileAction(frame, ol));
		
		// Select start from
		JLabel sflabel = new JLabel("Start From: ");
		sflabel.setPreferredSize(new Dimension(100, 10));
		JTextField sfl = new JTextField(40);
		JButton sfb = new JButton("Browse...");
		sfb.addActionListener(new SelectFileAction(frame, sfl));
		
		// Misc
		JLabel tl = new JLabel("t:");
		tl.setPreferredSize(new Dimension(100, 10));
		JTextField ttf = new JTextField(4);
		
		JLabel sl = new JLabel("Search level:");
		sl.setPreferredSize(new Dimension(100, 10));
		JTextField stf = new JTextField(4);
		
		JLabel cll = new JLabel("Coverage limit:");
		cll.setPreferredSize(new Dimension(100, 10));
		JTextField cltf = new JTextField(4);
		
		JLabel sll = new JLabel("Size limit:");
		sll.setPreferredSize(new Dimension(100, 10));
		JTextField sltf = new JTextField(4);
		
		JLabel wcl = new JLabel("Weighted: ");
		wcl.setPreferredSize(new Dimension(100, 10));
		JCheckBox wcb = new JCheckBox();
		
		// Action Buttons
		cs = new JButton("Count Solutions");
		cs.addActionListener(new CsAction(fml));
		ts = new JButton("Time Satisfiability");
		ts.addActionListener(new TsAction(fml));
		vs = new JButton("Verify Solutions");
		vs.addActionListener(new VsAction(fml, cal));
		ws = new JButton("Verify Weighted Partial Solutions");
		ws.addActionListener(new WsAction(fml, wl));
		gca = new JButton("Generate Covering Array");
		gca.addActionListener(new GcaAction(fml, ttf, wl, wcb, ol, sfl, cltf, sltf));
		cc = new JButton("Calculate Coverage");
		cc.addActionListener(new CcAction(fml, ttf, wl, wcb, cal));
		si = new JButton("Suggest Improvements");
		si.addActionListener(new SiAction(fml, ttf, wl, wcb, cal, stf));
		fic = new JButton("Generate FeatureIDE Files");
		fic.addActionListener(new FicAction(cal));
		
		// Construct parts
		fpanel = new JPanel(new FlowLayout());
		fpanel.add(fmlabel);
		fpanel.add(fml);
		fpanel.add(fmb);
		
		cabpanel = new JPanel(new FlowLayout());
		cabpanel.add(cablabel);
		cabpanel.add(cal);
		cabpanel.add(cab);
		
		wpanel = new JPanel(new FlowLayout());
		wpanel.add(wlabel);
		wpanel.add(wl);
		wpanel.add(wb);
		
		opanel = new JPanel(new FlowLayout());
		opanel.add(olabel);
		opanel.add(ol);
		opanel.add(ob);
		
		sfpanel = new JPanel(new FlowLayout());
		sfpanel.add(sflabel);
		sfpanel.add(sfl);
		sfpanel.add(sfb);
		
		tpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tpanel.add(tl);
		tpanel.add(ttf);
		
		spanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		spanel.add(sl);
		spanel.add(stf);
		
		clpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		clpanel.add(cll);
		clpanel.add(cltf);
		
		sllpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		sllpanel.add(sll);
		sllpanel.add(sltf);
		
		wcpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		wcpanel.add(wcl);
		wcpanel.add(wcb);

		// tabs
		JTabbedPane tabbedPane = new JTabbedPane();
		frame.getContentPane().add(tabbedPane);
		
		allPanel = new JPanel();
		allPanel.setLayout(new BoxLayout(allPanel, BoxLayout.Y_AXIS));
		tabbedPane.addTab("All", allPanel);
		
		tsPanel = new JPanel();
		tsPanel.setLayout(new BoxLayout(tsPanel, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Time Satisfiability", tsPanel);
		
		csPanel = new JPanel();
		csPanel.setLayout(new BoxLayout(csPanel, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Count Solutions", csPanel);
		
		vsPanel = new JPanel();
		vsPanel.setLayout(new BoxLayout(vsPanel, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Verify Solutions", vsPanel);
		
		wsPanel = new JPanel();
		wsPanel.setLayout(new BoxLayout(wsPanel, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Verify Weighted Partial Solutions", wsPanel);
		
		gcaPanel = new JPanel();
		gcaPanel.setLayout(new BoxLayout(gcaPanel, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Generate Covering Array", gcaPanel);
		
		ccPanel = new JPanel();
		ccPanel.setLayout(new BoxLayout(ccPanel, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Calculate Coverage", ccPanel);
		
		siPanel = new JPanel();
		siPanel.setLayout(new BoxLayout(siPanel, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Suggest Improvements", siPanel);
		
		ficPanel = new JPanel();
		ficPanel.setLayout(new BoxLayout(ficPanel, BoxLayout.Y_AXIS));
		tabbedPane.addTab("Generate FeatureIDE Files", ficPanel);
		
		// Activate and initialize
		tabbedPane.addChangeListener(this.new TabChange());
		tabbedPane.setSelectedIndex(1);
		tabbedPane.setSelectedIndex(0);

		// Finish
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setVisible(true);
	}
	
	class TabChange implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			JTabbedPane jtp = (JTabbedPane) e.getSource();
			String title = jtp.getTitleAt(jtp.getSelectedIndex());
			
			if(title.equals("All")){
				allPanel.removeAll();
				//allPanel.setPreferredSize(new Dimension(500, 0));
				
				allPanel.add(fpanel);
				allPanel.add(cabpanel);
				allPanel.add(wpanel);
				allPanel.add(opanel);
				allPanel.add(sfpanel);
				allPanel.add(tpanel);
				allPanel.add(spanel);
				allPanel.add(clpanel);
				allPanel.add(sllpanel);
				allPanel.add(wcpanel);
				
				JPanel bpanel = new JPanel(new FlowLayout());
				bpanel.setPreferredSize(new Dimension(500, 100));
				bpanel.add(gca);
				bpanel.add(cc);
				bpanel.add(vs);
				bpanel.add(ws);
				bpanel.add(si);
				bpanel.add(cs);
				bpanel.add(ts);
				bpanel.add(fic);
				allPanel.add(bpanel);
			}else if(title.equals("Time Satisfiability")){
				tsPanel.removeAll();
				//tsPanel.setPreferredSize(new Dimension(500, 0));
				
				tsPanel.add(fpanel);
				
				JPanel bpanel = new JPanel(new FlowLayout());
				//bpanel.setPreferredSize(new Dimension(500, 0));
				bpanel.add(ts);
				tsPanel.add(bpanel);
			}else if(title.equals("Count Solutions")){
				csPanel.removeAll();
				
				csPanel.add(fpanel);
				
				JPanel bpanel = new JPanel(new FlowLayout());
				//bpanel.setPreferredSize(new Dimension(500, 0));
				bpanel.add(cs);
				csPanel.add(bpanel);
			}else if(title.equals("Verify Solutions")){
				vsPanel.removeAll();
				
				vsPanel.add(fpanel);
				vsPanel.add(cabpanel);
				
				JPanel bpanel = new JPanel(new FlowLayout());
				//bpanel.setPreferredSize(new Dimension(500, 100));
				bpanel.add(vs);
				vsPanel.add(bpanel);
			}else if(title.equals("Verify Weighted Partial Solutions")){
				wsPanel.removeAll();
				
				wsPanel.add(fpanel);
				wsPanel.add(wpanel);
				
				JPanel bpanel = new JPanel(new FlowLayout());
				//bpanel.setPreferredSize(new Dimension(500, 100));
				bpanel.add(ws);
				wsPanel.add(bpanel);
			}else if(title.equals("Generate Covering Array")){
				gcaPanel.removeAll();
				
				gcaPanel.add(fpanel);
				gcaPanel.add(wpanel);
				gcaPanel.add(opanel);
				gcaPanel.add(sfpanel);
				gcaPanel.add(tpanel);
				gcaPanel.add(clpanel);
				gcaPanel.add(sllpanel);
				gcaPanel.add(wcpanel);
				
				JPanel bpanel = new JPanel(new FlowLayout());
				//bpanel.setPreferredSize(new Dimension(500, 100));
				bpanel.add(gca);
				gcaPanel.add(bpanel);
			}else if(title.equals("Calculate Coverage")){
				ccPanel.removeAll();
				
				ccPanel.add(fpanel);
				ccPanel.add(cabpanel);
				ccPanel.add(wpanel);
				ccPanel.add(tpanel);
				ccPanel.add(wcpanel);
				
				JPanel bpanel = new JPanel(new FlowLayout());
				//bpanel.setPreferredSize(new Dimension(500, 100));
				bpanel.add(cc);
				ccPanel.add(bpanel);
			}else if(title.equals("Suggest Improvements")){
				siPanel.removeAll();
				
				siPanel.add(fpanel);
				siPanel.add(cabpanel);
				siPanel.add(wpanel);
				siPanel.add(tpanel);
				siPanel.add(spanel);
				siPanel.add(wcpanel);
				
				JPanel bpanel = new JPanel(new FlowLayout());
				//bpanel.setPreferredSize(new Dimension(500, 100));
				bpanel.add(si);
				siPanel.add(bpanel);
			}else if(title.equals("Generate FeatureIDE Files")){
				ficPanel.removeAll();
				
				ficPanel.add(cabpanel);
				
				JPanel bpanel = new JPanel(new FlowLayout());
				//bpanel.setPreferredSize(new Dimension(500, 100));
				bpanel.add(fic);
				ficPanel.add(bpanel);
			}
		}
		
	}
}

class SelectFileAction implements ActionListener{
	private static JFrame frame;
	private JTextField label;

	@SuppressWarnings("static-access")
	public SelectFileAction(JFrame frame, JTextField fml) {
		this.frame = frame;
		this.label = fml;
	}
	
	static private File start = null;

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc;
		if(start != null)
			jfc = new JFileChooser(start);
		else
			jfc = new JFileChooser();
		jfc.showOpenDialog(frame);
		if(jfc.getSelectedFile() != null){
			boolean good = checkFile(jfc.getSelectedFile().getAbsolutePath());
			if(good){
				label.setText(jfc.getSelectedFile().getAbsolutePath());
				start = new File(jfc.getSelectedFile().getPath());
			}
		}
	}
	
	static private Map<String, Object> lfs = new HashMap<String, Object>();

	static private boolean checkFile(String fn) {
		if(fn.endsWith(".m") || fn.endsWith(".xml") || fn.endsWith(".dimacs")){
			CNF cnf;
			if(fn.endsWith(".m")){
				try {
					GUIDSL gdsl = new GUIDSL(new File(fn));
					SXFM sxfm = gdsl.getSXFM();
					cnf = sxfm.getCNF();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "There are errors in the feature model: \n\n" + e.getMessage(), "Feature Model Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}else if(fn.endsWith(".xml")){
				try {
					SXFM sxfm = new SXFM(fn);
					cnf = sxfm.getCNF();
				} catch (FeatureModelException e) {
					JOptionPane.showMessageDialog(frame, "There are errors in the feature model: \n\n" + e.getMessage(), "Feature Model Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}else if(fn.endsWith(".dimacs")){
				try {
					cnf = new CNF(fn, CNF.type.dimacs);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, "There are errors in the feature model: \n\n" + e.getMessage(), "Feature Model Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}else{
				JOptionPane.showMessageDialog(frame, "Unsupported feature model format.", "Loading Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			lfs.put("FM", cnf);
		}
		if(fn.endsWith(".csv") || fn.endsWith(".xlsx")){
			CoveringArrayFile ca;
			try {
				ca = new CoveringArrayFile(fn);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "There are errors in the covering array: \n\n" + e.getMessage(), "Covering Array Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if(lfs.containsKey("FM")){
				CNF cnf = (CNF) lfs.get("FM");
				if(ca.weights.isEmpty()){
					try {
						boolean ok = CALib.verifyCA(cnf, ca, true);
						if(!ok)
							throw new CoveringArrayGenerationException("See standard output for details.");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Error verifying covering array: \n\n" + e.getMessage(), "Covering Array Error", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}else{
					try {
						boolean ok = CALib.verifyWeightedCA(cnf, fn);
						if(!ok)
							throw new CoveringArrayGenerationException("See standard output for details.");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Error verifying covering array: \n\n" + e.getMessage(), "Covering Array Error", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}
			}
		}
		return true;
	}
}

class CcAction implements ActionListener{
	private JTextField fml;
	private JTextField ttf;
	private JTextField wl;
	private JCheckBox wcb;
	private JTextField cal;

	public CcAction(JTextField fml, JTextField ttf, JTextField wl, JCheckBox wcb, JTextField cal) {
		this.fml = fml;
		this.ttf = ttf;
		this.wl = wl;
		this.wcb = wcb;
		this.cal = cal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<String> argsl = new ArrayList<String>();
		
		argsl.add("-t");
		if(!wcb.isSelected()){
			argsl.add("calc_cov");
		}else{
			argsl.add("calc_cov_weighted");
			argsl.add("-weights");
			argsl.add(wl.getText());
		}
		
		argsl.add("-fm");
		argsl.add(fml.getText());
		
		argsl.add("-s");
		argsl.add(ttf.getText());
		
		argsl.add("-ca");
		argsl.add(cal.getText());
		
		String [] args = new String [argsl.size()];
		for(int i = 0; i < argsl.size(); i++){
			args[i] = argsl.get(i);
		}
		SpawnThread.spawnThread(args);
	}
}

class GcaAction implements ActionListener{
	private JTextField fml;
	private JTextField tl;
	private JTextField wl;
	private JCheckBox wcb;
	private JTextField ol;
	private JTextField sfl;
	private JTextField sll;
	private JTextField cll;

	public GcaAction(JTextField fml, JTextField tl, JTextField wl, JCheckBox wcb, JTextField ol, JTextField sfl, JTextField cll, JTextField sll) {
		this.fml = fml;
		this.sll = sll;
		this.cll = cll;
		this.tl = tl;
		this.wl = wl;
		this.wcb = wcb;
		this.ol = ol;
		this.sfl = sfl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<String> argsl = new ArrayList<String>();
		
		argsl.add("-t");
		if(!wcb.isSelected()){
			argsl.add("t_wise");
		}else{
			argsl.add("t_wise_weighted");
			argsl.add("-a");
			argsl.add("ChvatalWeighted");
			argsl.add("-weights");
			argsl.add(wl.getText());
		}
		
		argsl.add("-fm");
		argsl.add(fml.getText());
		
		if(!sfl.getText().isEmpty()){
			argsl.add("-startFrom");
			argsl.add(sfl.getText());
		}else if(!ol.getText().isEmpty()){
			argsl.add("-startFrom");
			argsl.add(ol.getText());
		}
		
		if(!cll.getText().isEmpty()){
			argsl.add("-limit");
			argsl.add(cll.getText());
		}
		
		if(!sll.getText().isEmpty()){
			argsl.add("-sizelimit");
			argsl.add(sll.getText());
		}
		
		argsl.add("-s");
		argsl.add(tl.getText());
		
		String [] args = new String [argsl.size()];
		for(int i = 0; i < argsl.size(); i++){
			args[i] = argsl.get(i);
		}
		SpawnThread.spawnThread(args);
	}
}

class VsAction implements ActionListener{
	private JTextField fml;
	private JTextField cal;

	public VsAction(JTextField fml, JTextField cal) {
		this.fml = fml;
		this.cal = cal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SpawnThread.spawnThread(new String [] {
			"-t", "verify_solutions", 
			"-fm", fml.getText(),
			"-check", cal.getText(),
		});
	}
}

class WsAction implements ActionListener{
	private JTextField fml;
	private JTextField wl;

	public WsAction(JTextField fml, JTextField wl) {
		this.fml = fml;
		this.wl = wl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SpawnThread.spawnThread(new String [] {
			"-t", "verify_weighted_solutions", 
			"-fm", fml.getText(),
			"-check", wl.getText(),
		});
	}
}

class SiAction implements ActionListener{

	private JTextField fml;
	private JTextField ttf;
	private JTextField wl;
	private JTextField cal;
	private JTextField stf;

	public SiAction(JTextField fml, JTextField ttf, JTextField wl, JCheckBox wcb, JTextField cal, JTextField stf) {
		this.fml = fml;
		this.ttf = ttf;
		this.wl = wl;
		this.cal = cal;
		this.stf = stf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<String> argsl = new ArrayList<String>();
		
		argsl.add("-t");
		argsl.add("improve_weighted");
		
		argsl.add("-weights");
		argsl.add(wl.getText());
		
		argsl.add("-fm");
		argsl.add(fml.getText());
		
		argsl.add("-s");
		argsl.add(ttf.getText());
		
		argsl.add("-search");
		argsl.add(stf.getText());
		
		argsl.add("-ca");
		argsl.add(cal.getText());
		
		String [] args = new String [argsl.size()];
		for(int i = 0; i < argsl.size(); i++){
			args[i] = argsl.get(i);
		}
		SpawnThread.spawnThread(args);
	}
}
class CsAction implements ActionListener{
	private JTextField fml;

	public CsAction(JTextField fml) {
		this.fml = fml;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SpawnThread.spawnThread(new String [] {
			"-t", "count_solutions", 
			"-fm", fml.getText(),
		});
	}
}

class TsAction implements ActionListener{
	private JTextField fml;

	public TsAction(JTextField fml) {
		this.fml = fml;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SpawnThread.spawnThread(new String [] {
			"-t", "sat_time", 
			"-fm", fml.getText(),
		});
	}
}

class FicAction implements ActionListener{
	private JTextField cab;

	public FicAction(JTextField cab) {
		this.cab = cab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SpawnThread.spawnThread(new String [] {
			"-t", "generate_featureide_equation_files", 
			"-ca", cab.getText(),
		});
	}
}

class SpawnThread{
	static void spawnThread(String[] args) {
		Thread t = new Thread(new SPLCAToolThread(args));
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}

class SPLCAToolThread implements Runnable{
	private String[] args;

	public SPLCAToolThread(String[] args) {
		this.args = args;
	}

	@Override
	public void run() {
		SPLCATool.main(args);
	}
}