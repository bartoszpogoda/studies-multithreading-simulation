package controllers.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.MainViewController;
import model.WaterBowlList;

public class MainViewControllerImpl implements MainViewController{

	private WaterBowlList waterBowlList;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equalsIgnoreCase("GARDENER_1")){
			waterBowlList.refill(0);
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("GARDENER_2")){
			waterBowlList.refill(1);
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("GARDENER_3")){
			waterBowlList.refill(2);
		}
		
	}

	@Override
	public void setWaterBowlList(WaterBowlList waterBowlList) {
		this.waterBowlList = waterBowlList;
		
	}

}
