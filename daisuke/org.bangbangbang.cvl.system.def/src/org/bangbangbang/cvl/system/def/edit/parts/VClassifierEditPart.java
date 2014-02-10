package org.bangbangbang.cvl.system.def.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bangbangbang.cvl.VClassifier;
import org.bangbangbang.cvl.impl.VClassifierImpl;
import org.bangbangbang.cvl.system.def.edit.policies.VClassifierCanonicalEditPolicy;
import org.bangbangbang.cvl.system.def.edit.policies.VClassifierItemSemanticEditPolicy;
import org.bangbangbang.cvl.system.def.part.CVLMetamodelVisualIDRegistry;
import org.bangbangbang.cvl.system.def.providers.CVLMetamodelElementTypes;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class VClassifierEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2004;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public VClassifierEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						CVLMetamodelVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new VClassifierItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new VClassifierCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new VClassifierFigure();
	}

	/**
	 * @generated
	 */
	public VClassifierFigure getPrimaryShape() {
		return (VClassifierFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof VClassifierNameEditPart) {
			((VClassifierNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureVClassifierNameFigure());
			return true;
		}
		if (childEditPart instanceof VClassifierVClassifierGroupMultiplicityCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureVClassifierGroupMultiplicityCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((VClassifierVClassifierGroupMultiplicityCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof VClassifierVClassifierInstanceMultiplicityIntervalCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureVClassifierInstanceMultiplicityCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((VClassifierVClassifierInstanceMultiplicityIntervalCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof VClassifierNameEditPart) {
			return true;
		}
		if (childEditPart instanceof VClassifierVClassifierGroupMultiplicityCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureVClassifierGroupMultiplicityCompartmentFigure();
			pane.remove(((VClassifierVClassifierGroupMultiplicityCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof VClassifierVClassifierInstanceMultiplicityIntervalCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureVClassifierInstanceMultiplicityCompartmentFigure();
			pane.remove(((VClassifierVClassifierInstanceMultiplicityIntervalCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connEditPart) {
		return new ModChopboxAnchor(getFigure());
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new ModChopboxAnchor(getFigure());
	}

	/**
	 * @generated NOT
	 */
	private class ModChopboxAnchor extends ChopboxAnchor {
		/**
		 * @generated NOT
		 */
		public ModChopboxAnchor(IFigure figure) {
			super(figure);
		}

		/**
		 * @generated NOT
		 */
		@Override
		public Point getLocation(Point reference) {
			Figure thisFigure = null, childFigure = null;
			Point p = super.getLocation(reference);
			if (this.getOwner().getChildren().size() > 0) {
				thisFigure = (Figure) this.getOwner().getChildren().get(0);
				if (thisFigure.getChildren().size() > 2) {
					childFigure = (RectangleFigure) thisFigure.getChildren()
							.get(2);
				}
			}
			if (((VClassifierImpl) ((NodeImpl) VClassifierEditPart.this
					.getModel()).getElement()).getGroupMultiplicity() != null) {
				p.x = thisFigure.getBounds().x + thisFigure.getBounds().width
						/ 2;
				p.y = childFigure.getBounds().y + 21;
			} else {
				p.x = thisFigure.getBounds().x + thisFigure.getBounds().width
						/ 2;
				p.y = childFigure.getBounds().y;

			}
			getOwner().translateToAbsolute(p);
			return p;
		}
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof VClassifierVClassifierGroupMultiplicityCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureVClassifierGroupMultiplicityCompartmentFigure();
		}
		if (editPart instanceof VClassifierVClassifierInstanceMultiplicityIntervalCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureVClassifierInstanceMultiplicityCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(CVLMetamodelVisualIDRegistry
				.getType(VClassifierNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ChoiceEditPart) {
			types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		}
		if (targetEditPart instanceof Choice2EditPart) {
			types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		}
		if (targetEditPart instanceof VariableEditPart) {
			types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		}
		if (targetEditPart instanceof org.bangbangbang.cvl.system.def.edit.parts.VClassifierEditPart) {
			types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		}
		if (targetEditPart instanceof CVSpecEditPart) {
			types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == CVLMetamodelElementTypes.VSpecChild_4001) {
			// types.add(CVLMetamodelElementTypes.Choice_2001);
			types.add(CVLMetamodelElementTypes.Choice_2002);
			types.add(CVLMetamodelElementTypes.Variable_2003);
			types.add(CVLMetamodelElementTypes.VClassifier_2004);
			types.add(CVLMetamodelElementTypes.CVSpec_2006);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		types.add(CVLMetamodelElementTypes.ConstraintContext_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == CVLMetamodelElementTypes.VSpecChild_4001) {
			types.add(CVLMetamodelElementTypes.Choice_2001);
			types.add(CVLMetamodelElementTypes.Choice_2002);
			types.add(CVLMetamodelElementTypes.Variable_2003);
			types.add(CVLMetamodelElementTypes.VClassifier_2004);
			types.add(CVLMetamodelElementTypes.CVSpec_2006);
		} else if (relationshipType == CVLMetamodelElementTypes.ConstraintContext_4002) {
			types.add(CVLMetamodelElementTypes.OpaqueConstraint_2005);
		}
		return types;
	}


	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
					.getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter
					.getAdapter(IElementType.class);
			if (type == CVLMetamodelElementTypes.MultiplicityInterval_3004) {
				return getChildBySemanticHint(CVLMetamodelVisualIDRegistry
						.getType(VClassifierVClassifierGroupMultiplicityCompartmentEditPart.VISUAL_ID));
			}
			if (type == CVLMetamodelElementTypes.MultiplicityInterval_3003) {
				return getChildBySemanticHint(CVLMetamodelVisualIDRegistry
						.getType(VClassifierVClassifierInstanceMultiplicityIntervalCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class VClassifierFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureVClassifierNameFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureVClassifierInstanceMultiplicityCompartmentFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureVClassifierGroupMultiplicityCompartmentFigure;

		/**
		 * @generated
		 */
		public VClassifierFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setOutline(false);
			this.setForegroundColor(ColorConstants.white);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure vClassifierFigureLabelContainerFigure0 = new RectangleFigure();

			vClassifierFigureLabelContainerFigure0
					.setForegroundColor(ColorConstants.black);
			vClassifierFigureLabelContainerFigure0.setBorder(new MarginBorder(
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(9),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));

			this.add(vClassifierFigureLabelContainerFigure0, BorderLayout.TOP);

			FlowLayout layoutVClassifierFigureLabelContainerFigure0 = new FlowLayout();
			layoutVClassifierFigureLabelContainerFigure0
					.setStretchMinorAxis(false);
			layoutVClassifierFigureLabelContainerFigure0
					.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutVClassifierFigureLabelContainerFigure0
					.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutVClassifierFigureLabelContainerFigure0.setMajorSpacing(5);
			layoutVClassifierFigureLabelContainerFigure0.setMinorSpacing(5);
			layoutVClassifierFigureLabelContainerFigure0.setHorizontal(true);

			vClassifierFigureLabelContainerFigure0
					.setLayoutManager(layoutVClassifierFigureLabelContainerFigure0);

			fFigureVClassifierNameFigure = new WrappingLabel();

			fFigureVClassifierNameFigure.setText("<...>");

			vClassifierFigureLabelContainerFigure0
					.add(fFigureVClassifierNameFigure);

			fFigureVClassifierInstanceMultiplicityCompartmentFigure = new RectangleFigure();

			fFigureVClassifierInstanceMultiplicityCompartmentFigure
					.setForegroundColor(ColorConstants.black);

			this.add(fFigureVClassifierInstanceMultiplicityCompartmentFigure,
					BorderLayout.CENTER);

			fFigureVClassifierGroupMultiplicityCompartmentFigure = new RectangleFigure();

			fFigureVClassifierGroupMultiplicityCompartmentFigure
					.setOutline(false);
			fFigureVClassifierGroupMultiplicityCompartmentFigure.setFill(false);
			fFigureVClassifierGroupMultiplicityCompartmentFigure
					.setOpaque(false);

			this.add(fFigureVClassifierGroupMultiplicityCompartmentFigure,
					BorderLayout.BOTTOM);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVClassifierNameFigure() {
			return fFigureVClassifierNameFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureVClassifierInstanceMultiplicityCompartmentFigure() {
			return fFigureVClassifierInstanceMultiplicityCompartmentFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureVClassifierGroupMultiplicityCompartmentFigure() {
			return fFigureVClassifierGroupMultiplicityCompartmentFigure;
		}

	}

}
