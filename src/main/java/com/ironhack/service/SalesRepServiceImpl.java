package com.ironhack.service;

import com.ironhack.model.SalesRep;
import com.ironhack.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesRepServiceImpl implements SalesRepService{
    @Autowired
    private SalesRepRepository salesRepRepository;

    @Override
    public SalesRep newSalesRep(String name) {
        SalesRep salesRep = new SalesRep(name);
        return salesRepRepository.save(salesRep);
    }

    @Override
    public List<SalesRep> getSalesReps() {
        return salesRepRepository.findAll();
    }

    @Override
    public SalesRep getSalesRepByName(String salesRepName) {
        return salesRepRepository.findSalesRepByName(salesRepName);
    }

    @Override
    public void reportLead() {

    }

    @Override
    public void reportOpportunity() {

    }

    @Override
    public void reportClosedWon() {

    }

    @Override
    public void reportClosedLost() {

    }

    @Override
    public void reportOpen() {

    }
}
