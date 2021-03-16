package MicroEShop.MProduit.repository;

import MicroEShop.MProduit.dto.ProductDTO;
import MicroEShop.MProduit.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
