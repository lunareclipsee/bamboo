<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
<style type="text/css">

 tr > th{ 
 	text-align: center; 
 } 
 


</style>
</head>
<body>
	<div class="container">
		<form action="postList.do" id="frm" name="frm" method="post">
			<div>
				<div>
					<h2>대나무숲</h2>

					<table class="table table-hover text-center">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>작성일</th>
							<th>비밀번호</th>

						</tr>
						<c:forEach items="${ postList }" var="post" varStatus="status">

							<tr>
								<td>${ post.idx }</td>
								<td class="text-left"><a href="postSelect.do?idx=${ post.idx }">${ post.title }</a>

								</td>
								<td>${ post.name } (${ post.inip })</td>
								<td>${ post.indate }</td>
								<td>${ post.password }</td>
							</tr>
						</c:forEach>
						<!-- model에 담겨진 postList를 반복문으로 처리 -->

					</table>

					<div>
						<button type="button" class="btn btn-primary"
							onclick="postAddFnc()">글쓰기</button>
					</div>

				</div>
			</div>
		</form>
	</div>

	<div style="padding: 30px">
		<jsp:include page="/WEB-INF/views/common/paging3.jsp">
			<jsp:param value="${pagingMap}" name="pagingMap" />
		</jsp:include>
	</div>
	
	<form action="/englishvillage/student/questionList.do" id="pagingForm" method="get">
		<input type="hidden" id="curPage" name="curPage"
			value="${ pagingMap.postPaging.curPage }"> 
	</form>

	<script type="text/javascript">
		var postAddFnc = function() {
			location.href = 'postAdd.do'
		}
	</script>

</body>
</html>