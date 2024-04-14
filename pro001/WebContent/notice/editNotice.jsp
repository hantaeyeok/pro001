<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<<<<<<< HEAD
<c:set var="path0" value="<%=request.getContextPath() %>" />    
=======
<c:set var="path0" value="<%=request.getContextPath() %>" />   

>>>>>>> 8bde16b449ad23f91d79e36f625bc2a73257819a
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>${title }</title>
=======
<title>Insert title here</title>
>>>>>>> 8bde16b449ad23f91d79e36f625bc2a73257819a
<%@ include file="/head.jsp" %>
<style>
.container { width:1400px; }
.page { clear:both; height:100vh; }
#page1 { background-color:#ececec; }
#page2 { background-color:#42bcf5; }
.page_title { font-size:36px; padding-top:2em; text-align:center; }
</style>
</head>
<body>
<div id="header">
<<<<<<< HEAD
	<%@ include file="/header.jsp" %>
</div>
=======

</div>
<!--  공지사항 글 수정 폼 만들기 ! -->
>>>>>>> 8bde16b449ad23f91d79e36f625bc2a73257819a
<div id="contents">
	<section class="page" id="page1">
		<div style="width:1400px; margin:0 auto;">
			<h3 class="page_title">공지사항 글 수정</h3>
<<<<<<< HEAD
=======
			<!-- 현재 페이지에서 데이터를 전달하기때문에 dopost -->
>>>>>>> 8bde16b449ad23f91d79e36f625bc2a73257819a
			<form action="${path0 }/EditProNotice.do" method="post">
				<table class="table">
					<tbody>
						<tr>
							<th><label for="no">글 번호</label></th>
							<td>
								<input type="text" name="no" id="no" class="form-control" maxlength="100" value="${noti.no }" readonly>
							</td>
						</tr>
						<tr>
							<th><label for="title">제목</label></th>
							<td>
								<input type="text" name="title" id="title" class="form-control" maxlength="100" value="${noti.title }" required>
							</td>
						</tr>
						<tr>
							<th><label for="content">내용</label></th>
							<td>
								<textarea name="content" id="content" rows="8" cols="80" class="form-control">${noti.content }</textarea>
							</td>
						</tr>
						<tr>
							<th><label for="resdate">작성일시</label></th>
							<td>
								<input type="text" name="resdate" id="resdate" class="form-control" value="${noti.resdate }" disabled>
							</td>
						</tr>
						<tr>
							<th><label for="visited">읽은횟수</label></th>
							<td>
								<input type="text" name="visited" id="visited" class="form-control" value="${noti.visited }" disabled>
							</td>
						</tr>
					</tbody>
				</table>
				<hr>
				<div class="btn-group">
				  <button type="submit" class="btn btn-secondary">글 수정</button>
				  <a href="${path0 }/NoticeList.do" class="btn btn-secondary">글 목록</a>
				  <a href="${path0 }/GetNotice.do?no=${noti.no} " class="btn btn-secondary">글 상세보기</a>
				</div>
			</form>
		</div>
	</section>	
</div>
<<<<<<< HEAD
=======

>>>>>>> 8bde16b449ad23f91d79e36f625bc2a73257819a
<div id="footer">
	<%@ include file="/footer.jsp" %>
</div>
</body>
</html>