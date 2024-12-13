CREATE TABLE product_in_order (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_id UUID NOT NULL,
    product_id UUID NOT NULL,
    quantity INT NOT NULL,
    totalCost NUMERIC(10, 2) NOT NULL,
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES ordering (id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product (id)
);
