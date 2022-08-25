package com.ironhack.dto;

import com.ironhack.enums.OpportunityStatus;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.model.Opportunity;
import com.ironhack.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class OpportunityDTO {
    private Long id;
    private Contact decisionMaker;
    private OpportunityStatus status;
    private List<ProductDTO> products;
    private Account account;

    public static OpportunityDTO fromEntity(Opportunity entity) {
        var dto = new OpportunityDTO();
        dto.setId(entity.getId());
        dto.setDecisionMaker(entity.getDecisionMaker());
        dto.setStatus(entity.getStatus());

        var products = entity.getProducts();
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (Product product : products) {
            productsDTO.add(ProductDTO.fromEntity(product));

        }

        dto.setProducts(productsDTO);

        return dto;
    }

}
