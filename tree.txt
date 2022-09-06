.
├── add_goods.sql
├── create.sql
├── deploy.sh
├── pom.xml
├── README.md
└── src
    └── main
        ├── java
        │   └── com
        │       └── liguangda
        │           ├── bean
        │           │   ├── Customer.java
        │           │   ├── Goods.java
        │           │   └── Order.java
        │           ├── controllers
        │           │   ├── CartServlet.java
        │           │   ├── IndexServlet.java
        │           │   ├── RegisterServlet.java
        │           │   ├── SignInServlet.java
        │           │   ├── SignOutServlet.java
        │           │   ├── TestServlet.java
        │           │   ├── UserInfoServlet.java
        │           │   └── UserUtils.java
        │           ├── dao
        │           │   ├── ICustomerDao.java
        │           │   ├── IGoodsDao.java
        │           │   ├── impl
        │           │   │   ├── CustomerDaoImpl.java
        │           │   │   ├── GoodsDaoImpl.java
        │           │   │   └── OrderDaoImpl.java
        │           │   └── IOrderDao.java
        │           ├── service
        │           │   ├── ICustomerService.java
        │           │   ├── IGoodsService.java
        │           │   ├── impl
        │           │   │   ├── CustomerServiceImpl.java
        │           │   │   ├── GoodsServiceImpl.java
        │           │   │   └── OrderServiceImpl.java
        │           │   └── IOrderService.java
        │           └── utils
        │               ├── C3P0ConnectionPoolUtils.java
        │               └── MyDBUtils.java
        ├── resources
        └── webapp
            ├── css
            │   └── xiaomi.css
            ├── img
            │   ├── cart.jpg
            │   ├── goods
            │   │   ├── phone1.jpg
            │   │   ├── phone2.jpg
            │   │   ├── phone3.jpg
            │   │   ├── phone4.jpg
            │   │   ├── phone5.jpg
            │   │   ├── toy1.jpg
            │   │   ├── toy2.jpg
            │   │   ├── toy3.jpg
            │   │   ├── toy4.jpg
            │   │   ├── tv1.jpg
            │   │   ├── tv2.jpg
            │   │   ├── tv3.jpg
            │   │   └── tv4.jpg
            │   ├── misc.jpg
            │   ├── shopping_bags.jpg
            │   ├── xiaomi1.jpg
            │   ├── xiaomi2.webp
            │   ├── xiaomi3.webp
            │   └── xiaomi_logo.png
            ├── js
            │   └── user.js
            └── WEB-INF
                ├── classes
                │   └── c3p0.properties
                ├── pages
                │   ├── include
                │   │   ├── carousel.jsp
                │   │   ├── footer.jsp
                │   │   ├── goods_card.jsp
                │   │   ├── left_offcanvas.jsp
                │   │   ├── navbar.jsp
                │   │   ├── register_form.jsp
                │   │   ├── right_offcanvas.jsp
                │   │   ├── signin_form.jsp
                │   │   └── userInfo.jsp
                │   ├── index.jsp
                │   ├── register.jsp
                │   └── signin.jsp
                └── web.xml
