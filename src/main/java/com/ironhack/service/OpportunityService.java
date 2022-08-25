package com.ironhack.service;

import com.ironhack.enums.OpportunityStatus;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.model.Opportunity;
import com.ironhack.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface OpportunityService {
    Opportunity newOpportunity(ArrayList<Product> productList, Contact contact);

    Opportunity updateOpportunity(Long id, Contact contact);

    Opportunity getOpportunityByName(String name);

    List<Opportunity> findAll();

    Opportunity getOpportunityById(Long id);

    Opportunity updateStatus(Opportunity chosenOpportunity, OpportunityStatus status);
}
