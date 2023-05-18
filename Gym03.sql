create database gym charset utf8;

use gym;


/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/5/18 19:41:30                           */
/*==============================================================*/


drop table if exists customer;

drop table if exists register;

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   cus_id               int not null,			/*用户账号*/
   cus_pswd             varchar(20) not null,/*用户密码*/
   cus_name             varchar(20) ,/*用户姓名*/
   vip_lvl              int,						/*会员等级*/
   cus_tel              varchar(20),			/*用户电话号码*/
   cus_hgt					int,						/*用户身高*/
   cus_wgt					int,						/*用户体重*/
   cus_age              int,						/*用户年龄*/
   primary key (cus_id)
);


/*==============================================================*/
/* Table: register                                              */
/*==============================================================*/
create table register
(
   cus_id               int not null,					/*用户账号*/
   cus_pswd             varchar(20) not null,		/*用户密码*/
   primary key (cus_id)
);



alter table customer add constraint FK_Reference_7 foreign key (cus_id)
      references register (cus_id) on delete restrict on update restrict;
