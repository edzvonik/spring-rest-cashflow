--liquibase formatted sql

--changeset edzvonik:1
create table account
(
    id bigint primary key not null,
    title text not null,
    currency text not null,
    balance  numeric(19, 2),
    constraint fk_user
        foreign key (user_id)
            references user(id)
            on delete cascade
);

create sequence seq_account;

create table account_category
(
    account_id bigint not null,
    category_id bigint not null,
    constraint fk_account
        foreign key (account_id)
            references account,
    constraint fk_category
        foreign key (category_id)
            references category
);

create table category
(
    id bigint primary key not null,
    title text,
);

create sequence seq_category;

create table category_transaction
(
    category_id bigint not null,
    transaction_id bigint not null,
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
    id bigint primary key not null,
    amount numeric(19, 2),
    category_id bigint,
    comment text,
    date date,
    type text,
    constraint fk_account
        foreign key (account_id)
            references account(id)
            on delete cascade
);

create sequence seq_transaciton;

create table "user"
(
    id bigint primary key not null,
    balance numeric(19, 2),
    base_currency text,
    email text,
    name text,
);

create sequence seq_user;
