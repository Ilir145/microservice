package MicroEShop.MProduit.util;

import MicroEShop.MProduit.entities.Product;
import MicroEShop.MProduit.services.ProductService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class ProductInit implements InitializingBean {

    private final ProductService service;

    private List<Product> init = Arrays.asList(
            Product.builder()
                    .name("FFP2")
                    .price(5.99)
                    .stockQuantity(1000)
                    .build(),
            Product.builder()
                    .name("Gel")
                    .price(4.99)
                    .stockQuantity(500)
                    .build(),
            Product.builder()
                    .name("Gants")
                    .price(2.99)
                    .stockQuantity(2000)
                    .build(),
            Product.builder()
                    .name("Dettol")
                    .price(7.99)
                    .stockQuantity(200)
                    .build(),
            Product.builder()
                    .name("Lubrifiant")
                    .price(1.99)
                    .stockQuantity(300)
                    .build()
    );

    public ProductInit(ProductService service) {
        this.service = service;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.init.forEach(service::insert);
    }
}
