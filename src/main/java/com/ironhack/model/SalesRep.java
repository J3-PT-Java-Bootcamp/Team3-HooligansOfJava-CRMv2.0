package com.ironhack.model;

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

    @OneToMany(mappedBy = "associatedSalesRep")
    private List<Lead> leads;

    @OneToMany(mappedBy = "associatedSalesRep")
    private List<Opportunity> opportunities;
}
