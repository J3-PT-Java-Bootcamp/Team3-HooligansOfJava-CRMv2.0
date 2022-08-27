package com.ironhack.service;

import com.ironhack.enums.TypeOfProduct;
import com.ironhack.model.Product;

import java.util.List;

public interface ProductService {
    Product newProduct(TypeOfProduct type, int quantity);

    void reportOpportunity();

    void reportClosedWon();

    void reportClosedLost();

    void reportOpen();

    void meanProductQuantity();
    void medianProductQuantity();
    void maxProductQuantity();
    void minProductQuantity();
}
