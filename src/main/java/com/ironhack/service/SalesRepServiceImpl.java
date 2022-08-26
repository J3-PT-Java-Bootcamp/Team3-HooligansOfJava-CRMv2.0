package com.ironhack.service;

import com.ironhack.model.SalesRep;
import com.ironhack.reporting.tableWithLinesAndMaxWidth;
import com.ironhack.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        var salesRepResponse = salesRepRepository.groupByName();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "SalesRep";
        data[0][1] = "Leads";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);

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
