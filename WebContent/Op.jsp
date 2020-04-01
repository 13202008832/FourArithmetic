
<%@ page language="java" import="java.sql.*" pageEncoding="utf-8" errorPage="login.jsp"%>

<html>
<head>

<title>四则运算器</title>
<style type="text/css">

.t{
BACKGROUND-COLOR:#D3D3D3;
border-color:#B0E0E6;
box-sizing:border-box;
/* padding:6px 20px; */
outline:none;
border-radius:6px;
text-align:center;
border-style:ridge;
}
</style>
</head>
<body>

<font color='#DAA520'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp欢迎您</font><br/>
<form action="/FourArithmetic/TiMu.jsp" method="post">
 生成题目个数：<input type="text" name="n"><br/><br/>
生成数的范围：<input type="text" name="r"><br/><br/>
<input type="submit"   value="确定" class="t"><br/><br/>
</form>
</body>
</html>