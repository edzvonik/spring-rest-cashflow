--liquibase formatted sql

--changeset edzvonik:1
create table account
(
    id       int4         not null,
    title    varchar(255) not null,
    currency varchar(255) not null,
    balance  numeric(19, 2),
    primary key (id)
);

create sequence seq_account;

create table account_category
(
    account_id    int4 not null,
    category_id int4 not null,
    constraint fk_account
        foreign key (account_id)
            references account,
    constraint fk_category
        foreign key (category_id)
            references category
);

create table category
(
    id    int4 not null,
    title varchar(255),
    primary key (id)
);

create sequence seq_category;

create table category_transaction
(
    category_id     int4 not null,
    transaction_id int4 not null,
    constraint uc_transactions
        unique (transaction_id),
    constraint uc_category
        unique (category_id),
    constraint fk_transaction
        foreign key (transaction_id)
            references transaction(id),
    constraint fk_category
        foreign key (category_id)
            references category(id)
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

create sequence seq_transaciton;

create table "user"
(
    id            int4 not null,
    balance       numeric(19, 2),
    base_currency varchar(255),
    email         varchar(255),
    name          varchar(255),
    primary key (id)
);

create sequence seq_user;
