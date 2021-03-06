<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>
  <!-- loader-->
  <link href="assets/css/pace.min.css" rel="stylesheet"/>
  <script src="assets/js/pace.min.js"></script>
  <!--favicon-->
  <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
  <!-- simplebar CSS-->
  <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
  <!-- Bootstrap core CSS-->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
  <!-- animate CSS-->
  <link href="assets/css/animate.css" rel="stylesheet" type="text/css"/>
  <!-- Icons CSS-->
  <link href="assets/css/icons.css" rel="stylesheet" type="text/css"/>
  <!-- Sidebar CSS-->
  <link href="assets/css/sidebar-menu.css" rel="stylesheet"/>
  <!-- Custom Style-->
  <link href="assets/css/app-style.css" rel="stylesheet"/>
<title>addMember</title>
</head>
<body class="bg-theme bg-theme1  pace-done">
	<div class="loader-wrapper"><div class="lds-ring"><div></div><div></div><div></div><div></div></div></div>
		<div class="card card-authentication1 mx-auto my-4">
			<div class="card-body">
				<div class="card-content p-2">
					<div class="text-center">
						<img src="${pageContext.request.contextPath}/assets/images/logo-icon.png" alt="logo icon">
					</div>
					<div class="card-title text-uppercase text-center py-3">회원가입</div>
						<form action="${pageContext.request.contextPath}/addMember" method="post">
							<div class="form-group">
								<label for="exampleInputID" class="sr-only">ID</label>
								<div class="position-relative has-icon-right">
									<input type="text" name="memberId" required="required" class="form-control input-shadow" placeholder="ID" width="100%">
									<div class="form-control-position">
										<i class="icon-user"></i>
									</div>
								</div>
							</div>
							<div class="form-group">
							<label for="exampleInputPW" class="sr-only">PW</label>
								<div class="position-relative has-icon-right">
									<input type="password" name="memberPw" required="required" class="form-control input-shadow" placeholder="Password" width="100%">
									<div class="form-control-position">
										<i class="icon-lock"></i>
									</div>
								</div>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-light btn-block waves-effect waves-light">가입</button>
							</div>
						</form>
					</div>
				</div>
			</div>
</body>
</html>