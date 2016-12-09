package view.impl.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import App.Constants;

public class FlowerPanel extends JPanel{
	
	private float hydrationLevel = 0f;
	private int dehydrationCycleCounter = 0;
	
	//TODO: private Image flowerImage;
	
	public void setHydrationLevel(float hydrationLevel){
		this.hydrationLevel = hydrationLevel;
		repaint();
	}
	
	public void setDehydrationCycleCounter(int dehydrationCycleCounter){
		this.dehydrationCycleCounter = dehydrationCycleCounter;
		repaint();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		//placeholder bef image
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		//dead
		if(dehydrationCycleCounter >= Constants.CYCLES_OF_DEHYDRATION_TO_DIE){
			g2d.setColor(new Color(102,0,0)); 
			g2d.fillRect(0, 0, getWidth(), getHeight());
		}
		else if(dehydrationCycleCounter == 0){
			
			int scaledY = (int)((hydrationLevel/100f)*this.getHeight());

			g2d.setColor(new Color(0.2f,0.6f,0.2f,(float)0.5));
			g2d.fillRect(0, this.getHeight()-scaledY, this.getWidth(), scaledY);
		} else{
			//dying
			int scaledY = (int)(((float)dehydrationCycleCounter/(float)Constants.CYCLES_OF_DEHYDRATION_TO_DIE)*this.getHeight());

			g2d.setColor(new Color(153,0,0)); 
			g2d.fillRect(0, this.getHeight()-scaledY, this.getWidth(), scaledY);
		}
		
	}
}
