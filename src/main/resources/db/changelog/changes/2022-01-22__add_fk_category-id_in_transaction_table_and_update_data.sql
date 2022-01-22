--liquibase formatted sql

--changeset edzvonik:4

alter table transaction
    add column category_id bigint,
    add constraint fk_category
        foreign key (category_id)
            references category(id);

-- update data with fk_category
update transaction as t set
    category_id = values_table.category_id
from (values
    -- income category: salary
    (8, 1),
    (8, 3),
    (8, 4),
    (8, 5),
    (8, 6),
    (8, 8),
    (8, 9),
    (8, 10),
    (8, 25),
    -- income category: side job
    (9, 13),
    (9, 14),
    (9, 16),
    (9, 20),
    (9, 21),
    (9, 23),
    (9, 24),
    (9, 26),
    -- other
    (1, 2),
    (1, 19),
    (2, 7),
    (2, 20),
    (3, 11),
    (3, 22),
    (4, 12),
    (4, 25),
    (5, 15),
    (5, 27),
    (6, 17),
    (7, 18)
) as values_table(category_id, transaction_id)
where values_table.transaction_id = t.id;