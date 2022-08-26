package com.ironhack.service;

import com.ironhack.enums.TypeOfProduct;
import com.ironhack.model.Product;
import com.ironhack.reporting.tableWithLinesAndMaxWidth;
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





    @Override
    public void reportOpportunity() {
        var salesRepResponse = productRepository.groupOpportunityByName();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Product";
        data[0][1] = "Number ";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportClosedWon() {
        var salesRepResponse = productRepository.groupOpportunityByNameWon();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Product";
        data[0][1] = "Number of opportunities won";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);

    }

    @Override
    public void reportClosedLost() {
        var salesRepResponse = productRepository.groupOpportunityByNameLost();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Products";
        data[0][1] = "Number of opportunities lost";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);

    }

    @Override
    public void reportOpen() {
        var salesRepResponse = productRepository.groupOpportunityByNameOpen();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Products";
        data[0][1] = "Number of opportunities open";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }
}
