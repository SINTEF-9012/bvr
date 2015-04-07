package no.sintef.bvr.tool.model;

import java.sql.Timestamp;
import java.util.Calendar;

import no.sintef.bvr.tool.interfaces.model.IPostfixGenerator;

public class PostfixGeneratorFacade {

	public static PostfixGeneratorFacade eINSTANCE = getInstance();
	private IPostfixGenerator generator;
	// bits are millesconds)
	private final int MASK_COUNT = 0x3FF; // to mask count, so we use the last
											// 10 bits
	private int count = 0;

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

	public String getDelimiter() {
		return generator.getPostfixDelimiter();
	}

	public void setPostfixGenerator(IPostfixGenerator _generator) {
		generator = (_generator == null) ? new DefaultPostfixGenerator() : _generator;
	}

	private class DefaultPostfixGenerator implements IPostfixGenerator {

		private final String DELIMITER = "@";

		@Override
		public String getPostfix() {
			Calendar calender = Calendar.getInstance();
			Timestamp currentTimestamp = new Timestamp(calender.getTime().getTime());
			long temestamp_millsec = currentTimestamp.getTime();
			long timestamp_sec = temestamp_millsec / 1000;
			// hopefully we do not create vspec with velocity which is more than
			// 999 vspecs per second, otherwise it will be a repetition
			long postfix = (timestamp_sec * 1000) + (count & MASK_COUNT);
			count++;
			return DELIMITER + postfix;
		}

		@Override
		public String getPostfixDelimiter() {
			return DELIMITER;
		}

	}
}
