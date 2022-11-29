ALTER TABLE lots
    DROP COLUMN IF EXISTS category_id cascade,
    DROP COLUMN IF EXISTS subscriber_id,
    DROP COLUMN IF EXISTS winner_id;