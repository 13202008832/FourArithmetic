package Method;

import Entity.stack;

public class anwser {
	 public String Y = new String();
	 public stack as;
	 public boolean flag = true;
	 
	 public anwser(stack As) {
	  this.as=As;
	     }
	 
	 public void anw(){
	  stack p = new stack(7);
	  while(as.top>0) {
	   String a = new String();
	   String b = new String();
	   String f = new String();
	   f = as.pop();
	   int i = 0;
	   //得出一组fab
	   while(true) {
	    String x;
	    x = as.pop();
	    if (x == "+" || x == "-" || x == "×" || x == "÷") {
	     p.push(f);
	     if(i == 1)
	      p.push(a);
	     f = x;
	     i = 0;
	    }
	    else if(i == 0) {
	     a = x;
	     i++;
	    }
	    else {
	     b = x;
	     i++;
	    }
	    if(i == 2)break;
	   }
	   String y = new String();
	   OpFraction op=new OpFraction();
	   y = op.opFr(b,f,a);
	   if(y=="-1")flag=false;
	   as.push(y);
	   while(!p.isEmpty()) {
	    as.push(p.pop());
	   }
	  }
	  Y = as.pop();
	 }

	 
	 public static void main(String[] args) {
	  // TODO 自动生成的方法存根
	  stack s = new stack(7);
	  s.push("1");
	  s.push("2");
	  s.push("+");
	  s.push("3");
	  s.push("4");
	  s.push("+");
	  s.push("×");
	  anwser t = new anwser(s);
	  t.anw();
	  System.out.println(t.Y);
	  //OpFraction op=new OpFraction();
	  //System.out.println(op.opFr("1","+","2"));
	 }

	}