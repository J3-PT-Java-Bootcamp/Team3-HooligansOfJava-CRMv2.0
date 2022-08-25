package com.ironhack.service;

import com.ironhack.model.Lead;
import com.ironhack.model.SalesRep;
import com.ironhack.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    LeadRepository leadRepository;
    @Override
    public Lead newLead(String name, String phoneNumber, String email, String companyName, SalesRep salesRep) {
        Lead lead = new Lead();
        lead.setName(name);
        lead.setPhoneNumber(phoneNumber);
        lead.setEmail(email);
        lead.setCompanyName(companyName);
        lead.setSalesRep(salesRep);
        return leadRepository.save(lead);
    }

    @Override
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Override
    public Lead getLeadById(Long id) {
         return leadRepository.findById(id).orElseThrow();
    }
}
