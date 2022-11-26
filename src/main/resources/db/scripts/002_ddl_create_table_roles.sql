CREATE TABLE IF NOT EXISTS roles
(
    user_id INTEGER REFERENCES users (id) ON DELETE CASCADE,
    role    VARCHAR NOT NULL,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role)
);