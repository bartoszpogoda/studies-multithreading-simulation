package view.impl;

import javax.swing.JFrame;

public class FlowerPanelTestFrame extends JFrame {
	public FlowerPanelTestFrame() {
		this.setSize(300,300);
		FlowerPanel fp = new FlowerPanel();
		this.add(fp);
		this.setVisible(true);
		
		fp.repaint();
		
		
	}
}
