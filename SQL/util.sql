drop database shopping;

create database shopping;

select * from t_comment;

select * from t_salesorder where userid = 1;

select * from t_salesorder ORDER BY pdate DESC limit 0,5

select * from t_product where DATE_SUB(CURDATE(), INTERVAL 3 DAY) <= date(pdate) ORDER BY pdate DESC limit 0,7;

select * from t_salesitem;
select * from t_notice order by pdate desc
select * from t_user;

select * from t_favorite where userid=1;

select sum(totalmoney) from t_salesorder where userid=1;

select * from t_category;

select * from t_category where pid = 0;

select * from t_product;

select * from  t_favorite;

select * from t_notice;

desc t_product;

select * from t_user where username like '%ad%';

select productid,sum(pcount) from t_salesitem group by productid limit 10;

select * from t_product where name like '%鸭%' and categoryid=8;

select * from t_product where name like '%大%' and categoryid in (select distinct id from t_category where pid=2);

select * from t_salesorder where userid=1 ORDER BY pdate DESC limit 0,5;