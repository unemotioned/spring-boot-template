-- user: boot_test
-- pw: 1234

use boot_test;

drop table if exists tbl_member;

create table tbl_member (
    member_id varchar(30) primary key,
    member_pw varchar(60) not null
);

insert into tbl_member (member_id, member_pw) values ('admin999', 'admin999@');

commit;
