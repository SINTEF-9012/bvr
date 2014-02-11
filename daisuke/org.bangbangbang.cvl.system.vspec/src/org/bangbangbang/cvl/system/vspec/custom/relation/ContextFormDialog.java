package org.bangbangbang.cvl.system.vspec.custom.relation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bangbangbang.cvl.ConfigurableUnit;
import org.bangbangbang.cvl.VClassifier;
import org.bangbangbang.cvl.VInterface;
import org.bangbangbang.cvl.VSpec;
import org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference;
import org.bangbangbang.cvl.system.cvlsystemrelation.RelationFactory;
import org.bangbangbang.cvl.system.cvlsystemrelation.VSpecRelation;
import org.bangbangbang.cvl.system.vspec.part.CVLSystemVSpecEditorPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

public class ContextFormDialog extends FormDialog {

	private VClassifier vclassifier;
	private VClassifier context;
	private URI uri;
	private VSpecRelation vclassifierRelation;

	private ResourceSet resourceSet;
	private FormToolkit toolkit;

	private List<VClassifier> vclassifiers;

	public ContextFormDialog(IShellProvider parentShellProvider) {
		this(parentShellProvider.getShell());
	}

	public ContextFormDialog(Shell shell) {
		super(shell);
		vclassifier = null;
		uri = null;
		vclassifierRelation = null;
		vclassifiers = new ArrayList<VClassifier>();
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		return super.createDialogArea(parent);
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		return super.createButtonBar(parent);
	}

	@Override
	protected void createFormContent(IManagedForm mform) {
		mform.getForm().setText("Select context VClassifier");
		mform.getForm().setBackgroundImage(null);
		mform.getToolkit().decorateFormHeading(mform.getForm().getForm());
		mform.getForm().setImage(
				PlatformUI.getWorkbench().getSharedImages()
						.getImage(ISharedImages.IMG_OBJ_ELEMENT));
		toolkit = mform.getToolkit();
		ScrolledForm form = mform.getForm();

		Composite body = form.getBody();
		body.setLayout(new TableWrapLayout());
		body.setLayout(new FillLayout());

		Table table = toolkit.createTable(body, SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = Arrays.asList(((Table) e.getSource()).getItems())
						.indexOf(e.item);
				if (index == -1 || vclassifiers.size() <= index) {
					context = null;
				} else {
					context = vclassifiers.get(index);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				CVLSystemVSpecEditorPlugin.getInstance().logError("Undefined");
			}
		});

		TableColumn[] column = new TableColumn[2];
		column[0] = new TableColumn(table, SWT.LEFT);
		column[0].setText("Resource");

		column[1] = new TableColumn(table, SWT.LEFT);
		column[1].setText("VClassifier");

		setTableContents(table);

		if (context != null) {
			int index = vclassifiers.indexOf(context);
			if (index != -1 && table.getItems().length > index) {
				table.setSelection(index);
			}
		}

		for (int i = 0; i < column.length; i++) {
			column[i].pack();
		}

	}

	private void setTableContents(Table table) {
		table.setRedraw(false);

		for (Iterator<Resource> ite = resourceSet.getResources().iterator(); ite
				.hasNext();) {
			Resource resource = ite.next();
			if (resource instanceof XMIResource
					&& !(resource instanceof GMFResource)) {
				if (resource.getURI().equals(uri)) {
					// System definition vspec
					for (TreeIterator<EObject> ti = resource.getAllContents(); ti
							.hasNext();) {
						EObject eo = ti.next();
						if (eo instanceof VClassifier
								&& isRootConfigurableUnit(((VClassifier) eo))) {
							TableItem item = new TableItem(table, SWT.NONE);
							item.setText(0, resource.getURI().toString());
							item.setText(1, ((VClassifier) eo).getName());
							vclassifiers.add((VClassifier) eo);
						}
					}
				} else {
					// Product feature vspec
					for (TreeIterator<EObject> ti = resource.getAllContents(); ti
							.hasNext();) {
						EObject eo = ti.next();
						if (eo instanceof VClassifier) {
							TableItem item = new TableItem(table, SWT.NONE);
							item.setText(0, resource.getURI().toString());
							item.setText(1, ((VClassifier) eo).getName());
							vclassifiers.add((VClassifier) eo);
						}
					}
				}
			}
		}
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(0, "N/A");
		item.setText(1, "N/A");

		table.setRedraw(true);
	}

	/**
	 * @generated NOT
	 */
	private static boolean isRootConfigurableUnit(VSpec vspec) {
		if (vspec.eContainer() == null) {
			return true;
		}
		if (vspec.eContainer() != null
				&& vspec.eContainer() instanceof VInterface) {
			return false;
		} else if (vspec.eContainer() != null
				&& vspec.eContainer() instanceof ConfigurableUnit) {
			return true;
		} else if (vspec.eContainer() != null
				&& vspec.eContainer() instanceof VSpec) {
			return isRootConfigurableUnit((VSpec) vspec.eContainer());
		}
		return false;

	}

	public void setVClassifier(VClassifier vclassifier) {
		this.vclassifier = vclassifier;
		this.initializeRelationModel();
		this.resourceSet = vclassifier.eResource().getResourceSet();
	}

	public void setURI(URI uri) {
		this.uri = uri;
		this.initializeRelationModel();
	}

	private void initializeRelationModel() {
		if (vclassifier == null || uri == null) {
			return;
		}
		// Check existence of relation model
		CVLReference reference = RelationHolder.getModel(uri);
		if (reference == null) {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Relation model does not exist");
			return;
		}

		// Check existence of the vclassifier in the model
		for (Iterator<VSpecRelation> ite = reference.getRelations().iterator(); ite
				.hasNext();) {
			VSpecRelation vsr = ite.next();
			// TODO check this equality
			if (vsr.getSystemVSpec().equals(vclassifier)) {
				vclassifierRelation = vsr;
				context = (VClassifier) vclassifierRelation.getContext();
			}
		}
		if (vclassifierRelation == null) {
			vclassifierRelation = RelationFactory.eINSTANCE
					.createVSpecRelation();
			vclassifierRelation.setSystemVSpec(vclassifier);
			reference.getRelations().add(vclassifierRelation);
		}

	}

	@Override
	protected void okPressed() {
		vclassifierRelation.setContext(context);
		super.okPressed();
	}
}
