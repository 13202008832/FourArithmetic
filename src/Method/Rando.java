package Method;



import Entity.Fraction;

public class Rando implements RandomCreate {

	@Override
	
	public String getFormula() {
		
		return null;
	}

	@Override
	/*
	 * ��ȡһ�����������
	 * @see Method.RandomCreate#getOperator()
	 */
	public String getOperator() {
		// TODO �Զ����ɵķ������
		switch(getNumber(4)) {
		case 0:return "+";
		case 1:return "-";
		case 2:return "��";
		case 3:return "��";
		}
		return null;
	}

	

	@Override
	/*
	 * ��ȡһ��0��max��Χ�ڵ��������
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


    //��ȡ0��max��Χ�ڵ�����		
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
