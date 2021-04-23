<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyMember</title>
</head>
<body>
	<h1>비밀번호 수정</h1>
	
	<form action="${pageContext.request.contextPath}/auth/modifyMember" method="post">
		<div>
			새 비밀번호 : <input type="password" name="memberPw" required="required">
		</div>
		<button type="submit">변경</button>
	</form>
	<a href="${pageContext.request.contextPath}/login"><button type="button">돌아가기</button></a>
</body>
</html>