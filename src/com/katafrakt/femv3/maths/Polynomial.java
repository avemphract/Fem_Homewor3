package com.katafrakt.femv3.maths;

public class Polynomial {
	private double[] function;
	public Polynomial(double[] function){
		this.function=function;
	}
	public double getValue(double s){
		double result=0;
		for(int i=0;i<function.length;i++){
			result+=function[i]*Math.pow(s, i);
		}
		return result;
	}
	public Polynomial getDerivative(){
		double[] result=new double[function.length-1];
		for(int i=1;i<function.length;i++){
			result[i-1]=function[i]*i;
		}
		return new Polynomial(result);
	}
	public Polynomial product(double k){
		double[] result=new double[function.length];
		for(int i=0;i<function.length;i++){
			result[i]=function[i]*k;
		}
		return new Polynomial(result);
	}
}
