CREATE TABLE IF NOT EXISTS currencies
(
    id   INTEGER REFERENCES wallets (currency_id),
    name VARCHAR(50)
);