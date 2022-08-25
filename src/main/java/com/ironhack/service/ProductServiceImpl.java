package com.ironhack.service;

import com.ironhack.enums.TypeOfProduct;
import com.ironhack.model.Product;
import com.ironhack.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product newProduct(TypeOfProduct type, int quantity) {
        Product product = new Product();
        product.setQuantity(quantity);
        product.setProduct(type);

        return productRepository.save(product);
    }
}
