package contract;

import lombok.Builder;
import lombok.Data;
import model.Product;
import model.Warehouse;

import java.util.UUID;

@Data
@Builder
public class ProductLocationDTO {
    private UUID id;
    private Product productID;
    private Warehouse warehouseID;
}