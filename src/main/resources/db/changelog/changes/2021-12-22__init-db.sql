--liquibase formatted sql

--changeset edzvonik:1

-- users
create sequence seq_user;

create table "user"
(
    id bigint primary key not null,
    name text not null,
    email text not null,
    base_currency text not null
);

-- accounts
create sequence seq_account;

create table account
(
    id bigint primary key not null,
    title text not null,
    currency text not null,
    balance  numeric not null,
	user_id bigint not null,
    constraint fk_user
        foreign key (user_id)
            references "user"(id)
            on delete cascade
);

-- categories
create sequence seq_category;

create table category
(
    id bigint primary key not null,
    title text not null
);

-- account_category
create table account_category
(
    account_id bigint not null,
    category_id bigint not null,
    constraint fk_account
        foreign key (account_id)
            references account(id),
    constraint fk_category
        foreign key (category_id)
            references category(id)
);

-- transactions
create sequence seq_transaciton;

create table transaction
(
    id bigint primary key not null,
    amount numeric not null,
    type text not null,
    date date not null,
    comment text,
	account_id bigint not null,
    constraint fk_account
        foreign key (account_id)
            references account(id)
            on delete cascade
);

-- category_transaction
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

