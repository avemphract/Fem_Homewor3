package com.katafrakt.femv3.elements;

import com.katafrakt.femv3.materials.Material;
import com.katafrakt.femv3.maths.Maths;
import com.katafrakt.femv3.models.Model;
import com.katafrakt.femv3.shapes.Triangle;
import com.katafrakt.framework.util.Yazdýr;

public class TriangleElement extends Element {

	public double[][] forces;
	public double[][] displacements;
	
	public TriangleElement(Model model, Material material,Node node1,Node node2,Node node3) {
		super(model, material);	
		nodeList.add(node1);	
		nodeList.add(node2);
		nodeList.add(node3);

		name="e"+node1.name+node2.name+node3.name;
		thickness=10;
		shape=new Triangle(node1.toPoint(),node2.toPoint(),node3.toPoint());
		setStiffness();
		//System.out.println(name+" "+(node1.index*2)+" "+(node1.index*2+1)+" "+(node2.index*2)+" "+(node2.index*2+1)+" "+(node3.index*2)+" "+(node3.index*2+1));
	}

	public double[][] getRotationMatrix(){
		double[][] b=new double[3][6];
		b[0][0]=nodeList.get(1).y-nodeList.get(2).y;
		b[0][2]=nodeList.get(2).y-nodeList.get(0).y;
		b[0][4]=nodeList.get(0).y-nodeList.get(1).y;
		
		b[1][1]=nodeList.get(2).x-nodeList.get(1).x;
		b[1][3]=nodeList.get(0).x-nodeList.get(2).x;
		b[1][5]=nodeList.get(1).x-nodeList.get(0).x;
		
		b[2][0]=nodeList.get(2).x-nodeList.get(1).x;
		b[2][1]=nodeList.get(1).y-nodeList.get(2).y;
		b[2][2]=nodeList.get(0).x-nodeList.get(2).x;		
		b[2][3]=nodeList.get(2).y-nodeList.get(0).y;
		b[2][4]=nodeList.get(1).x-nodeList.get(0).x;
		b[2][5]=nodeList.get(0).y-nodeList.get(1).y;
		//Yazdýr.printArray(b);
		b=Maths.productWithConstat(b, 1/(shape.area*2));
		//Yazdýr.printArray(b);
		//System.out.println(shape.area);
		return b;
	}



	public void setStiffness(){
		//Yazdýr.printArray(Maths.dotProduct(Maths.transpose(getRotationMatrix()),getRotationMatrix()));
		k=Maths.dotProduct(Maths.dotProduct(Maths.transpose(getRotationMatrix()), getMaterialMatrix()),getRotationMatrix());
		k=Maths.productWithConstat(k, thickness*shape.area);
		//Yazdýr.printArray(k);
		//System.out.println(name);
	}

	@Override
	public void setStress() {
		double[][] stressVector=new double[3][1];
		double[][] displacements=new double[6][1];
		for(int i=0;i<3;i++){
			displacements[i*2][0]=nodeList.get(i).dx;
			displacements[i*2+1][0]=nodeList.get(i).dy;
			}
		stressVector=Maths.dotProduct(getMaterialMatrix(),Maths.dotProduct(getRotationMatrix(), displacements));
		stressX=stressVector[0][0]; stressY=stressVector[1][0]; stressXY=stressVector[2][0];
		stressTotal=Math.pow(Math.pow(stressX-stressY, 2)+4*Math.pow(stressXY, 2), 0.5d);
		
		//System.out.print(index+"  " +stressVector[0][0]+" "+stressVector[1][0]+" "+stressVector[2][0]);
		/*System.out.print(index+"   "+name);
		System.out.print(String.format(("   %.4e"),stressVector[0][0] )+" ");
		System.out.print(String.format(("   %.4e"),stressVector[1][0] )+" ");
		System.out.print(String.format(("   %.4e"),stressVector[2][0] )+" ");
		System.out.println(String.format(("   %.4e"),stressTotal )+" ");*/
	}	
}
