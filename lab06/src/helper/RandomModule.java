package helper;

import java.util.Random;

public class RandomModule {

	private Random random;

	private float average;
	private int n;

	private RandomModule() {
		this.random = new Random();
		average = 0;
		n = 0;
	}

	// singleton

	private static RandomModule instance;

	public static RandomModule getInstance() {
		if (instance == null)
			instance = new RandomModule();

		return instance;
	}

	/**
	 * 
	 * @param value
	 *            value of which percentage range should be computed
	 * @param percentage
	 *            5 gives 5% etc.
	 * @return calculated random within +- percentage range
	 */
	public float getRandomFloatInPercentageRange(float value, int percentage) {

		boolean positive = random.nextBoolean();

		float randomFloat = random.nextFloat();
		float randomScale = randomFloat * (((float) percentage / (float) 100));
		float randomValue = randomScale * value;

		float result = positive ? (randomValue) : (-randomValue);

		recalculateAverage(positive ? (randomScale) : (-randomScale));

		return result;
	}

	private void recalculateAverage(float nextFloat) {
		average = (n * average + nextFloat) / (n + 1);
		n++;
	}

	public float getCurrentAverage() {
		return 100*average;
	}
}
