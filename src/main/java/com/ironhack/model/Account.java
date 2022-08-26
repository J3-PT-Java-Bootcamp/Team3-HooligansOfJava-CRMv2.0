package com.ironhack.model;

import com.ironhack.dto.AccountDTO;
import com.ironhack.enums.Industry;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    @Enumerated(EnumType.STRING)
    private Industry industry;

    private int employeeCount;

    private String city;

    private String country;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<Contact> contacts;

    public static Account fromDTO(AccountDTO dto){
        var entity = new Account();

        entity.setId(dto.getId());
        entity.setCompanyName(dto.getCompanyName());
        entity.setIndustry(dto.getIndustry());
        entity.setEmployeeCount(dto.getEmployeeCount());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());

        return entity;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", companyName='" + companyName + '\'' + ", industry=" + industry + ", " +
                "employeeCount=" + employeeCount + ", city='" + city + '\'' + ", country='" + country + '}';
    }
}