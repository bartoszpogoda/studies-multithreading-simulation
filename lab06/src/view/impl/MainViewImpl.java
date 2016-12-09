package view.impl;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import controllers.MainViewController;
import view.MainView;
import view.impl.graphics.FlowerPanel;
import view.impl.graphics.WaterBowlPanel;

import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class MainViewImpl extends JFrame implements MainView {
	private JTextField[] tfDehydrationSteps;
	private JTextField[] tfDehydrationLimits;
	
	private FlowerPanel[] flowerPanels;
	private WaterBowlPanel panelWaterBowl1, panelWaterBowl2, panelWaterBowl3;
	private JButton btnGardener1, btnGardener2, btnGardener3, btnUpdateData;
	
	public MainViewImpl() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		this.setSize(800,600);
		
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
	public void setMainViewController(MainViewController mainViewController) {
		btnGardener1.addActionListener(mainViewController);
		btnGardener1.setActionCommand("GARDENER_1");
		btnGardener2.addActionListener(mainViewController);
		btnGardener2.setActionCommand("GARDENER_2");
		btnGardener3.addActionListener(mainViewController);
		btnGardener3.setActionCommand("GARDENER_3");
		btnUpdateData.addActionListener(mainViewController);
		btnUpdateData.setActionCommand("UPDATE_DATA");
		
	}
	@Override
	public String getNthFlowerDehydrationStep(int n) {
		return tfDehydrationSteps[n].getText();
	}
	@Override
	public String getNthFlowerDehydrationLimit(int n) {
		return tfDehydrationLimits[n].getText();
	}
}
