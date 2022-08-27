package com.ironhack.dto;

import com.ironhack.model.Contact;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ContactDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    public static ContactDTO fromEntity(Contact entity){
        var dto = new ContactDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());

        return dto;
    }
}
