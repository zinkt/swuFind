set names utf8;

create table tab_user
{
    uid         int not null auto_increment,
    username    varchar(100) not null,
    password    varchar(32) not null,
    name        varchar(100) not null,
    stu_id      varchar(15) not null,
    gender      char(1),
    email       varchar(100),
    status      cahr(1),

    primary key (uid),
   unique key AK_nq_username (username),

};