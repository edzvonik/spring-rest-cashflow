--liquibase formatted sql

create table user (
    id varchar(255) not null,
    balance numeric(19, 2),
    base_currency varchar(255),
    email varchar(255) not null,
    name varchar(255) not null,
    primary key (id)
);

create table user_accounts (
    user_id varchar(255) not null,
    accounts_id int4 not null
);

create table user_categories (
    user_id varchar(255) not null,
    categories_id int4 not null
);

create table account (
    id int4 not null,
    balance numeric(19, 2),
    currency varchar(255),
    title varchar(255),
    primary key (id)
);

create table account_categories (
    account_id int4 not null,
    categories_id int4 not null
);

create table account_transactions (
    account_id int4 not null,
    transactions_id int4 not null
);

create table transaction (
    id int4 not null,
    amount numeric(19, 2),
    category_id int4,
    comment varchar(255),
    date date,
    type varchar(255),
    primary key (id)
);

create table category (
    id int4 not null,
    title varchar(255),
    type varchar(255),
    primary key (id)
);

create table category_transactions (
    category_id int4 not null,
    transactions_id int4 not null
);
