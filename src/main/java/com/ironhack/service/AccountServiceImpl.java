package com.ironhack.service;

import com.ironhack.enums.Industry;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Override
    public Account newAccount(String companyName) {
        Account account = newAccount(companyName);

        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, Industry industry, int employees, String city, String country, Contact contact) {
        Account account = accountRepository.findById(id).get();

        account.setIndustry(industry);
        account.setEmployeeCount(employees);
        account.setCity(city);
        account.setCountry(country);
        account.getContacts().add(contact);

        return accountRepository.save(account);
    }
}
