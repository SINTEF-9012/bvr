package org.bangbangbang.cvl.system.vspec.custom.relation;

import java.util.Iterator;

import org.bangbangbang.cvl.Choice;
import org.bangbangbang.cvl.system.cvlsystemrelation.CVLReference;
import org.bangbangbang.cvl.system.cvlsystemrelation.RelationFactory;
import org.bangbangbang.cvl.system.cvlsystemrelation.VSpecRelation;
import org.bangbangbang.cvl.system.vspec.part.CVLSystemVSpecEditorPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;

public class RelationFormDialog extends FormDialog {

	private Choice choice;
	private URI uri;
	private VSpecRelation choiceRelation;

	public RelationFormDialog(IShellProvider parentShellProvider) {
		super(parentShellProvider);
		choice = null;
		uri = null;
		choiceRelation = null;

	}

	public RelationFormDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		// TODO Auto-generated method stub
		return super.createDialogArea(parent);
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		// TODO Auto-generated method stub
		return super.createButtonBar(parent);
	}

	@Override
	protected void createFormContent(IManagedForm mform) {
		mform.getForm().setText("An example of a simple form dialog");
		mform.getForm().setBackgroundImage(null);
		mform.getToolkit().decorateFormHeading(mform.getForm().getForm());
		mform.getForm().setImage(
				PlatformUI.getWorkbench().getSharedImages()
						.getImage(ISharedImages.IMG_OBJ_ELEMENT));
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
		this.initializeRelationModel();
	}

	public void setURI(URI uri) {
		this.uri = uri;
		this.initializeRelationModel();
	}

	private void initializeRelationModel() {
		if (choice == null || uri == null) {
			return;
		}
		// Check existence of relation model
		CVLReference reference = RelationHolder.getModel(uri);
		if (reference == null) {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Relation model does not exist");
			return;
		}

		// Check existence of the choice in the model
		for (Iterator<VSpecRelation> ite = reference.getRelations().iterator(); ite
				.hasNext();) {
			VSpecRelation vsr = ite.next();
			// TODO check this equality
			if (vsr.getSystemVSpec().equals(choice)) {
				choiceRelation = vsr;
			}
		}
		if (choiceRelation == null) {
			choiceRelation = RelationFactory.eINSTANCE.createVSpecRelation();
			choiceRelation.setSystemVSpec(choice);
			reference.getRelations().add(choiceRelation);
		}

	}

}
