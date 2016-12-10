package model;

public interface Flower {
	public float getHydrationLevel();
	public float getDehydrationLimit();
	
	public void setDehydrationLimit(float dehydrationLimit);
	public void setDehydrationStep(float dehydrationStep);
}
