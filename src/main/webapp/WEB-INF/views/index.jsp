<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<style>
	#loginForm{
		width:300px;
	}
</style>

<h1>메인페이지</h1>
<c:choose>
	<c:when test="${sessionScope.member != null }">
		[${sessionScope.member.userName }]님 환영합니다.<a href="/member/logout.do">로그아웃</a><br>
		<a href="/member/myPage.do">마이페이지</a><br>
		<a href="/member/withDraw.do">회원탈퇴</a><br>
		<a href="/member/memberAllList.do">전체 회원 목록</a>
		<a href="/file/fileUploadPage.do">파일 업로드</a>
	</c:when>
	
	<c:otherwise>
		<form id="loginForm" action="/member/login.do" method="post">
			<fieldset>
				<legend>로그인</legend>
				ID : <input type="text" name="userId"/><br>
				PW : <input type="password" name="userPwd"/><br>
				<input type="submit" value="로그인"/><br>
			</fieldset>
		</form>
	</c:otherwise>
</c:choose>


</body>
</html>