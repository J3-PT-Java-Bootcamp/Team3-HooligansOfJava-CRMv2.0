package com.ironhack.service;

import com.ironhack.enums.Industry;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.reporting.tableWithLinesAndMaxWidth;
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

    @Override
    public void reportOpportunityByCity() {
        var salesRepResponse = accountRepository.OpportunityByCity();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "City";
        data[0][1] = "Number of opportunities won";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportClosedLostByCity() {
        var salesRepResponse = accountRepository.OpportunityByCityStatusClosed();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "City";
        data[0][1] = "Number of opportunities won";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportClosedWonByCity() {
        var salesRepResponse = accountRepository.OpportunityByCityStatusWon();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "City";
        data[0][1] = "Number of opportunities won";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);

    }

    @Override
    public void reportOpenByCity() {

        var salesRepResponse = accountRepository.OpportunityByCityStatusOpen();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "City";
        data[0][1] = "Number of opportunities open";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportOpenByCountry() {
        var salesRepResponse = accountRepository.OpportunityByCountryStatusOpen();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Country";
        data[0][1] = "Number of opportunities won";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportClosedLostByCountry() {
        var salesRepResponse = accountRepository.OpportunityByCountryStatusLost();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Country";
        data[0][1] = "Number of opportunities won";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportClosedWonByCountry() {
        var salesRepResponse = accountRepository.OpportunityByCountryStatusWon();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Country";
        data[0][1] = "Number of opportunities won";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportOpportunityByCountry() {
        var salesRepResponse = accountRepository.OpportunityByCountry();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Country";
        data[0][1] = "Number of opportunities";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportOpportunityByIndustry() {
        var salesRepResponse = accountRepository.OpportunityByIndustry();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Industry";
        data[0][1] = "Number of opportunities";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }


    @Override
    public void reportClosedWonByIndustry() {
        var salesRepResponse = accountRepository.OpportunityByIndustryStatusWon();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Industry";
        data[0][1] = "Number of opportunities";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportClosedLostByIndustry() {
        var salesRepResponse = accountRepository.OpportunityByIndustryStatusLost();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Industry";
        data[0][1] = "Number of opportunities";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportOpenByIndustry() {
        var salesRepResponse = accountRepository.OpportunityByIndustryStatusOpen();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "Industry";
        data[0][1] = "Number of opportunities";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }
}
