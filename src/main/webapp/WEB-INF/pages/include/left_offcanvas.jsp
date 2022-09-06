<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="offcanvas offcanvas-start bg-warning bg-gradient" tabindex="-1" id="left-offcanvas-${param.goodsId}" aria-labelledby="left-offcanvas-label">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="left-offcanvas-label">商品详情</h5>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">

    <div id="cart-message-${param.goodsId}"></div>

    <div class="card" style="height: 50%">
      <div class="card-body">
        <img style="max-width:80%; max-height:80%;margin:auto;vertical-align:middle;" src="${param.goodsPicture}" class="rounded" alt="goods">
      </div>
    </div>
    <h3>${param.goodsName}</h3>
    <ul class="list-group">
      <li class="list-group-item">${param.goodsFeature}</li>
      <li class="list-group-item">库存量：${param.goodsStock}</li>
      <li class="list-group-item">送货地址:<span class="user-address" id="user-address-${param.goodsId}"></span></li>
    </ul>
    <h3 class="text-danger d-flex">￥${param.goodsPrice}</h3>
    <div style="margin-bottom:10px;">
      <button type="button" class="btn btn-danger" style="margin-right:10px;" onclick="decrease(${param.goodsId})">-</button>
      <span id="goods-number-${param.goodsId}">1</span>
      <button type="button" class="btn btn-danger" style="margin-left:10px;" onclick="increase(${param.goodsId})">+</button>
    </div>
    <div class="d-grid gap-2">
        <c:choose>
            <c:when test="${sessionScope.userName != null}">
                <button class="btn btn-success" type="button" onclick="addToCart(${sessionScope.userId}, ${param.goodsId})">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-plus-fill" viewBox="0 0 16 16">
                      <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0z"/>
                    </svg>
                    加入购物车
                </button>
            </c:when>
            <c:otherwise>
                <button class="btn btn-success" type="button" onclick="moveToSignIn()">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-plus-fill" viewBox="0 0 16 16">
                  <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0z"/>
                </svg>
                    加入购物车
                </button>
            </c:otherwise>
        </c:choose>
    </div>

  </div>
</div>

<style>
    .user-address {
         
    }
</style>
