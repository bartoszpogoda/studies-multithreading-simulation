package view.impl;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.MainViewController;
import view.MainView;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainViewTestImpl extends JFrame implements MainView {

	private JLabel flower1, flower2, flower3;
	private JLabel bowl1, bowl2, bowl3;
	
	public MainViewTestImpl() {
		this.setSize(800,600);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {130, 200, 200, 200};
		gridBagLayout.rowHeights = new int[] {200, 0, 200};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		flower1 = new JLabel("F1");
		
				GridBagConstraints gbc_flower1 = new GridBagConstraints();
				gbc_flower1.fill = GridBagConstraints.BOTH;
				gbc_flower1.insets = new Insets(0, 0, 5, 5);
				gbc_flower1.gridx = 0;
				gbc_flower1.gridy = 0;
				getContentPane().add(flower1, gbc_flower1);
		flower2 = new JLabel("F2");
		GridBagConstraints gbc_flower2 = new GridBagConstraints();
		gbc_flower2.fill = GridBagConstraints.BOTH;
		gbc_flower2.insets = new Insets(0, 0, 5, 5);
		gbc_flower2.gridx = 1;
		gbc_flower2.gridy = 0;
		getContentPane().add(flower2, gbc_flower2);
		flower3 = new JLabel("F3");
		GridBagConstraints gbc_flower3 = new GridBagConstraints();
		gbc_flower3.fill = GridBagConstraints.BOTH;
		gbc_flower3.insets = new Insets(0, 0, 5, 5);
		gbc_flower3.gridx = 2;
		gbc_flower3.gridy = 0;
		getContentPane().add(flower3, gbc_flower3);
		
		bowl1 = new JLabel("B1");
		GridBagConstraints gbc_bowl1 = new GridBagConstraints();
		gbc_bowl1.fill = GridBagConstraints.BOTH;
		gbc_bowl1.insets = new Insets(0, 0, 0, 5);
		gbc_bowl1.gridx = 0;
		gbc_bowl1.gridy = 1;
		getContentPane().add(bowl1, gbc_bowl1);
		bowl2 = new JLabel("B2");
		GridBagConstraints gbc_bowl2 = new GridBagConstraints();
		gbc_bowl2.fill = GridBagConstraints.BOTH;
		gbc_bowl2.insets = new Insets(0, 0, 0, 5);
		gbc_bowl2.gridx = 1;
		gbc_bowl2.gridy = 1;
		getContentPane().add(bowl2, gbc_bowl2);
		bowl3 = new JLabel("B3");
		GridBagConstraints gbc_bowl3 = new GridBagConstraints();
		gbc_bowl3.insets = new Insets(0, 0, 0, 5);
		gbc_bowl3.fill = GridBagConstraints.BOTH;
		gbc_bowl3.gridx = 2;
		gbc_bowl3.gridy = 1;
		getContentPane().add(bowl3, gbc_bowl3);
		
		this.setVisible(true);
	}
	
	@Override
	public void setCurrentWaterLevels(float[] waterLevels) {
		bowl1.setText("B1: " + waterLevels[0]);
		bowl2.setText("B2: " + waterLevels[1]);
		bowl3.setText("B3: " + waterLevels[2]);
		
	}

	@Override
	public void setNthFlowerHydrationLevel(int n, float hydrationLevel) {
		if(n==0){
			flower1.setText("F1: " + hydrationLevel);
		} else if(n == 1){
			flower2.setText("F2: " + hydrationLevel);
		} else if(n == 2){
			flower3.setText("F3: " + hydrationLevel);
		}
	}

	@Override
	public void setMainViewController(MainViewController mainViewController) {
		// TODO Auto-generated method stub
		
	}

}
