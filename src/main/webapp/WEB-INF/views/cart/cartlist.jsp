<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<table class="table table-hover">
	<thead class="table-secondary">
		<tr>
			<th></th>
			<th>Product_Thumb</th>
			<th>Product_Name</th>
			<th>Product_Rate</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="d" varStatus="i">
			<tr>
				<td><input type="checkbox" class="ch" data-pn="${d.goodsNo}">
					<button class="btn btn-info tdel">삭제</button></td>

				<td><img src="/files/goods/${d.goodsfileDTO.fileName}"
					width="60px" height="60px" alt="상품이미지"></td>
				<td><a href="./detail?goodsNo=${d.goodsNo}">${d.goodsName}</a>
				</td>
				<td>${d.goodsRate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>