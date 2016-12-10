package view.impl;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import App.Constants;
import controllers.MainViewController;
import view.MainView;
import view.impl.graphics.FlowerPanel;
import view.impl.graphics.WaterBowlPanel;

import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class MainViewImpl extends JFrame implements MainView {
	private JTextField[] tfDehydrationSteps;
	private JTextField[] tfDehydrationLimits;
	
	private FlowerPanel[] flowerPanels;
	private WaterBowlPanel panelWaterBowl1, panelWaterBowl2, panelWaterBowl3;
	private JButton btnGardener1, btnGardener2, btnGardener3, btnUpdateData, btnUpdateWorldData;
	private JTextField tfWorldRefillInterval;
	private JTextField tfWorldRefillSpeed;
	private JButton btnRestartFlower1;
	private JButton btnRestartFlower2;
	private JButton btnRestartFlower3;
	
	public MainViewImpl() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		setSize(800,600);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		getContentPane().setBackground(new Color(240, 255, 255));
		getContentPane().setLayout(null);
		
		flowerPanels = new FlowerPanel[3];
		tfDehydrationSteps = new JTextField[3];
		tfDehydrationLimits = new JTextField[3];
		
		flowerPanels[0] = new FlowerPanel();
		flowerPanels[0].setBounds(200, 227, 150, 150);
		getContentPane().add(flowerPanels[0]);
		
		tfDehydrationSteps[0] = new JTextField();
		tfDehydrationSteps[0].setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDehydrationSteps[0].setBounds(200, 116, 150, 30);
		getContentPane().add(tfDehydrationSteps[0]);
		tfDehydrationSteps[0].setColumns(10);
		
		tfDehydrationLimits[0] = new JTextField();
		tfDehydrationLimits[0].setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDehydrationLimits[0].setColumns(10);
		tfDehydrationLimits[0].setBounds(200, 73, 150, 30);
		getContentPane().add(tfDehydrationLimits[0]);
		
		panelWaterBowl1 = new WaterBowlPanel();
		panelWaterBowl1.setBounds(200, 424, 150, 61);
		getContentPane().add(panelWaterBowl1);
		
		JLabel lblDehydrationLimit = new JLabel("Pr\u00F3g wysychania");
		lblDehydrationLimit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDehydrationLimit.setBounds(27, 67, 143, 41);
		getContentPane().add(lblDehydrationLimit);
		
		JLabel lblDehydrationStep = new JLabel("Krok wysychania");
		lblDehydrationStep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDehydrationStep.setBounds(27, 122, 125, 16);
		getContentPane().add(lblDehydrationStep);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(222, 184, 135));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ogrodnik", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(0, 498, 782, 55);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnGardener1 = new JButton("Nape\u0142nij");
		btnGardener1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGardener1.setBackground(new Color(245, 255, 250));
		btnGardener1.setBounds(200, 18, 150, 25);
		panel_2.add(btnGardener1);
		
		btnGardener2 = new JButton("Nape\u0142nij");
		btnGardener2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGardener2.setBackground(new Color(245, 255, 250));
		btnGardener2.setBounds(400, 18, 150, 25);
		panel_2.add(btnGardener2);
		
		btnGardener3 = new JButton("Nape\u0142nij");
		btnGardener3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGardener3.setBackground(new Color(245, 255, 250));
		btnGardener3.setBounds(600, 18, 150, 25);
		panel_2.add(btnGardener3);
		
		JLabel lblFlower1 = new JLabel("Ro\u015Blina 1");
		lblFlower1.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblFlower1.setBounds(234, 41, 93, 19);
		getContentPane().add(lblFlower1);
		
		panelWaterBowl2 = new WaterBowlPanel();
		panelWaterBowl2.setBounds(400, 424, 150, 61);
		getContentPane().add(panelWaterBowl2);
		
		flowerPanels[1] = new FlowerPanel();
		flowerPanels[1].setBounds(400, 227, 150, 150);
		getContentPane().add(flowerPanels[1]);
		
		tfDehydrationSteps[1] = new JTextField();
		tfDehydrationSteps[1].setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDehydrationSteps[1].setColumns(10);
		tfDehydrationSteps[1].setBounds(400, 116, 150, 30);
		getContentPane().add(tfDehydrationSteps[1]);
		
		tfDehydrationLimits[1] = new JTextField();
		tfDehydrationLimits[1].setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDehydrationLimits[1].setColumns(10);
		tfDehydrationLimits[1].setBounds(400, 73, 150, 30);
		getContentPane().add(tfDehydrationLimits[1]);
		
		JLabel lblFlower2 = new JLabel("Ro\u015Blina 2");
		lblFlower2.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblFlower2.setBounds(428, 41, 93, 19);
		getContentPane().add(lblFlower2);
		
		panelWaterBowl3 = new WaterBowlPanel();
		panelWaterBowl3.setBounds(600, 424, 150, 61);
		getContentPane().add(panelWaterBowl3);
		
		flowerPanels[2] = new FlowerPanel();
		flowerPanels[2].setBounds(600, 227, 150, 150);
		getContentPane().add(flowerPanels[2]);
		
		tfDehydrationSteps[2] = new JTextField();
		tfDehydrationSteps[2].setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDehydrationSteps[2].setColumns(10);
		tfDehydrationSteps[2].setBounds(600, 116, 150, 30);
		getContentPane().add(tfDehydrationSteps[2]);
		
		tfDehydrationLimits[2] = new JTextField();
		tfDehydrationLimits[2].setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDehydrationLimits[2].setColumns(10);
		tfDehydrationLimits[2].setBounds(600, 73, 150, 30);
		getContentPane().add(tfDehydrationLimits[2]);
		
		JLabel lblFlower3 = new JLabel("Ro\u015Blina 3");
		lblFlower3.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblFlower3.setBounds(632, 41, 93, 19);
		getContentPane().add(lblFlower3);
		
		btnUpdateData = new JButton("Zaktualizuj dane");
		btnUpdateData.setBackground(new Color(255, 255, 255));
		btnUpdateData.setBounds(200, 171, 550, 25);
		getContentPane().add(btnUpdateData);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\u015Awiat", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(30, 212, 140, 187);
		getContentPane().add(panel);
		
		
		JLabel lblWorldRefillInterval = new JLabel("Interwa\u0142 opad\u00F3w");
		lblWorldRefillInterval.setBounds(12, 22, 125, 16);
		panel.add(lblWorldRefillInterval);
		lblWorldRefillInterval.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfWorldRefillInterval = new JTextField();
		tfWorldRefillInterval.setBounds(12, 51, 116, 22);
		panel.add(tfWorldRefillInterval);
		tfWorldRefillInterval.setColumns(10);
		
		JLabel lblWorldRefillSpeed = new JLabel("Nasilenie opad\u00F3w");
		lblWorldRefillSpeed.setBounds(12, 86, 125, 16);
		panel.add(lblWorldRefillSpeed);
		lblWorldRefillSpeed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfWorldRefillSpeed = new JTextField();
		tfWorldRefillSpeed.setBounds(12, 115, 116, 22);
		panel.add(tfWorldRefillSpeed);
		tfWorldRefillSpeed.setColumns(10);
		
		btnUpdateWorldData = new JButton("Zaktualizuj");
		btnUpdateWorldData.setBackground(new Color(245, 245, 245));
		btnUpdateWorldData.setBounds(12, 150, 116, 25);
		panel.add(btnUpdateWorldData);
		
		btnRestartFlower1 = new JButton("");
		btnRestartFlower1.setBackground(new Color(0, 0, 255));
		btnRestartFlower1.setBounds(265, 13, 25, 16);
		getContentPane().add(btnRestartFlower1);
		
		btnRestartFlower2 = new JButton("");
		btnRestartFlower2.setBackground(new Color(255, 0, 0));
		btnRestartFlower2.setBounds(455, 12, 25, 16);
		getContentPane().add(btnRestartFlower2);
		
		btnRestartFlower3 = new JButton("");
		btnRestartFlower3.setBackground(new Color(255, 255, 0));
		btnRestartFlower3.setBounds(660, 13, 25, 16);
		getContentPane().add(btnRestartFlower3);
		
		tfDehydrationSteps[0].setText(Float.toString(Constants.F1_INIT_DEHYDRATION_STEP));
		tfDehydrationSteps[1].setText(Float.toString(Constants.F2_INIT_DEHYDRATION_STEP));
		tfDehydrationSteps[2].setText(Float.toString(Constants.F3_INIT_DEHYDRATION_STEP));
		
		tfDehydrationLimits[0].setText(Float.toString(Constants.F1_INIT_DEHYDRATION_LIMIT));
		tfDehydrationLimits[1].setText(Float.toString(Constants.F2_INIT_DEHYDRATION_LIMIT));
		tfDehydrationLimits[2].setText(Float.toString(Constants.F3_INIT_DEHYDRATION_LIMIT));

		tfWorldRefillInterval.setText(Integer.toString(Constants.WORLD_INIT_REFILL_INTERVAL));
		tfWorldRefillSpeed.setText(Float.toString(Constants.WORLD_INIT_REFILL_SPEED));
		try {
			Image flower1 = ImageIO.read(new File("blue_flower.png"));
			Image flower2 = ImageIO.read(new File("red_flower.png"));
			Image flower3 = ImageIO.read(new File("yellow_flower.png"));
			
			flowerPanels[0].setFlowerImage(flower1);
			flowerPanels[1].setFlowerImage(flower2);
			flowerPanels[2].setFlowerImage(flower3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void setCurrentWaterLevels(float[] waterLevels) {
		panelWaterBowl1.setCurrentWaterLevel(waterLevels[0]);
		panelWaterBowl2.setCurrentWaterLevel(waterLevels[1]);
		panelWaterBowl3.setCurrentWaterLevel(waterLevels[2]);
	}
	@Override
	public void setNthFlowerHydrationLevel(int n, float hydrationLevel) {
		flowerPanels[n].setHydrationLevel(hydrationLevel);
	}
	@Override
	public void setNthFlowerDehydrationCycleCounter(int n, int dehydrationCycleCounter) {
		flowerPanels[n].setDehydrationCycleCounter(dehydrationCycleCounter);
	}
	@Override
	public void setNthFlowerDehydrationLimit(int n, float dehydrationLimit) {
		flowerPanels[n].setDehydrationLimit(dehydrationLimit);
	}
	@Override
	public void setMainViewController(MainViewController mainViewController) {
		//gardeners
		btnGardener1.addActionListener(mainViewController);
		btnGardener1.setActionCommand("GARDENER_1");
		btnGardener2.addActionListener(mainViewController);
		btnGardener2.setActionCommand("GARDENER_2");
		btnGardener3.addActionListener(mainViewController);
		btnGardener3.setActionCommand("GARDENER_3");
		
		//data updates
		btnUpdateData.addActionListener(mainViewController);
		btnUpdateData.setActionCommand("UPDATE_DATA");
		btnUpdateWorldData.addActionListener(mainViewController);
		btnUpdateWorldData.setActionCommand("UPDATE_WORLD_DATA");
		
		//restarts
		btnRestartFlower1.addActionListener(mainViewController);
		btnRestartFlower1.setActionCommand("RESTART_FLOWER_1");
		btnRestartFlower2.addActionListener(mainViewController);
		btnRestartFlower2.setActionCommand("RESTART_FLOWER_2");
		btnRestartFlower3.addActionListener(mainViewController);
		btnRestartFlower3.setActionCommand("RESTART_FLOWER_3");
		
		//terminate threads on window close
		this.addWindowListener(new WindowListener(){
			@Override
			public void windowActivated(WindowEvent arg0) {}
			
			@Override
			public void windowClosed(WindowEvent arg0) { 
				mainViewController.terminateThreads();
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {}

			@Override
			public void windowDeactivated(WindowEvent arg0) {}

			@Override
			public void windowDeiconified(WindowEvent arg0) {}

			@Override
			public void windowIconified(WindowEvent arg0) {	}

			@Override
			public void windowOpened(WindowEvent arg0) { }
			
		});
		
	}

	@Override
	public void reportError(String message) {
		JOptionPane.showMessageDialog(this, message, "B³¹d", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public String getWorldRefillInterval() {
		return tfWorldRefillInterval.getText();
	}

	@Override
	public String getWorldRefillSpeed() {
		return tfWorldRefillSpeed.getText();
	}

	@Override
	public String[] getFlowerDehydrationSteps() {
		String flowerDehydrationSteps[] = new String[3];
		
		for(int i=0; i<3; i++){
			flowerDehydrationSteps[i] = tfDehydrationSteps[i].getText();
		}
		
		return flowerDehydrationSteps;
	}

	@Override
	public String[] getFlowerDehydrationLimits() {
		String flowerDehydrationLimits[] = new String[3];
		
		for(int i=0; i<3; i++){
			flowerDehydrationLimits[i] = tfDehydrationLimits[i].getText();
		}
		
		return flowerDehydrationLimits;
	}
}
