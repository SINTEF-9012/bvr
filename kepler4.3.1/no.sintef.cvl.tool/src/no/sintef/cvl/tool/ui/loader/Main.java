package no.sintef.cvl.tool.ui.loader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import no.sintef.cvl.tool.common.Constants;
import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.ui.command.event.ClearSelectionRelalizationEvent;
import no.sintef.cvl.tool.ui.command.event.CloseModelEvent;
import no.sintef.cvl.tool.ui.command.event.CopyModelEvent;
import no.sintef.cvl.tool.ui.command.event.CreateBindingsEvent;
import no.sintef.cvl.tool.ui.command.event.CreateFragmentSubstitutionEvent;
import no.sintef.cvl.tool.ui.command.event.CreatePlacementFragmentEvent;
import no.sintef.cvl.tool.ui.command.event.CreateReplacementFragmentEvent;
import no.sintef.cvl.tool.ui.command.event.CreateToBindingEvent;
import no.sintef.cvl.tool.ui.command.event.DeleteBindingAllEvent;
import no.sintef.cvl.tool.ui.command.event.DeleteBindingEvent;
import no.sintef.cvl.tool.ui.command.event.DeleteFragmentSubstitutionEvent;
import no.sintef.cvl.tool.ui.command.event.DeletePlacementReplacementFragmentEvent;
import no.sintef.cvl.tool.ui.command.event.ExecuteResolutionEvent;
import no.sintef.cvl.tool.ui.command.event.ExportModelImage;
import no.sintef.cvl.tool.ui.command.event.ExportModelSVG;
import no.sintef.cvl.tool.ui.command.event.ImportVSpecEvent;
import no.sintef.cvl.tool.ui.command.event.NewModelEvent;
import no.sintef.cvl.tool.ui.command.event.NewResolutionEvent;
import no.sintef.cvl.tool.ui.command.event.OpenModelEvent;
import no.sintef.cvl.tool.ui.command.event.SaveModelAsEvent;
import no.sintef.cvl.tool.ui.command.event.SettingsToolEvent;
import no.sintef.cvl.tool.ui.editor.CVLJFrame;
import cvl.NamedElement;

public class Main {
	private CVLJFrame jframe;
	public static NamedElement vSpecCut;
	private List<CVLView> views = Context.eINSTANCE.getCvlViews();
	private List<CVLModel> models = Context.eINSTANCE.getCvlModels();

	public void startVSpecView(){
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
		jframe = new CVLJFrame();
		
		// Tabbed pane
		JTabbedPane filePane = jframe.getJTabbedPane();

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
		close.addActionListener(new CloseModelEvent(filePane));
		filemenu.add(close);
		
		filemenu.add(new JSeparator());
		
		JMenuItem saveasImage = new JMenuItem("Export Diagram as PNG ...");
		filemenu.add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(filePane));
		JMenuItem saveasSVG = new JMenuItem("Export Diagram as SVG ...");
		filemenu.add(saveasSVG);
		saveasSVG.addActionListener(new ExportModelSVG(filePane));
		
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
		
		// tools menu
		JMenu toolsMenu = new JMenu(Constants.TOOLS_MENU_NAME);
		JMenuItem copyModel = new JMenuItem(Constants.TOOLS_COPY_MODEL);
		copyModel.addActionListener(new CopyModelEvent());
		toolsMenu.add(copyModel);
		
		JMenuItem settings = new JMenuItem(Constants.TOOLS_OPTIONS);
		settings.addActionListener(new SettingsToolEvent());
		toolsMenu.add(settings);
		
		menuBar.add(toolsMenu);

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


