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
	                <h1 class="h3 mb-4 text-gray-800">Cart Page</h1>
	                <div class="row">
	                   	<div>
	                   	<input type="checkbox" id="total">
	                   		<button type="submit" class="btn btn-primary">Submit</button>
	                   		<button type="submit" class="btn btn-danger"id="del">선택삭제</button>
	                   		
	                   	</div>
	                </div>
	                
	                   <div id="list">
	                   
	                   
	                   </div>
	                   

                </div>
                <!-- End Page container-fluid -->
			</div>
			<!-- End page Content -->
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		</div>
		<!-- End content-wrapper -->
	</div>
	<!-- End wrapper -->
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
	<script src="/js/cart/list.js"></script>
</body>
</html>