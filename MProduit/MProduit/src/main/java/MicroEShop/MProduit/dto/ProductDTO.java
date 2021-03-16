package MicroEShop.MProduit.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class ProductDTO {

    Integer id;

    String name;

    Double price;

    Integer stockQuantity;
}
