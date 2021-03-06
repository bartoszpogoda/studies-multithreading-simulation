package view.impl.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import App.Constants;

public class FlowerPanel extends JPanel{
	
	private float hydrationLevel = 0f;
	private float dehydrationLimit = 0f;
	private int dehydrationCycleCounter = 0;
	private Image flowerImage;
	
	public void setHydrationLevel(float hydrationLevel){
		this.hydrationLevel = hydrationLevel;
		repaint();
	}
	
	public void setDehydrationCycleCounter(int dehydrationCycleCounter){
		this.dehydrationCycleCounter = dehydrationCycleCounter;
		repaint();
	}
	
	public void setFlowerImage(Image flowerImage){
		this.flowerImage = flowerImage;
	}
	
	public void setDehydrationLimit(float dehydrationLimit){
		this.dehydrationLimit = dehydrationLimit;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		
		if(flowerImage == null){
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, getWidth(), getHeight());
		} else{
			g2d.drawImage(flowerImage, 0, 0, null);
		}
		
		//dead
		if(dehydrationCycleCounter >= Constants.CYCLES_OF_DEHYDRATION_TO_DIE){
			g2d.setColor(new Color(102,0,0)); 
			g2d.fillRect(0, 0, getWidth(), getHeight());
		}
		else if(dehydrationCycleCounter == 0){ // alive
			
			// dehydrationLimit lane draw
			int scaledDehydrationLimitY = (int)((dehydrationLimit/100f)*this.getHeight());
			g2d.setColor(Color.RED);
			g2d.drawLine(0, getHeight() - scaledDehydrationLimitY, getWidth(), getHeight() - scaledDehydrationLimitY);
			
			int scaledY = (int)((hydrationLevel/100f)*this.getHeight());

			g2d.setColor(new Color(0.2f,0.6f,0.8f,(float)0.5));
			g2d.fillRect(0, this.getHeight()-scaledY, this.getWidth(), scaledY);
		} else{
			//dying
			int scaledY = (int)(((float)dehydrationCycleCounter/(float)Constants.CYCLES_OF_DEHYDRATION_TO_DIE)*this.getHeight());

			g2d.setColor(new Color(153,0,0)); 
			g2d.fillRect(0, this.getHeight()-scaledY, this.getWidth(), scaledY);
		}
		
	}
}
