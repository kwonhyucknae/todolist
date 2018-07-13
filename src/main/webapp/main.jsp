<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript" src="static/js/todo.js"></script>
<link rel="stylesheet" href="/mavenweb/static/css/todolist.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<p class="decline">나의 해야할 일들</p>
		<button class="todo_btn">새로운 TODO 등록</button>
	</header>

	<section id="content">
		<div class="elements">
			<div class="todo box">
				<div class="element_top">
					<p>TO DO</p>
				</div>
					<c:forEach items="${todolists[0]}" var="todo">
						<div class="element">
							<h1> ${todo.title}</h1>
							<p class="date"> 등록날짜 : ${todo.regdate }, ${todo.name }, 우선순위 ${todo.sequence }</p>
							<button class="element_btn">-></button>
						</div>
					</c:forEach>
			</div>
			<div class="doing box">
				<div class="element_top">
					<p>DOING</p>
				</div>
					<c:forEach items="${todolists[1]}" var="doing">
						<div class="element">
							<h1> ${doing.title}</h1>
							<p class="date"> 등록날짜 : ${doing.regdate }, ${doing.name }, 우선순위 ${doing.sequence }</p>
							<button class="element_btn">-></button>
						</div>
					</c:forEach>
			</div>
			<div class="done box">
				<div class="element_top">
					<p>DONE</p>
				</div>
					<c:forEach items="${todolists[2]}" var="done">
						<div class="element">
							<h1> ${done.title}</h1>
							<p class="date"> 등록날짜 : ${done.regdate }, ${done.name }, 우선순위 ${done.sequence }</p>
							<button class="element_btn">-></button>
						</div>
					</c:forEach>
			</div>
		</div>
	</section>

	<footer> 
	
	</footer>
	
</body>
</html>