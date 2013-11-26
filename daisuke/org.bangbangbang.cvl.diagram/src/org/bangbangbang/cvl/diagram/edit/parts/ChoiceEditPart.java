package org.bangbangbang.cvl.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bangbangbang.cvl.diagram.edit.policies.ChoiceCanonicalEditPolicy;
import org.bangbangbang.cvl.diagram.edit.policies.ChoiceItemSemanticEditPolicy;
import org.bangbangbang.cvl.diagram.part.CVLMetamodelVisualIDRegistry;
import org.bangbangbang.cvl.diagram.providers.CVLMetamodelElementTypes;
import org.bangbangbang.cvl.impl.ChoiceImpl;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.GroupRequestViaKeyboard;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class ChoiceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2005;

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
	public ChoiceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated@NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						CVLMetamodelVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ChoiceItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new ChoiceCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			public Command getCommand(Request request) {
				// If the user presses the delete key, don't delete
				if (request instanceof GroupRequestViaKeyboard
						&& RequestConstants.REQ_DELETE.equals(request.getType())) {
					return UnexecutableCommand.INSTANCE;
				}
				return super.getCommand(request);
			}
		});
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
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
		return primaryShape = new ChoiceFigure();
	}

	/**
	 * @generated
	 */
	public ChoiceFigure getPrimaryShape() {
		return (ChoiceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ChoiceNameEditPart) {
			((ChoiceNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureChoiceNameFigure());
			return true;
		}
		if (childEditPart instanceof ChoiceChoiceGroupMultiplicityCompartment2EditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureChoiceGroupMultiplicityCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ChoiceChoiceGroupMultiplicityCompartment2EditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ChoiceNameEditPart) {
			return true;
		}
		if (childEditPart instanceof ChoiceChoiceGroupMultiplicityCompartment2EditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureChoiceGroupMultiplicityCompartmentFigure();
			pane.remove(((ChoiceChoiceGroupMultiplicityCompartment2EditPart) childEditPart)
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
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof ChoiceChoiceGroupMultiplicityCompartment2EditPart) {
			return getPrimaryShape()
					.getFigureChoiceGroupMultiplicityCompartmentFigure();
		}
		return getContentPane();
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

	@Override
	/**
	 * @generated NOT
	 */
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connEditPart) {
		return super.getTargetConnectionAnchor(connEditPart);
	}

	@Override
	/**
	 * @generated NOT
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return super.getTargetConnectionAnchor(request);
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
				if (thisFigure.getChildren().size() > 1) {
					childFigure = (RectangleFigure) thisFigure.getChildren()
							.get(1);
				}
			}
			if (((ChoiceImpl) ((ShapeImpl) ChoiceEditPart.this.getModel())
					.getElement()).getGroupMultiplicity() != null) {
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
				.getType(ChoiceNameEditPart.VISUAL_ID));
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
		if (targetEditPart instanceof org.bangbangbang.cvl.diagram.edit.parts.ChoiceEditPart) {
			types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		}
		if (targetEditPart instanceof Choice2EditPart) {
			types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		}
		if (targetEditPart instanceof VariableEditPart) {
			types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		}
		if (targetEditPart instanceof VClassifierEditPart) {
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
			//types.add(CVLMetamodelElementTypes.Choice_2005);
			types.add(CVLMetamodelElementTypes.Choice_2015);
			types.add(CVLMetamodelElementTypes.Variable_2016);
			types.add(CVLMetamodelElementTypes.VClassifier_2017);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(CVLMetamodelElementTypes.VSpecChild_4001);
		types.add(CVLMetamodelElementTypes.ConstraintContext_4003);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == CVLMetamodelElementTypes.VSpecChild_4001) {
			types.add(CVLMetamodelElementTypes.Choice_2005);
			types.add(CVLMetamodelElementTypes.Choice_2015);
			types.add(CVLMetamodelElementTypes.Variable_2016);
			types.add(CVLMetamodelElementTypes.VClassifier_2017);
		} else if (relationshipType == CVLMetamodelElementTypes.ConstraintContext_4003) {
			types.add(CVLMetamodelElementTypes.OpaqueConstraint_2014);
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
			if (type == CVLMetamodelElementTypes.MultiplicityInterval_3002) {
				return getChildBySemanticHint(CVLMetamodelVisualIDRegistry
						.getType(ChoiceChoiceGroupMultiplicityCompartment2EditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class ChoiceFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureChoiceNameFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureChoiceGroupMultiplicityCompartmentFigure;

		/**
		 * @generated
		 */
		public ChoiceFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setOutline(false);
			this.setFill(false);
			this.setOpaque(false);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(100),
					getMapMode().DPtoLP(0)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RoundedRectangle choiceFigure0 = new RoundedRectangle();

			choiceFigure0.setCornerDimensions(new Dimension(getMapMode()
					.DPtoLP(8), getMapMode().DPtoLP(8)));
			choiceFigure0.setForegroundColor(ColorConstants.black);
			choiceFigure0.setBorder(new MarginBorder(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(9), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));

			this.add(choiceFigure0, BorderLayout.CENTER);

			FlowLayout layoutChoiceFigure0 = new FlowLayout();
			layoutChoiceFigure0.setStretchMinorAxis(false);
			layoutChoiceFigure0.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutChoiceFigure0.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutChoiceFigure0.setMajorSpacing(5);
			layoutChoiceFigure0.setMinorSpacing(5);
			layoutChoiceFigure0.setHorizontal(true);

			choiceFigure0.setLayoutManager(layoutChoiceFigure0);

			fFigureChoiceNameFigure = new WrappingLabel();

			fFigureChoiceNameFigure.setText("<...>");

			choiceFigure0.add(fFigureChoiceNameFigure);

			fFigureChoiceGroupMultiplicityCompartmentFigure = new RectangleFigure();

			fFigureChoiceGroupMultiplicityCompartmentFigure.setOutline(false);
			fFigureChoiceGroupMultiplicityCompartmentFigure.setFill(false);
			fFigureChoiceGroupMultiplicityCompartmentFigure.setOpaque(false);

			this.add(fFigureChoiceGroupMultiplicityCompartmentFigure,
					BorderLayout.BOTTOM);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureChoiceNameFigure() {
			return fFigureChoiceNameFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureChoiceGroupMultiplicityCompartmentFigure() {
			return fFigureChoiceGroupMultiplicityCompartmentFigure;
		}

	}

}
