package no.sintef.bvr.tool.model;

import java.sql.Timestamp;
import java.util.Calendar;

import no.sintef.bvr.tool.interfaces.model.IPostfixGenerator;

public class PostfixGeneratorFacade {

	public static PostfixGeneratorFacade eINSTANCE = getInstance();
	private IPostfixGenerator generator;

	private PostfixGeneratorFacade() {
		generator = new DefaultPostfixGenerator();
	};

	private static PostfixGeneratorFacade getInstance() {
		if (eINSTANCE == null)
			eINSTANCE = new PostfixGeneratorFacade();
		return eINSTANCE;
	}

	public String getUnique() {
		return generator.getPostfix();
	}

	public void setPostfixGenerator(IPostfixGenerator _generator) {
		generator = (_generator == null) ? new DefaultPostfixGenerator() : _generator;
	}

	private class DefaultPostfixGenerator implements IPostfixGenerator {

		private Calendar calender = Calendar.getInstance();

		@Override
		public String getPostfix() {
			Timestamp currentTimestamp = new Timestamp(calender.getTime().getTime());
			return "@" + currentTimestamp.getTime();
		}

	}
}
