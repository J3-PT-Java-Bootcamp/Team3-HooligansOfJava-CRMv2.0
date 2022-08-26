package com.ironhack.service;

import com.ironhack.model.SalesRep;
import com.ironhack.reporting.tableWithLinesAndMaxWidth;
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

        var salesRepResponse = salesRepRepository.groupLeadsByName();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "SalesRep";
        data[0][1] = "Number of leads";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);

    }



    @Override
    public void reportOpportunity() {
        var salesRepResponse = salesRepRepository.groupOpportunityByName();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "SalesRep";
        data[0][1] = "Number of opportunities";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }

    @Override
    public void reportClosedWon() {
        var salesRepResponse = salesRepRepository.groupOpportunityByNameWon();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "SalesRep";
        data[0][1] = "Number of opportunities";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);

    }

    @Override
    public void reportClosedLost() {
        var salesRepResponse = salesRepRepository.groupOpportunityByNameLost();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "SalesRep";
        data[0][1] = "Number of opportunities";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);

    }

    @Override
    public void reportOpen() {
        var salesRepResponse = salesRepRepository.groupOpportunityByNameOpen();
        String[][] data = new String[salesRepResponse.size()+1][2];
        data[0][0] = "SalesRep";
        data[0][1] = "Number of opportunities";
        for (int i = 0; i < salesRepResponse.size(); i++) {
            data[i+1][0] =salesRepResponse.get(i)[0].toString();
            data[i+1][1] =salesRepResponse.get(i)[1].toString();
        }
        tableWithLinesAndMaxWidth.tableWithLinesAndMaxWidth(data);
    }
}
