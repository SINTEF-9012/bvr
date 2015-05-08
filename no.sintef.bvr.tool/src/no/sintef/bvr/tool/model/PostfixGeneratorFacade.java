package no.sintef.bvr.tool.model;

import java.sql.Timestamp;
import java.util.Calendar;

import no.sintef.bvr.tool.exception.UnexpectedException;
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

	public String getDelimiter() {
		return generator.getPostfixDelimiter();
	}

	public String removePostfix(String str) {
		return generator.removePostfix(str);
	}

	public void setPostfixGenerator(IPostfixGenerator _generator) {
		generator = (_generator == null) ? new DefaultPostfixGenerator() : _generator;
	}

	private class DefaultPostfixGenerator implements IPostfixGenerator {

		private final String DELIMITER = "@";
		private int count = 0;
		// bits are millesconds)
		private final int MASK_COUNT = 0x3FF; // to mask count, so we use the
												// last
												// 10 bits

		private String getPostfixTimestampBased() {
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

		private String getPostfixCountBased() {
			return DELIMITER + ++count;
		}

		@Override
		public String getPostfix() {
			return getPostfixCountBased();
		}

		@Override
		public String getPostfixDelimiter() {
			return DELIMITER;
		}

		@Override
		public String removePostfix(String str) {
			if (!str.contains(DELIMITER))
				throw new UnexpectedException("Invalid string, can not fine delimiter" + str);

			String[] strings = str.split(DELIMITER);
			if (strings.length != 2)
				throw new UnexpectedException("Invalid string, delimiter does not split string in 2 parts (do not know how to remove delimeter): " + str);

			return strings[0];
		}

	}
}
