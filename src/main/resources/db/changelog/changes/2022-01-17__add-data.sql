--liquibase formatted sql

--changeset edzvonik:3

-- accounts
insert into account(id, title, currency, balance, user_id) values (1, 'Cash', 'RUB', '0.34', 1);
insert into account(id, title, currency, balance, user_id) values (2, 'Card', 'USD', '1.50', 1);

select setval('seq_account', 2);

-- transactions
INSERT INTO transaction (id, amount, type, date, comment, account_id) VALUES
(1, '3523.20', 'INCOME', '2022-01-01', 'Salary', 1),
(2, '501.93', 'EXPENSE', '2022-01-01', 'New headphones', 1),
(3, '34.21', 'EXPENSE',	'2022-01-01', 'In quis justo', 1),
(4, '124.1', 'EXPENSE', '2022-01-03', 'Maecenas rhoncus', 1),
(5, '4.50', 'EXPENSE', '2022-01-03', 'Suspendisse', 1),
(6, '650.0', 'INCOME', '2022-01-12', 'Side job', 1),
(7, '3.20', 'EXPENSE', '2022-01-15', 'In quis justo', 1),
(8, '15.90', 'EXPENSE', '2022-01-15', 'Maecenas rhoncus', 1),
(9, '3530.12', 'INCOME', '2022-02-01', 'Salary', 1),
(10, '5.24', 'EXPENSE', '2022-02-05', 'Maecenas rhoncus', 1),
(11, '9.99', 'EXPENSE', '2022-02-07', 'Suspendisse', 1),
(12, '17.12', 'EXPENSE', '2022-02-10', 'In quis justo', 1),
(13, '90.70', 'EXPENSE', '2022-02-16', 'Maecenas rhoncus', 1),
(14, '4900.62', 'INCOME', '2022-03-01', 'Salary', 1),
(15, '150.80', 'EXPENSE', '2022-03-02', 'Maecenas rhoncus', 1),
(16, '70.1', 'EXPENSE', '2022-03-07', 'Suspendisse', 1),
(17, '36.87', 'EXPENSE', '2022-03-20', 'In quis justo', 1),
(18, '4.10', 'EXPENSE', '2022-03-22', 'Maecenas rhoncus', 1),
(19, '150.80', 'EXPENSE', '2022-03-02', 'Suspendisse', 1),
(20, '70.1', 'EXPENSE', '2022-03-07', 'In quis justo', 1);

insert into transaction (id, amount, type, date, comment, account_id) values
(21, '540.2', 'INCOME', '2022-01-02', 'Side job', 2),
(22, '359.12', 'EXPENSE', '2022-01-05', 'In quis justo', 2),
(23, '43.16', 'EXPENSE', '2022-01-05', 'Maecenas rhoncus', 2),
(24, '3.99', 'EXPENSE', '2022-01-16', 'Suspendisse', 2),
(25, '5.01', 'EXPENSE', '2022-01-20', 'In tempor', 2),
(26, '670.21', 'INCOME', '2022-01-02', 'Side job', 2),
(27, '5.24', 'EXPENSE', '2022-02-08', 'Nulla ac enim', 2),
(28, '9.99', 'EXPENSE', '2022-02-10', 'Risus semper', 2),
(29, '17.12', 'EXPENSE', '2022-02-10', 'Pellentesque', 2),
(30, '90.70', 'EXPENSE', '2022-02-15', 'Vestibulum rutrum', 2),
(31, '550.32', 'INCOME', '2022-02-16', 'Side job', 2),
(32, '1.50', 'EXPENSE', '2022-02-20', 'Pellentesque', 2),
(33, '50.52', 'EXPENSE', '2022-03-05', 'risus semper', 2),
(34, '120.10', 'EXPENSE', '2022-03-06', 'Pellentesque', 2),
(35, '590.31', 'INCOME', '2022-03-10', 'Side job', 2),
(36, '6.03', 'EXPENSE', '2022-03-11', 'risus semper', 2),
(37, '29.99', 'EXPENSE', '2022-05-12', 'Pellentesque', 2),
(38, '142.21', 'EXPENSE', '2022-05-13', 'risus semper', 2);

select setval('seq_transaction', 38);

-- categories
insert into category (id, title) values
(1, 'Salary'),
(2, 'Side job'),
(3, 'Food'),
(4, 'Home'),
(5, 'Hobbies'),
(6, 'Pets');

select setval('seq_category', 6);

-- account-category
insert into account_category(account_id, category_id) values
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6);


