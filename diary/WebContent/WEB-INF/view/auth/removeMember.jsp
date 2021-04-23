<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>removeMember</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/auth/removeMember" method="post">
		<div>
			memberPw :
		</div>
		<div>
			<input type="password" name="memberPw">
		</div>
		<div>
			<button type="submit">탈퇴</button>
		</div>
	</form>
</body>
</html>