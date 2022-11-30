ALTER TABLE categories
    DROP COLUMN id CASCADE;

ALTER TABLE categories
    ADD column id SERIAL PRIMARY KEY;