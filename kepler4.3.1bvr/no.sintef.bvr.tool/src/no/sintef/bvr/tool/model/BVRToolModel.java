package no.sintef.bvr.tool.model;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.ict.splcatool.SPLCABVRModel;
import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.BoundaryElementBinding;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.FragmentSubstitution;
import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.Variabletype;
import bvr.VariationPoint;

abstract public class BVRToolModel {
	protected SPLCABVRModel bvrm;
	protected File f;
	protected boolean platform = false;
	protected String loadFilename;
	protected boolean saved = true;
	protected List<VSpec> minimizedVSpec;
	protected List<VSpecResolution> minimizedVSpecResolution;

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
	
	public BVRToolModel(File sf, String loadLocation, boolean isPlatform){
		f = sf;
		platform = isPlatform;
		loadFilename = loadLocation;
		bvrm = new SPLCABVRModel(loadFilename, platform);
	}

	public BVRToolModel() {
		bvrm = new SPLCABVRModel();
	}
	
	public void reload(){
		bvrm = (!platform) ? new SPLCABVRModel(f) : new SPLCABVRModel(loadFilename, platform);
	}
	
	public void dispose() {
		f = null;
		bvrm = null;
		saved = false;
		loadFilename = "";
		platform = false;
	}

	String getShortFileName(){
		if(f == null) return "unnamed model";
		return f.getName();
	}

	String getLongFileName(){
		if(f == null) return "unnamed model";
		return f.getAbsolutePath();
	}
	
	public SPLCABVRModel getBVRM(){
		return bvrm;
	}
	
	public void setBVRM(SPLCABVRModel bvrm){
		this.bvrm = bvrm;
	}

	public void addVSpec(VSpec vSpec) {
		bvrm.getRootBVRModel().setVariabilityModel((CompoundNode) vSpec);
	}

	public BVRModel getBVRModel() {
		return bvrm.getRootBVRModel();
	}
	
	public void setFile(File f){
		this.f = f;
	}

	public File getFile() {
		return f;
	}
	
	public void setPlatform(boolean isPlatform){
		platform = isPlatform;
	}
	
	public void setLoadFilename(String loadName){		
		loadFilename = loadName;
	}
	
	public boolean isNotSaved(){
		return !saved;
	}
	
	public void markNotSaved(){
		saved = false;
	}

	public void markSaved() {
		saved = true;
	}
	
	public void addChoice(NamedElement parentVSpec) {
		throw new UnexpectedException("Are you using default implementation?!");
	};
	
	public void minimaizeVSpec(VSpec vspec){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public void maximizeVSpec(VSpec vspec){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public boolean isVSpecMinimized(VSpec vspec){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public void minimaizeVSpecResolution(VSpecResolution vspecRes){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public void maximizeVSpecResolution(VSpecResolution vspecRes){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public boolean isVSpecResolutionMinimized(VSpecResolution vspecRes){
		throw new UnexpectedException("Are you using default implementation?!");
	}
	
	public void updateVariable(Variable variable, String name, String typeName){
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

	public void toggleChoiceOptionalMandotary(Choice choice) {
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

	public void createFragmentSubstitution(PlacementFragment placement,
			ReplacementFragmentType replacement) {
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


	public void addChoiceResolution(VSpec resolvedVSpec, VSpecResolution parentNamedElement) {
		throw new UnexpectedException("Are you using default implementation?!");
		
	}

	public CompoundResolution createResolution() {
		throw new UnexpectedException("Are you using default implementation?!");
	}

	public void addResolutionModel(CompoundResolution root) {
		throw new UnexpectedException("Are you using default implementation?!");
	}


}
