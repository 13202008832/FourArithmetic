<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Method.*" %> 
<%@ page import="Entity.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>题目</title>
</head>
<body><form action="/FourArithmetic/Submit" method="post"><br/>
<%
int i=0;
int n=Integer.parseInt(request.getParameter("n")) ;
System.out.print("n为"+n+"nn");
int r=Integer.parseInt(request.getParameter("r")) ;
DaoTxt dao=new DaoTxt();
dao.clearAll();
String result="";
for(;i<n;i++)
{	rpn t = new rpn();
	t.r(r);
	stack s=new stack(7);
	t.Y.copy(s);
	expression q=new expression(t.Y);
	q.exp();
	
	anwser an = new anwser(s);
	an.anw();
	if(an.Y.indexOf("-")<0&&an.flag){
	
	result=result+an.Y+",";
	
	out.print("第"+(i+1)+"题: \t");
	
	out.print(q.Y);
	
	dao.saveExercise("第"+(i+1)+"题: "+q.Y+"\r\n"); //将题目保存到exercisefile.txt
	dao.saveAnswer("第"+(i+1)+"题: "+q.Y+an.Y+"\r\n");//将答案保存到anwserfile.txt
	
%><input type="text" name="text"><br/><br/>


<%
}else {
	i--;
	}
}

/* request.setAttribute("result", result); */
%>
<input type="hidden" name="result" value="<%=result %>">
<input type="submit" onclick="window.location.href='Submit'"  value="提交" ><br/><br/>
</form>
</body>
</html>