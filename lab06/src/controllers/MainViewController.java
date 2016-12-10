package controllers;

import java.awt.event.ActionListener;

import model.WaterBowlList;

public interface MainViewController extends ActionListener {
	public void setWaterBowlList(WaterBowlList waterBowlList);
}
