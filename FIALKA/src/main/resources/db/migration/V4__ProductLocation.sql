CREATE TABLE product_location (
    id UUID PRIMARY KEY NOT NULL,
    quantity INT NOT NULL,
    product_id UUID NOT NULL,
    warehouse_id UUID NOT NULL,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product (id),
    CONSTRAINT fk_warehouse FOREIGN KEY (warehouse_id) REFERENCES warehouse (id)
);
