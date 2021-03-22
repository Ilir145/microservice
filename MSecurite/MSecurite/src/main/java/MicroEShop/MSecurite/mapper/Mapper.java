package MicroEShop.MSecurite.mapper;


import MicroEShop.MSecurite.dto.ProductDTO;
import MicroEShop.MSecurite.dto.UserDto;
import MicroEShop.MSecurite.entities.Product;
import MicroEShop.MSecurite.entities.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public ProductDTO toProductDto(Product entity){
        return  entity != null ? ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .stockQuantity(entity.getStockQuantity())
                .price(entity.getPrice())
                .build() : null;
    }

    public Product toProduductEntity(ProductDTO dto){
        return  dto != null ? Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .stockQuantity(dto.getStockQuantity())
                .price(dto.getPrice())
                .build() : null;
    }

    @PreAuthorize("hashRole = 'USER' or hashRole = 'ADMIN'")
    public UserDto toUserDto(User user){
        return user != null ? UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles())
                .creationDate(user.getCreationDate())
                .build() : null;
    }

    public User toUserEntity(UserDto dto){
        return dto != null ? User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .roles(dto.getRoles())
                .build() : null;
    }
}
