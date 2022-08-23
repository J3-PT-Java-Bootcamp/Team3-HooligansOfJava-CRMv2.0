package com.ironhack.model;

import com.ironhack.dto.SalesRepDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class SalesRep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "salesRep")
    private List<Lead> leads;

    @OneToMany(mappedBy = "salesRep")
    private List<Opportunity> opportunities;

    public static SalesRep fromDTO(SalesRepDTO dto){
        var salesRep = new SalesRep();
        salesRep.setId(dto.getId());
        salesRep.setName(dto.getName());

        return salesRep;
    }
}
