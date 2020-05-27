package com.katafrakt.femv3.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.katafrakt.femv3.elements.Node;
import com.katafrakt.femv3.models.Model;


@SuppressWarnings("serial")
public class ModelVisualization extends JPanel {

	public static int height;
	public static int width;
	public static double scale;

	public static int frameStart=50;
	public static int frameEnd=100;
	
	public ModelVisualization(int width,int height ) {
		ModelVisualization.width=width;
		ModelVisualization.height=height;
		setPreferredSize(new Dimension(width,height));
		setBackground(Color.white);
		setFocusable(true);
		requestFocus();
		setScale();
		

	}
	public static void setScale(){
		double scaleX=(width-frameEnd-frameStart)/Node.getMaxX(Model.currentModel);
		double scaleY=(height-frameEnd-frameStart)/Node.getMaxY(Model.currentModel);
		if(scaleX>scaleY)
			scale=scaleY*0.95d;
		else
			scale=scaleX*0.95d;
	}
	
	@Override
	public void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		arg0.setColor(Color.LIGHT_GRAY);
		arg0.fillRect(0, 0, width, height);
		
		Model.currentModel.render(arg0);
	}
	
}
