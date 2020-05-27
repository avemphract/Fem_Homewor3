package com.katafrakt.femv3.maths;

public class Maths {
	public static double[][] dotProduct(double[][] array1,double[][] array2){
		double[][] result=new double[array1.length][array2[0].length];
		for(int k=0;k<array1.length;k++)
			for(int i=0;i<array2[0].length;i++)
				for(int j=0;j<array2.length;j++){
					result[k][i]+=array1[k][j]*array2[j][i];
				}
		return result;
	}
	
	public static double[][] productWithConstat(double[][] array,double cons){
		for(int i=0;i<array[0].length;i++){
			for(int j=0;j<array.length;j++){
				array[j][i]=array[j][i]*cons;
			}
		}
		return array;
	}

	public static double[][] transpose(double[][] array){
		double[][] result= new double[array[0].length][array.length];
		for(int i=0;i<array[0].length;i++){
			for(int j=0;j<array.length;j++){
				result[i][j]=array[j][i];
			}
		}
		return result;
	}
	
	public static double[][] dof6RotationMatrixF(double a){
		double[][] result=new double[6][6];
		result[0][0]= Math.cos(a);
		result[0][1]= Math.sin(a);
		result[1][0]= -Math.sin(a);
		result[1][1]= Math.cos(a);
		result[2][2]=1;
		
		result[3][3]= Math.cos(a);
		result[3][4]= Math.sin(a);
		result[4][3]= -Math.sin(a);
		result[4][4]= Math.cos(a);
		result[5][5]=1;
		return result;
	}
	public static double[][] dof6RotationMatrixI(double a){
		
		double[][] result=new double[6][6];
		result[0][0]= Math.cos(a);
		result[0][1]= -Math.sin(a);
		result[1][0]= Math.sin(a);
		result[1][1]= Math.cos(a);
		result[2][2]=1;
		
		result[3][3]= Math.cos(a);
		result[3][4]= -Math.sin(a);
		result[4][3]= Math.sin(a);
		result[4][4]= Math.cos(a);
		result[5][5]=1;
		return result;
	}

	public static double[][] matrixAdder(double[][] o1,double[][] o2,double[][] o3,double[][] o4){
		double[][] temp=new double[o1[0].length][o1[0].length];
			for(int i=0;i<o1[0].length;i++){
				for(int j=0;j<o1[0].length;j++){
					temp[i][j]+=o1[i][j];
					temp[i][j]+=o2[i][j];
					temp[i][j]+=o3[i][j];
					temp[i][j]+=o4[i][j];
				}
			}
		return temp;
	}
}
