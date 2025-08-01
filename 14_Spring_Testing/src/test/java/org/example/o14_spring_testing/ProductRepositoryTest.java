package org.example.o14_spring_testing;

import org.example.o14_spring_testing.entity.Product;
import org.example.o14_spring_testing.repo.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Test
    void shouldSaveProduct() {
        Product product = Product.builder()
                .name("Test Product")
                .price(11.11)
                .quantity(1)
                .build();
        Product saveProduct=productRepository.save(product);
        Assertions.assertNotNull(saveProduct.getId());
        Assertions.assertEquals("Test Product"
                ,saveProduct.getName());
        Assertions.assertEquals(11.11
                , saveProduct.getPrice());
        Assertions.assertEquals(1,
                saveProduct.getQuantity());
    }
    @Test
    void shouldFindAllProducts() {
        Product product1=
                Product.builder()
                        .name("P1")
                        .price(11.11)
                        .quantity(2)
                        .build();
        Product product2=
                Product.builder()
                    .name("P2")
                    .price(22.22)
                    .quantity(2)
                    .build();
        productRepository.save(product1);
        productRepository.save(product2);
        List<Product> products=productRepository.findAll();
        Assertions.assertEquals(2,products.size());
    }
}
