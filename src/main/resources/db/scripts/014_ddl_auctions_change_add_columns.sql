ALTER TABLE auctions
    ALTER COLUMN start_date DROP DEFAULT,
    ALTER COLUMN end_date DROP NOT NULL,
    ADD COLUMN IF NOT EXISTS category_id INTEGER references categories (id);