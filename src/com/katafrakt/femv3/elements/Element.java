package com.katafrakt.femv3.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;

import com.katafrakt.femv3.main.ModelVisualization;
import com.katafrakt.femv3.materials.Material;
import com.katafrakt.femv3.maths.Maths;
import com.katafrakt.femv3.models.Model;
import com.katafrakt.femv3.shapes.Shape;

public abstract class Element implements IRenderer {
	Model model;
	public int index;
	
	public Material material;
	double thickness;
	public ArrayList<Node> nodeList;
	public String name;
	
	public Shape shape;
	

	public double[][] k;
	
	public double stressX;
	public double stressY;
	public double stressXY;
	
	public double stressTotal;
	
	public Element(Model model,Material material){
		this.model=model;
		this.material=material;
		nodeList=new ArrayList<Node>();
		model.elementList.add(this);
		index=model.elementList.size();
	}
	public double[][] getMaterialMatrix(){
		double[][] array=new double[3][3];
		array[0][0]=1;
		array[0][1]=material.poisson;
		array[1][0]=material.poisson;
		array[1][1]=1;
		array[2][2]=(1-material.poisson)/2;
		array=Maths.productWithConstat(array, material.elasticityModul/(1-Math.pow(material.poisson, 2)));
		//Yazdýr.printArray(array);
		//System.out.println();
		return array;
	}
	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke((int)(3)));
		Polygon poly=new Polygon();
		int xC = 0,yC = 0;
		for(Node n:nodeList){
			poly.addPoint(getPixel(n.x+n.dx*model.deltafactor), getPixel(n.y+n.dy*model.deltafactor));
			xC+=getPixel(n.x+n.dx*model.deltafactor);yC+=getPixel(n.y+n.dy*model.deltafactor);
		}
		xC/=poly.npoints;yC/=poly.npoints;
		Color c=new Color((int)((stressTotal/model.maxStress)*255), (int)((1-stressTotal/model.maxStress)*255), 0);
		g2.setColor(c);
		g2.fill(poly);
		g2.setColor(Color.BLACK);
		g2.draw(poly);
		g2.drawString(String.format(("%.2e"), stressTotal), xC-25, yC+4);
		for(int n=0;n<nodeList.size();n++){
			nodeList.get(n).render(g);
		}
	}
	
	public int getPixel(double lenght) {
		return (int)(lenght*ModelVisualization.scale+ModelVisualization.frameStart);
	}
	
	public String toString() {
		String str = new String();
		for(Node n:nodeList){
			str=str+n.name;
		}
		return str;
	}

	public abstract void setStress();
}
