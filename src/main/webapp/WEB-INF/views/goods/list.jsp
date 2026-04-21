<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
				
				<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">${name}</h1>
                    
                    <!-- 테이블 DIV 시작 -->
                    <div class="row justify-content-center">
                    <div class="col-8">
                    	<!-- 검색 폼 -->
                    	
                    	<div>
                    		<form action="./list" method="get">
	                    		<div class="input-group mb-3">
	                    		  <div class="input-group-prepend">
									<select name="kind" class="custom-select">
										<option ${pager.kind eq 'v1'?'selected':''} value="v1">Name</option>
										<option ${pager.kind eq 'v2'?'selected':''} value="v2">Content</option>
										<option ${pager.kind eq 'v3'?'selected':''} value="v3">Category</option>
									</select>
								  </div>	
	                    		
								  <input type="text" value="${pager.search}" name="search" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
								  <div class="input-group-append">
								    <button class="btn btn-outline-secondary" id="button-addon2">검색</button>
								  </div>
								</div>
							</form>
                    		
                    	</div>
                    	
                    	<div class="row">
                    	<c:forEach items="${list}" var="p">
                    	<div class="col-4">
                    	<div class="card" style="width: 18rem;">
						  <img src="/files/${name}/${p.goodsfileDTO.fileName}" class="card-img-top" alt="...">
						  <div class="card-body">
						    <h5 class="card-title">${p.goodsName}</h5>
						    
						    <a href="./detail?goodsNo=${p.goodsNo}" class="btn btn-primary">Go somewhere</a>
						  </div>
						</div>
                    	</div>
                    	
                    	
                    	
                    	</c:forEach>
                    	</div>
                    <!--  
                    	<table class="table table-hover">
                    		<thead class="table-secondary">
                    			<tr>
                    				<th>No</th>
                    				<th>Name</th>
                    				<th>Category</th>
                    				<th>Rate</th>
                    				
                    			</tr>
                    		</thead>
                    		<tbody>
		                    	<c:forEach items="${list}" var="d">
		                    		<tr>
		                    			<td><a href="./detail?goodsNo=${d.goodsNo}">${d.goodsNo}</a></td>
		                    			<td>${d.goodsName}</td>
		                    			<td>${d.goodsCategory}</td>
		                    			<td>${d.goodsRate}</td>
		                    		</tr>
		                    	</c:forEach>
                    		</tbody>
                    	</table>
                    	-->
                    	<div>
                    	<nav aria-label="Page navigation example">
						  <ul class="pagination">
						    <li class="page-item ${pager.pre?'':'disabled'}">
						      <a class="page-link" href="./list?page=${pager.pre?pager.start-1:pager.start}&search=${pager.search}&kind=${pager.kind}" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						    	<c:forEach begin="${pager.start}" end="${pager.end}" var="i">
                    			<li class="page-item"><a class="page-link" href="./list?page=${i}&search=${pager.search}&kind=${pager.kind}">${i}</a></li>
                    			</c:forEach>
						    
						    <li class="page-item ${pager.next?'':'disabled'}">
						      <a class="page-link" href="./list?page=${pager.next?pager.end+1:pager.end}&search=${pager.search}&kind=${pager.kind}" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
						  </ul>
						</nav>
                    	
                    	
                    	</div>
                    	
                    	<div>
                    		<a href="./create" class="btn btn-danger">상품 등록</a>
                    	</div>
                    	
                    </div>
                    </div>
                    <!-- 테이블 DIV 끝 -->

                </div>
                <!-- End Page container-fluid -->
                
			</div>
			<!-- End page Content -->
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		</div>
		<!-- End Content wrapper -->
	</div>
	<!-- End Wrapper -->
	
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>

</body>
</html>
	<h1>List Page</h1>
</body>
</html>