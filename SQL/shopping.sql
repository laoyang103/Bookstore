/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012/9/22 22:34:20                           */
/*==============================================================*/

drop table if exists t_ad;

drop table if exists t_notice;

drop table if exists t_comment;

drop table if exists t_favorite;

drop table if exists t_salesitem;

drop table if exists t_salesorder;

drop table if exists t_user;

drop table if exists t_product;

drop table if exists t_category;


/*==============================================================*/
/* Table: t_ad        广告表                                          */
/*==============================================================*/
create table t_ad
(
   id                   int auto_increment,
   img                  varchar(50) COLLATE utf8_unicode_ci,
   primary key (id)
);

/*==============================================================*/
/* Table: t_category     种类表                                       */
/*==============================================================*/
create table t_category
(
   id                   int auto_increment,
   pid                  int,
   name                 varchar(20) COLLATE utf8_unicode_ci,
   descr                varchar(50) COLLATE utf8_unicode_ci,
   cno               int,
   grade           int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_comment       评论表                                      */
/*==============================================================*/
create table t_comment
(
   id                   int auto_increment,
   content              varchar(255) COLLATE utf8_unicode_ci,
   cdate                datetime,
   userid               int,
   productid            int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_favorate           收藏表                                 */
/*==============================================================*/
create table t_favorite
(
   id                   int auto_increment,
   userid               int,
   productid            int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_notice        公告表                                      */
/*==============================================================*/
create table t_notice
(
   id                   int auto_increment,
   title                varchar(30) COLLATE utf8_unicode_ci,
   content              varchar(100) COLLATE utf8_unicode_ci,
   pdate            datetime,
   edate            datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: t_product        商品表                                     */
/*==============================================================*/
create table t_product
(
   id                   int auto_increment,
   name                 varchar(30) COLLATE utf8_unicode_ci,
   ncount               int,
   img                  varchar(30) COLLATE utf8_unicode_ci,
   descr                varchar(50) COLLATE utf8_unicode_ci,
   normalprice          double,
   memberprice          double,
   pdate                datetime,
   categoryid           int,
   ifspecial               int,
   primary key (id)
);

/*==============================================================*/
/* Table: t_salesitem     订单项目表                                      */
/*==============================================================*/
create table t_salesitem
(
   id                   int auto_increment,
   productid            int,
   unitprice            double,
   pcount               int,
   orderid              varchar(50) COLLATE utf8_unicode_ci,
   primary key (id)
);

/*==============================================================*/
/* Table: t_salesorder      订单表                                    */
/*==============================================================*/
create table t_salesorder
(
   id                   varchar(50) COLLATE utf8_unicode_ci not null,
   userid               int,
   totalmoney       double,
   pdate             datetime,
   recievename        varchar(20) COLLATE utf8_unicode_ci,
   address              varchar(100) COLLATE utf8_unicode_ci,
   paymethod         int,
   recievemethod       int,
   timedemand     int,
   status               int,
   remark               varchar(100) COLLATE utf8_unicode_ci,
   postcode         int,
   phone              char(11) COLLATE utf8_unicode_ci,
   primary key (id)
);

/*==============================================================*/
/* Table: t_user     用户表                                           */
/*==============================================================*/
create table t_user
(
   id                   int auto_increment,
   username             varchar(20) COLLATE utf8_unicode_ci,
   realname              varchar(20) COLLATE utf8_unicode_ci,
   password             varchar(30) COLLATE utf8_unicode_ci,
   postcode	            int,
   phone                char(11) COLLATE utf8_unicode_ci,
   address              varchar(100)COLLATE utf8_unicode_ci,
   regdate              datetime,
   grade                int,
   area                 varchar(20) COLLATE utf8_unicode_ci,
   primary key (id)
);

alter table t_comment add constraint FK_Reference_5 foreign key (userid)
      references t_user (id) on delete cascade on update cascade;

alter table t_comment add constraint FK_Reference_6 foreign key (productid)
      references t_product (id) on delete cascade on update cascade;

alter table t_favorite add constraint FK_Reference_8 foreign key (userid)
      references t_user (id) on delete cascade on update cascade;

alter table t_favorite add constraint FK_Reference_9 foreign key (productid)
      references t_product (id) on delete cascade on update cascade;

alter table t_product add constraint FK_Reference_1 foreign key (categoryid)
      references t_category (id) on delete cascade on update cascade;

alter table t_salesitem add constraint FK_Reference_3 foreign key (productid)
      references t_product (id) on delete cascade on update cascade;

alter table t_salesitem add constraint FK_Reference_4 foreign key (orderid)
      references t_salesorder (id) on delete cascade on update cascade;

alter table t_salesorder add constraint FK_Reference_2 foreign key (userid)
      references t_user (id) on delete cascade on update cascade;
