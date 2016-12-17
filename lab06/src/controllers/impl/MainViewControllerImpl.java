package controllers.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.Constants;
import controllers.MainViewController;
import model.WaterBowlList;
import model.impl.threads.FlowerThread;
import model.impl.threads.WorldThread;
import view.MainView;

public class MainViewControllerImpl implements MainViewController {

	private WaterBowlList waterBowlList;
	private FlowerThread[] flowerThreads;
	private WorldThread worldThread;
	private ViewRefresherThread viewRefresherThread;
	private MainView mainView;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().contains("GARDENER")) {
			int id = -1;
			
			if(arg0.getActionCommand().endsWith("1")) id = 0;
			else if(arg0.getActionCommand().endsWith("2")) id = 1;
			else if(arg0.getActionCommand().endsWith("3")) id = 2;
			
			waterBowlList.refill(id);
		}
		else if (arg0.getActionCommand().contains("RESTART_FLOWER")){
			int id = -1;
			
			if(arg0.getActionCommand().endsWith("1")) id = 0;
			else if(arg0.getActionCommand().endsWith("2")) id = 1;
			else if(arg0.getActionCommand().endsWith("3")) id = 2;

			float dehydrationLimit, dehydrationStep;
			
			try {
				dehydrationLimit = Float.parseFloat(mainView.getFlowerDehydrationLimits()[id]);
				dehydrationStep = Float.parseFloat(mainView.getFlowerDehydrationSteps()[id]);
			} catch (NumberFormatException e) {
				mainView.reportError("Wartoœci musz¹ byæ typu float");
				return;
			}
			
			flowerThreads[id].kill();
			flowerThreads[id] = new FlowerThread(waterBowlList, id, 100f, dehydrationLimit, dehydrationStep);
			flowerThreads[id].start();
		}
		else if (arg0.getActionCommand().equalsIgnoreCase("UPDATE_DATA")) {
			String[] strDehydrationLimits, strDehydrationSteps;
			
			strDehydrationLimits = mainView.getFlowerDehydrationLimits();
			strDehydrationSteps = mainView.getFlowerDehydrationSteps();

			float[] dehydrationLimits = new float[3];
			float[] dehydrationSteps = new float[3];

			try {
				for (int i = 0; i < 3; i++) {
					dehydrationLimits[i] = Float.parseFloat(strDehydrationLimits[i]);
					dehydrationSteps[i] = Float.parseFloat(strDehydrationSteps[i]);
				}
			} catch (NumberFormatException e) {
				mainView.reportError("Wartoœci musz¹ byæ typu float");
				return;
			}

			for (int i = 0; i < 3; i++) {
				flowerThreads[i].setDehydrationLimit(dehydrationLimits[i]);
				flowerThreads[i].setDehydrationStep(dehydrationSteps[i]);
			}
		} 
		else if (arg0.getActionCommand().equalsIgnoreCase("UPDATE_WORLD_DATA")) {
			int worldRefillInterval;
			float worldRefillSpeed;

			try {
				worldRefillInterval = Integer.parseInt(mainView.getWorldRefillInterval());
				worldRefillSpeed = Float.parseFloat(mainView.getWorldRefillSpeed());

			} catch (NumberFormatException e) {
				mainView.reportError("Interwa³ musi byc ca³kowity (ms), prêdkoœæ typu float");
				return;
			}

			worldThread.setRefillInterval(worldRefillInterval);
			worldThread.setRefillSpeed(worldRefillSpeed);
		}

	}

	@Override
	public void setWaterBowlList(WaterBowlList waterBowlList) {
		this.waterBowlList = waterBowlList;

	}

	@Override
	public void setFlowerThreads(FlowerThread[] flowerThreads) {
		this.flowerThreads = flowerThreads;

	}

	@Override
	public void setMainView(MainView mainView) {
		this.mainView = mainView;

	}

	@Override
	public void terminateThreads() {
		for (FlowerThread flowerThread : flowerThreads)
			flowerThread.kill();

		worldThread.kill();
		viewRefresherThread.kill();
	}

	@Override
	public void setWorldThread(WorldThread worldThread) {
		this.worldThread = worldThread;

	}

	@Override
	public void setViewRefresherThread(ViewRefresherThread viewRefresherThread) {
		this.viewRefresherThread = viewRefresherThread;

	}

}
