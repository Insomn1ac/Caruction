CREATE TABLE IF NOT EXISTS lots
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    category_id   INTEGER NOT NULL UNIQUE,
    status        VARCHAR(50),
    start_price   INTEGER,
    finish_price  INTEGER,
    subscriber_id INTEGER,
    winner_id     INTEGER references users (id)
);