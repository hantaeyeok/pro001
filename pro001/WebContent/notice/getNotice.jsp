<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="path0" value="<%=request.getContextPath() %>" />    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/head.jsp" %>
<style >
.page { clear:both; height:100vh; }
#page1 { background-color:#ececec; }
<title>Insert title here</title>
</style>

</head>
<body>
<div id="header">
	<%@ include file="/header.jsp" %>
</div>
<div id="contents">
	<section class="page" id="page1">
		<div>
			<h3>공지사항 상세보기</h3>
			<div>
				<table class="table">
					<tbody>
						<tr>
							<th>글 번호</th>
							<td>${noti.no }</td>
						</tr>
						<tr>
							<th>글 제목</th>
							<td>${noti.title }</td>
						</tr>
						<tr>
							<th>글 내용</th>
							<td>${noti.content }</td>
						</tr>
						<tr>
							<th>작성일시</th>		
							<td>${noti.resdate }</td>
						</tr>
						<tr>
							<th>조회수</th>
							<td>${noti.visited }</td>
						</tr>
					</tbody>
					<!-- 공지사항 글등록, 수정,삭제,목록, 버튼으로 이동할꺼임 -->
				</table>
				<hr>
				<div class="btn-group">
				  <a href="${path0 }/notice/noti_ins.jsp" class="btn btn-secondary">글 등록</a>
				  <a href="${path0 }/EditNotice.do?no=${noti.no }" class="btn btn-secondary">글 수정</a>
				  <a href="${path0 }/DelNotice.do?no=${noti.no }" class="btn btn-secondary">글 삭제</a>
				  <a href="${path0 }/NotiList.do" class="btn btn-secondary">글 목록</a>
				</div>
			</div>
		</div>
	</section>
	<section class="page" id="page2">
		<div>	
			<h3></h3>

		</div>	
	</section>	
</div>
<div id="footer">
	<%@ include file="/footer.jsp" %>
</div>
</body>
</html>