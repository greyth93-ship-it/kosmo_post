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
	                   <h1 class="h3 mb-4 text-gray-800">회원가입페이지</h1>
	                   
	                   <form action="./join" method="post" enctype="multipart/form-data">
						  <div class="form-group">
						    <label for="username">ID</label>
						    <input type="text" name="username" class="form-control" id="username" >
						  </div>
						  <div class="form-group">
						    <label for="name">이름</label>
						    <input type="text" name="name" class="form-control" id="name" >
						  </div>						 
						  <div class="form-group">
						    <label for="password">비밀번호</label>
						    <input type="password" name="password" class="form-control" id="password" >
						    
						  </div>
						  
						<div class="form-group">
						    <label for="phone">전화번호</label>
						    <input type="tel" name="phone" class="form-control" id="phone" >
						    
						  </div>
						  <div class="form-group">
						    <label for="email">이메일</label>
						     <input type="email" name="email" class="form-control" id="email" placeholder="name@example.com">
						    
						  </div>
						  <div class="form-group">
						    <label for="birth">생일</label>
						    <input type="date" name="birth" class="form-control" id="birth">
						   
						    
						  </div>
						  
						  <div class="form-group">
						  	<label>첨부파일</label>
						  	<input type="file" name="attach" class="form-control">

						  </div>
						  				  					  
						  <button type="submit" class="btn btn-primary">Submit</button>
						</form>
	                   
	                   
	                   

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
</body>
</html>