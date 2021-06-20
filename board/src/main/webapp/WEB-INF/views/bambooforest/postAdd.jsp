<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div>
		<!-- 나중에 파일 등록을 위해 enctype="multipart/form-data" 을 넣어둠 -->
		<form action="postAddCtr.do" id="frm" name="frm" method="post">

			<div>
				<label for="title">제목</label>
				<div>
					<input id="title" name="title" placeholder="제목" type="text" value="" />
				</div>
			</div>

			<div>
				<label for="content">내용</label>
				<div>
					<textarea rows="5" id="content" name="content" placeholder="내용"></textarea>
				</div>
			</div>

			<div>
				<div>
					<input type="submit" value="저장">
					<input type="button" value="취소" onclick="postListMoveFnc()">
				</div>
			</div>
		</form>
	</div>

	<script type="text/javascript">
	var postListMoveFnc = function() {
		location.href = 'postList.do'
	}
	</script>

</body>
</html>