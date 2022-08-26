package com.ironhack.service;

import com.ironhack.enums.OpportunityStatus;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.model.Opportunity;
import com.ironhack.model.Product;
import com.ironhack.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ironhack.enums.OpportunityStatus.OPEN;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;

    @Override
    public Opportunity newOpportunity(ArrayList<Product> productList, Contact contact) {
        Opportunity opportunity = new Opportunity();
        opportunity.setStatus(OPEN);
        opportunity.setProducts(productList);
        opportunity.setDecisionMaker(contact);
        return opportunityRepository.save(opportunity);
    }

    @Override
    public Opportunity updateOpportunity(Long id, Contact contact) {
        Opportunity opportunity = opportunityRepository.findById(id).get();

        opportunity.setDecisionMaker(contact);
        return null;
    }

    @Override
    public List<Opportunity> getOpportunityByName(String name) {
        return opportunityRepository.findByCompanyName(name);
    }

    @Override
    public List<Opportunity> findAll() {
        return opportunityRepository.findAll();
    }

    @Override
    public Opportunity getOpportunityById(Long id) {
        return opportunityRepository.findById(id).get();
    }

    @Override
    public Opportunity updateStatus(Opportunity chosenOpportunity, OpportunityStatus status) {
        chosenOpportunity.setStatus(status);
        return opportunityRepository.save(chosenOpportunity);
    }
}
