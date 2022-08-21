package com.ironhack.dto;

import com.ironhack.model.Lead;
import com.ironhack.model.Opportunity;
import com.ironhack.model.SalesRep;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class SalesRepDTO {
    private Long id;
    private String name;
    private List<Lead> leads;
    private List<Opportunity> opportunities;

    public static SalesRepDTO fromEntity(SalesRep entity){
        var salesRepDTO = new SalesRepDTO();

        salesRepDTO.setId(entity.getId());
        salesRepDTO.setName(entity.getName());

        var leads =entity.getLeads();
        List<LeadDTO> leadsDTO = new ArrayList<>();
        for (Lead lead : leads) {
            leadsDTO.add(LeadDTO.fromEntity(lead));
        }

        var opportunities = entity.getOpportunities();
        List<OpportunityDTO> opportunitiesDTO = new ArrayList<>();
        for (Opportunity opportunity : opportunities){
            opportunitiesDTO.add(OpportunityDTO.fromEntity(opportunity));
        }

        return salesRepDTO;
    }
}