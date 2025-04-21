create database web_basic;
use web_basic;

select *from member; -- alt+x

drop table member;
-- 회원가입 테이블 생성

create table member(
   id varchar(20) primary key ,
   pwd varchar(20) not null,
   name varchar(20) not null,
   age int,
   phone varchar(15),
   addr varchar(50),
   join_date datetime not null
);

select * from member;
-- 레코드 추가
insert into member(id,pwd,name,age,phone,addr, join_date)
values('kim','1234','김희선',20,'010-8875-8253','서울시 광진구', now());

commit
