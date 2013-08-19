package no.sintef.cvl.ui.loader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;

import no.sintef.cvl.ui.command.event.ClearSelectionRelalizationEvent;
import no.sintef.cvl.ui.command.event.CloseModelEvent;
import no.sintef.cvl.ui.command.event.CreateBindingsEvent;
import no.sintef.cvl.ui.command.event.CreateFragmentSubstitutionEvent;
import no.sintef.cvl.ui.command.event.CreatePlacementFragmentEvent;
import no.sintef.cvl.ui.command.event.CreateReplacementFragmentEvent;
import no.sintef.cvl.ui.command.event.CreateToBindingEvent;
import no.sintef.cvl.ui.command.event.DeleteBindingAllEvent;
import no.sintef.cvl.ui.command.event.DeleteBindingEvent;
import no.sintef.cvl.ui.command.event.DeleteFragmentSubstitutionEvent;
import no.sintef.cvl.ui.command.event.DeletePlacementReplacementFragmentEvent;
import no.sintef.cvl.ui.command.event.ExecuteResolutionEvent;
import no.sintef.cvl.ui.command.event.ExportModelImage;
import no.sintef.cvl.ui.command.event.ExportModelSVG;
import no.sintef.cvl.ui.command.event.ImportVSpecEvent;
import no.sintef.cvl.ui.command.event.NewModelEvent;
import no.sintef.cvl.ui.command.event.NewResolutionEvent;
import no.sintef.cvl.ui.command.event.OpenModelEvent;
import no.sintef.cvl.ui.command.event.SaveModelAsEvent;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.ThirdpartyEditorSelector;
import no.sintef.cvl.ui.context.Context;
import cvl.CvlPackage;
import cvl.NamedElement;

public class Main {
	private JFrame jframe;
	public static NamedElement vSpecCut;
	private List<CVLView> views = Context.eINSTANCE.getCvlViews();
	private List<CVLModel> models = Context.eINSTANCE.getCvlModels();

	public static void main(String[] args){
		new Main().main();
	}
	
	// Eclipse connection
	private IWorkbenchWindow w;
	public void setEclipseWindow(IWorkbenchWindow w){
		this.w = w;
		Context.eINSTANCE.setIWorkbenchWindow(w);
	}
	// --

	public void main(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		views = Context.eINSTANCE.getCvlViews();
		models = Context.eINSTANCE.getCvlModels();

		// Create window
		jframe = new JFrame("CVL 2 Editor by SINTEF");
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
		x.addActionListener(new NewModelEvent(filePane));
		filemenu.add(x);
		JMenuItem openfile = new JMenuItem("Open ...");
		openfile.addActionListener(new OpenModelEvent(filePane));
		filemenu.add(openfile);
		filemenu.add(new JSeparator());
		JMenuItem save = new JMenuItem("Save");
		filemenu.add(save);
		save.addActionListener(new SaveModelAsEvent(filePane, true));
		//TODO: filemenu.add(new JMenuItem("Save all"));
		JMenuItem saveas = new JMenuItem("Save as ...");
		saveas.addActionListener(new SaveModelAsEvent(filePane, false));
		filemenu.add(saveas);
		JMenuItem close = new JMenuItem("Close");
		close.addActionListener(new CloseModelEvent(filePane, models, views));
		filemenu.add(close);
		
		filemenu.add(new JSeparator());
		
		JMenuItem saveasImage = new JMenuItem("Export Diagram as PNG ...");
		filemenu.add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(views, filePane));
		JMenuItem saveasSVG = new JMenuItem("Export Diagram as SVG ...");
		filemenu.add(saveasSVG);
		saveasSVG.addActionListener(new ExportModelSVG(views, filePane));
		
		//TODO: filemenu.add(new JSeparator());
		
		//TODO: filemenu.add(new JMenuItem("Exit"));
		menuBar.add(filemenu);

		// VSpec
		JMenu vsmenu = new JMenu("VSpec");
		JMenuItem importvspec = new JMenuItem("Import ...");
		importvspec.addActionListener(new ImportVSpecEvent(filePane, models, views));
		vsmenu.add(importvspec);
		//TODO: vsmenu.add(new JMenuItem("Export ..."));
		//TODO: vsmenu.add(new JMenuItem("Count Solutions"));
		menuBar.add(vsmenu);

		// Resolutions
		JMenu resmenu = new JMenu("Resolution");
		JMenuItem newres = new JMenuItem("New");
		newres.addActionListener(new NewResolutionEvent(filePane, models, views));
		resmenu.add(newres);
		resmenu.add(new JSeparator());
		JMenuItem importres = new JMenuItem("Import ...");
		importres.addActionListener(new ImportResolutions(filePane, models, views));
		resmenu.add(importres);
		//TODO: camenu.add(new JMenuItem("Export ..."));
		resmenu.add(new JSeparator());
		JMenuItem valres = new JMenuItem("Validate Resolution");
		valres.addActionListener(new ValidateResolution(filePane, models, views));
		resmenu.add(valres);
		
		/* Choice-only options */{
			JMenu camenu = new JMenu("Models with Choices Only");
			JMenuItem satvalres = new JMenuItem("Validate Resolutions");
			satvalres.addActionListener(new SATValidateResolutions(filePane, models, views));
			camenu.add(satvalres);
			JMenu cc1 = new JMenu("Calculate Coverage");
			JMenuItem calccov1 = new JMenuItem("1-wise");
			calccov1.addActionListener(new CalculateCoverage(filePane, models, views, 1));
			cc1.add(calccov1);
			JMenuItem calccov2 = new JMenuItem("2-wise");
			calccov2.addActionListener(new CalculateCoverage(filePane, models, views, 2));
			cc1.add(calccov2);
			JMenuItem calccov3 = new JMenuItem("3-wise");
			calccov3.addActionListener(new CalculateCoverage(filePane, models, views, 3));
			cc1.add(calccov3);
			camenu.add(cc1);
			camenu.add(new JSeparator());
			
			JMenu genca = new JMenu("Generate Covering Array");
			JMenuItem genca1 = new JMenuItem("1-wise");
			genca1.addActionListener(new GenerateCoveringArray(filePane, models, views, 1));
			genca.add(genca1);
			JMenuItem genca2 = new JMenuItem("2-wise");
			genca2.addActionListener(new GenerateCoveringArray(filePane, models, views, 2));
			genca.add(genca2);
			JMenuItem genca3 = new JMenuItem("3-wise");
			genca3.addActionListener(new GenerateCoveringArray(filePane, models, views, 3));
			genca.add(genca3);
			camenu.add(genca);
			
			resmenu.add(new JSeparator());
			resmenu.add(camenu);
		}
		
		resmenu.add(new JSeparator());
		
		JMenuItem execute = new JMenuItem(Constants.RESOLUTION_EXECUTE_NAME);
		execute.addActionListener(new ExecuteResolutionEvent(filePane));
		resmenu.add(execute);
		
		JMenuItem executeAll = new JMenuItem(Constants.RESOLUTION_EXECUTE_ALL_NAME);
		resmenu.add(executeAll);
		
		menuBar.add(resmenu);
		
		// realization menu
		JMenu realizationMenu = new JMenu(Constants.REALIZATION_MAIN_MENU_NAME);
		
		JMenuItem createPlacement = new JMenuItem(Constants.REALIZATION_CR_PLCMT_NAME);
		createPlacement.addActionListener(new CreatePlacementFragmentEvent(filePane));
		realizationMenu.add(createPlacement);
		
		JMenuItem createReplacement = new JMenuItem(Constants.REALIZATION_CR_RPLCMT_NAME);
		createReplacement.addActionListener(new CreateReplacementFragmentEvent(filePane));
		realizationMenu.add(createReplacement);
		
		JMenuItem createFragmentSubstitution = new JMenuItem(Constants.REALIZATION_CR_FS_NAME);
		createFragmentSubstitution.addActionListener(new CreateFragmentSubstitutionEvent(filePane, models, views));
		realizationMenu.add(createFragmentSubstitution);
		realizationMenu.add(new JSeparator());
		
		JMenuItem generateBindings = new JMenuItem(Constants.REALIZATION_GENERATE_BINDINGS);
		generateBindings.addActionListener(new CreateBindingsEvent(filePane, models, views));
		realizationMenu.add(generateBindings);
		
		JMenuItem createToBinding = new JMenuItem(Constants.REALIZATION_GENERATE_TO_BINDING);
		createToBinding.addActionListener(new CreateToBindingEvent(filePane, models, views));
		realizationMenu.add(createToBinding);
		
		JMenuItem deleteBinding = new JMenuItem(Constants.REALIZATION_DELETE_BINDING);
		deleteBinding.addActionListener(new DeleteBindingEvent(filePane, models, views));
		realizationMenu.add(deleteBinding);
		
		JMenuItem deleteAllBinding = new JMenuItem(Constants.REALIZATION_DELETE_ALL_BINDING);
		deleteAllBinding.addActionListener(new DeleteBindingAllEvent(filePane, models, views));
		realizationMenu.add(deleteAllBinding);
		
		realizationMenu.add(new JSeparator());
		
		
		JMenuItem deletePlacementReplacement = new JMenuItem(Constants.REALIZATION_DL_PLCMT_RPLCMT_NAME);
		deletePlacementReplacement.addActionListener(new DeletePlacementReplacementFragmentEvent(filePane, models, views));
		realizationMenu.add(deletePlacementReplacement);
		
		JMenuItem deleteFragmentSubstitution = new JMenuItem(Constants.REALIZATION_DL_FS_NAME);
		deleteFragmentSubstitution.addActionListener(new DeleteFragmentSubstitutionEvent(filePane, models, views));
		realizationMenu.add(deleteFragmentSubstitution);
		
		realizationMenu.add(new JSeparator());
		JMenuItem clearSelection = new JMenuItem(Constants.REALIZATION_CLEAR_SELECTION_NAME);
		clearSelection.addActionListener(new ClearSelectionRelalizationEvent(filePane, models, views));
		realizationMenu.add(clearSelection);
		
		menuBar.add(realizationMenu);

		// Done
		jframe.add(filePane, BorderLayout.CENTER);
		jframe.pack();
		jframe.repaint();
		
		//position jframe in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe.setLocation((int) (dim.getWidth()/2 - jframe.getWidth()/2), (int) (dim.getHeight()/2 - jframe.getHeight()/2));
		
		jframe.setVisible(true);
	}
}


