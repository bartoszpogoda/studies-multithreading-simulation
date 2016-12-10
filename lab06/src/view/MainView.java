package view;

import controllers.MainViewController;

public interface MainView {
	public void setCurrentWaterLevels(float[] waterLevels);
	public void setNthFlowerHydrationLevel(int n, float hydrationLevel);
	public void setNthFlowerDehydrationCycleCounter(int n, int dehydrationCycleCounter);
	
	public void setMainViewController(MainViewController mainViewController);
	
	public String getNthFlowerDehydrationStep(int n);
	public String getNthFlowerDehydrationLimit(int n);
	
	public void setVisible(boolean b);
	public void setNthFlowerDehydrationLimit(int n, float dehydrationLimit);
	
}
