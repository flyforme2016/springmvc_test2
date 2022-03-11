<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>


<form method="post" action="/infra/member/memberUpdt">
	<input type="hidden" name="ifmmSeq" value=<c:out value="${item.ifmmSeq}"/>> <!-- 아이디 입력후 제출하겠다.-->
	<input type="text" name="ifmmName" placeholder="ifmmName" value=<c:out value="${item.ifmmName}"/>> <!-- 아이디 입력후 제출하겠다.-->
	<input type="submit" value="제출">
</form>