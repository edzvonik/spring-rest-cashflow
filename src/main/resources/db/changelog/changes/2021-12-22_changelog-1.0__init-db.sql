--liquibase formatted sql

--changeset edzvonik:id1
create sequence seq_account start 1 increment 100;

create sequence seq_category start 1 increment 1000;

create sequence seq_transaciton start 1 increment 1000;

create sequence seq_user start 1 increment 50;

create table account
(
    id       int4         not null,
    balance  numeric(19, 2),
    currency varchar(255),
    title    varchar(255) not null,
    primary key (id)
);

create table account_categories
(
    account_id    int4 not null,
    categories_id int4 not null
);

create table account_transactions
(
    account_id      int4 not null,
    transactions_id int4 not null
);

create table category
(
    id    int4 not null,
    title varchar(255),
    primary key (id)
);

create table category_transactions
(
    category_id     int4 not null,
    transactions_id int4 not null
);

create table transaction
(
    id          int4 not null,
    amount      numeric(19, 2),
    category_id int4,
    comment     varchar(255),
    date        date,
    type        varchar(255),
    primary key (id)
);

create table "user"
(
    id            varchar(255) not null,
    balance       numeric(19, 2),
    base_currency varchar(255),
    email         varchar(255),
    name          varchar(255),
    primary key (id)
);

create table user_accounts
(
    user_id     varchar(255) not null,
    accounts_id int4         not null
);

alter table if exists account_transactions
    add constraint uc_account_transactions unique (transactions_id);

alter table if exists category_transactions
    add constraint uc_category_transactions unique (transactions_id);

alter table if exists user_accounts
    add constraint uc_user_accounts unique (accounts_id);

alter table if exists account_categories
    add constraint fk_account_categories_category
    foreign key (categories_id) references category;

alter table if exists account_categories
    add constraint fk_account_categories_account
    foreign key (account_id) references account;

alter table if exists account_transactions
    add constraint fk_account_transactions_transaction
    foreign key (transactions_id) references transaction;

alter table if exists account_transactions
    add constraint fk_account_transactions_account
    foreign key (account_id) references account;

alter table if exists category_transactions
    add constraint fk_category_transactions_transaction
    foreign key (transactions_id) references transaction;

alter table if exists category_transactions
    add constraint fk_category_transactions_category
    foreign key (category_id) references category;

alter table if exists user_accounts
    add constraint fk_user_accounts_account
    foreign key (accounts_id) references account;

alter table if exists user_accounts
    add constraint fk_user_accounts_user
    foreign key (user_id) references "user";
