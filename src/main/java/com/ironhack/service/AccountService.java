package com.ironhack.service;

import com.ironhack.enums.Industry;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;

public interface AccountService {
    Account newAccount(String companyName);

    Account updateAccount(Long id, Industry industry, int employees, String city, String country, Contact contact);

    void reportOpportunityByCity();

    void reportClosedLostByCity();

    void reportClosedWonByCity();

    void reportOpenByCity();

    void reportOpenByCountry();

    void reportClosedLostByCountry();

    void reportClosedWonByCountry();

    void reportOpportunityByCountry();

    void reportOpportunityByIndustry();

    void reportClosedWonByIndustry();

    void reportClosedLostByIndustry();

    void reportOpenByIndustry();

    void meanEmployeeCountQuantity();

    void medianEmployeeCountQuantity();

    void maxEmployeeCountQuantity();

    void minEmployeeCountQuantity();
}
