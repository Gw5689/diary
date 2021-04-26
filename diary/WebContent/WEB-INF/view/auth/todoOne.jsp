<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todoOne</title>
</head>
<body>
	<h1>todoOne</h1>
	
	<div>
		todoDate : ${todoOne.todoDate}
	</div>
	<div>
		todoTitle : ${todoOne.todoTitle}
	</div>
	<div>
		todoContent : ${todoOne.todoContent}
	</div>
	<div>
		todoFontColor : ${todoOne.todoFontColor} <input type="color" value="${todoOne.todoFontColor}" readonly="readonly" disabled="disabled">
	</div>

	<div>
		<a href="${pageContext.request.contextPath}/auth/removeTodo?todoNo=${todoOne.todoNo}&todoDate=${todoOne.todoDate}">
			<button type="button">삭제</button>
		</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/modifyTodo?todoNo=${todoOne.todoNo}">
			<button type="button">수정</button>
		</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/diary">
			<button type="button">돌아가기</button>
		</a>
	</div>
		
		
	
</body>
</html>