package view.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class FlowerPanel extends JPanel{
	
	private float hydrationLevel;
	private float dehydrationLimit;
	private float dehydrationStep;
	private int dehydrationCycleCounter = 0;
	
	private Image flowerImage;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		//placeholder bef image
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		//test
		hydrationLevel =  12.4f;
		
		int scaledY = (int)((hydrationLevel/100f)*this.getHeight());

		g2d.setColor(new Color(0.2f,0.6f,0.2f,(float)0.5));
		g2d.fillRect(0, this.getHeight()-scaledY, this.getWidth(), scaledY);
		
		
	}
}
