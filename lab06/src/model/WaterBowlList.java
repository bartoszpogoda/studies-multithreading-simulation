package model;

public interface WaterBowlList {
	public float[] getCurrentWaterLevels();
	
	//gardener
	public void refill(int n);

	public float askForWater(int number, float hydrationLevel);
}
