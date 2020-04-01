package Method;



import Entity.Fraction;

public class Rando implements RandomCreate {

	@Override
	
	public String getFormula() {
		
		return null;
	}

	@Override
	/*
	 * 获取一个随机操作符
	 * @see Method.RandomCreate#getOperator()
	 */
	public String getOperator() {
		// TODO 自动生成的方法存根
		switch(getNumber(4)) {
		case 0:return "+";
		case 1:return "-";
		case 2:return "×";
		case 3:return "÷";
		}
		return null;
	}

	

	@Override
	/*
	 * 获取一个0到max范围内的随机分数
	 * @see Method.RandomCreate#getFraction()
	 */
	public String getFraction(double max) {
		int dai,son,ma;
		Fraction f=new Fraction();
		do {
			dai=getNumber((int) max);
			son=getNumber((int) max);
			ma=getNumber((int) max);
			for(;ma==0;)
				ma=getNumber((int) max);
			f.setDaiFract(dai, son, ma);
		}while(!(f.val(f)<max)||ma==0||son>ma);
		return f.tranFr(f);
	
	}


    //获取0到max范围内的整数		
	public int getNumber(int max){
		int random=(int)(Math.random()*max);
		return random;
	}
	//text
	public static void main (String[] args) {
		Rando r=new Rando();
		for(int i=0;i<=12;i++) {
		System.out.println(r.getFraction(1));
	}}
}
