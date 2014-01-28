package no.sintef.cvl.table.resolution.editors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import cvl.BooleanLiteralExp;
import cvl.ChoiceResolutuion;
import cvl.ConfigurableUnit;
import cvl.IntegerLiteralExp;
import cvl.PrimitiveTypeEnum;
import cvl.PrimitiveValueSpecification;
import cvl.PrimitveType;
import cvl.RealLiteralExp;
import cvl.StringLiteralExp;
import cvl.UnlimitedLiteralExp;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;
import cvl.VSpecResolution;
import cvl.Variable;
import cvl.VariableValueAssignment;
import cvl.util.CvlSwitch;

public class ResolutionTableContentProvider implements
		IStructuredContentProvider {
	List<VSpec> headers;
	List<List<String>> resultMapList;
	CreateVSpecResolutionLabelVisitor visitor;

	public ResolutionTableContentProvider() {
		super();
		resultMapList = new ArrayList<List<String>>();
		visitor = new CreateVSpecResolutionLabelVisitor();
	}

	public void setHeaders(List<VSpec> headers) {
		this.headers = headers;
	}

	private int getHeaderIndex(VSpec vspec) {
		if (headers.contains(vspec)) {
			return headers.indexOf(vspec) + 1;
		}
		return -1;
	}

	private List<String> getResultMap(int index) {
		if (resultMapList.size() > index) {
			return resultMapList.get(index);
		} else {
			for (int i = resultMapList.size(); i <= index; i++) {
				resultMapList.add(new ArrayList<String>());
				for (int j = 0; j < headers.size() + 1; j++) {
					resultMapList.get(i).add(new String("-"));
				}
			}
			return resultMapList.get(index);
		}
	}

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//
	}

	@Override
	public Object[] getElements(Object inputElement) {
		resultMapList.clear();
		if (inputElement instanceof ConfigurableUnit) {
			ConfigurableUnit cu = (ConfigurableUnit) inputElement;
			int row = 0;
			for (Iterator<VSpecResolution> resolutionIterator = cu
					.getOwnedVSpecResolution().iterator(); resolutionIterator
					.hasNext();) {
				VSpecResolution rootResolution = resolutionIterator.next();
				// Product Name
				List<String> currentRow = getResultMap(row);
				currentRow.set(0, rootResolution.getName());

				// Traverse
				row = traverseVSpecResolution(rootResolution, row);
				row++;
			}

			return resultMapList.toArray();
		}
		return null;
	}

	private int traverseVSpecResolution(VSpecResolution vr, int row) {
		// Set label
		if (visitor.doSwitch(vr) != null) {
			int columnIndex = this.getHeaderIndex(vr.getResolvedVSpec());
			List<String> currentRow = getResultMap(row);
			if (columnIndex >= 0) {
				currentRow.set(columnIndex, (String) visitor.doSwitch(vr));
			}
		}
		// Traverse children
		int maxRow = row;
		Set<VClassifier> classifiers = new HashSet<VClassifier>();
		for (Iterator<VSpecResolution> resolutionIterator = vr.getChild()
				.iterator(); resolutionIterator.hasNext();) {
			VSpecResolution child = resolutionIterator.next();
			if (child instanceof ChoiceResolutuion) {
				// choice traverse
				int temp = traverseVSpecResolution(child, row);
				maxRow = temp > maxRow ? temp : maxRow;
			} else if (child instanceof VariableValueAssignment) {
				int temp = traverseVSpecResolution(child, row);
				maxRow = temp > maxRow ? temp : maxRow;
			} else if (child instanceof VInstance) {
				// get classifiers for VInstance
				classifiers.add((VClassifier) child.getResolvedVSpec());
			}
		}

		for (Iterator<VClassifier> vclassifierIterator = classifiers.iterator(); vclassifierIterator
				.hasNext();) {
			VClassifier targetClassifier = vclassifierIterator.next();
			int maxRowInVInstance = row - 1;
			for (Iterator<VSpecResolution> resolutionIterator = vr.getChild()
					.iterator(); resolutionIterator.hasNext();) {
				VSpecResolution child = resolutionIterator.next();
				if (child instanceof VInstance
						&& (VClassifier) ((VInstance) child).getResolvedVSpec() == targetClassifier) {
					// choice traverse
					maxRowInVInstance = traverseVSpecResolution(child,
							++maxRowInVInstance);
				}
			}
			maxRow = maxRowInVInstance > maxRow ? maxRowInVInstance : maxRow;
		}

		return maxRow;
	}

	protected class CreateVSpecResolutionLabelVisitor extends CvlSwitch<Object> {

		@Override
		public Object caseChoiceResolutuion(ChoiceResolutuion object) {
			if (object.isDecision()) {
				return "X";
			} else {
				return "";
			}
		}

		@Override
		public Object caseVariableValueAssignment(VariableValueAssignment object) {
			PrimitiveTypeEnum type;
			if (object.getResolvedVariable() == null) {
				if (((Variable) object.getResolvedVSpec()).getType() == null) {
					return "n/a";
				}
				type = ((PrimitveType) ((Variable) object.getResolvedVSpec())
						.getType()).getType();
			} else {
				if (((Variable) object.getResolvedVariable()).getType() == null) {
					return "n/a";
				}
				type = ((PrimitveType) ((Variable) object.getResolvedVariable())
						.getType()).getType();
			}

			if (type == PrimitiveTypeEnum.INTEGER) {
				return String
						.valueOf(((IntegerLiteralExp) ((PrimitiveValueSpecification) object
								.getValue()).getExpression()).getInteger());
			} else if (type == PrimitiveTypeEnum.REAL) {
				return ((RealLiteralExp) ((PrimitiveValueSpecification) object
						.getValue()).getExpression()).getReal();
			} else if (type == PrimitiveTypeEnum.UNLIMITED_NATURAL) {
				return String
						.valueOf(((UnlimitedLiteralExp) ((PrimitiveValueSpecification) object
								.getValue()).getExpression()).getUnlimited());
			} else if (type == PrimitiveTypeEnum.BOOLEAN) {
				return String
						.valueOf(((BooleanLiteralExp) ((PrimitiveValueSpecification) object
								.getValue()).getExpression()).isBool());
			} else if (type == PrimitiveTypeEnum.STRING) {
				return ((StringLiteralExp) ((PrimitiveValueSpecification) object
						.getValue()).getExpression()).getString();
			}
			return "n/a";
		}

		@Override
		public Object caseVInstance(VInstance object) {

			return object.getName();
		}

	}

}
