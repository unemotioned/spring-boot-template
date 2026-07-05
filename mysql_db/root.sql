-- '%': allows user to connect from any host
-- or can be replaced by specific ip or hostname(localhost || 192.168.0.43)
create user 'boot_test' @'%' identified by '1234';

-- grant all privileges on the database to the user
grant all privileges on boot_test.* to 'boot_test' @'%';

-- to ensure changes are applied immediately
flush privileges;
