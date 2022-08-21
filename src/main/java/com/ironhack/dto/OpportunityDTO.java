package com.ironhack.dto;

import com.ironhack.model.Opportunity;

public class OpportunityDTO {
    public static OpportunityDTO fromEntity(Opportunity opportunity) {
        var opportunityDTO = new OpportunityDTO();

        return opportunityDTO;
    }
}
