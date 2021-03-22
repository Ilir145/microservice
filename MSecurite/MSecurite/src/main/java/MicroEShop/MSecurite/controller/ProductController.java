package MicroEShop.MSecurite.controller;


import MicroEShop.MSecurite.dto.ProductDTO;
import MicroEShop.MSecurite.entities.Product;
import MicroEShop.MSecurite.services.ProductService;
import MicroEShop.MSecurite.util.ProductNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Set<ProductDTO> getAllProducts() throws ProductNotFoundException {
        Set<ProductDTO> products = service.getAllProducts();
        if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit dispo");
        return products;
    }

    @GetMapping(path = "/{id}")
    public ProductDTO getProductById(@PathVariable Integer id) throws ProductNotFoundException {
        ProductDTO product = service.getProductById(id);
        if(product == null) throw new ProductNotFoundException("Le produit " + id + " n est pas present");
        return product;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void insert(@RequestBody Product product){
        this.service.insert(product);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void update( @RequestBody Product product){
        this.service.update(product);
    }

}
