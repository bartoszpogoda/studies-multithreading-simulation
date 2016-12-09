package controllers;

import java.awt.event.ActionListener;

import view.IWaterBowlListGUI;

public interface MainViewController extends ActionListener {
	public void setWaterBowlList(IWaterBowlListGUI waterBowlList);
}
