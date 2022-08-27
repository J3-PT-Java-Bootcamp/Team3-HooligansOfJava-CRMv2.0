package com.ironhack.service;

import com.ironhack.model.SalesRep;

import java.util.List;

public interface SalesRepService {

    SalesRep newSalesRep(String name);

    List<SalesRep> getSalesReps();

    SalesRep getSalesRepByName(String salesRepName);

    void reportLead();

    void reportOpportunity();

    void reportClosedWon();

    void reportClosedLost();

    void reportOpen();
}
