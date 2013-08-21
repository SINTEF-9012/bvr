package no.sintef.cvl.ui.editor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.command.StaticUICommands;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.loader.CVLModel;

public class CVLJFrame extends JFrame {
	
	private CVLJFrame frame;
	private JTabbedPane tabbedPane;
	private static final String title = "CVL 2 Editor by SINTEF";
	
	public CVLJFrame() {
		super(title);
		frame = this;
		tabbedPane = new JTabbedPane();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000, 800));
		frame.setBackground(Color.WHITE);
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Are you sure to close this window?", "Close?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					try{
						int componentCount = tabbedPane.getComponentCount();
						for(int index = 0; index<componentCount; index++){
							CVLModel model = Context.eINSTANCE.getCvlModels().get(index);
							StaticUICommands.saveModelToFile((JComponent) tabbedPane.getComponent(index), model, true);
						}
						System.exit(0);
					}catch (Exception error){
						Context.eINSTANCE.logger.error("some error on Save", error);
						JOptionPane.showMessageDialog(frame, "Error : " + error.getMessage());
					}
				}
			}
		});
	}

	public JTabbedPane getJTabbedPane(){
		return tabbedPane;
	}

}
