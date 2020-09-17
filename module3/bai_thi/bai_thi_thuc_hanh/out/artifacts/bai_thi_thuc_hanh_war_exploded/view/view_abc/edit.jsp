<%--
  Created by IntelliJ IDEA.
  User: PC
  Date:9/11/2020
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<form method="post">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="card-body">
                <div>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="/product">Back</a></li>
                        </ul>
                    </nav>
                </div>
                <h2 class="card-title text-center">Edit Product</h2>
                <form class="form-signin">
                    <div class="form-label-group">
                        <h4>Id</h4><input type="number" class="form-control" name="id" placeholder="ID" required autofocus readonly="true">
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Name Product</h4><input type="text" class="form-control" name="nameProduct" placeholder="nameProduct" required >
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Price</h4><input type="number" class="form-control" name="price" placeholder="price" required>
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Quantity</h4><input type="number" class="form-control" name="amount" placeholder="amount" required>
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Color</h4><input type="text" class="form-control" name="color" placeholder="color" required>
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Description</h4><input type="text" class="form-control" name="description" placeholder="description" required>
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Category</h4>
                        <select name="category">
                            <c:forEach var="category" items="${categoryList}">
                            <option ><c:out value="${category.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <br>
                    <button type="button" class="btn btn-lg btn-primary btn-block text-uppercase" data-toggle="modal" data-target="#exampleModal">
                        Edit
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    confirm change ?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary" value="edit">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</form>
</body>
<script src="../../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
