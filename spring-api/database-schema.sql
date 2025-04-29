-- Users table (just for you and your readers/commenters)
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       display_name VARCHAR(100),
                       bio TEXT,
                       profile_image_url VARCHAR(255),
                       is_admin BOOLEAN DEFAULT FALSE, -- TRUE only for you
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Categories for organizing your content
CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(50) NOT NULL,
                            slug VARCHAR(50) UNIQUE NOT NULL,
                            description TEXT
);

-- Articles/Posts
CREATE TABLE articles (
                          id SERIAL PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          slug VARCHAR(255) UNIQUE NOT NULL,
                          content TEXT NOT NULL,
                          excerpt TEXT,
                          featured_image_url VARCHAR(255),
                          status VARCHAR(20) DEFAULT 'draft', -- 'draft', 'published'
                          category_id INTEGER REFERENCES categories(id) ON DELETE SET NULL,
                          published_at TIMESTAMP,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tags for articles
CREATE TABLE tags (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      slug VARCHAR(50) UNIQUE NOT NULL
);

-- Connection between articles and tags
CREATE TABLE article_tags (
                              article_id INTEGER REFERENCES articles(id) ON DELETE CASCADE,
                              tag_id INTEGER REFERENCES tags(id) ON DELETE CASCADE,
                              PRIMARY KEY (article_id, tag_id)
);

-- Comments on articles
CREATE TABLE comments (
                          id SERIAL PRIMARY KEY,
                          article_id INTEGER REFERENCES articles(id) ON DELETE CASCADE,
                          user_id INTEGER REFERENCES users(id) ON DELETE SET NULL,
                          parent_comment_id INTEGER REFERENCES comments(id) ON DELETE CASCADE,
                          content TEXT NOT NULL,
                          is_approved BOOLEAN DEFAULT FALSE, -- You can moderate comments
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Simple statistics tracking
CREATE TABLE article_stats (
                               article_id INTEGER REFERENCES articles(id) ON DELETE CASCADE,
                               views INTEGER DEFAULT 0,
                               date DATE NOT NULL,
                               PRIMARY KEY (article_id, date)
);

-- Email subscribers
CREATE TABLE subscribers (
                             id SERIAL PRIMARY KEY,
                             email VARCHAR(100) UNIQUE NOT NULL,
                             name VARCHAR(100),
                             is_confirmed BOOLEAN DEFAULT FALSE,
                             subscribed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);