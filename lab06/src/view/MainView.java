package view;

import controllers.MainViewController;

public interface MainView {
	public void setCurrentWaterLevels(float[] waterLevels);
	public void setNthFlowerHydrationLevel(int n, float hydrationLevel);
	
	public void setMainViewController(MainViewController mainViewController);
}
