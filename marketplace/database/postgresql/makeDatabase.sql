drop database if exists marketplacedb;
drop user if exists marketplace;

create database marketplacedb;

create user marketplace;
alter user marketplace with password 'marketplace';
GRANT CONNECT ON DATABASE marketplacedb TO marketplace;
GRANT ALL PRIVILEGES ON DATABASE marketplacedb TO marketplace;

