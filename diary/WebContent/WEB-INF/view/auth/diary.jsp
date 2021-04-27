<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>diary</title>
</head>
<body class="bg-theme bg-theme1  pace-done">
	<div class="row mt-3">
		<div class="col-lg-6">
			<div class="card">
            	<div class="card-body">
					<h5 class="card-title">DDAY List</h5>
					<div class="table-responsive">
						<table class="table table-sm">
							<tr>
								<th>todoDate</th>
								<th>todoTitle</th>
								<th>dday</th>
								<c:forEach var="m" items="${diaryMap.ddayList }">
									<tr>
										<td>${m.todoDate }</td>
										<td><a href="${pageContext.request.contextPath}/auth/todoOne?todoNo=${m.todoNo}">${m.todoTitle}</a></td>
										<td>-${m.dday }</td>
									</tr>
								</c:forEach>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
			
	<c:set var="totalCell" value="${diaryMap.startBlank + diaryMap.endDay + diaryMap.endBlank}"></c:set>
		<h3>
			<a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable"
			 href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth-1}">이전달</a>
				${diaryMap.targetYear}년 ${diaryMap.targetMonth+1}월
			<a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable"
			 href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth+1}">다음달</a>
		</h3>
	
		<table class="table table-hover">
			<tr>
				<c:forEach var="i" begin="1" end="${totalCell}" step="1">
					<c:set var="num" value="${i-diaryMap.startBlank}"></c:set>
					<td>
						<c:if test="${num > 0 && num <= diaryMap.endDay}">
							<a href="${pageContext.request.contextPath}/auth/addTodo?year=${diaryMap.targetYear}&month=${diaryMap.targetMonth+1}&day=${num}">
								<div>${num}</div>
								<div>
									<c:forEach var="todo" items="${diaryMap.todoList }">
										<c:if test="${todo.todoDate == num}">
											<div style="background-color: ${todo.todoFontColor}">
												<a href="${pageContext.request.contextPath}/auth/todoOne?todoNo=${todo.todoNo}">${todo.todoTitle}</a>
											</div>
										</c:if>
									</c:forEach>
								</div>
							</a>
						</c:if>
						<c:if test="${num <= 0 || num > diaryMap.endDay}">
							&nbsp;
						</c:if>
					</td>
					<c:if test="${i%7==0}">
						</tr><tr>
					</c:if>
				</c:forEach>
			</tr>
		</table>
		<a href="${pageContext.request.contextPath}/login"><button type="button" class="btn btn-light px-4">돌아가기</button></a>
</body>
</html>