package com.katafrakt.femv3.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.katafrakt.femv3.elements.Element;
import com.katafrakt.femv3.models.Model;
import com.katafrakt.femv3.main.ModelVisualization;
import com.katafrakt.femv3.shapes.DoublePoint;

public class Node implements IRenderer {
	public Model model;
	
	public int index;
	public String name;
	public ArrayList<Element> elements;
	
	public double x;
	public boolean statX=false;
	public double dx;
	
	public double y;
	public boolean statY;
	public double dy;
	
	public double forceX;
	public double forceY;
	
	int nodeSize=20;
	
	public Node(Model model,double x,double y, String name){
		elements=new ArrayList<Element>();
		this.model=model;
		index=model.nodeList.size();
		model.nodeList.add(this);
		this.x=x;
		this.y=y;
		this.name=name;
		statY=false;
		statX=false;
		
	}
	
	public void addEffect(double forceX,double forceY) {
		this.forceX+=forceX;
		this.forceY+=forceY;
	}
	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.drawOval(getPixel(x+dx*model.deltafactor)-nodeSize/2, getPixel(y+dy*model.deltafactor)-nodeSize/2, nodeSize, nodeSize);
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillOval(getPixel(x+dx*model.deltafactor)-nodeSize/2+2, getPixel(y+dy*model.deltafactor)-nodeSize/2+2, nodeSize-4, nodeSize-4);
		if(statX==true){
			g2.setColor(Color.WHITE);
			g2.drawLine(getPixel(x+dx*model.deltafactor), getPixel(y+dy*model.deltafactor)-35, getPixel(x+dx*model.deltafactor), getPixel(y+dy*model.deltafactor)+35);
		}
		if(statY==true){
			g2.setColor(Color.WHITE);
			g2.drawLine(getPixel(x+dx*model.deltafactor)-35, getPixel(y+dy*model.deltafactor), getPixel(x+dx*model.deltafactor)+35, getPixel(y+dy*model.deltafactor));
		}
		
		if(forceX!=0||forceY!=00){
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.CYAN);
			g2.drawString((int)(Math.pow(Math.pow(forceX, 2)+Math.pow(forceY,2), 0.5d)/1000)+" kN", getPixel(x+dx*model.deltafactor)+5, getPixel(y+dy*model.deltafactor)-25);
			g2.drawLine(getPixel(x+dx*model.deltafactor), getPixel(y+dy*model.deltafactor)-50, getPixel(x+dx*model.deltafactor), getPixel(y+dy*model.deltafactor));
			g2.fillOval(getPixel(x+dx*model.deltafactor)-5, getPixel(y+dy*model.deltafactor)-5, 10, 10);
		}
		
		g2.setColor(Color.WHITE);
		g2.drawString(name,getPixel(x+dx*model.deltafactor)-4,getPixel(y+dy*model.deltafactor)-15);
		
	}
	
	public DoublePoint toPoint(){
		return new DoublePoint(x,y);
	}

	@Override
	public int getPixel(double lenght) {
		return (int)(lenght*ModelVisualization.scale+ModelVisualization.frameStart);
	}

	public static double getMaxX(Model model){
		double x=0;
		for(Node nod:model.nodeList){
			if(nod.x>x)
				x=nod.x;
		}
		return x;
	}
	public static double getMaxY(Model model){
		double y=0;
		for(Node nod:model.nodeList){
			if(nod.y>y)
				y=nod.y;
		}
		return y;
		
	}
}
