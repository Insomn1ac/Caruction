CREATE TABLE IF NOT EXISTS categories
(
    id   INTEGER REFERENCES lots (category_id),
    name VARCHAR(100) NOT NULL
);