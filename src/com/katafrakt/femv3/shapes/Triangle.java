package com.katafrakt.femv3.shapes;

public class Triangle extends Shape {
	DoublePoint p1,p2,p3;
	public Triangle(DoublePoint p1,DoublePoint p2,DoublePoint p3){
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
		area=Math.abs((p1.x*(p2.y-p3.y)+p2.x*(p3.y-p1.y)+p3.x*(p1.y-p2.y))/2);
		center=new DoublePoint((p1.x+p2.x+p3.x)/3,(p1.y+p2.y+p3.y)/3);
	}
	public double[] interpolationAreas(DoublePoint c){
		double[] result=new double[3];
		result[0]=Math.abs((c.x*(p2.y-p3.y)+p2.x*(p3.y-c.y)+p3.x*(c.y-p2.y))/2);
		result[1]=Math.abs((p1.x*(c.y-p3.y)+c.x*(p3.y-p1.y)+p3.x*(p1.y-c.y))/2);
		result[2]=Math.abs((p1.x*(p2.y-c.y)+p2.x*(c.y-p1.y)+c.x*(p1.y-p2.y))/2);
		return result;
	}

}
