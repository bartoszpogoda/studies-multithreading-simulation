package controllers;

import java.awt.event.ActionListener;

import controllers.impl.ViewRefresherThread;
import model.WaterBowlList;
import model.impl.threads.FlowerThread;
import model.impl.threads.WorldThread;
import view.MainView;

public interface MainViewController extends ActionListener {
	public void setWaterBowlList(WaterBowlList waterBowlList);

	public void setFlowerThreads(FlowerThread[] flowerThreads);
	public void setWorldThread(WorldThread worldThread);
	public void setViewRefresherThread(ViewRefresherThread viewRefresherThread);
	
	public void terminateThreads();

	void setMainView(MainView mainView);
}
