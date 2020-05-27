package com.katafrakt.femv3.maths;

import java.util.ArrayList;

import com.katafrakt.framework.util.Yazdýr;

public class Matrix {
	public double[][] array;
	public ArrayList<Integer> eliminated=new ArrayList<Integer>();
	public final int initSize;
	
	public Matrix(double[][] array){
		this.array=array.clone();
		initSize=array[0].length;
	}
	public void addElim(int a){
		this.eliminated.add(a);
		if(array!=null)
			array = degraArray(getArrayIndex(a));
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

	public double[][] degraArray(int elim){
		int m = 0,n = 0;
		int size= array[0].length;
		/*System.out.println(size);
		System.out.println(elim);
		System.out.println();*/
		double[][] result=new double[size-1][size-1];
		for(int i=0;i<size;i++){
			if(i==elim)
				continue;
		
			for(int j=0;j<size;j++){
				if(j==elim)
					continue;
				//Yazdýr.printArray(result);
				//System.out.println(i+"i j"+j);
				//System.out.println(m+"m n"+n);
				result[m][n]=array[j][i];
				m++;
			}
		m=0;
		n++;
	}
	return result;}
}