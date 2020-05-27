package com.katafrakt.femv3.models;

import com.katafrakt.femv3.elements.Element;
import com.katafrakt.femv3.elements.Node;
import com.katafrakt.femv3.elements.TriangleElement;
import com.katafrakt.femv3.materials.Material;
import com.katafrakt.framework.util.Yazdýr;


public class ModelBir extends Model {
	TriangleElement e6,e5;
	@Override
	public void setModel() {
		final double t=1000;
		Node U=new Node(this,0, 0,"U");
		U.statX=true;
		U.statY=true;
		//U.statQ=true;
		Node N=new Node(this,0,10*t,"N");
		Node O=new Node(this,0,12.5f*t,"O");
		Node A=new Node(this,0,15*t,"A");
		
		Node M=new Node(this,4*t,10*t,"M");
		Node P=new Node(this,4*t,12.5f*t,"P");
		Node B=new Node(this,4*t,15*t,"B");
		
		Node L=new Node(this,8*t,10*t,"L");
		L.forceY=-5000;
		Node Q=new Node(this,8*t,12.5f*t,"Q");
		Node C=new Node(this,8*t,15*t,"C");
		
		Node K=new Node(this,12*t,10*t,"K");
		K.forceY=-10000;
		Node D=new Node(this,12*t,15*t,"D");
		
		Node J=new Node(this,16*t,10*t,"J");
		J.forceY=-20000;
		Node R=new Node(this,16*t,12.5f*t,"R");
		Node E=new Node(this,16*t,15*t,"E");
		Node I=new Node(this,20*t,10*t,"I");
		Node S=new Node(this,20*t,12.5f*t,"S");
		Node F=new Node(this,20*t,15*t,"F");
		
		Node V=new Node(this,24*t,0,"V");
		V.statY=true;
		Node H=new Node(this,24*t,10*t,"H");
		Node T=new Node(this,24*t,12.5f*t,"T");
		Node G=new Node(this,24*t,15*t,"G");
		
		new TriangleElement(this, Material.steel, O, B, A);
		new TriangleElement(this, Material.steel,O,P,B);
		new TriangleElement(this, Material.steel,O,M,P);
		new TriangleElement(this, Material.steel,N,M,O);
		e5= new TriangleElement(this, Material.steel,P,C,B);
		//5
		e6=new TriangleElement(this, Material.steel,P,Q,C);
		new TriangleElement(this, Material.steel,P,L,Q);
		new TriangleElement(this, Material.steel,M,L,P);
		new TriangleElement(this, Material.steel,Q,D,C);
		new TriangleElement(this, Material.steel,Q,K,D);
		//10
		new TriangleElement(this, Material.steel,L,K,Q);
		new TriangleElement(this, Material.steel,R,E,D);
		new TriangleElement(this, Material.steel,K,R,D);
		new TriangleElement(this, Material.steel,K,J,R);
		new TriangleElement(this, Material.steel,R,S,E);
		//15
		new TriangleElement(this, Material.steel,J,S,R);
		new TriangleElement(this, Material.steel,S,F,E);
		new TriangleElement(this, Material.steel,J,I,S);
		new TriangleElement(this, Material.steel,S,T,F);
		new TriangleElement(this, Material.steel,T,G,F);
		//20
		new TriangleElement(this, Material.steel,I,H,T);
		new TriangleElement(this, Material.steel,U,M,N);
		new TriangleElement(this, Material.steel,V,H,I);
		new TriangleElement(this, Material.steel,I,T,S);
	}

	@Override
	protected void afterProcess() {
		//Yazdýr.printArray(e5.forces);
		//Yazdýr.printArray(e6.forces);
		
	}
	
	public String toString(){
		return "Question 1";
	}
	
}
