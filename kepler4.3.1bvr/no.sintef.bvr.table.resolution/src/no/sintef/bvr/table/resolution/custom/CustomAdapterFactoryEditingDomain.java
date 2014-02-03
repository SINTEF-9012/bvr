package no.sintef.bvr.table.resolution.custom;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;
import org.eclipse.emf.edit.command.CutToClipboardCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.OverrideableCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;

import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.VInstance;

public class CustomAdapterFactoryEditingDomain extends
		AdapterFactoryEditingDomain {

	TransactionalEditingDomain editingDomain;

	public CustomAdapterFactoryEditingDomain(AdapterFactory adapterFactory,
			CommandStack commandStack, HashMap<Resource, Boolean> hashMap) {
		super(adapterFactory, commandStack, hashMap);
		editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("no.sintef.bvr.shared.EditingDomain"); //$NON-NLS-1$
		if (editingDomain == null) {
			editingDomain = DiagramEditingDomainFactory.getInstance()
					.createEditingDomain();
			editingDomain.setID("no.sintef.bvr.shared.EditingDomain"); //$NON-NLS-1$
		}
		((AdapterFactoryEditingDomain) editingDomain)
				.setAdapterFactory(adapterFactory);

	}

	@Override
	public Command createCommand(Class<? extends Command> commandClass,
			CommandParameter commandParameter) {
		Command command = editingDomain.createCommand(commandClass,
				commandParameter);
		if (command instanceof DeleteCommand) {
			if (commandParameter.getCollection() instanceof List
					&& ((List<?>) commandParameter.getCollection()).size() == 1) {
				Object target = ((List<?>) commandParameter.getCollection())
						.get(0);
				if (target instanceof VInstance) {
					return command;
				} else if (target instanceof ChoiceResolutuion
						&& ((ChoiceResolutuion) target).eContainer() instanceof ConfigurableUnit) {
					return command;
				}
			}
			return UnexecutableCommand.INSTANCE;
		} else if (command instanceof CutToClipboardCommand) {
			if (commandParameter.getCollection() instanceof List
					&& ((List<?>) commandParameter.getCollection()).size() == 1) {
				Object target = ((List<?>) commandParameter.getCollection())
						.get(0);
				if (target instanceof VInstance) {
					return command;
				} else if (target instanceof ChoiceResolutuion
						&& ((ChoiceResolutuion) target).eContainer() instanceof ConfigurableUnit) {
					return command;
				}
			}
			return UnexecutableCommand.INSTANCE;
		} else if (command instanceof CopyToClipboardCommand) {
			if (commandParameter.getCollection() instanceof List
					&& ((List<?>) commandParameter.getCollection()).size() == 1) {
				Object target = ((List<?>) commandParameter.getCollection())
						.get(0);
				if (target instanceof VInstance) {
					return command;
				} else if (target instanceof ChoiceResolutuion
						&& ((ChoiceResolutuion) target).eContainer() instanceof ConfigurableUnit) {
					return command;
				}
			}
			return UnexecutableCommand.INSTANCE;
		} else if (command instanceof PasteFromClipboardCommand) {
			if (commandParameter.getOwner() instanceof ConfigurableUnit
					&& editingDomain.getClipboard() != null
					&& editingDomain.getClipboard().size() == 1) {
				Object target = ((List<?>) editingDomain.getClipboard()).get(0);
				if (target instanceof ChoiceResolutuion) {
					return command;
				}
			} else if (commandParameter.getOwner() instanceof VirtualVClassifier
					&& editingDomain.getClipboard() != null
					&& editingDomain.getClipboard().size() == 1) {
				Object target = ((List<?>) editingDomain.getClipboard()).get(0);
				if (target instanceof VInstance
						&& ((VInstance) target).getResolvedVSpec() == ((VirtualVClassifier) commandParameter
								.getOwner()).getResolvedVSpec()) {
					commandParameter
							.setOwner(((VirtualVClassifier) commandParameter
									.getOwner()).getParent());
					command = editingDomain.createCommand(commandClass,
							commandParameter);
					return command;
				}
			}
			return UnexecutableCommand.INSTANCE;
		} else {
			return command;
		}
	}

	@Override
	public AdapterFactory getAdapterFactory() {
		return super.getAdapterFactory();
	}

	@Override
	public void setAdapterFactory(AdapterFactory adapterFactory) {
		super.setAdapterFactory(adapterFactory);
	}

	@Override
	public Resource createResource(String fileNameURI) {
		return editingDomain.createResource(fileNameURI);
	}

	@Override
	public Resource loadResource(String fileNameURI) {
		return editingDomain.loadResource(fileNameURI);
	}

	@Override
	public ResourceSet getResourceSet() {
		return editingDomain.getResourceSet();
	}

	@Override
	public Command createOverrideCommand(OverrideableCommand command) {
		return editingDomain.createOverrideCommand(command);
	}

	@Override
	public CommandStack getCommandStack() {
		return editingDomain.getCommandStack();
	}

	@Override
	public Collection<?> getChildren(Object object) {
		return editingDomain.getChildren(object);
	}

	@Override
	public Object getParent(Object object) {
		return editingDomain.getParent(object);
	}

	@Override
	public Object getRoot(Object object) {
		return editingDomain.getRoot(object);
	}

	@Override
	public List<?> resolve(Collection<?> objects) {
		return ((AdapterFactoryEditingDomain) editingDomain).resolve(objects);
	}

	@Override
	public Object getWrapper(Object object) {
		return ((AdapterFactoryEditingDomain) editingDomain).getWrapper(object);
	}

	@Override
	public Collection<?> getNewChildDescriptors(Object object, Object sibling) {
		return editingDomain.getNewChildDescriptors(object, sibling);
	}

	@Override
	public Collection<Object> getClipboard() {
		return editingDomain.getClipboard();
	}

	@Override
	public void setClipboard(Collection<Object> clipboard) {
		editingDomain.setClipboard(clipboard);
	}

	@Override
	public boolean getOptimizeCopy() {
		return editingDomain.getOptimizeCopy();
	}

	@Override
	public void setOptimizeCopy(boolean optimizeCopy) {
		((AdapterFactoryEditingDomain) editingDomain)
				.setOptimizeCopy(optimizeCopy);
	}

	@Override
	public Map<Resource, Boolean> getResourceToReadOnlyMap() {
		return ((AdapterFactoryEditingDomain) editingDomain)
				.getResourceToReadOnlyMap();
	}

	@Override
	public void setResourceToReadOnlyMap(
			Map<Resource, Boolean> resourceToReadOnlyMap) {
		((AdapterFactoryEditingDomain) editingDomain)
				.setResourceToReadOnlyMap(resourceToReadOnlyMap);
	}

	@Override
	public boolean isReadOnly(Resource resource) {
		return editingDomain.isReadOnly(resource);
	}

	@Override
	public TreeIterator<?> treeIterator(Object object) {
		return editingDomain.treeIterator(object);
	}

	@Override
	public List<?> getTreePath(Object object) {
		return editingDomain.getTreePath(object);
	}

	@Override
	public boolean isControllable(Object object) {
		return editingDomain.isControllable(object);
	}

	public TransactionalEditingDomain getTransactionalDomain() {

		return editingDomain;
	}
}
