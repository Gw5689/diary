<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>
  <!-- loader-->
  <link href="${pageContext.request.contextPath}/assets/css/pace.min.css" rel="stylesheet"/>
  <script src="${pageContext.request.contextPath}/assets/js/pace.min.js"></script>
  <!--favicon-->
  <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" type="image/x-icon">
  <!-- simplebar CSS-->
  <link href="${pageContext.request.contextPath}/assets/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
  <!-- animate CSS-->
  <link href="${pageContext.request.contextPath}/assets/css/animate.css" rel="stylesheet" type="text/css"/>
  <!-- Icons CSS-->
  <link href="${pageContext.request.contextPath}/assets/css/icons.css" rel="stylesheet" type="text/css"/>
  <!-- Sidebar CSS-->
  <link href="${pageContext.request.contextPath}/assets/css/sidebar-menu.css" rel="stylesheet"/>
  <!-- Custom Style-->
  <link href="${pageContext.request.contextPath}/assets/css/app-style.css" rel="stylesheet"/>
<title>removeMember</title>
</head>
<body class="bg-theme bg-theme1  pace-done">
	<div class="card-body">
		<h3 class="card-title">회원탈퇴</h3>
		<div class="card-content p-2">
			<form action="${pageContext.request.contextPath}/auth/removeMember" method="post">
				<div class="form-group">
					memberPw :
				</div>
				<div class="form-group">
					<input type="password" name="memberPw" class="form-control input-shadow"> <button type="submit" class="btn btn-light px-4">탈퇴</button>
				</div>
			</form>
			<a href="${pageContext.request.contextPath}/login"><button type="button" class="btn btn-light px-4">돌아가기</button></a>
		</div>
	</div>
</body>
</html>