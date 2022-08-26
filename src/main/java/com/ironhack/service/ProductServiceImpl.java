package com.ironhack.service;

import com.ironhack.enums.TypeOfProduct;
import com.ironhack.model.Product;
import com.ironhack.reporting.tableWithLinesAndMaxWidth;
import com.ironhack.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Override
    public void meanProductQuantity() {
        var response = productRepository.findMeanProductQuantity();
        String[][] data = new String[response.size()+1][2];
        data[0][0] = "Products";
        data[0][1] = "Mean quantity";
        for (int i = 0; i < response.size(); i++) {
            data[i+1][0] =response.get(i)[0].toString();
            data[i+1][1] =response.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void medianProductQuantity() {
//        var allProducts = productRepository.findMedianProductQuantity();
//        var allQuantities = allProducts.get(1);
//        ArrayList<Object[]> response = new ArrayList<>();
//        int median;
//
//        String productType = "";
//        int count = 0;
//        ArrayList<Integer> quantity = new ArrayList<>();
//        for (int i = 0; i < allProducts.size(); i++) {
//            var product = allProducts.get(i);
//
//            if(productType.equals(product[0])){
//                count++;
//                quantity.add((Integer) product[1]);
//            } else {
//                System.out.println(i);
//                if(i>1) {
//                    int mitad = count / 2;
//                    if (quantity.size() % 2 == 0) {
//                        median = (quantity.get(mitad - 1) + quantity.get(mitad) / 2);
//                    } else {
//                        median = quantity.get(mitad);
//                    }
//
//                    response.add(new Object[]{productType, median});
//                }
//                count = 1;
//                productType =(String) product[0];
//                quantity.clear();
//                quantity.add((Integer) product[1]);
//            }
//            int mitad = count / 2;
//            if (quantity.size() % 2 == 0) {
//                median = (quantity.get(mitad - 1) + quantity.get(mitad) / 2);
//            } else {
//                median = quantity.get(mitad);
//            }
//            response.add(new Object[]{productType,median});
//        }
//        int mitad = count / 2;
//        if (quantity.size() % 2 == 0) {
//            median = (quantity.get(mitad - 1) + quantity.get(mitad) / 2);
//        } else {
//            median = quantity.get(mitad);
//        }
//        response.add(new Object[]{productType,median});
//        String[][] array = new String[response.size()][2];
//        for (int i = 0; i < response.size(); i++){
//            array[i][0] = (String) response.get(i)[0];
//            array[i][1] = (String) response.get(i)[1];
//        }
//        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(array);
    }

    @Override
    public void maxProductQuantity() {
        var response = productRepository.findMaxProductQuantity();
        String[][] data = new String[response.size()+1][2];
        data[0][0] = "Products";
        data[0][1] = "Max quantity";
        for (int i = 0; i < response.size(); i++) {
            data[i+1][0] =response.get(i)[0].toString();
            data[i+1][1] =response.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void minProductQuantity() {
        var response = productRepository.findMinProductQuantity();
        String[][] data = new String[response.size()+1][2];
        data[0][0] = "Products";
        data[0][1] = "Max quantity";
        for (int i = 0; i < response.size(); i++) {
            data[i+1][0] =response.get(i)[0].toString();
            data[i+1][1] =response.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }
}