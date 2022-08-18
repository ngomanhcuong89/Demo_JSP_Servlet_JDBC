<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.DAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Confirm</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="Home.jsp">Shoes</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav" style="margin-right: 20px">
                        <c:if test="${sessionScope.ACCOUNT.isadmin == 1}">
                            <li class="nav-item">
                                <a class="nav-link" href="manageraccount">Manager Account</a>
                            </li>                                
                        </c:if>
                        <c:if test="${sessionScope.ACCOUNT.issell == 1}">
                            <li class="nav-item">
                                <a class="nav-link" href="managerproduct">Manager Product</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="managerorder">Manager Order</a>
                            </li>                                   
                        </c:if>
                        <c:if test="${sessionScope.ACCOUNT != null}">
                            <li class="nav-item">
                                <a class="nav-link" href="#">Hello ${sessionScope.ACCOUNT.user}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="logout">Logout</a>
                            </li>                                
                        </c:if>
                        <c:if test="${sessionScope.ACCOUNT == null}">
                            <li class="nav-item">
                                <a class="nav-link" href="Login.jsp">Login</a>
                            </li>                                
                        </c:if>
                    </ul>

                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="${SEARCHCONTENT != null ? SEARCHCONTENT : "Search..."}">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="YourCart.jsp">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">${sessionScope.CARTS != null ? sessionScope.CARTS.size() : "0"}</span>
                        </a>
                    </form>
                </div>
            </div>
        </nav>     
        <!-- menu -->
        <div class="container" style="margin-top: 20px">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="#"><a href="yourcart">Your Cart</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Order Confirm</li>
                        </ol>
                    </nav>
                </div>
            </div>            
            <div class="container breadcrumb">
                <h5>Xác Nhận Đơn Hàng</h5>
            </div>
            <div class="container breadcrumb">
                <table class="table">
                    <tr>
                        <%! String ngaydh;%>
                        <%  Date date = new Date();
                            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
                            ngaydh = formater.format(date);
                        %>
                        <td>Ngày đặt hàng : <%= ngaydh%> </td>
                    </tr>
                    <tr>
                        <c:set var="oldid" value="<%= new DAO().getOrderDetailId()%>"/>
                        <td>Order ID : ${oldid+1} </td>
                    </tr>
                    <tr>
                        <td>User người đặt : ${sessionScope.ACCOUNT.user} </td>
                    </tr>
                </table>
                <table class="table">
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Thành tiền</th>
                    </tr>                        
                    <c:set var="tongtien" value="0"/>
                    <c:forEach items="${sessionScope.PRODTO}" var="o">
                        <tr>
                            <c:set var="tongtien" value="${tongtien + (o.getProduct().getPrice() * o.getQuatity())}"/>
                            <td>${o.getProduct().getName()} </td>
                            <td>${o.getQuatity()} </td>
                            <td>${o.getProduct().getPrice() * o.getQuatity()} </td>                 
                        </tr>                            
                    </c:forEach>                     
                    <tr>
                        <th colspan="2">Tổng Cộng</th>
                        <th> ${tongtien} </th>
                    </tr>                            
                </table>                    
            </div>
            <div class="container breadcrumb">
                <a href="yourcart"><input type="submit" name="back" class="btn-success" style="margin-right: 10px" value="Sửa Đơn"/></a>
                <a href="ordersuccess"><input type="submit" name="buy" class="btn-success" value="Mua Hàng"/></a>
            </div>                
        </div>
        <!-- footer -->
        <footer class="text-light bg-dark">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-lg-4 col-xl-3" style="margin-top: 20px">
                        <h5>About</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <p class="mb-0">
                            Cựu sinh viên CNTT FPT. Ngành Ứng Dụng Phần Mềm. Mà do trường thương cô mến chưa trả bằng nên giờ đi code dạo kiếm cơm qua ngày !!!
                        </p>
                    </div>

                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto" style="margin-top: 20px">
                        <h5>Informations</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><a href="">Link 1</a></li>
                            <li><a href="">Link 2</a></li>
                            <li><a href="">Link 3</a></li>
                            <li><a href="">Link 4</a></li>
                        </ul>
                    </div>

                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto" style="margin-top: 20px">
                        <h5>Others links</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><a href="">Link 1</a></li>
                            <li><a href="">Link 2</a></li>
                            <li><a href="">Link 3</a></li>
                            <li><a href="">Link 4</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 col-lg-3 col-xl-3" style="margin-top: 20px">
                        <h5>Contact</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><i class="fa fa-home mr-2"></i> My company</li>
                            <li><i class="fa fa-envelope mr-2"></i> don.darkangel@gmail.com</li>
                            <li><i class="fa fa-phone mr-2"></i> + 84966 848 850</li>
                            <li><i class="fa fa-print mr-2"></i> + 84966 848 850</li>
                        </ul>
                    </div>
                    <div class="col-12 copyright mt-3">
                        <p class="float-left">
                            <a href="#">Back to top</a>
                        </p>
                        <p class="text-right text-muted">Deverloper Website <i class="fa fa-heart"></i> by <a href="https://www.facebook.com/dondark89/"><i>Ngô Mạnh Cường</i></a> | <span>Phone: 0966.848.850</span></p>
                    </div>
                </div>
            </div>
        </footer>            
        <!-- footer -->

    </body>
</html>