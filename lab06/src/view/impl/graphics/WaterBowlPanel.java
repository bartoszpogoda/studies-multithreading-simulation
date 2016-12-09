package view.impl.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class WaterBowlPanel extends JPanel {
	
	private float currentWaterLevel;
	
	public void setCurrentWaterLevel(float currentWaterLevel){
		this.currentWaterLevel = currentWaterLevel;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		
		int scaledY = (int)((currentWaterLevel/100f)*this.getHeight());

		g2d.setColor(new Color(0.2f,0.6f,0.2f,(float)0.5));
		g2d.fillRect(0, this.getHeight()-scaledY, this.getWidth(), scaledY);
		
		
	}
}
