CREATE TABLE IF NOT EXISTS products (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  price NUMERIC(10,2),
  stock INTEGER,
  category VARCHAR(100),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);