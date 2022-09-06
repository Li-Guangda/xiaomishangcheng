<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>小米商城</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">
    <link href="css/xiaomi.css" rel="stylesheet">
  </head>
  <body id="index-body">
    <%@ include file="include/navbar.jsp" %>
    <div id="index-main-card" class="card">
      <%@ include file="include/carousel.jsp" %>
      <div class="card-body">
         <!-- Show all goods -->
         <div class="row" style="margin-top:30px">
          <div class="col">
            <div class="card border border-warning">
              <div class="card-body border border-warning">
                <h2>所有</h2>&nbsp;
                <div class="grid text-center" style="--bs-columns: 5;">
                    <c:forEach items="${sessionScope.goodsList}" var="goods">
                        <jsp:include page="include/goods_card.jsp">
                            <jsp:param name="goodsId" value="${goods.getGoodsId()}" />
                            <jsp:param name="goodsPicture" value="${goods.getGoodsPicture()}" />
                            <jsp:param name="goodsName" value="${goods.getGoodsName()}" />
                            <jsp:param name="goodsPrice" value="${goods.getGoodsPrice()}" />
                            <jsp:param name="goodsStock" value="${goods.getGoodsStock()}" />
                            <jsp:param name="goodsFeature" value="${goods.getGoodsFeature()}" />
                        </jsp:include>
                    </c:forEach>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
    <%@ include file="include/footer.jsp" %>

    <script type="text/javascript" src="js/user.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
  </body>
</html>

