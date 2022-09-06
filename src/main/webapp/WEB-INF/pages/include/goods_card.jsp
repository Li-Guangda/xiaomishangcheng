<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div class="card border border-warning border-2" id="goods-div">
    <a data-bs-toggle="offcanvas" href="#left-offcanvas-${param.goodsId}" role="button" aria-controls="left-offcanvas" onclick="setToOneAndGetUserInfo(${sessionScope.userId}, ${param.goodsId})">
        <img src="${param.goodsPicture}" id="goods-img" class="card-img-top" alt="phone">
        <div class="card-body">
          <h5 class="card-title">${param.goodsName}</h5>
          <h2><span class="text-danger">￥${param.goodsPrice}</span></h2>
        </div>
    </a>
</div>
<jsp:include page="left_offcanvas.jsp" >
    <jsp:param name="goodsId" value="${param.goodsId}"/>
    <jsp:param name="goodsname" value="${param.goodsName}"/>
    <jsp:param name="goodsPicture" value="${param.goodsPicture}"/>
    <jsp:param name="goodsFeature" value="${param.goodsFeature}"/>
    <jsp:param name="goodsStock" value="${param.goodsStock}"/>
    <jsp:param name="goodsPrice" value="${param.goodsPrice}"/>
</jsp:include>

<style>
    #goods-div {
        padding: 1em;
    }
    #goods-img {
        height: 200px;
    }
    a {
        text-decoration: none;
    }
</style>
