
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- left --> 
<div class="col-sm-3">
    <!-- Danh ba-->
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">

            <c:forEach items="${SHOWCATE}" var="item">
                <li class="list-group-item text-white ${TAGCID == item.id ? "active " : ""}"><a href="category?cid=${item.id}" ${TAGCID == item.id ? "style='color:white'" : ""}><c:out value="${item.name}"/></a></li>
            </c:forEach>

        </ul>
    </div>
    <!-- Het Danh ba -->
    <!-- SP Moi nhat -->
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="${SHOWPRONEW.image}" />
            <h5 class="card-title"> ${SHOWPRONEW.name} </h5>
            <p class="card-text">${SHOWPRONEW.title}</p>
            <p class="bloc_left_price">${SHOWPRONEW.price}</p>
        </div>
    </div>
    <!-- Het SP Moi nhat -->
</div>                    
<!-- left -->