package com.ironhack.dto;

import com.ironhack.enums.Industry;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.model.Opportunity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private Long id;
    private String companyName;
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<ContactDTO> contacts;
    private Opportunity opportunities;

    public static AccountDTO fromEntity(Account entity){
        var dto = new AccountDTO();

        dto.setId(entity.getId());
        dto.setCompanyName(entity.getCompanyName());
        dto.setIndustry(entity.getIndustry());
        dto.setEmployeeCount(entity.getEmployeeCount());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());

        var contacts = entity.getContacts();
        List<ContactDTO> contactDTOS = new ArrayList<>();
        for (Contact contact : contacts) {
            contactDTOS.add(ContactDTO.fromEntity(contact));
        }

        dto.setContacts(contactDTOS);

        return dto;
    }
}