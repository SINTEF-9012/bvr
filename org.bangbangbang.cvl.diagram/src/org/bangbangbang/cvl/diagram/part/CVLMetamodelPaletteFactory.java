package org.bangbangbang.cvl.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bangbangbang.cvl.diagram.providers.CVLMetamodelElementTypes;
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
		paletteContainer.add(createRootChoice1CreationTool());
		paletteContainer.add(createVSpecChild2CreationTool());
		paletteContainer.add(createVSpecGroupMultiplicity3CreationTool());
		paletteContainer.add(createOpaqueConstraint4CreationTool());
		paletteContainer.add(createOpaqueConstraintLink5CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRootChoice1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.RootChoice1CreationTool_title,
				Messages.RootChoice1CreationTool_desc,
				Collections.singletonList(CVLMetamodelElementTypes.Choice_2005));
		entry.setId("createRootChoice1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CVLMetamodelElementTypes
				.getImageDescriptor(CVLMetamodelElementTypes.Choice_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVSpecChild2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.VSpecChild2CreationTool_title,
				Messages.VSpecChild2CreationTool_desc,
				Collections
						.singletonList(CVLMetamodelElementTypes.VSpecChild_4001));
		entry.setId("createVSpecChild2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CVLMetamodelElementTypes
				.getImageDescriptor(CVLMetamodelElementTypes.VSpecChild_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVSpecGroupMultiplicity3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(CVLMetamodelElementTypes.MultiplicityInterval_3002);
		types.add(CVLMetamodelElementTypes.MultiplicityInterval_3003);
		types.add(CVLMetamodelElementTypes.MultiplicityInterval_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VSpecGroupMultiplicity3CreationTool_title,
				Messages.VSpecGroupMultiplicity3CreationTool_desc, types);
		entry.setId("createVSpecGroupMultiplicity3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CVLMetamodelElementTypes
				.getImageDescriptor(CVLMetamodelElementTypes.MultiplicityInterval_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOpaqueConstraint4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OpaqueConstraint4CreationTool_title,
				Messages.OpaqueConstraint4CreationTool_desc,
				Collections
						.singletonList(CVLMetamodelElementTypes.OpaqueConstraint_2014));
		entry.setId("createOpaqueConstraint4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CVLMetamodelElementTypes
				.getImageDescriptor(CVLMetamodelElementTypes.OpaqueConstraint_2014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOpaqueConstraintLink5CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.OpaqueConstraintLink5CreationTool_title,
				Messages.OpaqueConstraintLink5CreationTool_desc,
				Collections
						.singletonList(CVLMetamodelElementTypes.ConstraintContext_4003));
		entry.setId("createOpaqueConstraintLink5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(CVLMetamodelElementTypes
				.getImageDescriptor(CVLMetamodelElementTypes.ConstraintContext_4003));
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
