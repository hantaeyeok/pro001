<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="fpath" value="<%=request.getContextPath() %>" />
<hr>    
<footer>
	<div class="ft_wrap">
		<nav id="fnb">
			<ul>
				<li><a href="${hpath }/member/terms.jsp">회원약관</a></li>
				<li><a href="${hpath }/member/policy.jsp">개인정보처리방침</a></li>
			</ul>
		</nav>
		<div id="loc">
			<select name="sel" id="sel" onchange="locate()">
				<option value="">해당 관광서</option>
				<option value="https://www.junggu.seoul.kr/dong/myeong/main.do">명동주민센터</option>
				<option value="https://map.naver.com/p/search/%EB%AA%85%EB%8F%99%ED%8C%8C%EC%B6%9C%EC%86%8C/place/18039864?placePath=?entry=pll&from=nx&fromNxList=true&searchType=place&c=15.00,0,0,0,dh">명동파출소</option>
				<option value="https://www.koreapost.go.kr/100/index.do">서울중앙우체국</option>
			</select>
		</div>
		<!-- locate(): 이 함수는 <select> 요소에서 옵션을 선택했을 때 실행
		선택된 값이 비어 있지 않으면, 새 창을 열고 해당 URL로 이동 -->
		<script>
		function locate(){
			var sel = document.getElementById("sel");
			if(sel.value!=""){
				window.open(sel.value);
			}
		}
		</script>
		<br><br>
		<div id="copyright">
			<p class="addr">(우) 04629 서울시 중구 퇴계로20길 3 (남산동2가 9-6)</p>
			<p class="copy">COPYRIGHT(C) SEOUL Myeong-dong INTRO. ALL RIGHTS RESERVED.</p>
		</div>
	</div> 
</footer>