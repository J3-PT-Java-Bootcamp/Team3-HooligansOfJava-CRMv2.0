package com.ironhack.service;

import com.ironhack.enums.Industry;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;

public interface AccountService {
    Account newAccount(String companyName);

    Account updateAccount(Long id, Industry industry, int employees, String city, String country, Contact contact);

}
