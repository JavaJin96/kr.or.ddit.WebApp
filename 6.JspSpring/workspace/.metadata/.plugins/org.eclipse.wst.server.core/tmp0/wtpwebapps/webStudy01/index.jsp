<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body{
	background : yellow;
}
</style>
<title>Insert title here</title>
</head>
<body>
웰컴 페이지
<h4 id="timeArea"></h4>
<script>
	document.getElementById("timeArea").innerHTML = new Date();
</script>
</body>
</html>