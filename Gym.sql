create database gym charset utf8;

use gym;


/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/12/21 22:37:10                          */
/*==============================================================*/


drop table if exists bill;

drop table if exists customer;

drop table if exists emp_lve;

drop table if exists employer;

drop table if exists equipment;

drop table if exists job;

drop table if exists vip_lvl;

/*==============================================================*/
/* Table: bill                                                  */
/*==============================================================*/
create table bill
(
   bill_id              int not null,
   bill_type            char(2),
   bill_time            date,
   bill_amo             int,
   bill_rea             varchar(20),
   bill_one_id          int not null,
   primary key (bill_id)
);

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   cus_id               int not null,
   cus_name             varchar(20) not null,
   vip_lvl              int,
   FI_id                int,
   FI_name              varchar(20),
   cus_tel              varchar(20),
   primary key (cus_id)
);

/*==============================================================*/
/* Table: emp_lve                                               */
/*==============================================================*/
create table emp_lve
(
   lve_id               int not null,
	emp_id               int not null,
   emp_name             varchar(20),
   lve_date             date,
   reason               varchar(30),
   days                 tinyint,
   primary key (lve_id)
);

/*==============================================================*/
/* Table: employer                                              */
/*==============================================================*/
create table employer
(
   emp_id               int not null,
   emp_name             varchar(20) not null,
   sal                  double not null,
   bonus                double,
   hdate                date not null,
   job_id               int,
   primary key (emp_id)
);

/*==============================================================*/
/* Table: equipment                                             */
/*==============================================================*/
create table equipment
(
   equ_id               int not null,
   equ_name             varchar(30),
   equ_pri              double,
   equ_num              tinyint,
   equ_emp_id           int not null,
   primary key (equ_id)
);

/*==============================================================*/
/* Table: job                                                   */
/*==============================================================*/
create table job
(
   job_name             varchar(20) not null,
   job_id               int not null,
   primary key (job_id)
);

/*==============================================================*/
/* Table: vip_lvl                                               */
/*==============================================================*/
create table vip_lvl
(
   vip_lvl              int not null,
   vip_days             int,
   vip_name             varchar(20),
   vip_pri              int,
   primary key (vip_lvl)
);

alter table bill add constraint FK_Reference_6 foreign key (bill_one_id)
      references employer (emp_id) on delete restrict on update restrict;

alter table customer add constraint FK_Reference_1 foreign key (FI_id)
      references employer (emp_id) on delete restrict on update restrict;

alter table customer add constraint FK_Reference_5 foreign key (vip_lvl)
      references vip_lvl (vip_lvl) on delete restrict on update restrict;

alter table emp_lve add constraint FK_Reference_4 foreign key (emp_id)
      references employer (emp_id) on delete restrict on update restrict;

alter table employer add constraint FK_Reference_3 foreign key (job_id)
      references job (job_id) on delete restrict on update restrict;

alter table equipment add constraint FK_Reference_2 foreign key (equ_emp_id)
      references employer (emp_id) on delete restrict on update restrict;

#***************************************************************************************

#select * from bill;
#select * from customer;
#select * from emp_lve;
#select * from employer;
#select * from equipment;
#select * from job;
#select * from vip_lvl;


#desc employer

#*********************************************************************************************************************************************************************

insert into `job` (`job_name`, `job_id`) values ('初级教练', 5001);
insert into `job` (`job_name`, `job_id`) values ('中级教练', 5002);
insert into `job` (`job_name`, `job_id`) values ('高级教练', 5003);
insert into `job` (`job_name`, `job_id`) values ('前台', 5004);
insert into `job` (`job_name`, `job_id`) values ('管理人员', 5005);

#********************************************************

insert into `employer` (`emp_id`, `emp_name`, `sal`, `bonus`, `hdate`, `job_id`) values (3001, '张三三', 4500, 200, '2022-07-21',5001);
insert into `employer` (`emp_id`, `emp_name`, `sal`, `bonus`, `hdate`, `job_id`) values (3002, '王老五', 5100, 500, '2022-11-09',5002);
insert into `employer` (`emp_id`, `emp_name`, `sal`, `bonus`, `hdate`, `job_id`) values (3003, '赵六六', 6000, 450, '2022-07-01',5003);
insert into `employer` (`emp_id`, `emp_name`, `sal`, `bonus`, `hdate`, `job_id`) values (3004, '阿巴', 3500, 100, '2022-11-16',5004);
insert into `employer` (`emp_id`, `emp_name`, `sal`, `bonus`, `hdate`, `job_id`) values (3005, '溜子', 3500, 200, '2022-03-03',5005);

#************************

insert into `vip_lvl` (`vip_lvl`, `vip_days`, `vip_name`,`vip_pri`) values (2001,30, '初级会员',80);
insert into `vip_lvl` (`vip_lvl`, `vip_days`, `vip_name`,`vip_pri`) values (2002,90, '中级会员',220);
insert into `vip_lvl` (`vip_lvl`, `vip_days`, `vip_name`,`vip_pri`) values (2003,180, '高级会员',410);
insert into `vip_lvl` (`vip_lvl`, `vip_days`, `vip_name`,`vip_pri`) values (2004,365, '钻石会员',580);
insert into `vip_lvl` (`vip_lvl`, `vip_days`, `vip_name`,`vip_pri`) values (2005,600, '铂金会员',888);

#**********************************************

insert into `customer` (`cus_id`, `cus_name`, `vip_lvl`, `FI_id`, `FI_name`, `cus_tel`) values (1001, '大哥', 2005, 3003, '赵六六', '15244385509');
insert into `customer` (`cus_id`, `cus_name`, `vip_lvl`, `FI_id`, `FI_name`, `cus_tel`) values (1002, '二哥', 2004, 3002, '王老五', '18699077822');
insert into `customer` (`cus_id`, `cus_name`, `vip_lvl`, `FI_id`, `FI_name`, `cus_tel`) values (1003, '三哥', 2003, 3002, '王老五', '15200601517');
insert into `customer` (`cus_id`, `cus_name`, `vip_lvl`, `FI_id`, `FI_name`, `cus_tel`) values (1004, '四弟', 2002, 3001, '张三三', '18268759272');
insert into `customer` (`cus_id`, `cus_name`, `vip_lvl`, `FI_id`, `FI_name`, `cus_tel`) values (1005, '五弟', 2001, 3001, '张三三', '15648119256');

#****************************************************** 

insert into `bill` (`bill_id`, `bill_type`, `bill_time`, `bill_amo`, `bill_rea`, `bill_one_id`) values (8001, '支出', '2022-08-20 22:44:20', 100000, '购置健身器材', 3005);
insert into `bill` (`bill_id`, `bill_type`, `bill_time`, `bill_amo`, `bill_rea`, `bill_one_id`) values (8002, '收入', '2022-03-22 19:15:45', 80, '五弟购买了初级会员', 3004);
insert into `bill` (`bill_id`, `bill_type`, `bill_time`, `bill_amo`, `bill_rea`, `bill_one_id`) values (8003, '支出', '2022-07-03 22:59:50', 5600, '发工资给王老五', 3005);
insert into `bill` (`bill_id`, `bill_type`, `bill_time`, `bill_amo`, `bill_rea`, `bill_one_id`) values (8004, '收入', '2022-07-19 07:26:51', 410, '三哥购买了高级会员', 3004);
insert into `bill` (`bill_id`, `bill_type`, `bill_time`, `bill_amo`, `bill_rea`, `bill_one_id`) values (8005, '收入', '2022-04-19 12:13:18', 888, '大哥购买了铂金会员', 3004);

#*****************************************************************

insert into `emp_lve` (`lve_id`,`emp_id`, `emp_name`, `lve_date`, `reason`, `days`) values (4001,3003, '赵六六', '2022-10-04 10:24:22', '家里母猪生崽', 3);
insert into `emp_lve` (`lve_id`,`emp_id`, `emp_name`, `lve_date`, `reason`, `days`) values (4002,3005, '溜子', '2022-11-13 16:31:24', '生病', 5);
insert into `emp_lve` (`lve_id`,`emp_id`, `emp_name`, `lve_date`, `reason`, `days`) values (4003,3002, '王老五', '2022-04-11 23:34:48', '家庭成员遭遇事故', 5);
insert into `emp_lve` (`lve_id`,`emp_id`, `emp_name`, `lve_date`, `reason`, `days`) values (4004,3004, '阿巴', '2022-09-22 02:41:07', '生病', 2);
insert into `emp_lve` (`lve_id`,`emp_id`, `emp_name`, `lve_date`, `reason`, `days`) values (4005,3003, '赵六六', '2022-07-22 22:40:15', '回家继承家产', 7);

#********************************************************************************

insert into `equipment` (`equ_id`, `equ_name`, `equ_pri`, `equ_num`, `equ_emp_id`) values (6001, '哑铃', 100, 50, 3005);
insert into `equipment` (`equ_id`, `equ_name`, `equ_pri`, `equ_num`, `equ_emp_id`) values (6002, '跑步机', 1000, 15, 3005);
insert into `equipment` (`equ_id`, `equ_name`, `equ_pri`, `equ_num`, `equ_emp_id`) values (6003, '坐式屈腿训练器', 1500, 2, 3002);
insert into `equipment` (`equ_id`, `equ_name`, `equ_pri`, `equ_num`, `equ_emp_id`) values (6004, '悬挂训练系统', 5000, 1, 3003);
insert into `equipment` (`equ_id`, `equ_name`, `equ_pri`, `equ_num`, `equ_emp_id`) values (6005, '划船机', 2000, 3, 3001);
