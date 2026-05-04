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
					<h1 class="h3 mb-4 text-gray-800">${name}Detail Page</h1>
					<div>
						<h3 tyep="hidden" id="goodsNo">${dto.goodsNo}</h3>
						<h3>${dto.goodsName}</h3>
						<h3>${dto.goodsContent}</h3>
						<h3>${dto.goodsRate}</h3>
						<div>
							<h4>
								<img src="/files/${name}/${dto.goodsfileDTO.fileName}">
							</h4>
						</div>
						<a href="../account/create?goodsNo=${dto.goodsNo}"
							class="btn btn-primary">상품가입</a>
						<button id="cart" data-pn="${dto.goodsNo}" class="btn btn-danger">장바구니
							담기</button>
						<div id="review_list" data-gn="${dto.goodsNo}"></div>
						<div>
							<textarea row="6" id="txt"></textarea>
							<button id="btn">등록</button>
						</div>
					</div>
				</div>
				<!-- End Page container-fluid -->
			</div>
			<!-- End page Content -->
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		</div>
		<!-- End Content wrapper -->
	</div>
	<!-- End Wrapper -->

	<div>
		<div class="modal fade" id="commentModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<input type="hidden" id="cn">
						<textarea rows="" cols="" id="content_update"></textarea>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal" id ="close">Close</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="update_btn">Save changes</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>

	<script src="/js/cart/cart.js"></script>
	<script src="/js/comment/list.js"></script>
</body>
</html>