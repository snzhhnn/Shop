CREATE TABLE product (
      id UUID PRIMARY KEY NOT NULL,
      title VARCHAR(50) NOT NULL,
      color VARCHAR(50) NOT NULL,
      price NUMERIC(10, 2) NOT NULL,
      category VARCHAR(50) NOT NULL,
      parameter VARCHAR(50) NOT NULL,
      description VARCHAR(50) NOT NULL,
      url_image VARCHAR(50) NOT NULL
);