package no.sintef.cvl.table.resolution.custom;

import java.util.ArrayList;
import java.util.List;

import cvl.VClassifier;
import cvl.VSpecResolution;

public class VirtualVClassifierHolder {
	public static VirtualVClassifierHolder instance;

	private static List<VirtualVClassifier> virtualList;

	private VirtualVClassifierHolder() {
		virtualList = new ArrayList<VirtualVClassifier>();
	}

	public static VirtualVClassifierHolder getInstance() {
		if (instance == null) {
			instance = new VirtualVClassifierHolder();
		}
		return instance;
	}

	public VirtualVClassifier getVirtualInstance(VSpecResolution parent,
			VClassifier target) {

		for (VirtualVClassifier virtual : virtualList) {
			if (virtual.getParent() == parent
					&& virtual.getResolvedVSpec() == target) {
				return virtual;
			}
		}
		return null;
	}

	public void addVirtualClassifier(VirtualVClassifier element) {
		virtualList.add(element);
	}
}
