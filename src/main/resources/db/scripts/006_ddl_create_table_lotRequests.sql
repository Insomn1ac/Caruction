CREATE TABLE IF NOT EXISTS lot_requests
(
    id      SERIAL PRIMARY KEY,
    lot_id  INTEGER REFERENCES lots (id),
    user_id INTEGER REFERENCES users (id),
    status  VARCHAR(50)
);