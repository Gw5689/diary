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
<title>todoOne</title>
</head>
<body class="bg-theme bg-theme1  pace-done">
	<div class="row mt-3">
		      	<div class="col-lg-6">
			         <div class="card">
			           <div class="card-body">
			           	<div class="card-title">상세 일정</div>
	
	<div class="form-group">
		todoDate : ${todoOne.todoDate}
	</div>
	<div class="form-group">
		todoTitle : ${todoOne.todoTitle}
	</div>
	<div class="form-group">
		todoContent : ${todoOne.todoContent}
	</div>
	<div class="form-group">
		todoFontColor : ${todoOne.todoFontColor} <input type="color" value="${todoOne.todoFontColor}" readonly="readonly" disabled="disabled">
	</div>

	<div class="form-group">
		<a href="${pageContext.request.contextPath}/auth/removeTodo?todoNo=${todoOne.todoNo}&todoDate=${todoOne.todoDate}">
			<button type="button" class="btn btn-light px-4">삭제</button>
		</a>
		
		<a href="${pageContext.request.contextPath}/auth/modifyTodo?todoNo=${todoOne.todoNo}">
			<button type="button" class="btn btn-light px-4">수정</button>
		</a>
	</div>

	<div class="form-group">
		<a href="${pageContext.request.contextPath}/auth/diary">
			<button type="button" class="btn btn-light px-4">돌아가기</button>
		</a>
	</div>
		
		
	
</body>
</html>