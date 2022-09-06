function register() { var http = new XMLHttpRequest();
    var url = "register";
    var name = document.querySelector("#name").value;
    var mobile = document.querySelector("#mobile").value;
    var password = document.querySelector("#password").value;
    var params = "name=" + name + "&" + "mobile=" + mobile + "&" + "password=" + password;

    http.open("POST", url, true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.onreadystatechange = function() {
        if(http.readyState == 4) {
            if (http.status ==  200) {
                document.getElementById("register-message")
                        .innerHTML = "<div class=\"alert alert-success\" role=\"alert\">" +
                                     "注册成功!</div>";
                document.getElementById("name").value = "";
                document.getElementById("mobile").value = "";
                document.getElementById("password").value = "";
                document.getElementById("password-again").value = "";
            } else {
                document.getElementById("register-message")
                        .innerHTML = "<div class=\"alert alert-danger\" role=\"alert\">" +
                                     "注册失败！</div>";
            }
        }
    }
    http.send(params);
}

function signin() {
    var http = new XMLHttpRequest();
    var url = "signin";
    var name = document.querySelector("#name").value;
    var password = document.querySelector("#password").value;
    var params = "name=" + name + "&" + "password=" + password;

    http.open("POST", url, true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.onreadystatechange = function() {
        if (http.readyState == 4) {
            if (http.status ==  200) {
                window.location.replace("index");
            } else {
                document.getElementById("signin-message")
                        .innerHTML = "<div class=\"alert alert-danger\" role=\"alert\">" +
                                     "用户名或密码错误！</div>";
            }
        }
    }
    http.send(params);
}

function moveToSignIn() { 
    window.location.replace("signin");
}

function addToCart(userId, goodsId) {
    var http = new XMLHttpRequest();  
    var url = "cart";
    var goodsNumber = document.getElementById("goods-number-" + goodsId).innerHTML;
    var params = "customerId=" + userId + "&" + "goodsId=" + goodsId + "&" + "goodsNumber=" + goodsNumber; 

    http.open("POST", url, true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.onreadystatechange = function() {
        if (http.readyState == 4) {
            if (http.status == 200) {
                document.getElementById("cart-message-" + goodsId)
                        .innerHTML = "<div class=\"alert alert-success\" role=\"alert\">" +
                                     "添加成功！</div>";
            } else {
                document.getElementById("cart-message-" + goodsId)
                        .innerHTML = "<div class=\"alert alert-danger\" role=\"alert\">" +
                                     "添加失败！</div>";
            }
        }
    }
    http.send(params);
}

function increase(goodsId) {
    var goodsNumber = document.getElementById("goods-number-" + goodsId);
    var number = Number(goodsNumber.innerHTML) + 1;
    goodsNumber.innerHTML = number.toString();
}

function decrease(goodsId) {
    var goodsNumber = document.getElementById("goods-number-" + goodsId);
    var number = Number(goodsNumber.innerHTML);
    if (number > 1) {
        number -= 1;
    } 
    goodsNumber.innerHTML = number.toString();
}

function getOrdersAndGoods(customerId) {
    var http = new XMLHttpRequest();  
    var url = "cart?customerId=" + customerId;

    http.open("GET", url, true);
    http.setRequestHeader("Content-Type", "application/json");
    http.onreadystatechange = function() {
        if (http.readyState == 4) {
            if (http.status == 200) {
                const ordersAndGoods = JSON.parse(http.responseText);
                var cartGrid = document.getElementById("cart-grid");
                cartGrid.innerHTML = "";
                var totalAmount = 0;
                for (let i = 0; i < ordersAndGoods[1].length; i++) {
                    var goodsCard =  "<div class=\"card\">" +
                      "<img src=\"" + ordersAndGoods[1][i].goodsPicture + "\" class=\"card-img-top\" alt=\"goods\" style=\"padding: 1em;height:50%;\">" +
                      "<div class=\"card-body\">" +
                        "<ul class=\"list-group\">" +
                        "<li class=\"list-group-item\">名称: " + ordersAndGoods[1][i].goodsName + "</li>" +
                        "<li class=\"list-group-item\"><span style=\"color:red;\">￥" + ordersAndGoods[1][i].goodsPrice + "</span></li>" +
                        "<li class=\"list-group-item\">数量: ×" + ordersAndGoods[0][i].orderNumber + "</li>" +
                        "</ul>&nbsp;" +
                        "<button onclick=\"deleteOrder(" + customerId + "," + ordersAndGoods[0][i].orderId + 
                        ")\" type=\"button\" class=\"btn btn-danger\" style=\"min-width:100%;\">" + 
                        "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-cart-x-fill\" viewBox=\"0 0 16 16\">" +
                        "<path d=\"M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM7.354 5.646 8.5 6.793l1.146-1.147a.5.5 0 0 1 .708.708L9.207 7.5l1.147 1.146a.5.5 0 0 1-.708.708L8.5 8.207 7.354 9.354a.5.5 0 1 1-.708-.708L7.793 7.5 6.646 6.354a.5.5 0 1 1 .708-.708z\"/>" +
                        "</svg>" +
                        "删除</button>" +
                      "</div>" +
                      "</div>";
                    cartGrid.innerHTML += goodsCard;
                    totalAmount += ordersAndGoods[0][i].orderAmount;
                }
                document.getElementById("total-amount").innerHTML = "￥" + totalAmount.toFixed(2); 
            } else {
                console.log("failed!");
            }
        }
    }
    http.send();
}

function deleteOrder(customerId, orderId) {
    var http = new XMLHttpRequest();
    var url = "cart?orderId=" + orderId;

    http.open("DELETE", url, true);
    http.onreadystatechange = function() {
        if (http.readyState == 4) {
            if (http.status == 200) {
                getOrdersAndGoods(customerId); 
            }
        }
    }
    http.send();
}

function updateUserInfo(userId) {
    var http = new XMLHttpRequest(); 
    var url = "user";
    var param = "userId=" + userId + "&" + "userAddress=" + document.querySelector("#user-address-1").value;

    http.open("POST", url, true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.onreadystatechange = function() {
        if (http.readyState == 4) {
            if (http.status == 200) {
                console.log("success");
            }
        }
    }
    http.send(param);
}

function getUserInfo(userId) {
    var http = new XMLHttpRequest(); 
    var url = "user?userId=" + userId;

    http.open("GET", url, true);
    http.onreadystatechange = function() {
        if (http.readyState == 4) {
            if (http.status == 200) {
                const userInfo = JSON.parse(http.responseText);
                document.getElementById("user-address-1").value = userInfo.customerAddress;
                var x =document.getElementsByClassName("user-address");
                for (let i = 0; i < x.length; i++) {
                    x[i].innerHTML = userInfo.customerAddress;
                }
            }
        }
    }
    http.send();
}

function setToOneAndGetUserInfo(userId, goodsId) {
    document.getElementById("goods-number-" + goodsId).innerHTML = 1;
    getUserInfo(userId);
}

