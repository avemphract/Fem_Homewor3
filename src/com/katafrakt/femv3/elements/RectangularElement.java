package com.katafrakt.femv3.elements;

import java.awt.Graphics;

import com.katafrakt.femv3.materials.Material;
import com.katafrakt.femv3.maths.Maths;
import com.katafrakt.femv3.models.Model;
import com.katafrakt.femv3.shapes.FilledRectangle;
import com.katafrakt.framework.util.Yazdýr;

public class RectangularElement extends Element {
	
	//public TwoUnkEquation[] n=new TwoUnkEquation[4];
	//public TwoUnkEquation getX,getY;
	private double[][] displacements;
	private double[][] forces;
	
	public RectangularElement(Model model, Material material,Node node1,Node node2,Node node3,Node node4) {
		super(model, material);
		


		nodeList.add(node1);
		nodeList.add(node2);	
		nodeList.add(node3);
		nodeList.add(node4);

		name="e"+node1.name+node2.name+node3.name+node4.name;
		thickness=10;
		setStiffness();
		shape=new FilledRectangle(2500, 4000);
		//System.out.println(name+" "+(node1.index*2)+" "+(node1.index*2+1)+" "+(node2.index*2)+" "+(node2.index*2+1)+" "+(node3.index*2)+" "+(node3.index*2+1)+" "+(node4.index*2)+" "+(node4.index*2+1));
	}
	
	public double[][] getG(double a,double b){
		double[][] temp=new double[4][8];
		temp[0][0]=-1+b;
		temp[0][2]=1-b;
		temp[0][4]=1+b;
		temp[0][6]=-1-b;

		temp[1][0]=-1+a;
		temp[1][2]=-1-a;
		temp[1][4]=1+a;
		temp[1][6]=1-a;
		
		temp[2][1]=-1+b;
		temp[2][3]=1-b;
		temp[2][5]=1+b;
		temp[2][7]=-1-b;
		
		temp[3][1]=-1+a;
		temp[3][3]=-1-a;
		temp[3][5]=1+a;
		temp[3][7]=1-a;
		return Maths.productWithConstat(temp, 0.25d	);
	}
	public double[][] getA(double a,double b){
		double j11=-(1d-b)*nodeList.get(0).x +(1d-b)*nodeList.get(1).x +(1d+b)*nodeList.get(2).x -(1d+b)*nodeList.get(3).x;
		double j12=-(1d-b)*nodeList.get(0).y +(1d-b)*nodeList.get(1).y +(1d+b)*nodeList.get(2).y -(1d+b)*nodeList.get(3).y;
		

		double j21=-(1d-a)*nodeList.get(0).x -(1d+a)*nodeList.get(1).x +(1d+a)*nodeList.get(2).x +(1d-a)*nodeList.get(3).x;
		double j22=-(1d-a)*nodeList.get(0).y -(1d+a)*nodeList.get(1).y +(1d+a)*nodeList.get(2).y +(1d-a)*nodeList.get(3).y;
		
		
		j11=j11/4d;
		j12=j12/4d;
		j22=j22/4d;
		j21=j21/4d;
		double[][] J=new double[][]{{j11,j12},{j21,j22}};
		double[][] A=new double[][]{{j22,-j12,0,0},{0,0,-j21,j11},{-j21,j11,j22,-j12}};
		return Maths.productWithConstat(A, 1/getJ(a,b));
	}
	
	private double getJ(double a,double b){
		double j11=-(1d-b)*nodeList.get(0).x +(1d-b)*nodeList.get(1).x +(1d+b)*nodeList.get(2).x -(1d+b)*nodeList.get(3).x;
		double j12=-(1d-b)*nodeList.get(0).y +(1d-b)*nodeList.get(1).y +(1d+b)*nodeList.get(2).y -(1d+b)*nodeList.get(3).y;
		
		double j21=-(1d-a)*nodeList.get(0).x -(1d+a)*nodeList.get(1).x +(1d+a)*nodeList.get(2).x +(1d-a)*nodeList.get(3).x;
		double j22=-(1d-a)*nodeList.get(0).y -(1d+a)*nodeList.get(1).y +(1d+a)*nodeList.get(2).y +(1d-a)*nodeList.get(3).y;
		
		j11=j11/4d;
		j12=j12/4d;
		j22=j22/4d;
		j21=j21/4d;
		return ((j11*j22-j21*j12));
	}
	
	private void setStiffness() {
		double[][] d=getMaterialMatrix();
		//1
		double[][] b1=Maths.dotProduct(getA(-0.57735d,-0.57735d),getG(-0.57735d,-0.57735d));
		double[][] bt1=Maths.transpose(b1);
		double[][] o1=Maths.productWithConstat(Maths.dotProduct(Maths.dotProduct(bt1, d), b1), getJ(-0.57735d,-0.57735d)*thickness);
		//System.out.println("o1");
		//Yazdýr.printArray(o1);
		//2
		double[][] b2=Maths.dotProduct(getA(0.57735d,-0.57735d),getG(0.57735d,-0.57735d));
		double[][] bt2=Maths.transpose(b2);
		double[][] o2=Maths.productWithConstat(Maths.dotProduct(Maths.dotProduct(bt2, d), b2), getJ(0.57735d,-0.57735d)*thickness);
		//System.out.println("o2");
		//Yazdýr.printArray(o2);
		//3
		double[][] b3=Maths.dotProduct(getA(0.57735d,0.57735d),getG(0.57735d,0.57735d));
		double[][] bt3=Maths.transpose(b3);
		double[][] o3=Maths.productWithConstat(Maths.dotProduct(Maths.dotProduct(bt3, d), b3), getJ(0.57735d,0.57735d)*thickness);
		//System.out.println("o3");
		//Yazdýr.printArray(o3);
		//4
		double[][] b4=Maths.dotProduct(getA(-0.57735d,0.57735d),getG(-0.57735d,0.57735d));
		double[][] bt4=Maths.transpose(b4);
		double[][] o4=Maths.productWithConstat(Maths.dotProduct(Maths.dotProduct(bt4, d), b4), getJ(-0.57735d,0.57735d)*thickness);
		//System.out.println("o4");
		//Yazdýr.printArray(o4);
		
		k=Maths.matrixAdder(o1,o2,o3,o4);
		
		
	}
	
	@Override
	public void setStress() {		
		double[][] stressVector=new double[3][1];
		displacements=new double[8][1];
		for(int i=0;i<4;i++){
			displacements[i*2][0]=nodeList.get(i).dx;
			displacements[i*2+1][0]=nodeList.get(i).dy;
			}
		stressVector= Maths.dotProduct(Maths.dotProduct(getMaterialMatrix(), Maths.dotProduct(getA(0,0),getG(0,0))),displacements);
		//Yazdýr.printArray(stressVector);
		stressX=stressVector[0][0]; stressY=stressVector[1][0]; stressXY=stressVector[2][0];
		stressTotal=Math.pow(Math.pow(stressX-stressY, 2)+4*Math.pow(stressXY, 2), 0.5d);
		//System.out.println(name+"  "+stressTotal);
		/*System.out.print(index+"   "+name);
		System.out.print(String.format(("   %.4e"),stressVector[0][0] )+" ");
		System.out.print(String.format(("   %.4e"),stressVector[1][0] )+" ");
		System.out.print(String.format(("   %.4e"),stressVector[2][0] )+" ");
		System.out.println(String.format(("   %.4e"),stressTotal )+" ");*/

	}
	public void getManualStress(double a,double b){
		double[][] stressVector= Maths.dotProduct(Maths.dotProduct(getMaterialMatrix(), Maths.dotProduct(getA(a,b),getG(a,b))),displacements);
		Yazdýr.printArray(stressVector);
		System.out.println(name);
	}
}