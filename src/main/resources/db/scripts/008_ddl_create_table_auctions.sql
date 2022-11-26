CREATE TABLE IF NOT EXISTS auctions
(
    id         SERIAL PRIMARY KEY,
    start_date TIMESTAMP DEFAULT now() NOT NULL,
    end_date   TIMESTAMP               NOT NULL,
    lot_id     INTEGER REFERENCES lots (id),
    status     VARCHAR(50)
);