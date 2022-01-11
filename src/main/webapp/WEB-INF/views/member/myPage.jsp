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

<form action="/member/memberUpdate.do" method="post" id="updateForm">
	<h1>마이페이지</h1>
	<fieldset>
		<legend>[${sessionScope.member.userName }] 회원정보</legend>
		NAME : <input type="text" name="userName" value="${sessionScope.member.userName }"/><br>
		AGE : <input type="text" name="age" value="${sessionScope.member.age }"/><br>
		ADDRESS : <input type="text" name="address" value="${sessionScope.member.address }"/><br>
		<input type="submit" value="수정"/>
	</fieldset>
</form>
<a href="/">메인페이지로 이동</a>

</body>
</html>