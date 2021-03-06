/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.constraints.interfaces.strategy.IConstraintFinderStrategy;
import no.sintef.bvr.constraints.strategy.ContextConstraintFinderStrategy;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.exception.ShowErrorException;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.interfaces.common.IVarModelResolutionsCopier;
import no.sintef.bvr.tool.interfaces.model.IBVRSPLCAModelTransformator;
import no.sintef.bvr.tool.interfaces.model.IBVRToolModel;
import no.sintef.bvr.tool.strategy.impl.CopierResolveChoiceStrategy;
import no.sintef.ict.splcatool.BVRException;
import no.sintef.ict.splcatool.CALib;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayComplete;
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;
import no.sintef.ict.splcatool.SPLCABVRModel;
import no.sintef.ict.splcatool.UnsupportedSPLCValidation;
import no.sintef.ict.splcatool.interfaces.IBVRModelHolderStrategy;
import no.sintef.ict.splcatool.interfaces.IResolutionFinderStrategy;
import no.sintef.ict.splcatool.interfaces.IResolveChoiceStrategy;
import no.sintef.ict.splcatool.interfaces.IVariabilityModelFinderStartegy;
import no.sintef.ict.splcatool.strategy.DefaultBVRModelHolderStrategy;
import no.sintef.ict.splcatool.strategy.DefaultConstraintFinderStrategy;
import no.sintef.ict.splcatool.strategy.DefaultResolutionFinderStrategy;
import no.sintef.ict.splcatool.strategy.DefaultVariabilityModelFinderStrategy;
import no.sintef.ict.splcatool.strategy.SingleResVariabilityFinderStrategy;
import no.sintef.ict.splcatool.strategy.SingleResolutionFinderStrategy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import splar.core.fm.FeatureModelException;
import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.BoundaryElementBinding;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.ChoiceResolution;
import bvr.ChoiceVSpec;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.Constraint;
import bvr.FragmentSubstitution;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.PosResolution;
import bvr.ReplacementFragmentType;
import bvr.Target;
import bvr.VClassOccurrence;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.VType;
import bvr.ValueResolution;
import bvr.Variable;
import bvr.Variabletype;
import bvr.VariationPoint;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

abstract public class BVRToolModel implements IBVRToolModel {
	protected SPLCABVRModel bvrm;
	protected File f;
	protected boolean platform = false;
	protected String loadFilename;
	protected boolean saved = true;
	protected List<VSpec> minimizedVSpec;
	protected List<VSpecResolution> minimizedVSpecResolution;
	protected ArrayList<String> satValidationMessage;
	static protected int instanceCount = 0;
	protected boolean showConstraints = false;
	protected boolean showGroupsResoultion = false;
	protected List<Constraint> invalidConstraints = new ArrayList<Constraint>();

	public int getIncrementedInstanceCount() {
		return instanceCount++;
	}

	public BVRToolModel(File sf) {
		f = sf;
		bvrm = new SPLCABVRModel(f);
		loadFilename = sf.getAbsolutePath();
	}

	public BVRToolModel(File sf, SPLCABVRModel x) {
		bvrm = x;
		f = sf;
		loadFilename = sf.getAbsolutePath();
	}

	public BVRToolModel(File sf, String loadLocation, boolean isPlatform) {
		f = sf;
		platform = isPlatform;
		loadFilename = loadLocation;
		bvrm = new SPLCABVRModel(loadFilename, platform);
	}

	public BVRToolModel() {
		bvrm = new SPLCABVRModel();
	}

	public void reload() {
		bvrm = (!platform) ? new SPLCABVRModel(f) : new SPLCABVRModel(loadFilename, platform);
	}

	public void dispose() {
		f = null;
		bvrm = null;
		saved = false;
		loadFilename = "";
		platform = false;
	}

	String getShortFileName() {
		if (f == null)
			return "unnamed model";
		return f.getName();
	}

	String getLongFileName() {
		if (f == null)
			return "unnamed model";
		return f.getAbsolutePath();
	}

	public SPLCABVRModel getSPLCABVRModel() {
		return bvrm;
	}

	public void setBVRM(SPLCABVRModel bvrm) {
		this.bvrm = bvrm;
	}

	public void addVSpec(VSpec vSpec) {
		bvrm.getRootBVRModel().setVariabilityModel((CompoundNode) vSpec);
	}

	@Override
	public BVRModel getBVRModel() {
		return bvrm.getRootBVRModel();
	}

	public void setFile(File f) {
		this.f = f;
	}

	public File getFile() {
		return f;
	}

	public void setPlatform(boolean isPlatform) {
		platform = isPlatform;
	}

	public void setLoadFilename(String loadName) {
		loadFilename = loadName;
	}

	public boolean isNotSaved() {
		return !saved;
	}

	public void markNotSaved() {
		saved = false;
	}

	public void markSaved() {
		saved = true;
	}

	public Choice addChoice(NamedElement parentVSpec) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void minimaizeVSpec(VSpec vspec) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void maximizeVSpec(VSpec vspec) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public boolean isVSpecMinimized(VSpec vspec) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void minimaizeVSpecResolution(VSpecResolution vspecRes) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void maximizeVSpecResolution(VSpecResolution vspecRes) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public boolean isVSpecResolutionMinimized(VSpecResolution vspecRes) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void updateVariable(Variable variable, String name, String typeName) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void updateName(NamedElement namedElement, String name) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void updateComment(NamedElement namedElement, String text) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public String getNodesCommentText(NamedElement namedElement) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void addVariable(VNode parentNode) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void setVClassifierUpperBound(VClassifier vClassifier, int upperBound) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void setVClassifierLowerBound(VClassifier vClassifier, int lowerBound) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void addVClassifier(NamedElement parentVSpec) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void addBCLConstraint(VNode parentVNode) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void updateBCLConstraint(BCLConstraint constraint, String strConstr) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void toggleChoiceOptionalMandotary(ChoiceVSpec choice) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void cutNamedElement(NamedElement namedElement) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void pastNamedElementAsChild(NamedElement parent) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void pastNamedElementAsSibling(NamedElement sibling) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void setGroupMultiplicity(VNode parent, int lowerBound, int upperBound) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void removeGroupMultiplicity(VNode parent) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public String getBCLConstraintString(BCLConstraint constraint) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void removeNamedElement(NamedElement element) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void deleteReplacements(EList<Variabletype> replacements) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void deletePlacements(EList<VariationPoint> placements) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void deleteFragments(EList<VariationPoint> fslist) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void createFragmentSubstitution(PlacementFragment placement, ReplacementFragmentType replacement) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void generateBindings(FragmentSubstitution fragmentSubstitution) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void updateFragmentSubstitutionBinding(VariationPoint vp, VSpec vSpec) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public EList<HashMap<EObject, Integer>> findFragmentElementsToHighlight(NamedElement fragment) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void highlightElements(EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public EList<HashMap<EObject, Integer>> findBoundaryElementsToHighlight(NamedElement binding) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void updateBindingBoundary(BoundaryElementBinding binding, NamedElement boundary) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public CompoundResolution createResolution() {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void addResolutionModel(CompoundResolution root) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void removeRootResolution(int resolutionIndex) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void removeAllResolutions() {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void generatAllProducts() {
		try {
			// copy and transform model to the format which can be proccesed by
			// splca tool
			copyBVRModelSetUpSPLCA();

			GUIDSL gdsl = getSPLCABVRModel().getGUIDSL();
			CNF cnf = gdsl.getSXFM().getCNF();
			CoveringArray ca = new CoveringArrayComplete(cnf);
			ca.generate();
			GraphMLFM gfm = gdsl.getGraphMLFMConf(ca);
			EList<VSpecResolution> resolutions = getSPLCABVRModel().getChoiceResolutions(gfm);
			for (VSpecResolution resolution : resolutions)
				addResolutionModel((CompoundResolution) resolution);
		} catch (Exception e) {
			throw new RethrownException("failed to generate products", e);
		} finally {
			getSPLCABVRModel().restoreDefaultStrategies();
		}
	}

	public boolean performSATValidation() {
		boolean valid = false;
		satValidationMessage = new ArrayList<String>();

		try {
			// copy and transform model to the format which can be proccesed by
			// splca tool
			copyBVRModelSetUpSPLCA();

			CoveringArray ca = getSPLCABVRModel().getCoveringArray();
			CNF cnf = getSPLCABVRModel().getGUIDSL().getSXFM().getCNF();
			valid = CALib.verifyCA(cnf, ca, true, satValidationMessage);
		} catch (CSVException e) {
			throw new RethrownException("Getting CA failed:", e);
		} catch (UnsupportedSPLCValidation e) {
			throw new RethrownException(e.getMessage(), e);
		} catch (BVRException e) {
			throw new RethrownException("Getting CA failed:", e);
		} catch (Exception e) {
			throw new RethrownException(e.getMessage(), e);
		} finally {
			getSPLCABVRModel().restoreDefaultStrategies();
		}

		return valid;
	}

	public boolean performSATValidation(VSpecResolution resoluion) {
		boolean valid = false;
		CoveringArray ca;
		satValidationMessage = new ArrayList<String>();

		try {
			// copy and transform model to the format which can be proccesed by
			// splca tool
			IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(getBVRModel());
			transformator.transformVarModelToSPLCA();
			IVarModelResolutionsCopier model_copier = transformator.getModelCopier();
			VSpecResolution copied_resolution = (VSpecResolution) ((Map) model_copier).get(resoluion);
			BVRModel copied_model = model_copier.getCopiedBVRModel();

			VNode node = (VNode) CommonUtility.getResolvedVSpec(copied_resolution);
			SingleResolutionFinderStrategy strRes = new SingleResolutionFinderStrategy((ChoiceResolution) copied_resolution);
			ContextConstraintFinderStrategy strConst = new ContextConstraintFinderStrategy(node);
			SingleResVariabilityFinderStrategy resVar = new SingleResVariabilityFinderStrategy(node);
			DefaultBVRModelHolderStrategy modelHoler = new DefaultBVRModelHolderStrategy(copied_model);

			getSPLCABVRModel().setResolutionFindStrategy(strRes);
			getSPLCABVRModel().setConstrtaintFindStrategy(strConst);
			getSPLCABVRModel().setVariabilityFindStrategy(resVar);
			getSPLCABVRModel().setBVRModelHolderStrategy(modelHoler);

			ca = getSPLCABVRModel().getCoveringArray();
			CNF cnf = getSPLCABVRModel().getGUIDSL().getSXFM().getCNF();
			valid = CALib.verifyCA(cnf, ca, true, satValidationMessage);
		} catch (CSVException e) {
			throw new RethrownException("Getting CA failed:", e);
		} catch (UnsupportedSPLCValidation e) {
			throw new RethrownException(e.getMessage(), e);
		} catch (BVRException e) {
			throw new RethrownException("Getting CA failed:", e);
		} catch (Exception e) {
			throw new RethrownException(e.getMessage(), e);
		} finally {
			getSPLCABVRModel().restoreDefaultStrategies();
		}

		return valid;
	}

	public List<String> getSATValidationMessage() {
		return satValidationMessage;
	}

	public Integer calculateCoverage(int t) {
		int cov;
		try {
			// copy and transform model to the format which can be proccesed by
			// splca tool
			copyBVRModelSetUpSPLCA();

			// Get FM:
			GUIDSL gdsl = getSPLCABVRModel().getGUIDSL();
			CNF cnf = gdsl.getSXFM().getCNF();
			// Get Covering Array
			CoveringArray ca = getSPLCABVRModel().getCoveringArray();
			// Calculate
			cov = (int) Math.round(CALib.calc_coverage(cnf, t, ca));
		} catch (UnsupportedSPLCValidation e) {
			throw new ShowErrorException(e.getMessage(), e);
		} catch (FeatureModelException | IOException | UnsupportedModelException | BVRException | CSVException e) {
			throw new RethrownException("Failed to calculate coverage", e);
		} finally {
			getSPLCABVRModel().restoreDefaultStrategies();
		}
		return cov;
	}

	public void generateCoveringArray(int xWise) {
		removeAllResolutions();
		try {
			// copy and transform model to the format which can be proccesed by
			// splca tool
			copyBVRModelSetUpSPLCA();

			GUIDSL gdsl = getSPLCABVRModel().getGUIDSL();
			CNF cnf = gdsl.getSXFM().getCNF();
			CoveringArray ca = cnf.getCoveringArrayGenerator("J11", xWise, 1);

			/*
			 * EList<CompoundResolution> compoundResolutions =
			 * getBVRModel().getResolutionModels(); EList<PosResolution>
			 * rootResolutions = new BasicEList<PosResolution>();
			 * for(CompoundResolution compoundResolution : compoundResolutions)
			 * { if(compoundResolution instanceof PosResolution)
			 * rootResolutions.add((PosResolution) compoundResolution); }
			 *
			 * if(rootResolutions.size() > 0){ CoveringArray startFrom =
			 * getBVRM().getCoveringArray(); ca.startFrom(startFrom); }
			 */

			ca.generate();
			GraphMLFM gfm = gdsl.getGraphMLFMConf(ca);
			EList<VSpecResolution> resolutions = getSPLCABVRModel().getChoiceResolutions(gfm);
			for (VSpecResolution resolution : resolutions)
				addResolutionModel((CompoundResolution) resolution);
		} catch (Exception e) {
			throw new RethrownException(e.getMessage(), e);
		} finally {
			getSPLCABVRModel().restoreDefaultStrategies();
		}
	}

	public void resolveSubtree(VSpecResolution parent) {
		throw new UnexpectedException("Are you using default implementation?!");

	}

	public void toggleChoice(NamedElement toToggle) {
		throw new UnexpectedException("Are you using default implementation?!");

	}

	public void removeVSpecResolution(NamedElement toDelete) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void importResolutionFromFile(File file) {
		GraphMLFM gfm;
		try {
			CoveringArray ca = new CoveringArrayFile(file);
			GUIDSL gdsl = getSPLCABVRModel().getGUIDSL();
			gfm = gdsl.getGraphMLFMConf(ca);
			getSPLCABVRModel().getChoiceResolutions(gfm);
		} catch (Exception e) {
			throw new RethrownException("Importing resolutions failed: ", e);
		}
	}

	public String calculateCosts() {
		int i = 0;
		String cstr = "";
		for (CompoundResolution resolution : getBVRModel().getResolutionModels()) {
			double d = (resolution instanceof PosResolution) ? calcCost(resolution) : Double.NaN;
			i++;
			cstr += i + " : " + d + "\n";
		}
		return cstr;
	}

	private double calcCost(ChoiceResolution resolution) {
		String comment = NoteFacade.eINSTANCE.getCommentText(CommonUtility.getResolvedVSpec(resolution));
		double d = 0;
		try {
			if (resolution instanceof PosResolution)
				d += Double.parseDouble(comment);
		} catch (NumberFormatException n) {
			d = Double.NaN;
		}

		if (resolution instanceof CompoundResolution) {
			for (VSpecResolution c : ((CompoundResolution) resolution).getMembers()) {
				d += (c instanceof ChoiceResolution) ? calcCost((ChoiceResolution) c) : Double.NaN;
			}
		}
		return d;
	}

	public void saveLastSavedLocation(String absolutePath) {
		Context.eINSTANCE.getConfig().saveLastLocation(absolutePath);
	}

	public void addChoiceOrVClassifierResolution(VSpec resolvedVspec, VSpecResolution parent) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void resolveVariable(CompoundResolution compountResolution, Variable variable) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void toggleShowConstraints() {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public boolean showConstraints() {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public boolean isResolutionModelSet() {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void setValueResolution(ValueResolution valueResoultion, String value) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public String getValueResolutionAsString(ValueResolution namedElement) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void setValueResolutionName(ValueResolution namedElement, String name) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public int getResolvedVClassifierCount(CompoundResolution compoundResolution, VClassifier vclassifier) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void addChoiceOrVClassifierResolution(VSpec vSpecToResolve, VSpecResolution parentNamedElement, int instancesToResolve) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public boolean checkGroupError(CompoundResolution compoundResolution) {
		VSpec vSpec = CommonUtility.getResolvedVSpec(compoundResolution);
		if (vSpec == null)
			throw new UnexpectedException("Resolution does not resolve any VSpec " + compoundResolution);

		MultiplicityInterval multiplicity = ((VNode) vSpec).getGroupMultiplicity();
		if (multiplicity == null)
			return false;

		int lower = multiplicity.getLower();
		int upper = multiplicity.getUpper();
		int i = 0;
		for (VSpecResolution x : compoundResolution.getMembers()) {
			if (x instanceof ChoiceResolution) {
				if (x instanceof PosResolution)
					i++;
			}
		}
		if ((i > upper && upper != -1) || i < lower)
			return true;

		return false;
	}

	public boolean showGrouping() {
		return showGroupsResoultion;
	}

	public void showGrouping(boolean grouping) {
		showGroupsResoultion = grouping;
	}

	public List<Constraint> getInvalidConstraints() {
		return invalidConstraints;
	}

	public List<String> validateChoiceResolution(VSpecResolution vSpecResolution) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void executeResolution(File destFile, int index) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void clearHighlightedObjects() {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void modifyVType(VNode vNode, VType vType) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void addVType(CompoundNode parent) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void removeVType(VType type) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void setChoiceOccurenceType(ChoiceOccurrence choiceOccurence, String strType) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void setVClassOccurenceType(VClassOccurrence vclassOccurence, String typeName) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void setVClassOccurenceUpperBound(VClassOccurrence vClassOccur, int upperBound) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void setVClassOccurenceLowerBound(VClassOccurrence vClassOccur, int lowerBound) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void addChoiceOccurence(CompoundNode compoundNode) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void addVClassOccurence(CompoundNode compoundNode) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void removeUncontainedResolutions(VSpecResolution compoundNode) {
		throw new UnexpectedException("Are you using default implementation?!");

	}

	@Override
	public Map<Target, Set<VSpec>> getTargetVSpecMap() {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	protected void copyBVRModelSetUpSPLCA() {
		IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(getBVRModel());
		transformator.transformVarModelToSPLCA();
		IVarModelResolutionsCopier model_copier = transformator.getModelCopier();
		BVRModel copied_model = model_copier.getCopiedBVRModel();

		IResolutionFinderStrategy strRes = new DefaultResolutionFinderStrategy(copied_model);
		IConstraintFinderStrategy strConst = new DefaultConstraintFinderStrategy(copied_model);
		IVariabilityModelFinderStartegy strVM = new DefaultVariabilityModelFinderStrategy(copied_model);
		IBVRModelHolderStrategy strMH = new DefaultBVRModelHolderStrategy(copied_model);
		IResolveChoiceStrategy strRC = new CopierResolveChoiceStrategy(model_copier);

		getSPLCABVRModel().setResolutionFindStrategy(strRes);
		getSPLCABVRModel().setConstrtaintFindStrategy(strConst);
		getSPLCABVRModel().setVariabilityFindStrategy(strVM);
		getSPLCABVRModel().setBVRModelHolderStrategy(strMH);
		getSPLCABVRModel().setResolveChoiceStrategy(strRC);
	}

	public void updateBaseModelFiles(List<String> paths) {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public List<String> getBaseModelPaths() {
		throw new UnexpectedException("Are you using default implementation?!");
	}

}
