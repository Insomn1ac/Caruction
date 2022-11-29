ALTER TABLE categories
    DROP COLUMN id;

ALTER TABLE categories
    ADD column id SERIAL PRIMARY KEY;