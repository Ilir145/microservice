package MicroEShop.MSecurite.services;


import MicroEShop.MSecurite.dto.ProductDTO;
import MicroEShop.MSecurite.entities.Product;
import MicroEShop.MSecurite.mapper.Mapper;
import MicroEShop.MSecurite.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
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
                .map(mapper::toProductDto)
                .collect(Collectors.toSet());
    }

    public ProductDTO getProductById(Integer id){
        Optional<Product> product =this.repository.findById(id);

        return product.map(mapper::toProductDto).orElse(null);
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
