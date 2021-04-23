<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<!-- 로그인 되어 있지 않을때 -->
	<c:if test="${sessionMember == null}">
		<h1>login</h1>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<div>
				<div>ID : </div>
				<div><input type="text" name="memberId" value="goodee@gdu.co.kr"></div>
				
				<div>PW : </div>
				<div><input type="password" name="memberPw" value="1234"></div>
				<div><button type="submit">로그인</button></div>
				<a href="${pageContext.request.contextPath}/addMember"><button type="button">회원가입</button></a>
			</div>
		</form>	
		
	</c:if>
	
	<!-- 로그인이 되어 있을 때 -->
	<c:if test="${sessionMember != null}">
		<div>${sessionMember.memberId}님 반갑습니다.</div>
		<div>
			<a href="${pageContext.request.contextPath}/auth/modifyMember">회원정보 수정</a>
			<a href="${pageContext.request.contextPath}/auth/logout">로그아웃</a>
			<a href="${pageContext.request.contextPath}/auth/removeMember">회원탈퇴</a>
		</div>
	</c:if>
</body>
</html>