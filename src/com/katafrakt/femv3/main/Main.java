package com.katafrakt.femv3.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.katafrakt.femv3.models.ModelBir;
import com.katafrakt.femv3.models.Model›ki;


public class Main {
	
	public final static int height=800;
	public final static int width=1400;
	
	public static ModelVisualization visual;
	public static ModelDetail detail;
	
	public static ModelBir bir;
	public static Model›ki iki;
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Emre «atalkaya");
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		bir=new ModelBir();
		iki=new Model›ki();
		
		/*double[][] array=new double[6][3];
		array[0][0]=1;array[0][1]=2;array[0][2]=4;
		array[1][1]=5;array[1][2]=6;
		array[2][0]=1;array[2][1]=2;array[2][2]=5;
		array[3][0]=2;array[3][1]=3;array[3][2]=8;
		array[4][0]=1;array[4][1]=2;array[4][2]=9;
		array[5][0]=1;array[5][1]=5;array[5][2]=4;
		
		double[][] brray=new double[3][6];
		brray[0][0]=9;brray[0][1]=8;brray[0][2]=7;brray[0][3]=5;
		brray[1][1]=6;brray[1][2]=6;brray[1][3]=6;
		brray[2][0]=1;brray[2][2]=2;brray[2][3]=1;brray[2][5]=1;
		
		double[][] c=Maths.dotProduct(array, brray);
		Yazd˝r.printArray(c);*/
		
		visual = new ModelVisualization(800, height);
		frame.add(visual,BorderLayout.WEST);
		
		detail=new ModelDetail(600,height);
		frame.add(detail);
		
		frame.setVisible(true);
	}
	

}