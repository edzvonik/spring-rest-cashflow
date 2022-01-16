--liquibase formatted sql

--changeset edzvonik:2
insert into "user"(name, email, base_currency) values ('Petr', 'user@user.com', 'USD');
