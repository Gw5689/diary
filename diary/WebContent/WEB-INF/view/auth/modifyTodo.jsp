<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyTodo</title>
</head>
<body>
	<h1>todoOne수정</h1>
	
	<form action="${pageContext.request.contextPath}/auth/modifyTodo" method="post">
	<div>
		<input type="hidden" name="todoNo" required="required" value="${todoOne.todoNo}">
	</div>
	<div>
		todoTitle : <input type="text" required="required" value="${todoOne.todoTitle}" name="todoTitle">
	</div>
	<div>
		todoDate : <input type="text" required="required" value="${todoOne.todoDate}" name="todoDate">
	</div>
	<div>
		todoContent : <textarea rows="3" cols="80" name ="todoContent" required="required"> ${todoOne.todoContent}</textarea>
	</div>
	<div>todoFontColor: <input type="color" name="todoFontColor" value="${todoOne.todoFontColor}"></div>
	<div><button type="submit">수정</button></div>
	</form>
</body>
</html> 