package org.example.o14_spring_testing.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.o14_spring_testing.entity.Product;
import org.example.o14_spring_testing.repo.ProductRepository;
import org.example.o14_spring_testing.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException
                        ("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product excpProduct = getProductById(product.getId());
        excpProduct.setName(product.getName());
        excpProduct.setPrice(product.getPrice());
        excpProduct.setQuantity(product.getQuantity());
        return productRepository.save(excpProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product=getProductById(id);
        productRepository.delete(product);
    }
}
