package com.katafrakt.femv3.models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import com.katafrakt.femv3.elements.Element;
import com.katafrakt.femv3.elements.Node;
import com.katafrakt.femv3.main.Main;
import com.katafrakt.femv3.main.ModelVisualization;
import com.katafrakt.femv3.maths.Matrix;
import com.katafrakt.femv3.maths.Vector;
import com.katafrakt.framework.util.Yazdýr;


public abstract class Model {
	public static ArrayList<Model> modelList=new ArrayList<Model>();
	public static Model currentModel;
	
	public Matrix stiffness;
	public Vector forces;
	public Vector displacements;
	
	public double deltafactor=3500;
	
	public ArrayList<Node> nodeList;
	public ArrayList<Element> elementList;
	
	public double maxStress;
	
	public Model(){
		currentModel=this;
		modelList.add(this);
		elementList=new ArrayList<Element>();
		nodeList=new ArrayList<Node>();
		setModel();
		createStiffness();
		createForces();
		modifyMatrices();
		//Yazdýr.printArray(stiffness.array);
		//Yazdýr.printVector(forces.vector);
		solveDisplacement();
		placeDisplacement();
		//Yazdýr.printVector(displacements.vector);
		setStresses();
		afterProcess();

		
	}
	
	

	public abstract void setModel();
	public void createStiffness(){
		double[][] tempStiffness=new double[nodeList.size()*2][nodeList.size()*2];
		for(Element e:elementList){		
			for(int i=0;i<e.nodeList.size();i++){
				for(int j=0;j<e.nodeList.size();j++){
					tempStiffness[e.nodeList.get(i).index*2][e.nodeList.get(j).index*2]+=e.k[i*2][j*2];
					tempStiffness[e.nodeList.get(i).index*2+1][e.nodeList.get(j).index*2]+=e.k[i*2+1][j*2];
					tempStiffness[e.nodeList.get(i).index*2][e.nodeList.get(j).index*2+1]+=e.k[i*2][j*2+1];
					tempStiffness[e.nodeList.get(i).index*2+1][e.nodeList.get(j).index*2+1]+=e.k[i*2+1][j*2+1];
				}
			}
		}
		stiffness=new Matrix(tempStiffness);
	}
	
	public void createForces(){
		double[] tempForces=new double[nodeList.size()*2];
		for(Node n:nodeList){
			tempForces[n.index*2]=n.forceX;
			tempForces[n.index*2+1]=n.forceY;
		}
		forces=new Vector(tempForces);
		
	}
	
	public void modifyMatrices(){
		for(Node n:nodeList){
			if(n.statX){
				//System.out.println(n.name);
				stiffness.addElim(2*n.index);
				forces.addElim(2*n.index);
			}
			if(n.statY){
				//System.out.println(n.index*2+1);
				stiffness.addElim(2*n.index+1);
				forces.addElim(2*n.index+1);
			}
		}
	}
	
	public void solveDisplacement(){
		RealMatrix coefficient=new Array2DRowRealMatrix(stiffness.array);
		//delta=Maths.getDeterminant(stiffnessMatrix.array);
		DecompositionSolver solver = new LUDecomposition(coefficient).getSolver();
		RealVector constant=new ArrayRealVector(forces.vector);
		RealVector solution = solver.solve(constant);
		displacements=new Vector(solution.toArray());
		
	}
	
	public void placeDisplacement(){
		int k=0;
		for(Node n:nodeList){
			if(!stiffness.eliminated.contains(n.index*2)){
				n.dx=displacements.vector[k];
				k++;
			}
			if(!stiffness.eliminated.contains(n.index*2+1)){
				n.dy=displacements.vector[k];
				k++;
			}
			//System.out.println(n.name+"   "+n.dx+"   "+n.dy);
		}
	}
	private void setStresses() {
		for(Element e:elementList){
			e.setStress();
		}
		for(Element e:elementList){
			if(maxStress<e.stressTotal)
				maxStress=e.stressTotal;
		}
		
	}

	public void render(Graphics g){
		g.setColor(Color.GREEN);
		g.drawLine(ModelVisualization.frameStart, ModelVisualization.frameStart, Main.width, ModelVisualization.frameStart);
		g.setColor(Color.RED);
		g.drawLine(ModelVisualization.frameStart, ModelVisualization.frameStart, ModelVisualization.frameStart,Main.height);
		for(Element e:elementList)
			e.render(g);
	}
	protected abstract void afterProcess();
}