drop table if exists AC_PWD;

/*==============================================================*/
/* Table: AC_PWD                                                */
/*==============================================================*/
create table AC_PWD
(
   ID                   bigint not null,
   NAME                 varchar(50),
   AC                   varchar(50),
   PWD                  varchar(50),
   EXT_FLD              varchar(100),
   primary key (ID)
)DEFAULT CHARSET=utf8;;

alter table AC_PWD comment '’ ∫≈√‹¬Î±Ì';