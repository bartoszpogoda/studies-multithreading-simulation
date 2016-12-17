package controllers;

import java.awt.event.ActionListener;

import controllers.impl.ViewRefresherThread;
import model.WaterBowlList;
import model.impl.threads.FlowerThread;
import model.impl.threads.WorldThread;
import view.MainView;

public interface MainViewController extends ActionListener {

	// dependencies
	void setWaterBowlList(WaterBowlList waterBowlList);

	void setFlowerThreads(FlowerThread[] flowerThreads);

	void setWorldThread(WorldThread worldThread);

	void setViewRefresherThread(ViewRefresherThread viewRefresherThread);

	void setMainView(MainView mainView);

	/**
	 * kills all threads
	 */
	void terminateThreads();

}
