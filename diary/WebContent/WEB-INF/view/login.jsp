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
<title>login</title>
</head>
<body class="bg-theme bg-theme1  pace-done">
	<!-- 로그인 되어 있지 않을때 -->
	<div class="loader-wrapper"><div class="lds-ring"><div></div><div></div><div></div><div></div></div></div>
		<div class="card card-authentication1 mx-auto my-5">
			<div class="card-body">
				<div class="card-content p-2">
					<div class="text-center">
						<img src="assets/images/logo-icon.png" alt="logo icon">
					</div>
					<div class="card-title text-uppercase text-center py-3">My_Diary</div>
						<c:if test="${sessionMember == null}">
							<form action="${pageContext.request.contextPath}/login" method="post">
								<div class="form-group">
									<label for="exampleInputId" class="sr-only">ID</label>
										<div class="position-relative has-icon-right">
										<div><input type="text" name="memberId" value="goodee@gdu.co.kr" class="form-control input-shadow" required="required" placeholder="Enter ID" style="width: 100%"></div>
											<div class="form-control-position">
					  							<i class="icon-user"></i>
				  							</div>
			  							</div>
		  								</div>
										<div class="form-group">
							 				<label for="exampleInputPassword" class="sr-only">Password</label>
							 					<div class="position-relative has-icon-right">	
							 						<div><input type="password" name="memberPw" value="1234" class="form-control input-shadow" required pattern="^[a-z0-9\W]{4,10}$" placeholder="Enter Password" style="width: 100%"></div>
									 				<div class="form-control-position">
											  			<i class="icon-lock"></i>
										  			</div>
									  			</div>
						  				</div>
										  <div class="form-group">
											<label for="submit" class="sr-only">Sign In</label>
												<div class="position-relative has-icon-right">			
							 						<button type="submit" class="btn btn-light btn-block">로그인</button>
							 					</div>
						 				</div>
							 			<div class="form-group">
							 				<div class="position-relative has-icon-right">
												<a href="${pageContext.request.contextPath}/addMember">
													<button type="button" class="btn btn-light btn-block">회원가입</button>
												</a>
									</div>
								</div>
							</form>
						</c:if>
				</div>
			<c:if test="${sessionMember != null}">
				<div class="card-title text-center py-3">${sessionMember.memberId}님 반갑습니다.</div>
				<div class="position-relative has-icon-right">
					<a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable"
					 href="${pageContext.request.contextPath}/auth/diary">다이어리</a>
				</div>
				<div class="position-relative has-icon-right"> 
					<a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable" 
					href="${pageContext.request.contextPath}/auth/modifyMember">회원정보 수정</a>
				</div>
				<div class="position-relative has-icon-right">
					<a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable" 
					href="${pageContext.request.contextPath}/auth/logout">로그아웃</a>
				</div>
				<div class="position-relative has-icon-right">
					<a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable" 
					href="${pageContext.request.contextPath}/auth/removeMember">회원탈퇴</a>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>