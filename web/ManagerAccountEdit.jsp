<%-- 
    Document   : ManagerAccountEdit
    Created on : Dec 30, 2021, 9:39:31 AM
    Author     : CuongPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager Account Edit</title>
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
        <div class="container">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="manageraccountedit" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Manager Account - Edit</h4>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Id</label>
                                <input name="id" type="text" value="${SHOWACC.id}" class="form-control" readonly="readonly" required>
                            </div>
                            <div class="form-group">
                                <label>User</label>
                                <input name="user" type="text" value="${SHOWACC.user}" class="form-control" readonly="readonly" required>
                            </div>
                            <div class="form-group">
                                <label>Pass</label>
                                <input name="pass" type="text" value="${SHOWACC.pass}" class="form-control" required>
                            </div>
                            <div class="form-group" name="radio">
                                <label>Seller</label>
                                <div class="">
                                    <input type="radio" name="issellradio" value="1" ${SHOWACC.issell == 1 ? "checked" : ""} />
                                    <label> Yes </label>
                                    <input type="radio" name="issellradio" value="0" ${SHOWACC.issell == 0 ? "checked" : ""}/>
                                    <label> No </label>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="manageraccount"><input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel"></a>
                            <input type="submit" class="btn btn-success" value="Edit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
        <script></script>
    </body>
</html>