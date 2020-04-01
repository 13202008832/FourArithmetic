package Method;

import Entity.stack;

public class rpn {
	public stack Y = new stack(7);;
	
	public void r(int max) {
		Rando f=new Rando();
		
		Y.push(f.getFraction(max));
		Y.push(f.getFraction(max));
		int m = 0,n = 0,i = (int)(Math.random()*3);//均等生成0、1、2
		while(m < i && n < i) {
			int j = (int)(Math.random()*2);
			if(j == 0 || n-m>0) {Y.push(f.getFraction(max));m++;}
				else {Y.push(f.getOperator());n++;}
		}
		while(m == i && n < i) {
			Y.push(f.getOperator());n++;
		}
		while(n == i && m < i) {
			Y.push(f.getFraction(max));m++;
		}		
		Y.push(f.getOperator());
		
	}
	

}
