DELETE FROM xiaomi.goods;

-- Sample goods
INSERT INTO xiaomi.goods (
    goodsName, goodsBrand, goodsCategory, 
    goodsPrice, goodsStock, goodsPicture, goodsFeature
) VALUES 
('iphone11黑', '1001', '1001', 7899.99, 635, 'img/goods/phone1.jpg', '限购特惠2000加现货速发苹果iPhoneXSMAx'),
('iphone13粉', '1001', '1001', 5688.99, 323, 'img/goods/phone2.jpg', '限购特惠2000加现货速发苹果iPhoneXSMAx'),
('小米5', '1001', '1001', 1892.99, 728, 'img/goods/phone3.jpg', '限购特惠2000加现货速发小米'),
('iphone10黑', '1001', '1001', 9999.99, 992, 'img/goods/phone5.jpg', '限购特惠2000加现货速发苹果iPhoneXSMAx'),
('小米TV蓝', '1001', '1001', 5693.99, 281, 'img/goods/tv1.jpg', '限购特惠2000加现货速发小米tv'),
('索尼电视XS2', '1001', '1001', 6628.99, 233, 'img/goods/tv3.jpg', '限购特惠2000加现货速发苹果iPhoneXSMAx'),
('松下电视DH5', '1001', '1001', 9899.99, 888, 'img/goods/tv4.jpg', '限购特惠2000加现货速发苹果iPhoneXSMAx'),
('罗汉塔玩具', '1001', '1001', 10.05, 332, 'img/goods/toy1.jpg', '限购特惠免运费赠挂件'),
('绿军车玩具', '1001', '1001', 20.05, 32, 'img/goods/toy2.jpg', '限购特惠免运费赠挂件'),
('电话车玩具', '1001', '1001', 14.99, 342, 'img/goods/toy3.jpg', '限购特惠免运费赠挂件'),
('小房子玩具', '1001', '1001', 50.00, 883, 'img/goods/toy4.jpg', '限购特惠免运费赠挂件');

