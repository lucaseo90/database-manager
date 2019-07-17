login error: Unable to load authentication plugin 'caching_sha2_password'

ALTER USER root@'%' IDENTIFIED WITH mysql_native_password BY 'pwd';

CREATE DATABASE test;

CREATE USER 'test'@'%' IDENTIFIED BY 'pwd';

GRANT ALL PRIVILEGES ON test.* TO 'test'@'%';

FLUSH PRIVILEGES;