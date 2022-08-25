package com.ironhack.service;

import com.ironhack.model.SalesRep;
import com.ironhack.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesRepServiceImpl implements SalesRepService{
    @Autowired
    SalesRepRepository salesRepRepository;

    @Override
    public SalesRep newSalesRep(String name) {
        SalesRep salesRep = new SalesRep(name);
        return salesRepRepository.save(salesRep);
    }
}
