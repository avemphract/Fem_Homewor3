package com.katafrakt.femv3.shapes;

public class FilledRectangle extends Shape {
	public FilledRectangle(double width,double height){
		area=width*height;
		inertia=Math.pow(height,3)*width/12;
		ySize=height;
	}

	@Override
	public double[] interpolationAreas(DoublePoint c) {
		// TODO Auto-generated method stub
		return null;
	}

}
