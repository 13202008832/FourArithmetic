package Method;

import Entity.stack;

public class expression {
	public String Y = new String();
	public stack as;
	
	public expression(stack As) {
		this.as=As;
		}
	
	void Exp(stack S,int I) {
		//提取符号
		String f = new String();
		f = S.pop();
		//定义优先等级
		int i;
		if (f == "+" || f == "-")
			i = 1;
		else i = 2;
		//提取右表达式
		stack b = new stack(7);
		{
			int m = 0, n = 0;
			while(true) {
				String x = S.pop();
				if (x == "+" || x == "-" || x == "×" || x == "÷")
					n++;
				else 
					m++;
				b.push(x);
				if(1 == m - n)
					break;
			}
			b.inversion();
		}
		//提取左表达式
		stack a = new stack(7);	
		while(true) {
			String x = S.pop();
			a.push(x);
			if(S.isEmpty()) break;
		}
		a.inversion();
		//表达式输出
		if(i < I)
			Y = Y + "(";
		if(a.top == 0)
			Y = Y + a.pop();
		else Exp(a,i);
		Y = Y + " "+f+" ";
		if(b.top == 0)
			Y = Y + b.pop();
		else Exp(b,i+1);
		if(i < I)
			Y = Y + ")";
		if(I == 0) Y = Y + " = ";
	}
	public void exp() {
		Exp(as,0);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		stack s1 = new stack(7);
		s1.push("a");
		s1.push("b");
		s1.push("+");
		s1.push("c");
		s1.push("d");
		s1.push("+");
		s1.push("*");//ab+cd+*
		expression t1 = new expression(s1);
		t1.exp();
		System.out.println(t1.Y);
		stack s2 = new stack(7);
		s2.push("a");
		s2.push("b");
		s2.push("c");
		s2.push("+");
		s2.push("+");
		s2.push("d");
		s2.push("*");//abc++d*
		expression t2 = new expression(s2);
		t2.exp();
		System.out.println(t2.Y);
		rpn r =new rpn();
		
	}

}
