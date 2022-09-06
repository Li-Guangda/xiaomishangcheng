DROP SCHEMA IF EXISTS xiaomi;

-- xiaomi
CREATE OR REPLACE SCHEMA xiaomi CHARACTER SET =utf8 
    COMMENT "This is a schema for XiaoMi shopping mall.";

-- customers
CREATE OR REPLACE TABLE xiaomi.customers (
    customerId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    customerName VARCHAR(16),
    customerMobile VARCHAR(16) NOT NULL,
    customerAddress VARCHAR(256),
    customerPassword VARCHAR(15) DEFAULT "00000000"
);

-- goods
CREATE OR REPLACE TABLE xiaomi.goods (
    goodsId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  
    goodsName VARCHAR(128) NOT NULL,
    goodsBrand CHAR(4) NOT NULL DEFAULT "1001", 
    goodsCategory CHAR(4) NOT NULL DEFAULT "1010",
    goodsPrice DOUBLE(8,2) NOT NULL DEFAULT 0,
    goodsStock INT(6) DEFAULT 1, 
    goodsPicture VARCHAR(128),
    goodsFeature VARCHAR(256)
);

-- orders
CREATE OR REPLACE TABLE xiaomi.orders (
    orderId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    customerId INT NOT NULL REFERENCES xiaomi.customers(customerId),
    goodsId INT NOT NULL REFERENCES xiaomi.goods(goodsId),
    orderNumber INT(6) NOT NULL DEFAULT 1,
    orderAmount DOUBLE(10,2) NOT NULL DEFAULT 0,
    orderStatus CHAR(4) NOT NULL DEFAULT "1001",
    orderDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

-- sys_dictionary
CREATE OR REPLACE TABLE xiaomi.dictionary (
    dictionaryId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dictionaryTableName VARCHAR(16) NOT NULL,
    dictionaryColumnName VARCHAR(16) NOT NULL,
    dictionaryCode VARCHAR(4) NOT NULL,
    dictionaryValue VARCHAR(128)
);

