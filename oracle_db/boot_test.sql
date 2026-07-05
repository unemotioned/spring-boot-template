-- user: boot_test
-- pw: 1234

drop table tbl_member;

create table tbl_member (
    member_id varchar2(30) primary key,
    member_pw varchar2(60) not null
);

insert into tbl_member (member_id, member_pw) values ('admin999', 'admin999@');

commit;
