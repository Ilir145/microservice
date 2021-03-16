package MicroEShop.MProduit.services;

import MicroEShop.MProduit.dto.ProductDTO;
import MicroEShop.MProduit.entities.Product;
import MicroEShop.MProduit.mapper.Mapper;
import MicroEShop.MProduit.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    private final Mapper mapper;

    public ProductService(ProductRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Set<ProductDTO> getAllProducts(){
        return this.repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    public ProductDTO getProductById(Integer id){
        Optional<Product> product =this.repository.findById(id);

        return product.map(mapper::toDto).orElse(null);
    }

    public void insert(Product product){
        if(product != null){
            this.repository.save(product);
        }
    }

    public void update(Product product){
        if(product != null){
            Optional<Product> productToUpadte= this.repository.findById(product.getId());
            if(productToUpadte.isPresent()){
                this.repository.save(product);
            }
        }
    }



}
