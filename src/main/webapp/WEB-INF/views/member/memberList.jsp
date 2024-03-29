<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>

<c:choose>
	<c:when test="${fn:length(list) eq 0}">
		<tr>
			<td class="text-center" colspan="9">There is no data!</td>
		</tr>	
	</c:when>
	<c:otherwise>
		<c:forEach items="${list}" var="item" varStatus="status">	
		
		   <c:out value=" ${item.ifmmSeq}"/> | <a href="/infra/member/memberView?ifmmSeq=${item.ifmmSeq}"><c:out value="${item.ifmmName}"/></a> | <c:out value="${item.ifmmDelNy}"/><br>
		
		</c:forEach>
	</c:otherwise>
</c:choose>	 

<a href="/infra/member/memberForm?ifmmSeq=<c:out value="${item.ifmmSeq}"/>">등록</a>