package com.ironhack.service;

import com.ironhack.enums.Industry;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Override
    public Account newAccount(String companyName) {
        Account account = new Account();
        account.setCompanyName(companyName);

        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, Industry industry, int employees, String city, String country, Contact contact) {
        Account account = accountRepository.findById(id).get();

        account.setIndustry(industry);
        account.setEmployeeCount(employees);
        account.setCity(city);
        account.setCountry(country);
        var contacts = account.getContacts();
        if (contacts.size() > 0) {
            contacts.add(contact);
            account.setContacts(contacts);
        }
        else {
            List<Contact> contactList = new ArrayList<>();
            contactList.add(contact);
            account.setContacts(contactList);
        }

        return accountRepository.save(account);
    }
}
