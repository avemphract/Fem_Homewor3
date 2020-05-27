package com.katafrakt.femv3.shapes;

public class Circle extends Shape {
	public Circle(double innerDia,double outerDia){
		area=(Math.pow(outerDia, 2)-Math.pow(innerDia, 2))*Math.PI/4;
		inertia=(Math.pow(outerDia, 4)-Math.pow(innerDia, 4))*Math.PI/64;
		ySize=outerDia;
	}

	@Override
	public double[] interpolationAreas(DoublePoint c) {
		// TODO Auto-generated method stub
		return null;
	}
}
