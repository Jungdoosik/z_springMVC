<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<style>
	#withDrawArea{
		width:500px;
	}
</style>

	<form action="/member/withDraw.do" method="post" id="withDrawArea">
		<fieldset>
			<legend>회원탈퇴</legend>
			PW : <input type="password" name="userPwd"/><br>
			
			<h4>탈퇴시 복구 불가능입니다.</h4><br>
			
			<input type="checkbox" name="agree" value="Y"/>동의<br>
			<input type="submit" value="동의"/><br>
		</fieldset>
	</form>

</body>
</html>