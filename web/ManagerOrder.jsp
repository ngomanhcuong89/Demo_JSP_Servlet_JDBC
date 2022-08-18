<%-- 
    Document   : ManagerAccount.jsp
    Created on : Dec 28, 2021, 11:44:31 PM
    Author     : CuongPC
--%>

<%@page import="entity.Account"%>
<%@page import="dao.DAO"%>
<%@page import="entity.OrderDetail"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager Order</title>
        <!--begin of menu-->        
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>        
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <!--begin of menu-->        
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">

        </nav>      
        <!-- menu -->  
        <c:if test="${empty SHOW_ORDER_BY_CUST}">
            <div class="container">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage Order</h2>
                            </div>
                            <div class="col-sm-6">
                                <!--
                                <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Create New Account</span></a>
                                -->
                                <a href="Home.jsp" class="btn btn-primary"><i class="material-icons">&#xE15C;</i> <span>Back Home</span></a>	

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${not empty SHOW_ORDER_BY_CUST}">
            <div class="container">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage Order</h2>
                            </div>
                            <div class="col-sm-6">
                                <!--
                                <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Create New Account</span></a>
                                -->
                                <a href="Home.jsp" class="btn btn-primary"><i class="material-icons">&#xE15C;</i> <span>Back Home</span></a>	

                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Order_ID</th>
                                <th>Order_Date</th>
                                <th>User_Order</th>
                                <th>Complete_Date</th>
                                <th>Order_Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${SHOW_ORDER_BY_CUST}" var="item">
                                <tr>
                                    <c:set var="status" value=""/>
                                    <c:choose>
                                        <c:when test="${item.orderStatus == 0}">
                                            <c:set var="status" value="Đang Chờ Duyệt"/>
                                        </c:when>
                                        <c:when test="${item.orderStatus == 1}">
                                            <c:set var="status" value="Đã Hoàn Thành"/>
                                        </c:when>
                                        <c:when test="${item.orderStatus == 2}">
                                            <c:set var="status" value="Đơn Bị Hủy"/>
                                        </c:when>
                                    </c:choose>
                                    <td> ${item.id} </td>
                                    <td> ${item.orderDate} </td>
                                    <td> ${item.uid} </td>
                                    <td> ${item.completeDate} </td>
                                    <td> ${status} </td>
                                    <td>
                                        <c:if test="${empty UNLOCK}">
                                            <a href="managerordershow?oid=${item.id}"><i class="fa fa-lock" style="font-size:18px;" title="Mở khóa đơn hàng"></i></a>
                                            </c:if>
                                            <c:if test="${not empty UNLOCK}">
                                                <c:if test="${OID == item.id}">
                                                <a href="#showOrderItemModal" class="view" data-toggle="modal"><i class="fa fa-address-card-o" style="font-size:18px;" title="Chi tiết đơn hàng"></i></a>
                                                </c:if>
                                            </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                            <li class="page-item active"><a href="#" class="page-link">1</a></li>
                            <li class="page-item"><a href="#" class="page-link">2</a></li>
                            <li class="page-item"><a href="#" class="page-link">3</a></li>
                            <li class="page-item"><a href="#" class="page-link">4</a></li>
                            <li class="page-item"><a href="#" class="page-link">5</a></li>
                            <li class="page-item"><a href="#" class="page-link">Next</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <!-- Edit Modal HTML -->
            <div id="showOrderItemModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="managerorderupdate" method="POST">
                            <div class="modal-header">						
                                <h4 class="modal-title">Chi Tiết Đơn Hàng</h4>
                            </div>
                            <div class="modal-body">					
                                <table class="table">
                                    <tr>
                                        <td>Ngày đặt hàng : ${ORDERDETAIL.orderDate} </td>
                                    </tr>
                                    <tr>
                                        <td>Order ID : ${ORDERDETAIL.id} </td>
                                    <input type="hidden" name="orderid" value="${ORDERDETAIL.id}"/>
                                    </tr>
                                    <tr>

                                        <%! String name;%>
                                        <%
                                            int uid = (int) ((OrderDetail) request.getAttribute("ORDERDETAIL")).getUid();
                                            name = (String) ((Account) (new DAO().getAccountById(uid))).getUser();
                                        %>

                                        <td>User người đặt : <%= name%> </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="modal-body">
                                <table class="table" >
                                    <tr>
                                        <th style="width:35%">Sản phẩm</th>
                                        <th>Giá tiền</th>
                                        <th>Số lượng</th>
                                    </tr> 
                                    <c:set var="tongtien" value="0"/>
                                    <c:forEach items="${ORDERITEM}" var="items">
                                        <tr>
                                            <c:set var="tongtien" value="${tongtien+(items.pricenow*items.quatity)}"/>
                                            <td> ${items.pname} </td>
                                            <td> ${items.pricenow} </td>
                                            <td> ${items.quatity} </td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <th>Tổng Cộng</th>
                                        <th colspan="2"> ${tongtien} </th>
                                    </tr>
                                </table>                                         
                            </div>
                            <div class="modal-footer">
                                <a href="managerorder"> <input type="button" class="btn btn-default" value="CLOSE"/></a>
                                <input type="submit" class="btn btn-default" name="action" value="CANCEL">
                                <input type="submit" class="btn btn-success" name="action" value="SUBMIT">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:if>                            
        <script src="js/manager.js" type="text/javascript"></script>
        <script>

        </script>
    </body>
</html>