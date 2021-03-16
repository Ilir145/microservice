package MicroEShop.MProduit.mapper;

import MicroEShop.MProduit.dto.ProductDTO;
import MicroEShop.MProduit.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public ProductDTO toDto(Product entity){
        return  entity != null ? ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .stockQuantity(entity.getStockQuantity())
                .price(entity.getPrice())
                .build() : null;
    }

    public Product toEntity(ProductDTO dto){
        return  dto != null ? Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .stockQuantity(dto.getStockQuantity())
                .price(dto.getPrice())
                .build() : null;
    }
}
