/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/5/23 21:52:40                           */
/*==============================================================*/


drop table if exists customer;

drop table if exists personal_timetable;

drop table if exists public_timetable;

drop table if exists register;

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   cus_id               int not null,
   cus_pswd             varchar(20) not null,
   cus_name             varchar(20),
   vip_lvl              int,
   cus_tel              varchar(20),
   cus_hgt              varchar(4),
   cus_wgt              varchar(4),
   cus_age              varchar(4),
   primary key (cus_id)
);

/*==============================================================*/
/* Table: personal_timetable                                    */
/*==============================================================*/
create table personal_timetable
(
   course_id            int not null,
   course               varchar(20) not null,
   teacher_name         varchar(10) not null,
   room                 varchar(10) not null,
   week                 varchar(4) not null,
   time                 time not null,
   cus_id               int not null,
   primary key (course_id)
);

/*==============================================================*/
/* Table: public_timetable                                      */
/*==============================================================*/
create table public_timetable
(
   course_id            int not null,
   week                 varchar(4) not null,
   time                 time not null,
   course               varchar(20) not null,
   booked               int not null,
   teacher_id           int not null,
   teacher_name         varchar(255) not null,
   room                 varchar(255) not null,
   time_id              int not null,
   upper_limit          int,
   primary key (course_id)
);

/*==============================================================*/
/* Table: register                                              */
/*==============================================================*/
create table register
(
   cus_id               int not null,
   cus_pswd             varchar(20) not null,
   primary key (cus_id)
);

alter table customer add constraint FK_Reference_1 foreign key (cus_id)
      references register (cus_id) on delete restrict on update restrict;

alter table personal_timetable add constraint FK_Reference_2 foreign key (course_id)
      references public_timetable (course_id) on delete restrict on update restrict;

