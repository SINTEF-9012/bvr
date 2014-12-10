/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.tool.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;
import no.sintef.bvr.tool.checker.ModelChecker;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.DeriveProduct;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.AddMissingResolutions;
import no.sintef.bvr.tool.controller.command.AddResolution;
import no.sintef.bvr.tool.strategy.impl.BindingCalculatorContext;
import no.sintef.bvr.tool.exception.IllegalOperationException;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.exception.UserInputError;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.interfaces.model.IBVRTransactionalVTypeState;
import no.sintef.bvr.tool.interfaces.observer.ResourceObserver;
import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.BoundaryElementBinding;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.ChoiceResolution;
import bvr.ChoiceVSpec;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.Constraint;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.FromReplacement;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.NegResolution;
import bvr.Note;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.PosResolution;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitveType;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentType;
import bvr.Target;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.VClassOccurrence;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.ValueResolution;
import bvr.Variable;
import bvr.Variabletype;
import bvr.VariationPoint;
import bvr.VType;


public class BVRTransactionalModel extends BVRToolModel implements ResourceObserver, ResourceSubject {
	private Resource resource;

	static private int variableCount = 0;
	static private int resolutionCount = 0;
	private NamedElement cutNamedElement = null;
	private HashMap<NegResolution, PosResolution> buffer;
	private List<ResourceObserver> observers;
	

	public BVRTransactionalModel(File sf, no.sintef.ict.splcatool.SPLCABVRModel x) {
		bvrm = x;
		f = sf;
		loadFilename = sf.getAbsolutePath();
		init();
	}

	public BVRTransactionalModel(File sf) {
		f = sf;
		bvrm = new BVRInnerModel(f);
		loadFilename = sf.getAbsolutePath();
		init();
	}

	private void init() {
		observers = new ArrayList<ResourceObserver>();
		minimizedVSpec = new ArrayList<VSpec>();
		minimizedVSpecResolution = new ArrayList<VSpecResolution>();
		buffer = new HashMap<NegResolution, PosResolution>();
		invalidConstraints = new ArrayList<Constraint>();
		checkModel();
	}

	@Override
	public no.sintef.ict.splcatool.SPLCABVRModel getBVRM() {
		return bvrm;
	}

	@Override
	public BVRModel getBVRModel() {
		return bvrm.getRootBVRModel();
	}

	@Override
	public File getFile() {
		return f;
	}

	public Resource getResource() {
		return resource;
	}

	private class BVRInnerModel extends no.sintef.ict.splcatool.SPLCABVRModel {

		public BVRInnerModel(File f) {
			model = loadFromFile(f);
		}

		@Override
		public BVRModel getRootBVRModel() {
			return model;
		}

		private BVRModel loadFromFile(File file) {
			TransactionalEditingDomain editingDomain = Context.eINSTANCE.getEditorCommands().testTransactionalEditingDomain();

			URIConverter converter = new ExtensibleURIConverterImpl();
			URI emptyFileURI = URI.createFileURI(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + File.separator);
			URI emptyPlatformURI = URI.createPlatformResourceURI("/", false);
			converter.getURIMap().put(emptyFileURI, emptyPlatformURI);
			URI platformURI = converter.normalize(URI.createFileURI(file.getAbsolutePath()));

			resource = editingDomain.getResourceSet().getResource(platformURI, true);
			resource.setTrackingModification(true);

			return (BVRModel) resource.getContents().get(0);
		}

		public void writeToFile(String filename) throws IOException {

			TransactionalEditingDomain editingDomain = Context.eINSTANCE.getEditorCommands().testTransactionalEditingDomain();

			URIConverter converter = new ExtensibleURIConverterImpl();
			URI emptyFileURI = URI.createFileURI(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + File.separator);
			URI emptyPlatformURI = URI.createPlatformResourceURI("/", false);
			converter.getURIMap().put(emptyFileURI, emptyPlatformURI);
			URI platformURI = converter.normalize(URI.createFileURI(filename));

			resource = editingDomain.getResourceSet().getResource(platformURI, true);
			resource.setTrackingModification(true);

			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMIResource.OPTION_ENCODING, "UTF-8");
			resource.save(options);
		}

	}

	@Override
	public void update(ResourceSubject subject) {
		if (subject instanceof ResourceSetEditedSubject) {
			checkModel();
		}
	}

	private void checkModel() {
		Job job = new Job("Checking model") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Status status = new Status(Status.OK, Constants.PLUGIN_ID, "OK!");
				try {
					Context.eINSTANCE.problemLogger.resetLogger();
					ModelChecker.eINSTANCE.execute(getBVRModel());
				} catch (Exception error) {
					Context.eINSTANCE.logger.error("Model check failed", error);
					status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Model check failed (see log for more details): " + error.getMessage(),
							error);
				}
				return status;
			}
		};
		job.schedule();
	}

	private EList<EObject> calculateInnerFragmentElements(EList<EObject> outsideInside, EList<EObject> outsideOutside, EList<EObject> inside,
			EList<EObject> visited) {
		for (EObject eObject : inside) {
			EList<EReference> links = new BasicEList<EReference>(eObject.eClass().getEAllReferences());
			EList<EObject> refobjects = getReferencedEObjects(eObject, links);
			refobjects.addAll(eObject.eContents());
			if (!outsideInside.contains(eObject) && !outsideOutside.contains(eObject) && !visited.contains(eObject)) {
				visited.add(eObject);
				visited = calculateInnerFragmentElements(outsideInside, outsideOutside, refobjects, visited);
			}
		}
		return visited;
	}

	private EList<EObject> getReferencedEObjects(EObject source, EList<EReference> links) {
		EList<EObject> eObjects = new BasicEList<EObject>();
		for (EReference link : links) {
			if (CommonUtility.isDerived(link) == 0) {
				Object value = source.eGet(link);
				if (value instanceof EObject) {
					eObjects.add((EObject) value);
				} else if (value instanceof EObjectEList) {
					eObjects.addAll((EList<? extends EObject>) value);
				} else if (value != null) {
					Context.eINSTANCE.logger.debug("reference " + link + " does not point to EObject nor EObjectList :" + value);
				}
			}
		}
		return eObjects;
	}

	private EList<HashMap<EObject, Integer>> markObjects(EList<EObject> outsideInsideElements, EList<EObject> outsideOutsideElements,
			EList<EObject> insideElements, boolean isPlacement) {
		EList<HashMap<EObject, Integer>> objectsToHL = new BasicEList<HashMap<EObject, Integer>>();
		int fragment = (isPlacement) ? IBVREnabledEditor.HL_PLACEMENT : IBVREnabledEditor.HL_REPLACEMENT;
		int fragment_in = (isPlacement) ? IBVREnabledEditor.HL_PLACEMENT_IN : IBVREnabledEditor.HL_REPLACEMENT_IN;
		int fragment_out = (isPlacement) ? IBVREnabledEditor.HL_PLACEMENT_OUT : IBVREnabledEditor.HL_REPLACEMENT_OUT;
		for (EObject eObject : outsideInsideElements) {
			HashMap<EObject, Integer> objectsToH = new HashMap<EObject, Integer>();
			objectsToH.put(eObject, fragment_in);
			objectsToHL.add(objectsToH);
		}
		for (EObject eObject : insideElements) {
			HashMap<EObject, Integer> objectsToH = new HashMap<EObject, Integer>();
			objectsToH.put(eObject, fragment);
			objectsToHL.add(objectsToH);
		}
		for (EObject eObject : outsideOutsideElements) {
			HashMap<EObject, Integer> objectsToH = new HashMap<EObject, Integer>();
			objectsToH.put(eObject, fragment_out);
			objectsToHL.add(objectsToH);
		}
		return objectsToHL;
	}

	private EList<HashMap<EObject, Integer>> getBoundaryObjectsToHighlight(NamedElement boundary) throws IllegalOperationException {
		EList<HashMap<EObject, Integer>> list = new BasicEList<HashMap<EObject, Integer>>();
		if (boundary instanceof ToPlacement || boundary instanceof ToReplacement) {
			boolean isToPlacement = (boundary instanceof ToPlacement) ? true : false;
			if (!isToPlacement && LoaderUtility.isNullBoundary(boundary))
				return list;

			EObject eObject = (isToPlacement) ? ((ToPlacement) boundary).getOutsideBoundaryElement().getMOFRef() : ((ToReplacement) boundary)
					.getOutsideBoundaryElement().getMOFRef();
			if (eObject != null) {
				HashMap<EObject, Integer> map = new HashMap<EObject, Integer>();
				map.put(eObject, (isToPlacement) ? IBVREnabledEditor.HL_PLACEMENT_IN : IBVREnabledEditor.HL_REPLACEMENT_IN);
				list.add(map);
			} else {
				Context.eINSTANCE.logger.error("outside boundary element reference is null for toBoundary" + boundary);
			}

			EList<ObjectHandle> objectHandles = (isToPlacement) ? ((ToPlacement) boundary).getInsideBoundaryElement() : ((ToReplacement) boundary)
					.getInsideBoundaryElement();
			for (ObjectHandle oh : objectHandles) {
				eObject = oh.getMOFRef();
				if (eObject != null) {
					HashMap<EObject, Integer> map = new HashMap<EObject, Integer>();
					map.put(eObject, (isToPlacement) ? IBVREnabledEditor.HL_PLACEMENT : IBVREnabledEditor.HL_REPLACEMENT);
					list.add(map);
				} else {
					Context.eINSTANCE.logger.error("inside boundary element reference is null for toBoundary" + boundary);
				}
			}
		} else if (boundary instanceof FromPlacement || boundary instanceof FromReplacement) {
			boolean isFromPlacement = (boundary instanceof FromPlacement) ? true : false;
			if (isFromPlacement && LoaderUtility.isNullBoundary(boundary))
				return list;

			EObject eObject = (isFromPlacement) ? ((FromPlacement) boundary).getInsideBoundaryElement().getMOFRef() : ((FromReplacement) boundary)
					.getInsideBoundaryElement().getMOFRef();
			if (eObject != null) {
				HashMap<EObject, Integer> map = new HashMap<EObject, Integer>();
				map.put(eObject, (isFromPlacement) ? IBVREnabledEditor.HL_PLACEMENT : IBVREnabledEditor.HL_REPLACEMENT);
				list.add(map);
			} else {
				Context.eINSTANCE.logger.error("inside boundary element reference is null for fromBoundary" + boundary);
			}

			EList<ObjectHandle> objectHandles = (isFromPlacement) ? ((FromPlacement) boundary).getOutsideBoundaryElement()
					: ((FromReplacement) boundary).getOutsideBoundaryElement();
			for (ObjectHandle oh : objectHandles) {
				eObject = oh.getMOFRef();
				if (eObject != null) {
					HashMap<EObject, Integer> map = new HashMap<EObject, Integer>();
					map.put(eObject, (isFromPlacement) ? IBVREnabledEditor.HL_PLACEMENT_OUT : IBVREnabledEditor.HL_REPLACEMENT_OUT);
					list.add(map);
				} else {
					Context.eINSTANCE.logger.error("outside boundary element reference is null for fromBoundary" + boundary);
				}
			}
		}
		return list;
	}

	@Override
	public void addChoice(NamedElement parent) {
		VSpecFacade.eINSTANCE.appendChoice(parent);
	}
	
	@Override
	public void addChoiceOrVClassifierResolution(VSpec resolvedVspec, VSpecResolution parent) {
		ChoiceResolution cr = null;
		if (resolvedVspec instanceof Choice) {
			cr = BvrFactory.eINSTANCE.createNegResolution();
			cr.setName(resolvedVspec.getName());
		} else if (resolvedVspec instanceof VClassifier) {
			cr = BvrFactory.eINSTANCE.createPosResolution();
			cr.setName("I: " + getIncrementedInstanceCount());
		} else if (resolvedVspec instanceof ChoiceOccurrence) {
			cr = BvrFactory.eINSTANCE.createPosResolution();
			cr.setName(resolvedVspec.getName());
		} else if (resolvedVspec instanceof VClassOccurrence) {
			cr = BvrFactory.eINSTANCE.createPosResolution();
			cr.setName(resolvedVspec.getName());
		}
		CommonUtility.setResolved(cr, resolvedVspec);
		Context.eINSTANCE.getEditorCommands().addChoiceResoulution(parent, cr);
	}

	@Override
	public void minimaizeVSpec(VSpec vspec) {
		minimizedVSpec.add(vspec);
	}

	@Override
	public void maximizeVSpec(VSpec vspec) {
		minimizedVSpec.remove(vspec);
	}

	@Override
	public boolean isVSpecMinimized(VSpec vspec) {
		return minimizedVSpec.contains(vspec);
	}

	@Override
	public void minimaizeVSpecResolution(VSpecResolution vspecRes) {
		minimizedVSpecResolution.add(vspecRes);
	}

	@Override
	public void maximizeVSpecResolution(VSpecResolution vspecRes) {
		minimizedVSpecResolution.remove(vspecRes);
	}

	@Override
	public boolean isVSpecResolutionMinimized(VSpecResolution vspecRes) {
		return minimizedVSpecResolution.contains(vspecRes);
	}

	@Override
	public void updateVariable(Variable variable, String name, String typeName) {
		PrimitiveTypeFacade.getInstance().testModelsPrimitiveTypes(getBVRModel());

		if (name.equals("")) {
			Context.eINSTANCE.getEditorCommands().removeVSpecVariable((VSpec) variable.eContainer(), variable);
			return;
		}

		Context.eINSTANCE.getEditorCommands().setName(variable, name);

		PrimitiveTypeEnum t = null;
		for (PrimitiveTypeEnum x : PrimitiveTypeEnum.VALUES) {
			if (x.getName().equals(typeName)) {
				t = x;
			}
		}

		if (t == null)
			throw new UnsupportedOperationException("Invalid primitive type name " + typeName);

		PrimitveType primitivType = PrimitiveTypeFacade.getInstance().testPrimitiveType(getBVRModel(), t);
		Context.eINSTANCE.getEditorCommands().setTypeForVariable(variable, primitivType);
	}

	@Override
	public void updateName(NamedElement namedElement, String name) {
		// update corresponding target accordingly if namedElement is VClassifier or Choice
		if (namedElement instanceof VClassifier || namedElement instanceof Choice) {
			Target target = TargetFacade.eINSTANCE.testVSpecTarget((VSpec) namedElement);
			Context.eINSTANCE.getEditorCommands().setName(target, name);
		}
		if(namedElement.getName() == null || !namedElement.getName().equals(name)){
			Context.eINSTANCE.getEditorCommands().setName(namedElement, name);
		}
	}

	@Override
	public void updateComment(NamedElement namedElement, String text) {
		Note commentNote = NoteFacade.eINSTANCE.testCommentNote(namedElement);
		Context.eINSTANCE.getEditorCommands().updateNoteExp(commentNote, text);
	}

	@Override
	public String getNodesCommentText(NamedElement namedElement) {
		return NoteFacade.eINSTANCE.getCommentText(namedElement);
	}

	@Override
	public void addVariable(VNode parentNode) {
		Variable var = BvrFactory.eINSTANCE.createVariable();

		PrimitveType primitivType = PrimitiveTypeFacade.getInstance().testPrimitiveType(getBVRModel(), PrimitiveTypeEnum.INTEGER);
		var.setName("Var" + variableCount);
		variableCount++;
		var.setType(primitivType);

		Context.eINSTANCE.getEditorCommands().addVariable(parentNode, var);
	}

	@Override
	public void setVClassifierLowerBound(VClassifier vClassifier, int lowerBound) {
		MultiplicityInterval interval = vClassifier.getInstanceMultiplicity();
		Context.eINSTANCE.getEditorCommands().setGroupMultiplicityLowerBound(interval, lowerBound);
	}

	@Override
	public void setVClassifierUpperBound(VClassifier vClassifier, int upperBound) {
		MultiplicityInterval interval = vClassifier.getInstanceMultiplicity();
		Context.eINSTANCE.getEditorCommands().setGroupMultiplicityUpperBound(interval, upperBound);
	}

	@Override
	public void addVClassifier(NamedElement parent) {
		VSpecFacade.eINSTANCE.appendVClassifier(parent);
	}

	@Override
	public void addBCLConstraint(VNode parentVNode) {
		ConstraintFacade.eINSTANCE.createBCLConstraint(parentVNode);
	}

	@Override
	public void updateBCLConstraint(BCLConstraint constraint, String strConstr) {
		ConstraintFacade.eINSTANCE.updateBCLConstraint(bvrm.getRootBVRModel(), constraint, strConstr);
	}

	@Override
	public void toggleChoiceOptionalMandotary(ChoiceVSpec choice) {
		Context.eINSTANCE.getEditorCommands().setIsImpliedByParent(choice, !choice.isIsImpliedByParent());
	}

	@Override
	public void cutNamedElement(NamedElement namedElement) {
		EObject parent = namedElement.eContainer();
		if (namedElement instanceof VNode) {
			if (parent instanceof CompoundNode && namedElement instanceof VNode) {
				Context.eINSTANCE.getEditorCommands().removeVNodeCompoundNode((CompoundNode) parent, (VNode) namedElement);
			} else if (parent instanceof BVRModel && namedElement instanceof CompoundNode) {
				Context.eINSTANCE.getEditorCommands().removeVariabilityModelBVRModel((BVRModel) parent, (CompoundNode) namedElement);
			} else {
				throw new UnexpectedException("not supported operation");
			}
		} else {
			throw new UnsupportedOperationException("Cut is not implemented for anything other than VNode " + namedElement);
		}
		cutNamedElement = namedElement;
	}

	@Override
	public void pastNamedElementAsChild(NamedElement parent) {
		if (cutNamedElement != null) {
			if (parent instanceof CompoundNode && cutNamedElement instanceof VNode) {
				Context.eINSTANCE.getEditorCommands().addVNodeToCompoundNode((CompoundNode) parent, (VNode) cutNamedElement);
			} else if (parent instanceof BVRModel && cutNamedElement instanceof CompoundNode) {
				Context.eINSTANCE.getEditorCommands().addVariabilityModelToBVRModel((BVRModel) parent, (CompoundNode) cutNamedElement);
			} else {
				throw new UnexpectedException("not supported operation");
			}
			cutNamedElement = null;
		}
	}

	@Override
	public void pastNamedElementAsSibling(NamedElement sibling) {
		if (cutNamedElement != null) {
			EObject parent = sibling.eContainer();
			if (parent instanceof CompoundNode && cutNamedElement instanceof VNode) {
				Context.eINSTANCE.getEditorCommands().addVNodeToCompoundNode((CompoundNode) parent, (VNode) cutNamedElement);
			} else {
				throw new UnexpectedException("not supported operation");
			}
			cutNamedElement = null;
		}
	}

	@Override
	public void setGroupMultiplicity(VNode parent, int lowerBound, int upperBound) {
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(lowerBound);
		mi.setUpper(upperBound);
		Context.eINSTANCE.getEditorCommands().setVNodeGroupMultiplicity(parent, mi);
	}

	@Override
	public void removeGroupMultiplicity(VNode parent) {
		Context.eINSTANCE.getEditorCommands().setVNodeGroupMultiplicity(parent, null);
	}

	@Override
	public String getBCLConstraintString(BCLConstraint constraint) {
		String str = ConstraintFacade.eINSTANCE.getBCLConstraintString(bvrm.getRootBVRModel(), constraint);
		return ConstraintFacade.eINSTANCE.formatConstraintString(str, 15);
	}

	@Override
	public void removeNamedElement(NamedElement element) {
		EObject parent = element.eContainer();
		if (parent != null) {
			if (parent instanceof VNode) {
				if (element instanceof Constraint) {
					Context.eINSTANCE.getEditorCommands().removeConstraintVNode((VNode) parent, (Constraint) element);
				} else if (element instanceof VNode && parent instanceof CompoundNode) {
					Context.eINSTANCE.getEditorCommands().removeVNodeCompoundNode((CompoundNode) parent, (VNode) element);
				} else {
					throw new UnexpectedException("can not remove " + element + " with parent " + parent);
				}
			} else if (parent instanceof BVRModel) {
				Context.eINSTANCE.getEditorCommands().removeVariabilityModelBVRModel((BVRModel) parent, (CompoundNode) element);
			} else {
				throw new UnexpectedException("can not remove " + element + " with parent " + parent);
			}
		} else {
			throw new UnexpectedException("can not find parent element to remove " + element);
		}
	}

	@Override
	public void deletePlacements(EList<VariationPoint> placements) {
		if (placements.size() > 0)
			Context.eINSTANCE.getEditorCommands().removeOwenedVariationPoints(getBVRModel(), placements);
	}

	@Override
	public void deleteReplacements(EList<Variabletype> replacements) {
		if (replacements.size() > 0)
			Context.eINSTANCE.getEditorCommands().removeOwnedVariationTypes(getBVRModel(), replacements);
	}

	@Override
	public void deleteFragments(EList<VariationPoint> fslist) {
		if (fslist.size() > 0)
			Context.eINSTANCE.getEditorCommands().removeOwenedVariationPoints(getBVRModel(), fslist);
	}

	@Override
	public void createFragmentSubstitution(PlacementFragment placement, ReplacementFragmentType replacement) {
		FragmentSubstitution fs = SubstitutionFragmentFacade.eINSTANCE.createFragmentSubstitution();
		fs.setPlacement(placement);
		fs.setReplacement(replacement);
		Context.eINSTANCE.getEditorCommands().addRealizationVariationPoint(getBVRModel(), fs);
	}

	@Override
	public void generateBindings(FragmentSubstitution fragmentSubstitution) {
		BindingCalculatorContext bindingCalculator = new BindingCalculatorContext();
		bindingCalculator.generateBindings(fragmentSubstitution);
	}

	@Override
	public void updateFragmentSubstitutionBinding(VariationPoint vp, VSpec vSpec) {
		Context.eINSTANCE.getEditorCommands().setBindingVariationPoint(vp, vSpec);
	}

	@Override
	public EList<HashMap<EObject, Integer>> findFragmentElementsToHighlight(NamedElement fragment) {
		EList<HashMap<EObject, Integer>> objectsToHighlightList = new BasicEList<HashMap<EObject, Integer>>();
		if (!Context.eINSTANCE.getConfig().isHighlightingMode())
			return objectsToHighlightList;

		if (fragment instanceof PlacementFragment) {
			PlacementFragment placement = (PlacementFragment) fragment;
			EList<PlacementBoundaryElement> boundaries = placement.getPlacementBoundaryElement();
			EList<EObject> outsideInsideElements = new BasicEList<EObject>();
			EList<EObject> outsideOutsideElements = new BasicEList<EObject>();
			EList<EObject> insideElements = new BasicEList<EObject>();
			for (PlacementBoundaryElement boundary : boundaries) {
				if (boundary instanceof ToPlacement) {
					ToPlacement toPlacement = (ToPlacement) boundary;
					if (!LoaderUtility.isNullBoundary(toPlacement)) {
						EObject eObject = toPlacement.getOutsideBoundaryElement().getMOFRef();
						if (eObject == null) {
							Context.eINSTANCE.logger.error("outside boundary element refrence is null for toPlacement" + toPlacement);
						} else {
							outsideInsideElements.add(eObject);
						}
						EList<ObjectHandle> objectHandles = toPlacement.getInsideBoundaryElement();
						for (ObjectHandle objectHandle : objectHandles) {
							eObject = objectHandle.getMOFRef();
							if (eObject == null) {
								Context.eINSTANCE.logger.error("inside boundary element refrence is null for toPlacement" + toPlacement);
							} else {
								insideElements.add(eObject);
							}
						}
					} else {
						Context.eINSTANCE.logger.error("toPlacement can not be null boundary, placement " + placement);
					}
				}
				if (boundary instanceof FromPlacement) {
					FromPlacement fromPlacement = (FromPlacement) boundary;
					if (!LoaderUtility.isNullBoundary(fromPlacement)) {
						EObject eObject = fromPlacement.getInsideBoundaryElement().getMOFRef();
						if (eObject == null) {
							Context.eINSTANCE.logger.error("inside boundary element refrence is null for fromPlacement" + fromPlacement);
						} else {
							insideElements.add(eObject);
						}
						EList<ObjectHandle> objectHandles = fromPlacement.getOutsideBoundaryElement();
						for (ObjectHandle objectHandle : objectHandles) {
							eObject = objectHandle.getMOFRef();
							if (eObject == null) {
								Context.eINSTANCE.logger.error("outside boundary element refrence is null for fromPlacement" + fromPlacement);
							} else {
								outsideOutsideElements.add(eObject);
							}
						}
					}
				}
			}
			insideElements = calculateInnerFragmentElements(outsideInsideElements, outsideOutsideElements, insideElements, new BasicEList<EObject>());
			objectsToHighlightList.addAll(markObjects(outsideInsideElements, outsideOutsideElements, insideElements, true));
		}
		if (fragment instanceof ReplacementFragmentType) {
			ReplacementFragmentType replacement = (ReplacementFragmentType) fragment;
			EList<ReplacementBoundaryElement> boundaries = replacement.getReplacementBoundaryElement();
			EList<EObject> outsideInsideElements = new BasicEList<EObject>();
			EList<EObject> outsideOutsideElements = new BasicEList<EObject>();
			EList<EObject> insideElements = new BasicEList<EObject>();
			for (ReplacementBoundaryElement boundary : boundaries) {
				if (boundary instanceof ToReplacement) {
					ToReplacement toReplacement = (ToReplacement) boundary;
					if (!LoaderUtility.isNullBoundary(toReplacement)) {
						EObject eObject = toReplacement.getOutsideBoundaryElement().getMOFRef();
						if (eObject == null) {
							Context.eINSTANCE.logger.debug("outside boundary element refrence is null for toReplacement" + toReplacement);
						} else {
							outsideInsideElements.add(eObject);
						}
						EList<ObjectHandle> objectHandles = toReplacement.getInsideBoundaryElement();
						for (ObjectHandle objectHandle : objectHandles) {
							eObject = objectHandle.getMOFRef();
							if (eObject == null) {
								Context.eINSTANCE.logger.debug("inside boundary element refrence is null for toReplacement" + toReplacement);
							} else {
								insideElements.add(eObject);
							}
						}
					}
				}
				if (boundary instanceof FromReplacement) {
					FromReplacement fromReplacement = (FromReplacement) boundary;
					if (!LoaderUtility.isNullBoundary(fromReplacement)) {
						EObject eObject = fromReplacement.getInsideBoundaryElement().getMOFRef();
						if (eObject == null) {
							Context.eINSTANCE.logger.debug("inside boundary element refrence is null for fromReplacement" + fromReplacement);
						} else {
							insideElements.add(eObject);
						}
						EList<ObjectHandle> objectHandles = fromReplacement.getOutsideBoundaryElement();
						for (ObjectHandle objectHandle : objectHandles) {
							eObject = objectHandle.getMOFRef();
							if (eObject == null) {
								Context.eINSTANCE.logger.debug("outside boundary element refrence is null for fromReplacement" + fromReplacement);
							} else {
								outsideOutsideElements.add(eObject);
							}
						}
					} else {
						Context.eINSTANCE.logger.debug("fromPlacement can not be null boundary, replacement " + replacement);
					}
				}
			}
			insideElements = calculateInnerFragmentElements(outsideInsideElements, outsideOutsideElements, insideElements, new BasicEList<EObject>());
			objectsToHighlightList.addAll(this.markObjects(outsideInsideElements, outsideOutsideElements, insideElements, false));
		}
		return objectsToHighlightList;
	}

	@Override
	public void highlightElements(EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		if (!Context.eINSTANCE.getConfig().isHighlightingMode())
			return;
		Context.eINSTANCE.highlightObjects(objectsToHighlightList);
	}

	@Override
	public EList<HashMap<EObject, Integer>> findBoundaryElementsToHighlight(NamedElement binding) {
		EList<HashMap<EObject, Integer>> objectsToHighlightList = new BasicEList<HashMap<EObject, Integer>>();
		if (!Context.eINSTANCE.getConfig().isHighlightingMode())
			return objectsToHighlightList;

		if (binding instanceof ToBinding) {
			ToBinding toBinding = (ToBinding) binding;
			ToPlacement toPlacement = toBinding.getToPlacement();
			ToReplacement toReplacement = toBinding.getToReplacement();
			objectsToHighlightList.addAll(getBoundaryObjectsToHighlight(toPlacement));
			objectsToHighlightList.addAll(getBoundaryObjectsToHighlight(toReplacement));
		} else {
			FromBinding fromBinding = (FromBinding) binding;
			FromPlacement fromPlacement = fromBinding.getFromPlacement();
			FromReplacement fromReplacement = fromBinding.getFromReplacement();
			objectsToHighlightList.addAll(getBoundaryObjectsToHighlight(fromPlacement));
			objectsToHighlightList.addAll(getBoundaryObjectsToHighlight(fromReplacement));
		}
		return objectsToHighlightList;
	}

	@Override
	public void updateBindingBoundary(BoundaryElementBinding binding, NamedElement boundary) {
		if (binding instanceof ToBinding && boundary instanceof ToReplacement) {
			ToBinding toBinding = (ToBinding) binding;
			Context.eINSTANCE.getEditorCommands().setToBindingToReplacement(toBinding, (ToReplacement) boundary);
		} else if (binding instanceof FromBinding && boundary instanceof FromPlacement) {
			FromBinding fromBinding = (FromBinding) binding;
			Context.eINSTANCE.getEditorCommands().setFromBindingFromPlacement(fromBinding, (FromPlacement) boundary);
		} else {
			throw new UnexpectedException("binding or boundary is not of the right type");
		}
	}

	@Override
	public CompoundResolution createResolution() {
		BVRModel model = getBVRModel();
		if (model.getVariabilityModel() == null)
			throw new UserInputError("there is not variability model yet, nothing to resolve");

		PosResolution root = BvrFactory.eINSTANCE.createPosResolution();

		CompoundNode variablityModel = model.getVariabilityModel();

		if (variablityModel instanceof Choice) {
			CommonUtility.setResolved(root, (VSpec) variablityModel);
			root.setName(((NamedElement) variablityModel).getName() + "[" + resolutionCount +"]");
			resolutionCount++;
			ResolutionModelIterator.getInstance().iterateEmptyOnChildren(this, new AddResolution(), (VSpec) root.getResolvedChoice(), root, false);
		} else {
			throw new UserInputError("model must start with a choice");
		}
		return root;
	}

	@Override
	public void addResolutionModel(CompoundResolution root) {
		BVRModel model = getBVRModel();
		Context.eINSTANCE.getEditorCommands().createNewResolution((PosResolution) root, model);
	}

	@Override
	public void removeRootResolution(int resolutionIndex) {
		BVRModel model = getBVRModel();
		CompoundResolution resolution = model.getResolutionModels().get(resolutionIndex);
		Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolution(model, resolution);
	}

	@Override
	public void removeAllResolutions() {
		BVRModel model = getBVRModel();
		EList<CompoundResolution> resolutions = new BasicEList<CompoundResolution>();
		for (CompoundResolution cr : model.getResolutionModels()) {
			if (cr instanceof PosResolution)
				resolutions.add(cr);
		}
		Context.eINSTANCE.getEditorCommands().removeBVRModelCompoundResolutions(model, resolutions);
	}
	
	public void resolveSubtree(VSpecResolution parent) {
		VSpecResolution grandParent = ResolutionModelIterator.getInstance().getParent(getBVRModel(), (VSpecResolution) parent);
		if (grandParent == null) {
			for(Iterator<CompoundResolution> it = getBVRModel().getResolutionModels().iterator(); it.hasNext(); ){
				CompoundResolution c = it.next();
				if (c == parent) {
					VSpecResolution root = CloneResFacade.getResolution().cloneItStart((VSpecResolution) parent, this);
					ResolutionModelIterator.getInstance().iterateEmptyOnChildren(this, new AddMissingResolutions(), parent.getResolvedVSpec(), root, false);
					
					
					Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolution(getBVRModel(), (VSpecResolution) parent);
					Context.eINSTANCE.getEditorCommands().createNewResolution((PosResolution) root, getBVRModel());
				}
			}
		}
		else{
			VSpecResolution root = CloneResFacade.getResolution().cloneItStart((VSpecResolution) parent, this);
			ResolutionModelIterator.getInstance().iterateEmptyOnChildren(this, new AddMissingResolutions(), parent.getResolvedVSpec(), root, false);
			
			
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(grandParent, parent);
			if (parent instanceof PosResolution) {
				Context.eINSTANCE.getEditorCommands().addChoiceResoulution( grandParent, (PosResolution) root);
				InheritanceFacade.getInstance().passInheritance((ChoiceResolution)root, (root instanceof PosResolution), this);
			}
			else if(parent instanceof NegResolution){
				Context.eINSTANCE.getEditorCommands().addChoiceResoulution(grandParent, (NegResolution) root);
				InheritanceFacade.getInstance().passInheritance((ChoiceResolution)root, (root instanceof PosResolution), this);
			}/* else if (parent instanceof VariableValueAssignment) {
			}
				Context.eINSTANCE.getEditorCommands().addVariableValueAssignment(grandParent, (VariableValueAssignment) root);

			} else if (parent instanceof VInstance) {
				Context.eINSTANCE.getEditorCommands().addVInstance(grandParent, (VInstance) root);
				
				

			}*/
		}
		
	}

	public void removeVSpecResolution(NamedElement toDelete) {
		NamedElement parentNamedElement = ResolutionModelIterator.getInstance().getParent(getBVRModel(), (VSpecResolution) toDelete);
		Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution((VSpecResolution) parentNamedElement, toDelete);
	}

	public void toggleChoice(NamedElement toToggle) {
		EObject parent = toToggle.eContainer();
		if(!(parent instanceof ChoiceResolution))
			return;

		if (toToggle instanceof ChoiceResolution) {
			if(toToggle instanceof PosResolution) {
				ChoiceResolution negResolution = ChangeChoiceFacade.eINSTANCE.setChoiceResolution((ChoiceResolution) toToggle, !(toToggle instanceof PosResolution), this);
				buffer.put((NegResolution) negResolution, (PosResolution) toToggle);
			} else {
				PosResolution buffered = buffer.remove((NegResolution) toToggle);
				if(buffered != null) {
					ChangeChoiceFacade.eINSTANCE.replaceChoiceResolution((ChoiceResolution) parent, (ChoiceResolution) toToggle, (ChoiceResolution) buffered);
				} else {
					ChangeChoiceFacade.eINSTANCE.setChoiceResolution((ChoiceResolution) toToggle, !(toToggle instanceof PosResolution), this);
					InheritanceFacade.getInstance().passInheritance((ChoiceResolution) toToggle, true, this);
				}
			}
		}
	}
	
	@Override
	public void resolveVariable(CompoundResolution compountResolution, Variable variable) {
		ValueResolution valueResolution = PrimitiveTypeFacade.getInstance().createDefaultValueResolution(variable);
		Context.eINSTANCE.getEditorCommands().addValueResolution(compountResolution, valueResolution);
	}
	
	@Override
	public void toggleShowConstraints() {
		showConstraints = !showConstraints;
	}
	
	@Override
	public boolean showConstraints(){
		return showConstraints;
	}

	@Override
	public boolean isResolutionModelSet() {
		return (getBVRModel().getResolutionModels().size() > 0) ? true : false;
	}

	@Override
	public void setValueResolution(ValueResolution valueResoultion, String value) {
		PrimitiveTypeFacade.getInstance().testPrimitiveValSpecValueResolution(valueResoultion, value);
	}

	@Override
	public String getValueResolutionAsString(ValueResolution namedElement) {
		return PrimitiveTypeFacade.getInstance().getValueAsString(namedElement);
	}

	@Override
	public void setValueResolutionName(ValueResolution namedElement, String name) {
		if(namedElement.getName().equals(name))
			return;
		Context.eINSTANCE.getEditorCommands().setName(namedElement, name);
	}

	@Override
	public int getResolvedVClassifierCount(CompoundResolution compoundResolution, VClassifier vclassifier) {
		int currentInstances = 0;
		for (VSpecResolution x : compoundResolution.getMembers()) {
			if (x.getResolvedVSpec() == vclassifier) {
				if (x.getResolvedVSpec() == vclassifier) {
					currentInstances++;
				}
			}
		}
		return currentInstances;
	}

	@Override
	public void addChoiceOrVClassifierResolution(VSpec vSpecToResolve,
			VSpecResolution parentNamedElement, int instancesToResolve) {
		for(int i = 0; i < instancesToResolve; i++)
			addChoiceOrVClassifierResolution(vSpecToResolve, parentNamedElement);
	}
	
	@Override
	public List<String> validateChoiceResolution(VSpecResolution vSpecResolution) {
		Validate validator = new Validator();
		validator.validate(this, vSpecResolution);
		List<Constraint> invalidConstaraints = validator.getInvalidConstraints();
		List<String> messages = new ArrayList<String>(); 
		if(invalidConstaraints.size() == 0)
			return messages;
		
		for(Constraint constraint : invalidConstaraints) {
			List<String> errors = validator.getConstraintValidationResultMessage(constraint);
			messages.addAll(errors);
		}
		
		return messages;
	}
	
	@Override
	public void executeResolution(File destFile, int index) {
		if(index < 0 || getBVRModel().getResolutionModels().size() < index)
			throw new UnexpectedException("can not find resolution to execute " + index);
		
		if(destFile == null)
			throw new UnexpectedException("destinition file is not defined for a product" + destFile);
		
		final File destinationFile = destFile;
		final int resolutionIndex = index;
		Context.eINSTANCE.getEditorCommands().executeSimpleExeCommand(new SimpleExeCommandInterface() {
			
			@Override
			public void execute() {
				File newFile = new File(getFile().getAbsolutePath() + "_tmp");
				BVREmptyModel tmpModel = new BVREmptyModel(newFile);
				tmpModel.setBVRModel(EcoreUtil.copy(getBVRModel()));
				try {
					Context.eINSTANCE.writeModelToFile(tmpModel, tmpModel.getFile());
					Context.eINSTANCE.reloadModel(tmpModel);
					executeProduct(tmpModel, (PosResolution) tmpModel.getBVRModel().getResolutionModels().get(resolutionIndex), destinationFile);
				} catch (Exception error) {
					Context.eINSTANCE.logger.error("Failed to execute product, resason : " + error.getMessage(), error);
					throw new RethrownException("Failed to execute product, resason : " + error.getMessage(), error);
				} finally {
					Context.eINSTANCE.nullSetModel(tmpModel);
				}
			}

		});
	}
	
	private void executeProduct(BVRToolModel tmpModel, PosResolution resolutionToExecute, File destFile){
		HashMap<String, Object> keywords = new HashMap<String, Object>();
		keywords.put("model", tmpModel.getBVRModel());
		keywords.put("PosResolution", resolutionToExecute);
		keywords.put("bvrModel", tmpModel);
		keywords.put("destFile", destFile);
				
		DeriveProduct deriviator = new DeriveProduct(keywords);
		deriviator.run();
	}
	
	@Override
	public void clearHighlightedObjects() {
		Context.eINSTANCE.clearHighlights();
	}

	@Override
	public void attach(ResourceObserver observer) {
		observers.add(observer);
		
	}

	@Override
	public void detach(ResourceObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(ResourceObserver observer : observers)
			observer.update(this);
	}
	
	@Override
	public void modifyVType(VNode vNode, VType vType){
		IBVRTransactionalVTypeState<VNode, VType> state = new VTypeState<VNode, VType>(vNode, vType, this);
		for(ResourceObserver observer : observers)
			observer.update(state);
	}
	
	class VTypeState<VNODE extends VNode, VTYPE extends VType> implements IBVRTransactionalVTypeState<VNODE, VTYPE> {
		
		private VTYPE vType;
		private VNODE vNode;
		private ResourceSubject subject;
		
		public VTypeState(VNODE vNode, VTYPE vType, ResourceSubject subject) {
			this.vNode = vNode;
			this.vType = vType;
		}

		@Override
		public VNODE getParentVNode() {
			return vNode;
		}

		@Override
		public VTYPE getVType() {
			return vType;
		}

		@Override
		public void attach(ResourceObserver observer) {
			subject.attach(observer);
			
		}

		@Override
		public void detach(ResourceObserver observer) {
			subject.detach(observer);
		}

		@Override
		public void notifyObservers() {
			subject.notifyObservers();
		}	
	}
	
	@Override
	public void addVType(CompoundNode parent) {
		VTypeFacade.eINSTANCE.appendVTypeCopoundNode(parent);
	}
	
	@Override
	public void removeVType(VType type) {
		removeNamedElement(type);
	}
	
	@Override
	public void setChoiceOccurenceType(ChoiceOccurrence choiceOccurence,
			String strType) {
		if(choiceOccurence.getVType() == null && strType.equals(Constants.DEFAULT_TYPE_TITLE))
			return;
		
		if(choiceOccurence.getVType() != null && choiceOccurence.getVType().getName().equals(strType))
			return;
		
		VType vType = findTypeByName(strType);
		
		if (vType == null && !strType.equals(Constants.DEFAULT_TYPE_TITLE))
			throw new UserInputError("cannot find VType : " + strType);
		
		VTypeFacade.eINSTANCE.setChoiceOccurenceVType(choiceOccurence, vType);
	}
	
	private VType findTypeByName(String typeName) {
		BVRModel model = getBVRModel();
		TreeIterator<EObject> iterator = model.eAllContents();
		while(iterator.hasNext()) {
			EObject eObject = iterator.next();
			if(eObject instanceof VType && ((VType) eObject).getName().equals(typeName))
				return (VType) eObject;
		}
		return null;
	}
	
	@Override
	public void setVClassOccurenceType(VClassOccurrence vclassOccurence,
			String typeName) {
		if(vclassOccurence.getVType() == null && typeName.equals(Constants.DEFAULT_TYPE_TITLE))
			return;
		
		if(vclassOccurence.getVType() != null && vclassOccurence.getVType().getName().equals(typeName))
			return;
		
		VType vType = findTypeByName(typeName);
		
		if (vType == null && !typeName.equals(Constants.DEFAULT_TYPE_TITLE))
			throw new UserInputError("cannot find VType : " + typeName);
		
		VTypeFacade.eINSTANCE.setVClassOccurenceVType(vclassOccurence, vType);
	}
	
	@Override
	public void setVClassOccurenceLowerBound(VClassOccurrence vClassOccur,
			int lowerBound) {
		MultiplicityInterval interval = vClassOccur.getInstanceMultiplicity();
		Context.eINSTANCE.getEditorCommands().setGroupMultiplicityLowerBound(interval, lowerBound);
	}
	
	@Override
	public void setVClassOccurenceUpperBound(VClassOccurrence vClassOccur,
			int upperBound) {
		MultiplicityInterval interval = vClassOccur.getInstanceMultiplicity();
		Context.eINSTANCE.getEditorCommands().setGroupMultiplicityUpperBound(interval, upperBound);
	}
	
	@Override
	public void addChoiceOccurence(CompoundNode compoundNode) {
		VSpecFacade.eINSTANCE.appendChoiceOccurence(compoundNode);
	}
	
	@Override
	public void addVClassOccurence(CompoundNode compoundNode) {
		VSpecFacade.eINSTANCE.appendVClassOccurence(compoundNode);
	}
}
