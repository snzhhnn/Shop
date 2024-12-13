CREATE TABLE ordering (
    id UUID PRIMARY KEY NOT NULL,
    order_date DATE NOT NULL,
    status VARCHAR(25) NOT NULL,
    user_id UUID NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES "user" (id)
);