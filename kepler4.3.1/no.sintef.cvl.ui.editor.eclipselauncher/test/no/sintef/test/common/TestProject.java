package no.sintef.test.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import no.sintef.cvl.thirdparty.common.Constants;
import no.sintef.cvl.tool.primitive.Symbol;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.framework.Bundle;

import cvl.FragmentSubstitution;

public class TestProject {

	public IProject iProject;
	
	public TestProject(String projectName) throws CoreException{
		IWorkspaceRoot iWorcspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		iProject = iWorcspaceRoot.getProject(projectName);
		iProject.create(null);
		iProject.open(null);
	}
	
	public IFolder createFolder(String testName) throws CoreException{
		IFolder iFolder = iProject.getFolder(testName);
		iFolder.create(true, true, null);
		return iFolder;
	}
	
	public void disposeTestProject() throws CoreException{
		iProject.delete(true, null);
	}
	
	public IFile copyFileFromPlugin(String source, String target) throws IOException, CoreException{
		Bundle bundle = Platform.getBundle(Constants.PLUGIN_ID_CVL_LAUNCHER);
		URL url = bundle.getEntry(source);
		InputStream stream = url.openConnection().getInputStream();
		IFile iFile = iProject.getFile(target);
		iFile.create(stream, true, null);
		return iFile;
	}
	
	public static boolean isIdentical(String original, String created){
		File originalFile = new File(original);
		File createdFile = new File(created);
		ResourceSetImpl resSet = new ResourceSetImpl();
		ResourceSetImpl resSet1 = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource originalResource = resSet.getResource(URI.createFileURI(originalFile.getAbsolutePath()), true);
		Resource createdResource = resSet1.getResource(URI.createFileURI(createdFile.getAbsolutePath()), true);
		
		EList<EObject> originaElements = new BasicEList<EObject>();
		EList<EObject> createdElements = new BasicEList<EObject>();
		TreeIterator<EObject> originalTreeElements = originalResource.getAllContents();
		TreeIterator<EObject> createdTreeElements = createdResource.getAllContents();

		while(originalTreeElements.hasNext())
			originaElements.add(originalTreeElements.next());
		
		while(createdTreeElements.hasNext())
			createdElements.add(createdTreeElements.next());
		
		if(originaElements.size() != createdElements.size())
			return false;
		
		EList<EObject> originalIterator = new BasicEList<EObject>(originaElements);
		for(EObject originalEObject : originalIterator){
			Iterator<EObject> createdIterator = createdElements.iterator();
			while(createdIterator.hasNext()){
				EObject copiedEObject = createdIterator.next();
				if(compareEObject(originalEObject, copiedEObject)){
					createdElements.remove(copiedEObject);
					originaElements.remove(originalEObject);
					break;
				}
			}
		}

		if(!originaElements.isEmpty() || !createdElements.isEmpty())
			return false;
		
		return true;
	}
		
	public static boolean compareEObject(EObject originalEObject, EObject copiedEObject){
		if(!originalEObject.eClass().equals(copiedEObject.eClass()))
			return false;
		EList<EReference> originalReferences = originalEObject.eClass().getEAllReferences();
		EList<EReference> copiedReferences = copiedEObject.eClass().getEAllReferences();
		if(originalReferences.size() != copiedReferences.size())
			return false;
		for(EReference reference : originalReferences){
			if(copiedReferences.indexOf(reference) < 0)
				return false;
		}
		EList<EAttribute> originalAttributes = originalEObject.eClass().getEAllAttributes();
		EList<EAttribute> copiedAttributes = copiedEObject.eClass().getEAllAttributes();
		if(originalAttributes.size() != copiedAttributes.size())
			return false;
		for(EAttribute attribute : originalAttributes){
			if(copiedAttributes.indexOf(attribute) < 0)
				return false;
			Object originalValue = originalEObject.eGet(attribute);
			Object copiedValue = copiedEObject.eGet(attribute);
			if(originalValue != null && !originalValue.equals(copiedValue)){
				return false;
			}else if(originalValue == null && copiedValue != null){
				return false;
			}
		}
		
		return true;
	}
	
	public static EList<FragmentSubstitution> collectFragmentSuubstitutions(ArrayList<Symbol> symbols){
		HashSet<FragmentSubstitution> fragments = new HashSet<FragmentSubstitution>();
		for(Symbol symbol : symbols){
			EList<FragmentSubstitution> fragmentSubstitutions = symbol.getFragmentSubstitutions();
			for(FragmentSubstitution fragment : fragmentSubstitutions){
				FragmentSubstitution frgamentCopy = symbol.getFragmentSubstitutionCopy(fragment);
				FragmentSubstitution fragmentTpExecute = (frgamentCopy == null) ? fragment : frgamentCopy;
				symbol.addFragmentSubstitutionsToExecute(fragmentTpExecute);
				fragments.add(fragmentTpExecute);
			}
		}
		return new BasicEList<FragmentSubstitution>(fragments);
	}
	
	public static EList<Symbol> sortSymbolByNames(ArrayList<Symbol> symbols, String[] names){
		ArrayList<Symbol> arrayList = new ArrayList<Symbol>();
		for(int i=0; i<names.length; i++){
			for(Symbol symbol : symbols){
				if(symbol.getVSpec().getName().equals(names[i])){
					arrayList.add(i, symbol);
				}
			}
		}
		return new BasicEList<Symbol>(arrayList);
	}
}
