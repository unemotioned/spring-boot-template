-- '%': allows user to connect from any host
-- or can be replaced by specific ip or hostname(localhost || 192.168.0.43)
create user 'spring_boot_template' @'%' identified by '1234';

-- grant all privileges on the database to the user
grant all privileges on spring_boot_template.* to 'spring_boot_template' @'%';

-- to ensure changes are applied immediately
flush privileges;
