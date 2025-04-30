-- SQL script for materialized views

CREATE MATERIALIZED VIEW article_view AS
SELECT
    id,
    title,
    slug,
    excerpt,
    featured_image_url,
    published_at
FROM
    articles
WHERE
    status = 'PUBLISHED';

CREATE MATERIALIZED VIEW category_view AS
SELECT
    id,
    name,
    slug,
    description
FROM
    categories;
