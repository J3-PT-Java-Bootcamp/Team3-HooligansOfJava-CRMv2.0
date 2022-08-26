package com.ironhack.model;

import com.ironhack.dto.ProductDTO;
import com.ironhack.enums.TypeOfProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeOfProduct product;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "opportunity_id")
    private Opportunity opportunity;

    public Product fromDTO(ProductDTO dto){
        var entity = new Product();
        entity.setId(dto.getId());
        entity.setProduct(dto.getProduct());
        entity.setQuantity(dto.getQuantity());

        return entity;
    }
}