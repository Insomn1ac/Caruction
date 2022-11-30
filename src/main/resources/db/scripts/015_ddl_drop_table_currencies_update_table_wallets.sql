DROP TABLE IF EXISTS currencies;

DROP TABLE IF EXISTS wallets;

CREATE TABLE IF NOT EXISTS wallets
(
    id          SERIAL PRIMARY KEY,
    balance     DECIMAL(20, 2)
);
