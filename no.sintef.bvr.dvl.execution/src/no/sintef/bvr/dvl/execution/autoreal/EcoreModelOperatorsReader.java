package no.sintef.bvr.dvl.execution.autoreal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.operators.interfaces.IOperator;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.repository.interfaces.IOperatorsReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import realop.Operator;

public class EcoreModelOperatorsReader implements IOperatorsReader {

	private String realop_file;
	private EcoreModelOperatorConverter operatorConverte;
	private EcoreOperatorDeserializer converter;

	public EcoreModelOperatorsReader(String _file_path) {
		converter = new EcoreOperatorDeserializer();
		realop_file = _file_path;
		operatorConverte = new EcoreModelOperatorConverter();
	}

	@Override
	public Operators read() throws ReaderException {
		Operators operators = new Operators();

		try {
			List<Operator> ecore_operators = converter.deserialize(realop_file);
			for (Operator ecore_operator : ecore_operators) {
				IOperator operator = operatorConverte.convert(ecore_operator);
				operators.add((no.sintef.bvr.planner.operators.Operator) operator);
			}
		} catch (Exception ex) {
			throw new ReaderException(ex.getMessage(), ex);
		}
		return operators;
	}

	public class EcoreOperatorDeserializer {

		public List<Operator> deserialize(String src) {
			Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
			registry.getExtensionToFactoryMap().put("realop", new XMIResourceFactoryImpl());

			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(src, true), true);
			return new ArrayList<Operator>((Collection<? extends Operator>) resource.getContents());
		}

	}
}
