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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    public Contact(String name, String phoneNumber, String email, Account account) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.account = account;
    }

    public static Contact fromDTO(ContactDTO dto){
        var entity = new Contact();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());

        return entity;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", name='" + name + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", email" +
                "='" + email + '\'' + ", account=" + account + '}';
    }
}
