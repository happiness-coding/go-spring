CREATE TABLE article_view (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL,
    excerpt TEXT,
    featured_image_url VARCHAR(255),
    published_at TIMESTAMP
);

CREATE TABLE category_view (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL,
    description TEXT
);
