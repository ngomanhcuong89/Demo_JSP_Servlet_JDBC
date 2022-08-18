<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Teamlate/Menu.jsp" %>
<%@include file="Teamlate/Left.jsp" %>
<!-- right -->
<div class="col-sm-9">
    <div class="row">
        <c:set var="DANHDAUTRANG" value="T1" scope="session"/>
        <!--Tu dong ktra de cap nhat ds product -->
        <c:if test="${empty SHOWPRO}">
            <c:redirect url="showproduct"/>
        </c:if>
        <!--Tu dong ktra de cap nhat ds product -->
        <c:forEach items="${SHOWPRO}" var="item">
            <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                    <img class="card-img-top" src="${item.image}" alt="Card image cap">
                    <div class="card-body">
                        <h4 class="card-title show_txt"><a href="http://localhost:8088/Webbanhang1/detail?id=${item.id}" title="View Product">${item.name}</a></h4>
                        <p class="card-text show_txt">${item.title}</p>
                        <div class="row">
                            <div class="col">
                                <p class="btn btn-danger btn-block">${item.price}</p>
                            </div>
                            <div class="col">
                                <form action="addtocart" method="GET">
                                    <input type="hidden" name="id" value="${item.id}"/>
                                    <input type="hidden" name="cid" value="${TAGCID}"/>
                                    <input type="submit" class="btn btn-success btn-block" name="addtocart" value="Add to cart"/>
                                </form>
                                <!--
                                <a href="addtocart?id=${item.id}" class="btn btn-success btn-block">Add to cart</a>
                                -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>    
    </div>
    <div class="row clearfix" style="margin-top: 20px; float: right">
        <ul class="pagination">
            
            <c:if test="${not empty ISCATEPRO}">
                <c:if test="${INDEXPAGE != 1}">
                    <li class="page-item"><a href="category?indexpage=${INDEXPAGE-1}&cid=${TAGCID}"  class="page-link">Previous</a></li>
                </c:if>
                <c:forEach begin="1" end="${TOTALINDEXPAGE}" var="item">
                    <li class="page-item ${INDEXPAGE == item ? "active" : ""}"><a href="category?indexpage=${item}&cid=${TAGCID}" class="page-link">${item}</a></li>
                </c:forEach>
                <c:if test="${INDEXPAGE != TOTALINDEXPAGE}">
                    <li class="page-item"><a href="category?indexpage=${INDEXPAGE+1}&cid=${TAGCID}" class="page-link">Next</a></li>
                </c:if>                
            </c:if>
            
            <c:if test="${empty ISCATEPRO}">
                <c:if test="${INDEXPAGE != 1}">
                    <li class="page-item"><a href="showproduct?indexpage=${INDEXPAGE-1}"  class="page-link">Previous</a></li>
                </c:if>
                <c:forEach begin="1" end="${TOTALINDEXPAGE}" var="item">
                    <li class="page-item ${INDEXPAGE == item ? "active" : ""}"><a href="showproduct?indexpage=${item}" class="page-link">${item}</a></li>
                </c:forEach>
                <c:if test="${INDEXPAGE != TOTALINDEXPAGE}">
                    <li class="page-item"><a href="showproduct?indexpage=${INDEXPAGE+1}" class="page-link">Next</a></li>
                </c:if>
            </c:if>
        </ul>
    </div>      
</div>
<!-- right -->
<%@include file="Teamlate/Footer.jsp" %>