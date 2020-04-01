package Method;

import Entity.Fraction;

public class OpFraction {

	public int maxNum(int m,int n) {
		int i,t;
		t=m>n?m:n;
		n=m>n?n:m;
		m=t;
		for(i=n;i>=1;i--) {
			if(m%i==0&&n%i==0) {
				return i;
			}
		}
		return 1;
	}
	Fraction addFr(Fraction m,Fraction n) {
		Fraction sum=new Fraction();
		int son,ma,dm,dn,max;
		int d=0;
		   dm=m.getDai();
		   dn=n.getDai();
		  
			son=(dm*m.getFma()+m.getFson())*n.getFma()+(dn*n.getFma()+n.getFson())*m.getFma();
			ma=m.getFma()*n.getFma();
			max=maxNum(son,ma);
			if(son>ma) {
				if(ma!=1) {
					d=son/ma;
				son=son%ma;
				}
			}
			sum.setDaiFract(d, son/max, ma/max);	
		
			
		return sum;
		
	}
	Fraction toFr(Fraction m,Fraction n) {
		Fraction cha=new Fraction();
		int son,ma,dm,dn,max;
		int d=0;
		
		   dm=m.getDai();
		   dn=n.getDai();
		   
			son=(dm*m.getFma()+m.getFson())*n.getFma()-(dn*n.getFma()+n.getFson())*m.getFma();
			ma=m.getFma()*n.getFma();
			max=maxNum(son,ma);
			if(son>ma) {
				if(ma!=1) {
					d=son/ma;
				son=son%ma;
				}
			}
			cha.setDaiFract(d, son/max, ma/max);	
			
			 
			return cha;
	}
	Fraction chengFr(Fraction m,Fraction n) {
		Fraction ji=new Fraction();
		int son,ma,dm,dn,max;
		int d=0;
		
		   dm=m.getDai();
		   dn=n.getDai();
			son=(dm*m.getFma()+m.getFson())*(dn*n.getFma()+n.getFson());
			 
			ma=m.getFma()*n.getFma();
		
			max=maxNum(son,ma);
			
			if(son>ma) {
				if(ma!=1) {
					d=son/ma;
				son=son%ma;
				}
			}
			ji.setDaiFract(d, son/max, ma/max);
		return ji;
		
	}
	Fraction chuFr(Fraction m,Fraction n) {
		Fraction chu=new Fraction();
		int son,ma,dm,dn,max;
		int d=0;
		   dm=m.getDai();
		   dn=n.getDai();
		   
			son=(dm*m.getFma()+m.getFson())*n.getFma();
			ma=m.getFma()*(dn*n.getFma()+n.getFson());
			max=maxNum(son,ma);
			
			if(son>ma) {
				if(ma!=1) {
					d=son/ma;
				son=son%ma;
				}
			}
			chu.setDaiFract(d, son/max, ma/max);
		
		return chu;
		
	}
	Fraction tranString(String str) {
		Fraction f=new Fraction();
		if(str.indexOf("'")>=0) {
		String[] s1=str.split("'");
		
		String[] s2=s1[1].split("/");
		f.setDaiFract(Integer.parseInt(s1[0]),Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
		}
		else {
			if(str.indexOf("/")>=0) {
				String[] s1=str.split("/");
				f.setDaiFract(0,Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));
			}
			else {
				
				f.setDaiFract(0,Integer.parseInt(str),1);
				
			}
		}
		return f;
		
	}
	public String opFr(String m,String op, String n) {
		Fraction g=new Fraction();
		System.out.println(g.val(tranString(m))<g.val(tranString(n)));
		switch(op) {
		case "+":return g.tranFr(addFr(tranString(m),tranString(n)));
		case "-":if(g.val(tranString(m))<g.val(tranString(n))) {return "-1";}else return g.tranFr(toFr(tranString(m),tranString(n)));
		case "¡Á":return g.tranFr(chengFr(tranString(m),tranString(n)));
		case "¡Â":if(g.val(tranString(n))==0) {return "-1";}else return g.tranFr(chuFr(tranString(m),tranString(n)));
		default: return null;
		}
		 
	
		
	}
	public static void main(String[] args) {
	    OpFraction o=new OpFraction();
		String s1="1";
		String s2="3/1";
		System.out.println(o.opFr(s1,"+",s2));
	    }

}
    