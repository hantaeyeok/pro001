<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="hpath" value="<%=request.getContextPath() %>" />   
<!-- head의 경로 변수로 설정 다른페이지에서 hpath로 상대경로 구성 가능, 위치 동적으로 변환-->
<header>
<!-- 로고 이미지를 클릭하면 메인페이지로 돌아가는 방식 , a태그 hrep 는 url을 사용하여 이동시킴 -->
	<div class="logo_wrap">
		<a href="/pro001"><img src="${hpath }/images/logo.png" alt="명동 로고" /></a>
	</div>
	<!-- tnb : 로그인, 회원가입, 로그아웃 메뉴 포함 Top Navigation Bar -->
	<nav id="tnb">
		<ul>
			<c:if test="${empty sid }">
			<li><a href="${hpath }/member/">로그인</a></li>
			<li><a href="${hpath }/member/">회원가입</a></li>
			</c:if>
			<c:if test="${not empty sid }">
			<li><a href="${hpath }/member/">로그아웃</a></li>
			<li><a href="${hpath }/member/">회원정보</a></li>
			</c:if>
			<c:if test="${sid.equals('admin') }">
			<li><a href="${hpath }/admin/">관리자로</a></li>
			</c:if>
		</ul>
	</nav>
	<!-- 소메뉴 -->
	<!-- gnb : 주메뉴 서브메뉴 Global Navigation Bar -->
	<!-- ${hpath}/NotiList.do는 현재 웹 애플리케이션의 컨텍스트 경로에 
	/NotiList.do를 추가하여 공지사항 페이지의 전체 경로 구성 
	사용자가 해당 링크를 클릭하면 공지사항 페이지로 이동 -->
	<nav id="gnb">
		<ul class="main_menu">
			<li><a href="">커뮤니티</a>
				<ul>
					<li><a href="${hpath }/NotiList.do">공지사항</a></li>
					<li><a href="">자료실</a></li>
					<li><a href="">묻고답하기</a></li>
				</ul>
			</li>
		</ul>
	</nav>
</header>
<hr>