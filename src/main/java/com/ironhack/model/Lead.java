package com.ironhack.model;

import com.ironhack.dto.LeadDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    private SalesRep salesRep;

    public static Lead fromDTO(LeadDTO dto){
        var entity = new Lead();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setCompanyName(dto.getCompanyName());
        entity.setSalesRep(dto.getSalesRep());

        return entity;
    }
}