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
	<nav id="gnb">
	<!-- gnb  -->
		<ul class="">
			<li class="item" >
				<a href="" class="dp1">마이페이지</a>
				<ul class="sub_menu">
					<c:if test="${empty sid }">
					<li><a href="${hpath }/member/login.jsp">로그인</a></li>
					<li><a href="${hpath }/member/term.jsp">회원가입</a></li>
					</c:if>
					<c:if test="${not empty sid }">
					<li><a href="${hpath }/LogOut.do">로그아웃</a></li>
					<li><a href="${hpath }/EditMember.do?id=${sid }">회원정보</a></li>
					</c:if>
					<c:if test="${sid.equals('admin') }">
					<li><a href="${hpath }/AdminMain.do">관리자로</a></li>
					</c:if>
					<li><a href="${hpath }/member/terms.jsp">회원약관</a></li>
					<li><a href="${hpath }/member/policy.jsp">개인정보처리방침</a></li>
				</ul>
			</li>
			<li class="item" >
				<a href="" class="dp1">지역소개</a>
				<ul class="sub_menu">
					<li><a href="${hpath }/intro/origin.jsp">지명유래</a></li>
					<li><a href="${hpath }/intro/facility.jsp">지역 특징 및 시설안내</a></li>
					<li><a href="${hpath }/intro/history.jsp">연혁</a></li>
					<li><a href="${hpath }/intro/map.jsp">오시는 길</a></li>
				</ul>
			</li>
			<li class="item" >
				<a href="" class="dp1">이용안내</a>
				<ul class="sub_menu">
					<li><a href="${hpath }/GetTrafficList.do">교통편 안내</a></li>
					<li><a href="${hpath }/tour/tour.jsp">관광 안내</a></li>
					<li><a href="${hpath }/tour/rest.jsp">맛집 안내</a></li>
					<li><a href="${hpath }/tour/lodg.jsp">숙박 시설 안내</a></li>
				</ul>
			</li>
			<li class="item" >
				<a href="" class="dp1">커뮤니티</a>
				<ul class="sub_menu">
					<li><a href="${hpath }/NotiList.do">공지사항</a></li>
					<li><a href="${hpath }/ArchiveList.do">자료실</a></li>
					<li><a href="${hpath }/GetQnaList.do">묻고답하기</a></li>
				</ul>
			</li>
		</ul>
	</nav>
</header> 
<hr>