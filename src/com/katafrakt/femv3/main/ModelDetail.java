package com.katafrakt.femv3.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import javax.swing.JSlider;

import com.katafrakt.femv3.elements.Element;
import com.katafrakt.femv3.models.Model;

public class ModelDetail extends JPanel implements ChangeListener{
	int width;
	int height;
	JList list;
	private JLabel lblLocal1;
	private JLabel lblGlobal1;
	private JLabel lbldefX1;
	private JLabel lbldefY1;
	private JLabel lbldeltaX1;
	private JLabel lbldeltaY1;
	private JLabel lblLocal2;
	private JLabel lblGlobal2;
	private JLabel lbldefX2;
	private JLabel lbldefY2;
	private JLabel lbldeltaX2;
	private JLabel lbldeltaY2;
	private JComboBox comboModel;
	private DefaultListModel<Element> dataModel;
	private JLabel lblStress;
	private JLabel lblArea;
	private JLabel lblMm_1;
	private JLabel lblNmm;
	private JLabel lblTrescaR;
	private JLabel textAreaR;
	private JLabel textIndexR;
	private JLabel lblElement;
	private JLabel lblNodes;
	private JLabel lblMm_3;
	private JLabel lblMm_4;
	private JLabel lblMm_5;
	private JLabel lblMm_6;
	private JPanel panel_1;
	private JPanel panel_2;
	public Element selectedE;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblGlobal3;
	private JLabel lblGlobal4;
	private JLabel lbldefX3;
	private JLabel lbldefX4;
	private JLabel lbldefY3;
	private JLabel lbldefY4;
	private JLabel lbldeltaX3;
	private JLabel lbldeltaX4;
	private JLabel lbldeltaY3;
	private JLabel lbldeltaY4;
	private JLabel lblStressX;
	private JLabel lblStressY;
	private JLabel lblShear;
	private JLabel lblTresca;
	private JLabel lblShearR;
	private JLabel lblStressYR;
	private JLabel lblStressXR;
	private JLabel lblName;
	private JLabel lblName1;
	private JLabel lblName2;
	private JLabel lblName3;
	private JLabel lblName4;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public ModelDetail(int width,int height) {
		setLayout(null);
		this.width=width;
		this.height=height;
		setPreferredSize(new Dimension(600, 750));
		
		
		dataModel=new DefaultListModel<Element>();
		for(Element e:Model.currentModel.elementList)
			dataModel.addElement(e);
		list = new JList(dataModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//list.setBounds(12, 48, 200, 195);
		//add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(12, 48);
		scrollPane.setSize(258, 130);
		scrollPane.setViewportView(list);
		add(scrollPane);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(12, 229, 576, 393);

		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {40, 100, 100, 100, 100, 40};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblElement = new JLabel("Element");
		lblElement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblElement = new GridBagConstraints();
		gbc_lblElement.anchor = GridBagConstraints.WEST;
		gbc_lblElement.insets = new Insets(0, 0, 5, 5);
		gbc_lblElement.gridx = 0;
		gbc_lblElement.gridy = 0;
		panel.add(lblElement, gbc_lblElement);
		
		textIndexR = new JLabel("-");
		GridBagConstraints gbc_textIndexR = new GridBagConstraints();
		gbc_textIndexR.insets = new Insets(0, 0, 5, 5);
		gbc_textIndexR.gridx = 1;
		gbc_textIndexR.gridy = 0;
		panel.add(textIndexR, gbc_textIndexR);
		
		lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblArea = new GridBagConstraints();
		gbc_lblArea.anchor = GridBagConstraints.WEST;
		gbc_lblArea.insets = new Insets(0, 0, 5, 5);
		gbc_lblArea.gridx = 0;
		gbc_lblArea.gridy = 1;
		panel.add(lblArea, gbc_lblArea);
		
		textAreaR = new JLabel("-");
		GridBagConstraints gbc_textAreaR = new GridBagConstraints();
		gbc_textAreaR.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaR.gridx = 1;
		gbc_textAreaR.gridy = 1;
		panel.add(textAreaR, gbc_textAreaR);
		
		lblMm_1 = new JLabel("mm^2");
		lblMm_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_1 = new GridBagConstraints();
		gbc_lblMm_1.anchor = GridBagConstraints.WEST;
		gbc_lblMm_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMm_1.gridx = 2;
		gbc_lblMm_1.gridy = 1;
		panel.add(lblMm_1, gbc_lblMm_1);
		
		lblStressX = new JLabel("Stress x");
		lblStressX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStressX = new GridBagConstraints();
		gbc_lblStressX.insets = new Insets(0, 0, 5, 5);
		gbc_lblStressX.gridx = 1;
		gbc_lblStressX.gridy = 2;
		panel.add(lblStressX, gbc_lblStressX);
		
		lblStressY = new JLabel("Stress y");
		lblStressY.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStressY = new GridBagConstraints();
		gbc_lblStressY.insets = new Insets(0, 0, 5, 5);
		gbc_lblStressY.gridx = 2;
		gbc_lblStressY.gridy = 2;
		panel.add(lblStressY, gbc_lblStressY);
		
		lblShear = new JLabel("Shear");
		lblShear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblShear = new GridBagConstraints();
		gbc_lblShear.insets = new Insets(0, 0, 5, 5);
		gbc_lblShear.gridx = 3;
		gbc_lblShear.gridy = 2;
		panel.add(lblShear, gbc_lblShear);
		
		lblTresca = new JLabel("Tresca");
		lblTresca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTresca = new GridBagConstraints();
		gbc_lblTresca.insets = new Insets(0, 0, 5, 5);
		gbc_lblTresca.gridx = 4;
		gbc_lblTresca.gridy = 2;
		panel.add(lblTresca, gbc_lblTresca);
		
		lblStress = new JLabel("CenterStress");
		lblStress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStress = new GridBagConstraints();
		gbc_lblStress.anchor = GridBagConstraints.WEST;
		gbc_lblStress.insets = new Insets(0, 0, 5, 5);
		gbc_lblStress.gridx = 0;
		gbc_lblStress.gridy = 3;
		panel.add(lblStress, gbc_lblStress);
		
		lblStressXR = new JLabel("-");
		lblStressXR.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblStressXR = new GridBagConstraints();
		gbc_lblStressXR.insets = new Insets(0, 0, 5, 5);
		gbc_lblStressXR.gridx = 1;
		gbc_lblStressXR.gridy = 3;
		panel.add(lblStressXR, gbc_lblStressXR);
		
		lblStressYR = new JLabel("-");
		lblStressYR.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblStressYR = new GridBagConstraints();
		gbc_lblStressYR.insets = new Insets(0, 0, 5, 5);
		gbc_lblStressYR.gridx = 2;
		gbc_lblStressYR.gridy = 3;
		panel.add(lblStressYR, gbc_lblStressYR);
		
		lblShearR = new JLabel("-");
		lblShearR.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblShearR = new GridBagConstraints();
		gbc_lblShearR.insets = new Insets(0, 0, 5, 5);
		gbc_lblShearR.gridx = 3;
		gbc_lblShearR.gridy = 3;
		panel.add(lblShearR, gbc_lblShearR);
		
		lblTrescaR = new JLabel("-");
		lblTrescaR.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblTrescaR = new GridBagConstraints();
		gbc_lblTrescaR.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrescaR.gridx = 4;
		gbc_lblTrescaR.gridy = 3;
		panel.add(lblTrescaR, gbc_lblTrescaR);
		
		lblNmm = new JLabel("N/mm^2");
		lblNmm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNmm = new GridBagConstraints();
		gbc_lblNmm.anchor = GridBagConstraints.WEST;
		gbc_lblNmm.insets = new Insets(0, 0, 5, 0);
		gbc_lblNmm.gridx = 5;
		gbc_lblNmm.gridy = 3;
		panel.add(lblNmm, gbc_lblNmm);
		
		lblNodes = new JLabel("Nodes");
		lblNodes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNodes = new GridBagConstraints();
		gbc_lblNodes.gridwidth = 4;
		gbc_lblNodes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNodes.gridx = 1;
		gbc_lblNodes.gridy = 4;
		panel.add(lblNodes, gbc_lblNodes);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLocal = new GridBagConstraints();
		gbc_lblLocal.anchor = GridBagConstraints.WEST;
		gbc_lblLocal.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocal.gridx = 0;
		gbc_lblLocal.gridy = 5;
		panel.add(lblLocal, gbc_lblLocal);
		
		lblLocal1 = new JLabel("1");
		lblLocal1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLocal1 = new GridBagConstraints();
		gbc_lblLocal1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocal1.gridx = 1;
		gbc_lblLocal1.gridy = 5;
		panel.add(lblLocal1, gbc_lblLocal1);
		
		lblLocal2 = new JLabel("2");
		lblLocal2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLocal2 = new GridBagConstraints();
		gbc_lblLocal2.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocal2.gridx = 2;
		gbc_lblLocal2.gridy = 5;
		panel.add(lblLocal2, gbc_lblLocal2);
		
		label = new JLabel("3");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 5;
		panel.add(label, gbc_label);
		
		label_1 = new JLabel("4");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 4;
		gbc_label_1.gridy = 5;
		panel.add(label_1, gbc_label_1);
		
		JLabel lblGlobal = new JLabel("Global");
		lblGlobal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblGlobal = new GridBagConstraints();
		gbc_lblGlobal.anchor = GridBagConstraints.WEST;
		gbc_lblGlobal.insets = new Insets(0, 0, 5, 5);
		gbc_lblGlobal.gridx = 0;
		gbc_lblGlobal.gridy = 6;
		panel.add(lblGlobal, gbc_lblGlobal);
		
		lblGlobal1 = new JLabel("-");
		GridBagConstraints gbc_lblGlobal1 = new GridBagConstraints();
		gbc_lblGlobal1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGlobal1.gridx = 1;
		gbc_lblGlobal1.gridy = 6;
		panel.add(lblGlobal1, gbc_lblGlobal1);
		
		lblGlobal2 = new JLabel("-");
		GridBagConstraints gbc_lblGlobal2 = new GridBagConstraints();
		gbc_lblGlobal2.insets = new Insets(0, 0, 5, 5);
		gbc_lblGlobal2.gridx = 2;
		gbc_lblGlobal2.gridy = 6;
		panel.add(lblGlobal2, gbc_lblGlobal2);
		
		lblGlobal3 = new JLabel("-");
		GridBagConstraints gbc_lblGlobal3 = new GridBagConstraints();
		gbc_lblGlobal3.insets = new Insets(0, 0, 5, 5);
		gbc_lblGlobal3.gridx = 3;
		gbc_lblGlobal3.gridy = 6;
		panel.add(lblGlobal3, gbc_lblGlobal3);
		
		lblGlobal4 = new JLabel("-");
		GridBagConstraints gbc_lblGlobal4 = new GridBagConstraints();
		gbc_lblGlobal4.insets = new Insets(0, 0, 5, 5);
		gbc_lblGlobal4.gridx = 4;
		gbc_lblGlobal4.gridy = 6;
		panel.add(lblGlobal4, gbc_lblGlobal4);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 7;
		panel.add(lblName, gbc_lblName);
		
		lblName1 = new JLabel("-");
		lblName1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblName1 = new GridBagConstraints();
		gbc_lblName1.insets = new Insets(0, 0, 5, 5);
		gbc_lblName1.gridx = 1;
		gbc_lblName1.gridy = 7;
		panel.add(lblName1, gbc_lblName1);
		
		lblName2 = new JLabel("-");
		lblName2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblName2 = new GridBagConstraints();
		gbc_lblName2.insets = new Insets(0, 0, 5, 5);
		gbc_lblName2.gridx = 2;
		gbc_lblName2.gridy = 7;
		panel.add(lblName2, gbc_lblName2);
		
		lblName3 = new JLabel("-");
		lblName3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblName3 = new GridBagConstraints();
		gbc_lblName3.insets = new Insets(0, 0, 5, 5);
		gbc_lblName3.gridx = 3;
		gbc_lblName3.gridy = 7;
		panel.add(lblName3, gbc_lblName3);
		
		lblName4 = new JLabel("-");
		lblName4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblName4 = new GridBagConstraints();
		gbc_lblName4.insets = new Insets(0, 0, 5, 5);
		gbc_lblName4.gridx = 4;
		gbc_lblName4.gridy = 7;
		panel.add(lblName4, gbc_lblName4);
		
		JLabel lblDefaultx = new JLabel("defaultX");
		lblDefaultx.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDefaultx = new GridBagConstraints();
		gbc_lblDefaultx.anchor = GridBagConstraints.WEST;
		gbc_lblDefaultx.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefaultx.gridx = 0;
		gbc_lblDefaultx.gridy = 8;
		panel.add(lblDefaultx, gbc_lblDefaultx);
		
		lbldefX1 = new JLabel("-");
		GridBagConstraints gbc_lbldefX1 = new GridBagConstraints();
		gbc_lbldefX1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefX1.gridx = 1;
		gbc_lbldefX1.gridy = 8;
		panel.add(lbldefX1, gbc_lbldefX1);
		
		lbldefX2 = new JLabel("-");
		GridBagConstraints gbc_lbldefX2 = new GridBagConstraints();
		gbc_lbldefX2.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefX2.gridx = 2;
		gbc_lbldefX2.gridy = 8;
		panel.add(lbldefX2, gbc_lbldefX2);
		
		lbldefX3 = new JLabel("-");
		GridBagConstraints gbc_lbldefX3 = new GridBagConstraints();
		gbc_lbldefX3.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefX3.gridx = 3;
		gbc_lbldefX3.gridy = 8;
		panel.add(lbldefX3, gbc_lbldefX3);
		
		lbldefX4 = new JLabel("-");
		GridBagConstraints gbc_lbldefX4 = new GridBagConstraints();
		gbc_lbldefX4.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefX4.gridx = 4;
		gbc_lbldefX4.gridy = 8;
		panel.add(lbldefX4, gbc_lbldefX4);
		
		lblMm_3 = new JLabel("mm");
		lblMm_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_3 = new GridBagConstraints();
		gbc_lblMm_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblMm_3.gridx = 5;
		gbc_lblMm_3.gridy = 8;
		panel.add(lblMm_3, gbc_lblMm_3);
		
		JLabel lblDefaulty = new JLabel("defaultY");
		lblDefaulty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDefaulty = new GridBagConstraints();
		gbc_lblDefaulty.anchor = GridBagConstraints.WEST;
		gbc_lblDefaulty.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefaulty.gridx = 0;
		gbc_lblDefaulty.gridy = 9;
		panel.add(lblDefaulty, gbc_lblDefaulty);
		
		lbldefY1 = new JLabel("-");
		GridBagConstraints gbc_lbldefY1 = new GridBagConstraints();
		gbc_lbldefY1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefY1.gridx = 1;
		gbc_lbldefY1.gridy = 9;
		panel.add(lbldefY1, gbc_lbldefY1);
		
		lbldefY2 = new JLabel("-");
		GridBagConstraints gbc_lbldefY2 = new GridBagConstraints();
		gbc_lbldefY2.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefY2.gridx = 2;
		gbc_lbldefY2.gridy = 9;
		panel.add(lbldefY2, gbc_lbldefY2);
		
		lbldefY3 = new JLabel("-");
		GridBagConstraints gbc_lbldefY3 = new GridBagConstraints();
		gbc_lbldefY3.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefY3.gridx = 3;
		gbc_lbldefY3.gridy = 9;
		panel.add(lbldefY3, gbc_lbldefY3);
		
		lbldefY4 = new JLabel("-");
		GridBagConstraints gbc_lbldefY4 = new GridBagConstraints();
		gbc_lbldefY4.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefY4.gridx = 4;
		gbc_lbldefY4.gridy = 9;
		panel.add(lbldefY4, gbc_lbldefY4);
		
		lblMm_4 = new JLabel("mm");
		lblMm_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_4 = new GridBagConstraints();
		gbc_lblMm_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblMm_4.gridx = 5;
		gbc_lblMm_4.gridy = 9;
		panel.add(lblMm_4, gbc_lblMm_4);
		
		JLabel lblDeltax = new JLabel("deltaX");
		lblDeltax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDeltax = new GridBagConstraints();
		gbc_lblDeltax.anchor = GridBagConstraints.WEST;
		gbc_lblDeltax.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeltax.gridx = 0;
		gbc_lblDeltax.gridy = 10;
		panel.add(lblDeltax, gbc_lblDeltax);
		
		lbldeltaX1 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaX1 = new GridBagConstraints();
		gbc_lbldeltaX1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaX1.gridx = 1;
		gbc_lbldeltaX1.gridy = 10;
		panel.add(lbldeltaX1, gbc_lbldeltaX1);
		
		lbldeltaX2 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaX2 = new GridBagConstraints();
		gbc_lbldeltaX2.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaX2.gridx = 2;
		gbc_lbldeltaX2.gridy = 10;
		panel.add(lbldeltaX2, gbc_lbldeltaX2);
		
		lbldeltaX3 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaX3 = new GridBagConstraints();
		gbc_lbldeltaX3.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaX3.gridx = 3;
		gbc_lbldeltaX3.gridy = 10;
		panel.add(lbldeltaX3, gbc_lbldeltaX3);
		
		lbldeltaX4 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaX4 = new GridBagConstraints();
		gbc_lbldeltaX4.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaX4.gridx = 4;
		gbc_lbldeltaX4.gridy = 10;
		panel.add(lbldeltaX4, gbc_lbldeltaX4);
		
		lblMm_5 = new JLabel("mm");
		lblMm_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_5 = new GridBagConstraints();
		gbc_lblMm_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblMm_5.gridx = 5;
		gbc_lblMm_5.gridy = 10;
		panel.add(lblMm_5, gbc_lblMm_5);
		
		JLabel lblDeltay = new JLabel("deltaY");
		lblDeltay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDeltay = new GridBagConstraints();
		gbc_lblDeltay.anchor = GridBagConstraints.WEST;
		gbc_lblDeltay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeltay.gridx = 0;
		gbc_lblDeltay.gridy = 11;
		panel.add(lblDeltay, gbc_lblDeltay);
		
		lbldeltaY1 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaY1 = new GridBagConstraints();
		gbc_lbldeltaY1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaY1.gridx = 1;
		gbc_lbldeltaY1.gridy = 11;
		panel.add(lbldeltaY1, gbc_lbldeltaY1);
		
		lbldeltaY2 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaY2 = new GridBagConstraints();
		gbc_lbldeltaY2.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaY2.gridx = 2;
		gbc_lbldeltaY2.gridy = 11;
		panel.add(lbldeltaY2, gbc_lbldeltaY2);
		
		lbldeltaY3 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaY3 = new GridBagConstraints();
		gbc_lbldeltaY3.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaY3.gridx = 3;
		gbc_lbldeltaY3.gridy = 11;
		panel.add(lbldeltaY3, gbc_lbldeltaY3);
		
		lbldeltaY4 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaY4 = new GridBagConstraints();
		gbc_lbldeltaY4.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaY4.gridx = 4;
		gbc_lbldeltaY4.gridy = 11;
		panel.add(lbldeltaY4, gbc_lbldeltaY4);
		
		lblMm_6 = new JLabel("mm");
		lblMm_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_6 = new GridBagConstraints();
		gbc_lblMm_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblMm_6.gridx = 5;
		gbc_lblMm_6.gridy = 11;
		panel.add(lblMm_6, gbc_lblMm_6);
		
		JButton btnSelectItem = new JButton("Select Element");
		btnSelectItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				print();
			}
		});
		btnSelectItem.setBounds(12, 191, 200, 25);	
		add(btnSelectItem);
		
		comboModel = new JComboBox(Model.modelList.toArray());

		comboModel.setBounds(12, 13, 200, 22);
		comboModel.setSelectedItem(Model.currentModel);
		add(comboModel);
		
		JButton btnSelectModel = new JButton("Select Model");
		btnSelectModel.setBounds(224, 12, 146, 25);
		btnSelectModel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				changeModel();
			}
		});
		add(btnSelectModel);
		}
	public void stateChanged(ChangeEvent e) {
		System.out.println("FF");
		//panel_1.repaint();
    }
	public void print(){
		selectedE=(Element) list.getSelectedValue();
		if(selectedE==null)
			selectedE=Model.currentModel.elementList.get(0);
		textIndexR.setText(Integer.toString(selectedE.index));

		textAreaR.setText(String.format("%.3f",selectedE.shape.area));
		lblStressXR.setText(String.format("%.3f",selectedE.stressX));
		lblStressYR.setText(String.format("%.3f",selectedE.stressY));
		lblShearR.setText(String.format("%.3f",selectedE.stressXY));
		lblTrescaR.setText(String.format("%.3f",selectedE.stressTotal));
		
		lblGlobal1.setText(""+selectedE.nodeList.get(0).index);
		lblGlobal2.setText(""+selectedE.nodeList.get(1).index);		
		lblGlobal3.setText(""+selectedE.nodeList.get(2).index);
		
		lblName1.setText(selectedE.nodeList.get(0).name);
		lblName2.setText(selectedE.nodeList.get(1).name);
		lblName3.setText(selectedE.nodeList.get(2).name);
		
		lbldefX1.setText(""+selectedE.nodeList.get(0).x);
		lbldefX2.setText(""+selectedE.nodeList.get(1).x);
		lbldefX3.setText(""+selectedE.nodeList.get(2).x);
		
		lbldefY1.setText(""+selectedE.nodeList.get(0).y);
		lbldefY2.setText(""+selectedE.nodeList.get(1).y);
		lbldefY3.setText(""+selectedE.nodeList.get(2).y);

		lbldeltaX1.setText(String.format("%.3e", selectedE.nodeList.get(0).dx));
		lbldeltaX2.setText(String.format("%.3e", selectedE.nodeList.get(1).dx));
		lbldeltaX3.setText(String.format("%.3e", selectedE.nodeList.get(2).dx));
		
		lbldeltaY1.setText(String.format("%.3e", selectedE.nodeList.get(0).dy));
		lbldeltaY2.setText(String.format("%.3e", selectedE.nodeList.get(1).dy));
		lbldeltaY3.setText(String.format("%.3e", selectedE.nodeList.get(2).dy));
		if(selectedE.nodeList.size()==4){
			lblGlobal4.setText(""+selectedE.nodeList.get(3).index);
			lblName4.setText(selectedE.nodeList.get(3).name);
			lbldefX4.setText(""+selectedE.nodeList.get(3).x);
			lbldefY4.setText(""+selectedE.nodeList.get(3).y);
			lbldeltaX4.setText(String.format("%.3e", selectedE.nodeList.get(3).dx));
			lbldeltaY4.setText(String.format("%.3e", selectedE.nodeList.get(3).dy));
		}
		else{
			lblGlobal4.setText("-");
			lblName4.setText("-");
			lbldefX4.setText("-");
			lbldefY4.setText("-");
			lbldeltaX4.setText(String.format("-"));
			lbldeltaY4.setText(String.format("-"));
		}

		
	}

	public void changeModel(){
		Model.currentModel=((Model)comboModel.getSelectedItem());

		dataModel.removeAllElements();
		for(Element e:Model.currentModel.elementList)
			dataModel.addElement(e);
		ModelVisualization.setScale();
		System.out.println(ModelVisualization.scale);
		Main.visual.repaint();
		//panel_2.repaint();
	}
}
