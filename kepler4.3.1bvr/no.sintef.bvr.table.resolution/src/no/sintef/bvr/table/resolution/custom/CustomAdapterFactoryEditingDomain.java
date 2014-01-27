package no.sintef.bvr.table.resolution.custom;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;
import org.eclipse.emf.edit.command.CutToClipboardCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.VInstance;

public class CustomAdapterFactoryEditingDomain extends
		AdapterFactoryEditingDomain {

	public CustomAdapterFactoryEditingDomain(AdapterFactory adapterFactory,
			CommandStack commandStack, HashMap<Resource, Boolean> hashMap) {
		super(adapterFactory, commandStack, hashMap);

	}

	@Override
	public Command createCommand(Class<? extends Command> commandClass,
			CommandParameter commandParameter) {
		Command command = super.createCommand(commandClass, commandParameter);
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
					&& clipboard != null && clipboard.size() == 1) {
				Object target = ((List<?>) clipboard).get(0);
				if (target instanceof ChoiceResolutuion) {
					return command;
				}
			} else if (commandParameter.getOwner() instanceof VirtualVClassifier
					&& clipboard != null && clipboard.size() == 1) {
				Object target = ((List<?>) clipboard).get(0);
				if (target instanceof VInstance
						&& ((VInstance) target).getResolvedVSpec() == ((VirtualVClassifier) commandParameter
								.getOwner()).getResolvedVSpec()) {
					commandParameter
							.setOwner(((VirtualVClassifier) commandParameter
									.getOwner()).getParent());
					command = super.createCommand(commandClass,
							commandParameter);
					return command;
				}
			}
			return UnexecutableCommand.INSTANCE;
		} else {
			return command;
		}
	}
}
