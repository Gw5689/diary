<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember</title>
</head>
<body>
	<h1>회원가입</h1>
	
	<form action="${pageContext.request.contextPath}/addMember" method="post">
		<div>
			MemberId : <input type="text" name="memberId" required="required">
		</div>
		<div>
			MemberPw : <input type="password" name="memberPw" required="required">
		</div>
		<button type="submit">가입</button>
	</form>
</body>
</html>