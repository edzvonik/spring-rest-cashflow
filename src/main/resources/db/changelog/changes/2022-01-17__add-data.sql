--liquibase formatted sql

--changeset edzvonik:3

-- users
insert into "user"(id, name, email, base_currency) values (2, 'Ivan', 'ivan@user.com', 'RUB');
insert into "user"(id, name, email, base_currency) values (3, 'Sergey', 'sergey@user.com', 'EUR');

select setval('seq_user', 3);

-- accounts
insert into account(id, title, currency, balance, user_id) values (1, 'Cash', 'RUB', '0.34', 1);
insert into account(id, title, currency, balance, user_id) values (2, 'Card1', 'USD', '1.50', 1);
insert into account(id, title, currency, balance, user_id) values (3, 'Card2', 'EUR', '6.21', 1);

insert into account(id, title, currency, balance, user_id) values (4, 'Cash', 'RUB', '0.49', 2);
insert into account(id, title, currency, balance, user_id) values (5, 'Card1', 'USD', '0.23', 2);
insert into account(id, title, currency, balance, user_id) values (6, 'Card2', 'EUR', '5.57', 2);

insert into account(id, title, currency, balance, user_id) values (7, 'Cash', 'USD', '1.13', 3);
insert into account(id, title, currency, balance, user_id) values (8, 'Cash', 'USD', '10.05', 3);
insert into account(id, title, currency, balance, user_id) values (9, 'Cash', 'USD', '123.01', 3);

select setval('seq_account', 9);

-- transactions
insert into transaction (id, amount, type, date, comment, account_id)
    values (1, '674.03', 'INCOME','2021-07-13', 'in leo maecenas pulvinar', 1);
insert into transaction (id, amount, type, date, comment, account_id)
    values (2, '216.81', 'EXPENSE','2021-03-09', 'curabitur convallis duis consequat dui', 1);
insert into transaction (id, amount, type, date, comment, account_id)
    values (3, '662.12', 'INCOME','2021-11-09', 'nascetur ridiculus', 1);

insert into transaction (id, amount, type, date, comment, account_id)
    values (4, '595.68', 'INCOME', '2021-02-19', 'lectus pellentesque eget nunc donec', 2);
insert into transaction (id, amount, type, date, comment, account_id)
    values (5, '95.96', 'INCOME','2021-07-02', 'sed ante', 2);
insert into transaction (id, amount, type, date, comment, account_id)
    values (6, '738.66', 'INCOME', '2021-04-14', 'convallis nulla neque libero convallis', 2);

insert into transaction (id, amount, type, date, comment, account_id)
    values (7, '655.1', 'EXPENSE', '2021-12-14', 'eleifend luctus', 3);
insert into transaction (id, amount, type, date, comment, account_id)
    values (8, '859.17', 'INCOME', '2021-11-07', 'at turpis donec posuere metus', 3);
insert into transaction (id, amount, type, date, comment, account_id)
    values (9, '60.47', 'INCOME', '2021-02-19', 'bibendum felis sed interdum venenatis', 3);

insert into transaction (id, amount, type, date, comment, account_id)
    values (10, '94.4', 'INCOME', '2021-10-21', 'ut massa quis augue luctus', 4);
insert into transaction (id, amount, type, date, comment, account_id)
    values (11, '333.44', 'EXPENSE', '2021-03-15', 'elementum in', 4);
insert into transaction (id, amount, type, date, comment, account_id)
    values (12, '45.89', 'EXPENSE', '2021-03-22', 'phasellus sit amet erat nulla', 4);

insert into transaction (id, amount, type, date, comment, account_id)
    values (13, '900.66', 'INCOME', '2021-10-17', 'ipsum praesent', 5);
insert into transaction (id, amount, type, date, comment, account_id)
    values (14, '66.75', 'INCOME', '2021-07-08', 'ornare imperdiet', 5);
insert into transaction (id, amount, type, date, comment, account_id)
    values (15, '378.62', 'EXPENSE', '2021-03-13', 'porta volutpat quam pede', 5);

insert into transaction (id, amount, type, date, comment, account_id)
    values (16, '58.71', 'INCOME', '2021-12-12', 'mattis egestas', 6);
insert into transaction (id, amount, type, date, comment, account_id)
    values (17, '795.76', 'EXPENSE', '2021-12-15', 'amet nunc viverra dapibus', 6);
insert into transaction (id, amount, type, date, comment, account_id)
    values (18, '553.25', 'EXPENSE', '2021-03-12', 'sapien varius ut blandit', 6);

insert into transaction (id, amount, type, date, comment, account_id)
    values (19, '396.56', 'EXPENSE', '2021-02-04', 'elit ac nulla sed', 7);
insert into transaction (id, amount, type, date, comment, account_id)
    values (20, '676.48', 'INCOME', '2021-08-06', 'dictumst aliquam augue quam sollicitudin', 7);
insert into transaction (id, amount, type, date, comment, account_id)
    values (21, '666.06', 'INCOME', '2021-04-23', 'nunc purus phasellus in', 7);

insert into transaction (id, amount, type, date, comment, account_id)
    values (22, '24.64', 'EXPENSE', '2021-12-05', 'nam dui', 8);
insert into transaction (id, amount, type, date, comment, account_id)
    values (23, '746.44', 'INCOME', '2021-05-30', 'molestie lorem', 8);
insert into transaction (id, amount, type, date, comment, account_id)
    values (24, '571.15', 'INCOME', '2021-08-22', 'id nisl', 8);

insert into transaction (id, amount, type, date, comment, account_id)
    values (25, '924.84', 'INCOME', '2021-04-17', 'curae duis faucibus', 9);
insert into transaction (id, amount, type, date, comment, account_id)
    values (26, '388.18', 'EXPENSE', '2021-11-15', 'sapien ut', 9);
insert into transaction (id, amount, type, date, comment, account_id)
    values (27, '86.65', 'INCOME', '2021-04-22', 'velit id pretium iaculis', 9);

select setval('seq_transaction', 27);

-- categories
insert into category (id, title) values (1, 'Food');
insert into category (id, title) values (2, 'Clothing');
insert into category (id, title) values (3, 'Electronics');
insert into category (id, title) values (4, 'Hobbies');
insert into category (id, title) values (5, 'Health');
insert into category (id, title) values (6, 'Kids');
insert into category (id, title) values (7, 'Transport');
insert into category (id, title) values (8, 'Salary');
insert into category (id, title) values (9, 'Side job');

select setval('seq_category', 9);

-- account-category
insert into account_category(account_id, category_id) values (1, 1);
insert into account_category(account_id, category_id) values (1, 2);
insert into account_category(account_id, category_id) values (1, 3);

insert into account_category(account_id, category_id) values (2, 2);
insert into account_category(account_id, category_id) values (2, 3);
insert into account_category(account_id, category_id) values (2, 4);

insert into account_category(account_id, category_id) values (3, 5);
insert into account_category(account_id, category_id) values (3, 6);
insert into account_category(account_id, category_id) values (3, 7);

-- category-transaction
-- income category: salary
insert into category_transaction(category_id, transaction_id) values (8, 1);
insert into category_transaction(category_id, transaction_id) values (8, 3);
insert into category_transaction(category_id, transaction_id) values (8, 4);
insert into category_transaction(category_id, transaction_id) values (8, 5);
insert into category_transaction(category_id, transaction_id) values (8, 6);
insert into category_transaction(category_id, transaction_id) values (8, 8);
insert into category_transaction(category_id, transaction_id) values (8, 9);
insert into category_transaction(category_id, transaction_id) values (8, 10);
insert into category_transaction(category_id, transaction_id) values (8, 25);

-- income category: side job
insert into category_transaction(category_id, transaction_id) values (9, 13);
insert into category_transaction(category_id, transaction_id) values (9, 14);
insert into category_transaction(category_id, transaction_id) values (9, 16);
insert into category_transaction(category_id, transaction_id) values (9, 20);
insert into category_transaction(category_id, transaction_id) values (9, 21);
insert into category_transaction(category_id, transaction_id) values (9, 23);
insert into category_transaction(category_id, transaction_id) values (9, 24);
insert into category_transaction(category_id, transaction_id) values (9, 26);

-- other
insert into category_transaction(category_id, transaction_id) values (1, 2);
insert into category_transaction(category_id, transaction_id) values (1, 19);
insert into category_transaction(category_id, transaction_id) values (2, 7);
insert into category_transaction(category_id, transaction_id) values (2, 20);
insert into category_transaction(category_id, transaction_id) values (3, 11);
insert into category_transaction(category_id, transaction_id) values (3, 22);
insert into category_transaction(category_id, transaction_id) values (4, 12);
insert into category_transaction(category_id, transaction_id) values (4, 25);
insert into category_transaction(category_id, transaction_id) values (5, 15);
insert into category_transaction(category_id, transaction_id) values (5, 27);
insert into category_transaction(category_id, transaction_id) values (6, 17);
insert into category_transaction(category_id, transaction_id) values (7, 18);


