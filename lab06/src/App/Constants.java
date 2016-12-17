package App;

public class Constants {
	public static final int DEHYDRATION_MS_INTERAVAL = 50;
	public static final int CYCLES_OF_DEHYDRATION_TO_DIE = 50;
	public static final float DEHYDRATION_DYING_LEVEL = 0.5f;
	public static final int RANDOMNESS_IN_PERCENTS = 5;
	
	//flower 1 defaults
	public static final float F1_INIT_HYDRATION_LEVEL = 87.5f;
	public static final float F1_INIT_DEHYDRATION_STEP = 0.05f;
	public static final float F1_INIT_DEHYDRATION_LIMIT = 33.2f;
	
	//flower 2 defaults
	public static final float F2_INIT_HYDRATION_LEVEL = 25.2f;
	public static final float F2_INIT_DEHYDRATION_STEP = 0.66f;
	public static final float F2_INIT_DEHYDRATION_LIMIT = 10f;
	
	//flower 3 defaults
	public static final float F3_INIT_HYDRATION_LEVEL = 100f;
	public static final float F3_INIT_DEHYDRATION_STEP = 0.44f;
	public static final float F3_INIT_DEHYDRATION_LIMIT = 5f;
	
	//water bowls
	public static final int WATER_BOWL_WATER_MAX_LEVEL = 100;
	public static final int WATER_BOWL_WATER_INIT_LEVEL = 100;
	
	//view refresher
	public static final int VIEW_REFRESHER_INTERVAL = 32;
	
	//world constants
	public static final float WORLD_INIT_REFILL_SPEED = 0.77f;
	public static final int WORLD_INIT_REFILL_INTERVAL = 100;
}
