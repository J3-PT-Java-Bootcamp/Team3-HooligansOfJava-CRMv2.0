package com.ironhack.dto;

import com.ironhack.model.Lead;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LeadDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    public static LeadDTO fromEntity(Lead entity){
        var dto = new LeadDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        dto.setCompanyName(entity.getCompanyName());

        return dto;

    }
}