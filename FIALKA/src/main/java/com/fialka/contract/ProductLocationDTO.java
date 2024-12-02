package com.fialka.contract;

import lombok.Builder;
import lombok.Data;
import com.fialka.model.Product;
import com.fialka.model.Warehouse;

import java.util.UUID;

@Data
@Builder
public class ProductLocationDTO {
    private UUID id;
    private Product productID;
    private Warehouse warehouseID;
}