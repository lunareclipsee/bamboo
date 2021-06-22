<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>비밀번호 확인</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript">
	$(document).ready(function() {

		$('input[type=password]').focus();

		$('#editBtn').click(function() {
			confirmPassword();

		});

		$('input[type=password]').keydown(function(key) {

			if (key.keyCode == 13) {//키가 13이면 실행 (엔터는 13)
				confirmPassword();
			}

		});

		confirmPassword = function() {
			//검색 찾는 로직 구현
			var password = $('input[type=password]').val();
			var passwordCheck = '${member.memberPassword}';

			if (password == passwordCheck) {
				location.href = "/englishvillage/student/update.do"
			} else if (password == "") {
				alert("비밀번호를 입력해주세요.");
				return false;
			} else {
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
		};

	});
</script>
<style type="text/css">
input[type=button] {
	margin-left: 68px;
}
</style>
</head>

<body>
	<div class="container bs-docs-container contentBox">
		<div class="col-md-7" style="margin-top: 40px">

			<div id="pageName">본인인증</div>

			<div id="pwdCheckBox" style="padding-top: 25px;">
				<h3 style="font-weight: bold; text-align: center;">비밀번호를 입력해주세요 ${ boardDto.name }</h3>

				<input type="password" class="form-control pwdInputBox" value=""
					maxlength="12"> <input class="btn btn-default btn-lg"
					type='button' value='뒤로가기'
					onClick="location.href='/englishvillage/student/myInfo.do'">
				<input id="editBtn" class="btn btn-primary btn-lg" type='button'
					value='입력완료'>

			</div>


		</div>


	</div>



</body>
</html>