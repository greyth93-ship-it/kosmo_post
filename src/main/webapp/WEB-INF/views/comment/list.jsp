<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<table class="table table-hover">
  <thead>
  	<tr>
  		<th>Content</th>
  		<th>Writer</th>
  		<th>Date</th>
  		<th></th>
  	</tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="r">
	  <tr id="ppa">
		  <td>${r.commentContent}</td>
		  <td>${r.username}</td>
		  <td>
		  	<fmt:parseDate value="${r.commentDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDate" type="both" />
		  	<fmt:formatDate value="${parsedDate}" pattern="yy-MM-dd HH:mm:ss" /> 
		  </td>
		  <td data-comment="${r.commentNo}" id="pa">
		  	<button class="btn btn-outline-success edit" data-toggle="modal" data-target="#commentModal">수정</button>
		  	<button class="btn btn-outline-danger del">삭제</button>
		  </td>
	  </tr>
  </c:forEach>
  
  </tbody>
</table>
