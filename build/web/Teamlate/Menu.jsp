<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
                                    <a class="nav-link" href="myaccount">Hello ${sessionScope.ACCOUNT.user}</a>
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
                            <a class="btn btn-success btn-sm ml-3" href="yourcart">
                                <i class="fa fa-shopping-cart"></i> Cart
                                <span class="badge badge-light">${sessionScope.CARTS != null ? sessionScope.CARTS.size() : "0"}</span>
                            </a>
                        </form>
                    </div>
                </div>
            </nav>
            <section class="jumbotron text-center">
                <div class="container">
                    <h1 class="jumbotron-heading">Demo Web Bán Giày Bằng JSP - Servlet - JDBC</h1>
                    <p class="lead text-muted mb-0" style="color:red">Ngô Mạnh Cường</p>
                </div>
            </section>        
            <!-- menu -->
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Category</a></li>
                                <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">