create table tbl01(
bno int not null auto_increment,
title varchar(200) not null,
content varchar(2000) not null,
writer varchar(200) not null,
regdate timestamp not null default now(),
viewcnt int default 0,
primary key(bno));
