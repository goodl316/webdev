<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>      
<div>
	<div>
		<c:if test="${loginUser !=null }">		
		<a href="/board/reg?typ=${param.typ == null ? 1 : param.typ}"><button>글쓰기</button></a>
		</c:if>
	</div>
	<c:choose>
	<c:when test="${fn:length(list) ==0 }">
		<div>글이 없습니다.</div>
	</c:when>
	
	<c:otherwise>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>조회수</td>
			<td>작성일</td>
			<td>작성자</td>
		</tr>		
		<c:forEach items="${list}" var="item">
			<tr class="pointer" onclick="clkArticle(${item.i_board},${param.typ})">
				<td>${item.seq}</td>
				<td>${item.title}</td>
				<td>${item.hits}</td>
				<td>${item.r_dt}</td>
			<td>
				<c:if test="${item.profile_img==null }">
					<div class="circular--landscape circular--size30">
						<img id="profileImg" src="/resources/img/basic_profile.jpg">
					</div>
				</c:if>
				<c:if test="${item.profile_img!=null}">
					<div class="circular--landscape circular--size30">
						<img id="profileImg" src="/resources/img/${item.i_user}/${item.profile_img }">
					</div>
				</c:if>
				${item.writer_nm}
				</td>
			</tr>
		</c:forEach>
		
	</table>
	</c:otherwise>
	</c:choose>
	<div class="pageContainer">
		<c:forEach begin="1" end="${pageCnt}" var="i">
			<span class="page">
				<a href="/list?typ=${typ}&page=${i}">${i}</a>
			</span>
		</c:forEach>
	</div>
</div>    