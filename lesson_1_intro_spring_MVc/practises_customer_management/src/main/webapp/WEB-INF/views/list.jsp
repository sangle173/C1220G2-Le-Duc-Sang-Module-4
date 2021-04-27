<%--
  Created by IntelliJ IDEA.
  User: SANG
  Date: 4/26/2021
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"></script>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Mr Sang</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Codegym</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Menu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">C12</a>
                        <a class="dropdown-item" href="#">Final Test</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <%--            <form class="form-inline my-2 my-lg-0">--%>
            <%--                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
            <%--                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">SearchByName</button>--%>
            <%--            </form>--%>
        </div>
    </nav>
    <%--    <div class="row">--%>

    <%--        <table class="table table-striped" style="width:100%">--%>
    <%--            <tr>--%>
    <%--                <td>--%>
    <%--                    <form class="form-inline my-2 my-lg-0" action="/search_name" method="get">--%>
    <%--                        <input class="form-control mr-sm-2" type="text" placeholder="Product Name" aria-label="Search"--%>
    <%--                               name="nameSearch">--%>
    <%--                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">SearchByName</button>--%>
    <%--                    </form>--%>
    <%--                </td>--%>
    <%--                <td>--%>
    <%--                    <form class="form-inline my-2 my-lg-0" action="/search_price" method="get">--%>
    <%--                        <input class="form-control mr-sm-2" type="number" placeholder="Product Price"--%>
    <%--                               aria-label="Search"--%>
    <%--                               name="priceSearch">--%>
    <%--                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">SearchPrice</button>--%>
    <%--                    </form>--%>
    <%--                </td>--%>
    <%--                <td>--%>
    <%--                    <input class="form-control mr-sm-2" type="text" placeholder="Product Category"--%>
    <%--                           aria-label="Search"--%>
    <%--                           name="categorySearch">--%>
    <%--                </td>--%>
    <%--                <td>--%>
    <%--                    <input class="form-control mr-sm-2" type="text" placeholder="Product Color" aria-label="Search"--%>
    <%--                           name="colorSearch">--%>
    <%--                </td>--%>
    <%--                <td>--%>

    <%--                </td>--%>
    <%--            </tr>--%>
    <%--        </table>--%>
    <%--    </div>--%>
    <a class="btn btn-primary" type="button" href="http://localhost:8080/create">Create Customers</a>
    <table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Category</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.customers}" var="customer" varStatus="i">
            <tr>
                <td><c:out value="${i.index+1}"/></td>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.email}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td>
                    Edit
                </td>
                <td>
                    Delete
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="modal fade" id="confirm-delete" tabindex="-1"
         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">×
                    </button>
                </div>
                <div class="modal-body">
                    <p>Do you want to proceed <span id="nameDelete"></span>?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <form action="/delete">
                        <input type="hidden" name="idDelete" value="idDelete" id="idDelete">
                        <input type="submit" class="btn btn-danger" value="Delete">
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
        function setIdToForm(productId, productName) {
            $('#confirm-delete').modal('show');
            document.getElementById("idDelete").value = productId;
            document.getElementById("nameDelete").innerText = productName;
        }

        $(document).ready(function () {
            $('#example').dataTable({
                "language": {
                    "sProcessing": "Đang xử lý...",
                    "sLengthMenu": "Xem _MENU_ mục",
                    "sZeroRecords": "Không tìm thấy dòng nào phù hợp",
                    "sInfo": "Đang xem _START_ đến _END_ trong tổng số _TOTAL_ mục",
                    "sInfoEmpty": "Đang xem 0 đến 0 trong tổng số 0 mục",
                    "sInfoFiltered": "(được lọc từ _MAX_ mục)",
                    "sInfoPostFix": "",
                    "sSearch": "Tìm:",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "Đầu",
                        "sPrevious": "Trước",
                        "sNext": "Tiếp",
                        "sLast": "Cuối"
                    }
                }
            });
        });
    </script>
</div>
<h1>There are ${requestScope.customers.size()} customer(s) in list.</h1>

</body>
</html>
