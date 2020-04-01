package Method;

public interface RandomCreate {

	String getFormula();       //获取随机算式
	String getOperator();       //获取随机操作符
	int getNumber(int max);   //获取0到max范围内的随机整数
	String getFraction(double max);     //获取随机分数

}
