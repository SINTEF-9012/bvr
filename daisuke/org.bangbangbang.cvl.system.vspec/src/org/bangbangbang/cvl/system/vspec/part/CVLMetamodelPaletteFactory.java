package org.bangbangbang.cvl.system.vspec.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelElementTypes;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class CVLMetamodelPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createCvl1Group());
	}

	/**
	 * Creates "cvl" palette tool group
	 * @generated
	 */
	private PaletteContainer createCvl1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Cvl1Group_title);
		paletteContainer.setId("createCvl1Group"); //$NON-NLS-1$
		paletteContainer.add(createVSpecChild1CreationTool());
		paletteContainer.add(createVSpecGroupMultiplicity2CreationTool());
		paletteContainer.add(createOpaqueConstraint3CreationTool());
		paletteContainer.add(createOpaqueConstraintLink4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVSpecChild1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.VSpecChild1CreationTool_title,
				Messages.VSpecChild1CreationTool_desc,
				Collections
						.singletonList(CVLMetamodelElementTypes.VSpecChild_4001));
		entry.setId("createVSpecChild1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CVLSystemVSpecEditorPlugin
				.findImageDescriptor("/org.bangbangbang.cvl.model.edit/icons/full/obj16/ChildNode.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVSpecGroupMultiplicity2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(CVLMetamodelElementTypes.MultiplicityInterval_3001);
		types.add(CVLMetamodelElementTypes.MultiplicityInterval_3002);
		types.add(CVLMetamodelElementTypes.MultiplicityInterval_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VSpecGroupMultiplicity2CreationTool_title,
				Messages.VSpecGroupMultiplicity2CreationTool_desc, types);
		entry.setId("createVSpecGroupMultiplicity2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CVLSystemVSpecEditorPlugin
				.findImageDescriptor("/org.bangbangbang.cvl.model.edit/icons/full/obj16/MultiplicityInterval.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOpaqueConstraint3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OpaqueConstraint3CreationTool_title,
				Messages.OpaqueConstraint3CreationTool_desc,
				Collections
						.singletonList(CVLMetamodelElementTypes.OpaqueConstraint_2007));
		entry.setId("createOpaqueConstraint3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CVLSystemVSpecEditorPlugin
				.findImageDescriptor("/org.bangbangbang.cvl.model.edit/icons/full/obj16/OpaqueConstraint.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOpaqueConstraintLink4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.OpaqueConstraintLink4CreationTool_title,
				Messages.OpaqueConstraintLink4CreationTool_desc,
				Collections
						.singletonList(CVLMetamodelElementTypes.ConstraintContext_4002));
		entry.setId("createOpaqueConstraintLink4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CVLSystemVSpecEditorPlugin
				.findImageDescriptor("/org.bangbangbang.cvl.model.edit/icons/full/obj16/ConstraintLine.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
