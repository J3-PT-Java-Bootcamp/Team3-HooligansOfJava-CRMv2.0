package com.ironhack.service;

import com.ironhack.model.Lead;
import com.ironhack.model.SalesRep;

import java.util.List;

public interface LeadService {


    Lead newLead(String name, String phoneNumber, String email, String companyName, SalesRep salesRep);

    List<Lead> getAllLeads();

    Lead getLeadById(Long id);

    void removeLead(Lead lead);
}
