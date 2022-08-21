package com.ironhack.model;


import com.ironhack.dto.ContactDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public static Contact fromDTO(ContactDTO dto){
        var entity = new Contact();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());

        return entity;
    }

}
