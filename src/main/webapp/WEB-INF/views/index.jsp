<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Sr.No</th>
							<th scope="col">Product Name</th>
							<th scope="col">Product Description</th>
							<th scope="col">Product Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="product">
							<tr>
								<th scope="row">${product.productId}</th>
								<td>${product.productName}</td>
								<td>${product.productDescription}</td>
								<td>&#8377;${product.productPrice}</td>
								<td><a
									href="delete-product/productId/
									${product.productId}"><i
										class="fas fa-trash-alt text-danger"></i></a> <a
									href="update-product/productId/
									${product.productId}"><i
										class="fas fa-pen-nib text-primary"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-success">Add
						Product</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
