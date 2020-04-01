package Entity;

import Method.OpFraction;

public class Fraction {

	private int fson;   //分子m
	private int fma;   //分母n
	private String fract;  //分数m/n
	private String daiFract; //带分数i'm/n
	private int dai;  //i
	
	public int getDai() {
		return dai;
	}
	public void setDai(int dai) {
		this.dai = dai;
	}
	public String getDaiFract() {
		return daiFract;
	}
	public void setDaiFract(int i,int m,int n) {
		this.dai=i;
		this.fma=n;
		this.fson=m;
		this.daiFract = String.valueOf(i)+"'"+String.valueOf(m)+"/"+String.valueOf(n);;
	}
	public int getFson() {
		return fson;
	}
	public void setFson(int fson) {
		this.fson = fson;
	}
	public int getFma() {
		return fma;
	}
	public void setFma(int fma) {
		this.fma = fma;
	}
	public String getFract() {
		return fract;
	}
	public void setFract(int m,int n) {
		this.fma=n;
		this.fson=m;
		this.fract = String.valueOf(m)+"/"+String.valueOf(n);
	}
	public String tranFr(Fraction q) {
		int max;
		OpFraction o=new OpFraction();
		
		if(q.fson==0) {return "0";}else {
		max=o.maxNum(q.fma,q.fson);
		q.setDaiFract(q.dai, q.fson/max, q.fma/max);
		if(q.dai==0) {
			if(q.fma==1) {
				return String.valueOf(q.fson);				
			}
			else{
			
			 return String.valueOf(q.fson)+"/"+String.valueOf(q.fma);
		}}
		else {
			if(q.fma==1) {
				return String.valueOf(q.fson);				
			}
			else return String.valueOf(q.dai)+"'"+String.valueOf(q.fson)+"/"+String.valueOf(q.fma);
		}
	}}
	
	
	
	public double val(Fraction f) {
	
		if(f.fson==0)return 0;
		return f.dai+f.fson/f.fma;
	}
	
		
}
