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
    (1, 1), (1, 9), (1, 14),
    (2, 6), (2, 21), (2, 26), (2, 31), (2, 35),
    (3, 3), (3, 4), (3, 3), (3, 7), (3, 8), (3, 10), (3, 11), (3, 17), (3, 24), (3, 25), (3, 27), (3, 28), (3, 33),
    (4, 5), (4, 18), (4, 19), (4, 20), (4, 22), (4, 34),
    (5, 2), (5, 13), (5, 15), (5, 23), (5, 32), (5, 36), (5, 37),
    (6, 12), (6, 16), (6, 29), (6, 30), (6, 38)
) as values_table(category_id, transaction_id)
where values_table.transaction_id = t.id;
