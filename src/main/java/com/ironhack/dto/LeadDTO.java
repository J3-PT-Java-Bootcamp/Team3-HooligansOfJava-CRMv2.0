package com.ironhack.dto;

import com.ironhack.model.Lead;

public class LeadDTO {
    public static LeadDTO fromEntity(Lead lead) {
        var leadDTO = new LeadDTO();

        return leadDTO;
    }
}