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
#myPageForm{
	width:300px;
	margin:0 auto;
}
</style>

<form action="/member/myPage.do" method="post" id="myPageForm">
	<h1>마이페이지</h1>
	<fieldset>
		<legend>패스워드 확인</legend>
		PW : <input type="password" name="userPwd"/>
		<input type="submit" value="입력"/>
	</fieldset>
</form>
<a href="/">메인페이지로 이동</a>

</body>
</html>