package no.sintef.cvl.tool.ui.loader;

import java.awt.Point;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.demo.TextInBox;
import org.abego.treelayout.demo.TextInBoxNodeExtentProvider;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;

import no.sintef.cvl.tool.exception.CVLModelException;
import no.sintef.cvl.tool.subject.ConfigurableUnitSubject;
import no.sintef.cvl.tool.ui.command.AddBCLConstraint;
import no.sintef.cvl.tool.ui.command.AddChoice;
import no.sintef.cvl.tool.ui.command.AddConfigurableUnit;
import no.sintef.cvl.tool.ui.command.AddGroupMultiplicity;
import no.sintef.cvl.tool.ui.command.AddOpaqueConstraint;
import no.sintef.cvl.tool.ui.command.AddVClassifier;
import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.TitledElement;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.cvl.ui.framework.elements.EditableModelPanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import cvl.BCLConstraint;
import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.Constraint;
import cvl.NamedElement;
import cvl.OpaqueConstraint;
import cvl.VClassifier;
import cvl.VSpec;

abstract public class CVLView {
	private CVLModel m;
	
	public JTabbedPane modelPane;
	
	// VSpec
	public JScrollPane vspecScrollPane;
	public EditableModelPanel vspecEpanel;
	private Map<JComponent, NamedElement> vspecvmMap;
	private List<JComponent> vspecNodes;
	private List<Pair<JComponent, JComponent>> vspecBindings;
	private CVLUIKernel vSpeccvluikernel;
	
	// Resolutions
	private List<Map<JComponent, NamedElement>> resolutionvmMaps;
	
	// Realization
	private ConfigurableUnitSubject configurableUnitSubject;

	private BVRNotifier ep;


	abstract public CVLUIKernel getKernel() ;


	public abstract ConfigurableUnitSubject getConfigurableUnitSubject() ;


	public abstract boolean isDirty() ;

	public abstract ConfigurableUnit getCU();

	int choiceCount = 1;


	abstract public void notifyResolutionViewUpdate() ;


	abstract  public void notifyVspecViewUpdate();


	abstract public void notifyRelalizationViewReset() ;


	abstract public void notifyAllViews() ;


	abstract public void setMaximized(VSpec v);


	abstract public void setMinimized(VSpec v) ;

}
