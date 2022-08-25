package com.ironhack.service;

import com.ironhack.enums.TypeOfProduct;
import com.ironhack.model.Product;

public interface ProductService {
    Product newProduct(TypeOfProduct type, int quantity);
}
