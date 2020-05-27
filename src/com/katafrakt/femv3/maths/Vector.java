package com.katafrakt.femv3.maths;

import java.util.ArrayList;

public class Vector {
	public double[] vector;
	
	public ArrayList<Integer> eliminated=new ArrayList<Integer>();

	public Vector(double[] vector){
		this.vector=vector.clone();
	}
	public void addElim(int a){
		this.eliminated.add(a);
		vector= degraVector(vector, getArrayIndex(a));
	}
	public int getArrayIndex(int b){
		int k=b;
		if(!eliminated.isEmpty()){
			for(int i:eliminated){
				if(b>i)
					k--;
			}
		}
		return k;
	}

	public double getEleman(int a){
		return vector[getArrayIndex(a)];
	} 
	public static double[] degraVector(double[] vector,int x){
		double[] result=new double[vector.length-1];
		for(int i=0;i<vector.length-1;i++){
			if(i<x)
				result[i]=vector[i];
			else
				result[i]=vector[i+1];
		}
		return result;
	}
}
