package com.ironhack.service;

import com.ironhack.enums.OpportunityStatus;
import com.ironhack.model.*;

import java.util.ArrayList;
import java.util.List;

public interface OpportunityService {
    Opportunity newOpportunity(ArrayList<Product> productList, Contact contact, SalesRep salesRep);

    Opportunity updateOpportunity(Long id, Contact contact);

    List<Opportunity> getOpportunityByName(String name);

    List<Opportunity> findAll();

    Opportunity getOpportunityById(Long id);

    Opportunity updateStatus(Opportunity chosenOpportunity, OpportunityStatus status);
}
