--liquibase formatted sql

--changeset edzvonik:2

insert into "user"(id, name, email, base_currency) values (1, 'Petr', 'petr@user.com', 'USD');
select setval('seq_user', 1);
