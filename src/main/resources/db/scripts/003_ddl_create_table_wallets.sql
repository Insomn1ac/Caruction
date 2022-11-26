CREATE TABLE IF NOT EXISTS wallets
(
    id          INTEGER REFERENCES users (wallet_id),
    balance     INTEGER,
    currency_id INTEGER NOT NULL UNIQUE
);