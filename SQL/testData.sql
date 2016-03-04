insert into t_user values(null,'admin','网管','123456','241000','13800000001','农大',now(),2,'江西南昌南昌市');
insert into t_user values(null,'root','树根','123456','241000','13800000002','科大',now(),1,'广东深圳宝安区');
insert into t_user values(null,'manager','管理员','123456','123456','13879898989','交大',now(),0,'广东广州广州市');

insert into t_notice values(null,'百斯盾女裤到新货','百斯盾女裤新款上市欢迎选购',now(),'2012-12-04 23:05:25.0'); 
insert into t_notice values(null,'柒牌减价大酬宾','柒牌从2012年3月1日起减价大酬宾,欢迎新老顾客',now(),'2012-12-04 23:05:25.0');

insert into t_ad values(null,'dangdang');
insert into t_ad values(null,'taobao');

insert into t_category values(null,0,'食品烟酒','食品烟酒系列',010000,1);
insert into t_category values(null,0,'健康美容','健康美容系列',020000,1);
insert into t_category values(null,0,'家居日用','家居日用系列',030000,1);
insert into t_category values(null,0,'服装鞋帽','服装鞋帽系列',040000,1);
insert into t_category values(null,0,'IT数码','IT数码系列',050000,1);
insert into t_category values(null,0,'文房四宝','文房四宝系列',060000,1);

insert into t_category values(null,1,'素食区','素食区系列',010100,2);
insert into t_category values(null,1,'熟食区','熟食区系列',010200,2);
insert into t_category values(null,1,'香烟区','香烟区系列',010300,2);
insert into t_category values(null,1,'酒水区','酒水区系列',010400,2);

insert into t_category values(null,2,'护肤区','护肤区系列',020100,2);
insert into t_category values(null,2,'彩妆区','彩妆区系列',020200,2);
insert into t_category values(null,2,'美发区','美发区系列',020300,2);
insert into t_category values(null,2,'香水区','香水区系列',020400,2);
insert into t_category values(null,2,'瘦身区','瘦身区系列',020500,2);

insert into t_category values(null,3,'生活用品区','生活用品区系列',030100,2);
insert into t_category values(null,3,'家电区','家电区系列',030200,2);

insert into t_category values(null,4,'女装区','女装区系列',040100,2);
insert into t_category values(null,4,'男装区','男区系列',040200,2);
insert into t_category values(null,4,'童装区','童装区系列',040300,2);
insert into t_category values(null,4,'鞋帽区','鞋帽区系列',040400,2);

insert into t_category values(null,5,'手机区','手机区系列',050100,2);
insert into t_category values(null,5,'笔记本区','笔记本区系列',050200,2);
insert into t_category values(null,5,'电脑区','电脑区系列',050300,2);
insert into t_category values(null,5,'相机区','相机区系列',050400,2);
insert into t_category values(null,5,'配件区','配件区系列',050500,2);
insert into t_category values(null,5,'影音区','影音区系列',050600,2);

insert into t_category values(null,6,'书籍区','书籍区系列',060100,2);
insert into t_category values(null,6,'文具区','文具区系列',060200,2);


insert into t_product values(null,'小白菜',1000,'小白菜','天然绿色',8,6,now(),7,1);
insert into t_product values(null,'鸭脖',591,'鸭脖','可口熟食',28,26,now(),8,0);
insert into t_product values(null,'芙蓉王',173,'芙蓉王','吸烟有害健康',28,16,now(),9,0);
insert into t_product values(null,'水果啤酒',2301,'水果啤酒','天然绿色',8,6,now(),10,0);

insert into t_product values(null,'大宝soD蜜',463,'大宝soD蜜','爱美之心人皆有之',42,36,now(),11,1);
insert into t_product values(null,'YangSang彩妆',1456,'YangSang彩妆','爱美之心人皆有之',45,37,now(),12,1);
insert into t_product values(null,' 蝴蝶珍珠镶钻发圈 ',379,'蝴蝶珍珠镶钻发圈','爱美之心人皆有之',3.8,2.6,now(),13,0);
insert into t_product values(null,'瑞希尔 魔境女士香水',190,'瑞希尔 魔境女士香水','爱美之心人皆有之',168,159,now(),14,1);
insert into t_product values(null,'窈窕纤体凝露',791,'窈窕纤体凝露','爱美之心人皆有之',98,86,now(),15,1);

insert into t_product values(null,'Tonze天际豆浆机',496,'Tonze天际豆浆机','生活用品',193.8,187,now(),16,0);
insert into t_product values(null,'康佳电视',96,'康佳电视','家电',1800,1680,now(),17,1);

insert into t_product values(null,'条纹拼接裙子',560,'条纹拼接裙子','韩版女装',390,350,now(),18,1);
insert into t_product values(null,'劲霸男上衣',1000,'劲霸男上衣','劲霸男装',800,680,now(),19,1);
insert into t_product values(null,'童装长袖T袖',833,'童装长袖T袖','韩版童装',80,68,now(),20,1);
insert into t_product values(null,'英伦风韩版休闲鞋',731,'英伦风韩版休闲鞋','韩版男鞋',749,720,now(),21,1);

insert into t_product values(null,'诺基亚C500',794,'诺基亚C500','智能手机',990,940,now(),22,1);
insert into t_product values(null,'联想 Y180N',400,'联想 Y180N','笔记本电脑',4466,4148,now(),23,1);
insert into t_product values(null,'dell R1530',400,'dell R1530','台式电脑',4687,4400,now(),24,1);
insert into t_product values(null,'佳能 IXUS 125',490,'佳能 IXUS 125','数码相机',1209,1180,now(),25,1);
insert into t_product values(null,'三星i9220蓝牙耳机',406,'三星i9220蓝牙耳机','配件',87,80,now(),26,1);
insert into t_product values(null,'纽曼A26 1.8寸4G超薄MP3',677,'纽曼A26 1.8寸4G超薄MP3','影音随身听',139,120,now(),27,1);

insert into t_product values(null,'看图片识单词',700,'看图片识单词','宝宝学习的好帮手',20,18,now(),28,1);
insert into t_product values(null,'0.5mm子弹头笔芯 ',3461,'0.5mm子弹头笔芯','宝宝学习的好帮手',2,1.8,now(),29,0);



insert into t_salesorder values('201209240001',1,1800,now(),'admin','农大南区',1,1,1,1,'求不坑',241000,'18779885607');
insert into t_salesorder values('201209240002',1,2800,now(),'小三','农大北区',1,2,2,2,'求不坑',241000,'18779885607');

insert into t_salesitem values(null,1,900,2,'201209240001');
insert into t_salesitem values(null,2,700,4,'201209240001');

insert into t_favorite values(null,1,10);
insert into t_favorite values(null,1,20);

insert into t_comment values(null,'东西不错',now(),1,22);
insert into t_comment values(null,'还行吧',now(),2,22);