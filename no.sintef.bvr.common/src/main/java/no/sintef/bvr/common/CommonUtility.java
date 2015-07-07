/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.common;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.ChoiceResolution;
import bvr.ObjectHandle;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.Target;
import bvr.VClassOccurrence;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.ValueResolution;
import bvr.Variable;

import com.google.common.base.Throwables;

public final class CommonUtility {

	public static String getStackTraceAsString(Throwable throwable) {
		return Throwables.getStackTraceAsString(throwable);
	}

	public static final int DERIVED = 0x1;
	public static final int TRANSIENT = 0x2;
	public static final int MASK = 0x1FF; // 9 bits are required to encode all
											// properties

	/*
	 * 000000000 - ok, 000000001-derived, 000000010 - transient, 000000011
	 * -derived and transient etc
	 */
	public static int isDerived(EStructuralFeature property) {
		int value = 0x0 & MASK;
		/*
		 * The value of a derived feature is computed from other features, so it
		 * doesn't represent any additional object state. Framework classes,
		 * such as EcoreUtil.Copier, that copy model objects will not attempt to
		 * copy such features. The generated code is unaffected by the value of
		 * the derived flag. Derived features are typically also marked volatile
		 * and transient.
		 */
		int drvd = (property.isDerived()) ? MASK & DERIVED : value;

		/*
		 * Transient features are used to declare (modeled) data whose lifetime
		 * never spans application invocations and therefore doesn't need to be
		 * persisted. The (default XMI) serializer will not save features that
		 * are declared to be transient.
		 */
		int trnsnt = (property.isTransient()) ? MASK & TRANSIENT : value;

		value = drvd | trnsnt;
		return value;
	}

	public static int unMask(int value, int umaskValue) {
		return value & umaskValue;
	}

	public static ObjectHandle testObjectHandle(PlacementFragment placement, EObject eObject) {
		EList<ObjectHandle> objectHandles = placement.getSourceObject();
		for (ObjectHandle oh : objectHandles) {
			if (eObject != null && eObject.equals(oh.getMOFRef())) {
				return oh;
			} else if (oh.getMOFRef() == null && eObject == null) {
				return oh;
			}
		}
		ObjectHandle objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
		objectHandle.setMOFRef(eObject);
		placement.getSourceObject().add(objectHandle);
		return objectHandle;
	}

	public static ObjectHandle testObjectHandle(ReplacementFragmentType replacement, EObject eObject) {
		EList<ObjectHandle> objectHandles = replacement.getSourceObject();
		for (ObjectHandle oh : objectHandles) {
			if (eObject != null && eObject.equals(oh.getMOFRef())) {
				return oh;
			} else if (oh.getMOFRef() == null && eObject == null) {
				return oh;
			}
		}
		ObjectHandle objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
		objectHandle.setMOFRef(eObject);
		replacement.getSourceObject().add(objectHandle);
		return objectHandle;
	}

	public static String removeExtension(String s) {

		String separator = System.getProperty("file.separator");
		String filename;

		// Remove the path upto the filename.
		int lastSeparatorIndex = s.lastIndexOf(separator);
		if (lastSeparatorIndex == -1) {
			filename = s;
		} else {
			filename = s.substring(lastSeparatorIndex + 1);
		}

		// Remove the extension.
		int extensionIndex = filename.lastIndexOf(".");
		if (extensionIndex == -1)
			return filename;

		return filename.substring(0, extensionIndex);
	}

	public static EList<EObject> getReferencedEObjects(EObject eObject) {
		EList<EObject> eObjects = new BasicEList<EObject>();
		EList<EReference> references = eObject.eClass().getEAllReferences();
		for (EReference reference : references) {
			if (isDerived(reference) != 0)
				continue;
			Object targetObject = eObject.eGet(reference);
			if (targetObject instanceof EObject) {
				EObject targetEObject = (EObject) targetObject;
				eObjects.add(targetEObject);
			} else if (targetObject instanceof EList) {
				EList<? extends EObject> eEObjects = (EList<? extends EObject>) targetObject;
				eObjects.addAll(eEObjects);
			} else if (targetObject != null) {
				throw new UnsupportedOperationException("Cannot perform operation : an element referenced by " + reference + " of " + eObject
						+ " is neither EObject nor EList: class -> " + targetObject.getClass() + " object ->" + targetObject);
			}
		}
		return eObjects;
	}

	public static EList<EObject> getReferencedEObjects(EObject source, EList<EReference> references) {
		EList<EObject> eObjects = new BasicEList<EObject>();
		for (EReference reference : references) {
			if (isDerived(reference) == 0) {
				Object value = source.eGet(reference);
				if (value instanceof EObject) {
					eObjects.add((EObject) value);
				} else if (value instanceof EList) {
					eObjects.addAll((EList<? extends EObject>) value);
				} else if (value != null) {
					throw new UnsupportedOperationException("Cannot perform operation: reference " + reference + " of " + source
							+ " does not point to EObject nor EList :" + value);
				}
			}
		}
		return eObjects;
	}

	public static boolean isVSpecResolutionVClassifier(VSpecResolution vSpecResolution) {
		if ((vSpecResolution instanceof ChoiceResolution)
				&& ((((ChoiceResolution) vSpecResolution).getResolvedVClassifier() != null) || ((ChoiceResolution) vSpecResolution).getResolvedVClassOcc() != null))
			return true;
		return false;
	}

	public static boolean isTypeNotNull(Object occurrence) {
		if (occurrence instanceof ChoiceOccurrence)
			return (((ChoiceOccurrence) occurrence).getVType() != null);
		else if (occurrence instanceof VClassOccurrence)
			return (((VClassOccurrence) occurrence).getVType() != null);

		return false;
	}

	public static VSpec getResolvedVSpec(VSpecResolution vSpecResolution) {
		if (vSpecResolution instanceof ChoiceResolution) {
			ChoiceResolution choiceResolution = (ChoiceResolution) vSpecResolution;
			if (choiceResolution.getResolvedChoice() != null)
				return choiceResolution.getResolvedChoice();
			if (choiceResolution.getResolvedVClassifier() != null)
				return choiceResolution.getResolvedVClassifier();
			if (choiceResolution.getResolvedChoiceOcc() != null)
				return choiceResolution.getResolvedChoiceOcc();
			if (choiceResolution.getResolvedVClassOcc() != null)
				return choiceResolution.getResolvedVClassOcc();
			if (choiceResolution.getResolvedVSpec() != null)
				return choiceResolution.getResolvedVSpec();
		}
		return null;
	}

	/**
	 * use to set setResolvedVspec and setResolved_TYPE_
	 *
	 * @param target
	 * @param toResolve
	 * @return
	 */
	public static VSpecResolution setResolved(VSpecResolution target, VSpec toResolve) {

		target.setResolvedVSpec(toResolve);
		if (target instanceof ChoiceResolution) {
			if (toResolve instanceof Choice) {
				((ChoiceResolution) target).setResolvedChoice((Choice) toResolve);
			} else if (toResolve instanceof VClassifier) {
				((ChoiceResolution) target).setResolvedVClassifier((VClassifier) toResolve);
			} else if (toResolve instanceof ChoiceOccurrence) {
				((ChoiceResolution) target).setResolvedChoiceOcc((ChoiceOccurrence) toResolve);
			} else if (toResolve instanceof VClassOccurrence) {
				((ChoiceResolution) target).setResolvedVClassOcc((VClassOccurrence) toResolve);
			} else {
				throw new UnsupportedOperationException("target/toResolve type mismach " + toResolve);
			}
		}
		if (target instanceof ValueResolution) {
			if (toResolve instanceof Variable) {
				((ValueResolution) target).setResolvedVariable((Variable) toResolve);
			} else {
				throw new UnsupportedOperationException("target/toResolve type mismach");
			}
		}

		return target;
	}

	public static boolean isOccurrence(VNode y) {
		if (y instanceof ChoiceOccurrence) {
			return true;
		} else if (y instanceof VClassOccurrence) {
			return true;
		}
		return false;
	}

	public static EList<VNode> getTypeMembers(VNode y) {
		if (!isTypeNotNull(y))
			return null;
		if (y instanceof ChoiceOccurrence) {
			ChoiceOccurrence typeRoot = (ChoiceOccurrence) y;
			return typeRoot.getVType().getMember();
		} else if (y instanceof VClassOccurrence) {
			VClassOccurrence typeRoot = (VClassOccurrence) y;
			return typeRoot.getVType().getMember();
		}
		return null;

	}

	public static Target getTargetByName(List<Target> targets, String name) {
		for (Target target : targets) {
			if (target.getName().equals(name))
				return target;
		}
		return null;
	}
}
