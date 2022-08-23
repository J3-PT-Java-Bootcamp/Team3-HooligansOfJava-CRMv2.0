package com.ironhack.model;

import com.ironhack.dto.OpportunityDTO;
import com.ironhack.enums.OpportunityStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Contact decisionMaker;

    @Enumerated(EnumType.STRING)
    private OpportunityStatus status;

    @OneToMany(mappedBy = "opportunity")
    private List<Product> products; // product & quantity

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    private SalesRep salesRep;

    public static Opportunity fromDTO(OpportunityDTO dto){
        var entity = new Opportunity();
        entity.setId(dto.getId());
        entity.setDecisionMaker(dto.getDecisionMaker());
        entity.setStatus(dto.getStatus());

        return entity;
    }
}