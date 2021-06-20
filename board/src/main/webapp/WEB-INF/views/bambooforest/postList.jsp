<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div>
		<form action="postList.do" id="frm" name="frm" method="post">
			<div>
				<div>
					<h2>게시글 리스트</h2>

					<table>
						<thead>
							<tr>
								<th>제목</th>
								<th>등록일</th>
								<th>비밀번호</th>
								<th>접속아이피</th>
								
							</tr>
						</thead>
						<tbody>
							<!-- model에 담겨진 postList를 반복문으로 처리 -->
							<c:forEach items="${postList}" var="post" varStatus="status">
								<tr>
									<td><a href="boardarticleview.sd?seq=${ post.idx }">${ post.title }</a>
										<!-- 클릭 시 상세화면으로 이동하기 위해 링크가 있습니다. --></td>
									<td>${ post.indate }</td>
									
									<td>${ post.password }</td>
									<td>${ post.inip }</td>
								</tr>
							</c:forEach>
							<!-- model에 담겨진 postList를 반복문으로 처리 -->

						</tbody>
					</table>

					<div>
						<a class="btn btn-info" href="postAdd.do" title="등록"> 등록</a>
					</div>

				</div>
			</div>
		</form>
	</div>

	<form action="/englishvillage/student/questionList.do" id="pagingForm"
		method="get">
		<input type="hidden" id="curPage" name="curPage"
			value="${pagingMap.memberPaging.curPage}"> <input
			type="hidden" name="searchOption" value="${searchMap.searchOption}">
		<input type="hidden" name="keyword" value="${searchMap.keyword}">
	</form>
	
	<script type="text/javascript">
		function dataList() {
			$('#frm').submit('postList.do');
		}

		function dataAdd() {
			$('#frm').submit('postAdd.do');
		}

		function dataView(seq) {
			$('#seq').val(seq);
			$.soledot.submit('', 'postView.do');
		}
	</script>

</body>
</html>