package com.katafrakt.femv3.models;

import com.katafrakt.femv3.elements.Node;
import com.katafrakt.femv3.elements.RectangularElement;
import com.katafrakt.femv3.elements.TriangleElement;
import com.katafrakt.femv3.materials.Material;
import com.katafrakt.framework.util.Yazdýr;

public class ModelÝki extends Model {

	private RectangularElement e4;

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
		L.forceY=-5*t;
		Node Q=new Node(this,8*t,12.5f*t,"Q");
		Node C=new Node(this,8*t,15*t,"C");
		
		Node K=new Node(this,12*t,10*t,"K");
		K.forceY=-10*t;
		Node Z=new Node(this,12*t,12.5d*t,"Z");
		Node D=new Node(this,12*t,15*t,"D");
		
		Node J=new Node(this,16*t,10*t,"J");
		J.forceY=-20*t;
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
		
		Material m= Material.steel;
		new TriangleElement(this,m,U,M,N);
		new RectangularElement(this, m, N, M, P, O);
		new RectangularElement(this, m, O, P, B, A);
		
		new RectangularElement(this, m, M, L, Q, P);
		e4=new RectangularElement(this, m, P, Q, C, B);
		
		new RectangularElement(this, m, L, K, Z, Q);
		new RectangularElement(this, m, Q, Z, D, C);

		new RectangularElement(this, m, K, J, R, Z);
		new RectangularElement(this, m, Z, R, E, D);
		
		new RectangularElement(this, m, J, I, S, R);
		new RectangularElement(this, m, R, S, F, E);
		
		new RectangularElement(this, m, I, H, T, S);
		new RectangularElement(this, m, S, T, G, F);
		new TriangleElement(this,m,I,H,V);
		
	}

	@Override
	protected void afterProcess() {
		e4.getManualStress(-1, 1);
		e4.getManualStress(0, 1);
		e4.getManualStress(1, 1);

	}	
	
	public String toString(){
		return "Question 2";
	}

}
