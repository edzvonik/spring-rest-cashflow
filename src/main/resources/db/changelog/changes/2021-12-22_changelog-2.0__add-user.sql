--liquibase formatted sql

--changeset edzvonik:id2
insert into "user" (id, balance, base_currency, email, name) values (1, 0.00, 'USD', 'user@user.com', 'User');
