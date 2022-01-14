<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"></script>
</head>
<body>

<c:choose>
	<c:when test="${!requestScope.list.isEmpty() }">
		<table border="1px">
			<tr>
				<th>순번</th>
				<th>회원번호</th>
				<th>ID</th>
				<th>PW</th>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
				<th>가입일</th>
				<th>탈퇴여부</th>
			</tr>
			<c:forEach items="${requestScope.list }" var="m" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${m.userNo }</td>
					<td>${m.userId }</td>
					<td>${m.userPwd }</td>
					<td>${m.userName }</td>
					<td>${m.age }</td>
					<td>${m.address }</td>
					<td>${m.enrollDate }</td>
					<td><button style="width:100%; height:100%;" class="withDrawBtn" data="${m.userNo }">${m.endYN }</button></td>
				</tr>
			</c:forEach>
			
		</table>
	
	</c:when>
	<c:otherwise>
		<h1>현재 회원이 없습니다.</h1>
	</c:otherwise>
</c:choose>
<a href="/">메인페이지로 이동</a>


<script>
	$('.withDrawBtn').click(function(){
		var userNo = $(this).attr('data');
		var endYN = $(this).html();

		$.ajax({
			url : "/member/withDrawChangeBtn.do",
			data : {"userNo":userNo, "endYN":endYN},
			type : "get",
			context : this,
			success : function(result){
				if(result != "false"){
					$(this).html(result);
				}else{
					alert('변경실패');
				}
			},
			error : function(){
				console.log('ajax 통신 에러');
			}
			
		});
	});
</script>
</body>
</html>