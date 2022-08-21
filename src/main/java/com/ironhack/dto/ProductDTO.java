package com.ironhack.dto;

import com.ironhack.enums.TypeOfProduct;
import com.ironhack.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private Long id;
    private TypeOfProduct product;
    private int quantity;
    public static ProductDTO fromEntity(Product entity) {
        var dto = new ProductDTO();

        dto.setId(entity.getId());
        dto.setProduct(entity.getProduct());
        dto.setQuantity(entity.getQuantity());

        return dto;
    }
}
