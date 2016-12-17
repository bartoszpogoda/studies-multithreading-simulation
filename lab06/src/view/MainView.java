package view;

import controllers.MainViewController;

public interface MainView {
	public void setCurrentWaterLevels(float[] waterLevels);
	public void setNthFlowerHydrationLevel(int n, float hydrationLevel);
	public void setNthFlowerDehydrationCycleCounter(int n, int dehydrationCycleCounter);
	
	public void setMainViewController(MainViewController mainViewController);
	
	public String[] getFlowerDehydrationSteps();
	public String[] getFlowerDehydrationLimits();
	
	public String getWorldRefillInterval();
	public String getWorldRefillSpeed();
	
	public void setVisible(boolean b);
	public void setNthFlowerDehydrationLimit(int n, float dehydrationLimit);
	
	public void reportError(String errorMessage);
	public void setRandomnessAverage(float currentAverage);
	
}
