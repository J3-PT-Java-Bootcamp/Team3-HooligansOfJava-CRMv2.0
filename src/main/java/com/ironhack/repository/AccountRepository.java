package com.ironhack.repository;

import com.ironhack.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT a.city, COUNT(a.city) FROM Account a  GROUP BY a.city")
    List<Object[]> OpportunityByCity();

    @Query(value = "SELECT a.city, COUNT(a.city) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='CLOSED_LOST' GROUP BY a.city")
    List<Object[]>  OpportunityByCityStatusClosed();

    @Query(value = "SELECT a.city, COUNT(a.city) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='CLOSED_WON' GROUP BY a.city")
    List<Object[]>  OpportunityByCityStatusWon();

    @Query(value = "SELECT a.city, COUNT(a.city) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='OPEN' GROUP BY a.city")
    List<Object[]>  OpportunityByCityStatusOpen();

    @Query(value = "SELECT a.country, COUNT(a.country) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='OPEN' GROUP BY a.country")
    List<Object[]>  OpportunityByCountryStatusOpen();

    @Query(value = "SELECT a.country, COUNT(a.country) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='CLOSED_LOST' GROUP BY a.country")
    List<Object[]>  OpportunityByCountryStatusLost();

    @Query(value = "SELECT a.country, COUNT(a.country) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='CLOSED_WON' GROUP BY a.country")
    List<Object[]>  OpportunityByCountryStatusWon();

    @Query(value = "SELECT a.country, COUNT(a.country) FROM Account a  GROUP BY a.country")
    List<Object[]>  OpportunityByCountry();

    @Query(value = "SELECT a.industry, COUNT(a.industry) FROM Account a  GROUP BY a.industry")
    List<Object[]> OpportunityByIndustry();

    @Query(value = "SELECT a.industry, COUNT(a.industry) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='CLOSED_WON' GROUP BY a.industry")
    List<Object[]>  OpportunityByIndustryStatusWon();

    @Query(value = "SELECT a.industry, COUNT(a.industry) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='CLOSED_LOST' GROUP BY a.industry")
    List<Object[]> OpportunityByIndustryStatusLost();

    @Query(value = "SELECT a.industry, COUNT(a.industry) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='OPEN' GROUP BY a.industry")
    List<Object[]>OpportunityByIndustryStatusOpen();

    @Query(value = "SELECT company_name, AVG(employee_count) FROM account GROUP BY company_name", nativeQuery = true)
    List<Object[]> findMeanEmployeeCountQuantity();

    @Query(value = "SELECT company_name, employee_count FROM account ORDER BY company_name, employee_count", nativeQuery = true)
    List<Object[]> findMedianEmployeeCountQuantity();

    @Query(value = "SELECT company_name, MAX(employee_count) FROM account GROUP BY company_name", nativeQuery = true)
    List<Object[]> findMaxEmployeeCountQuantity();

    @Query(value = "SELECT company_name, MIN(employee_count) FROM account GROUP BY company_name", nativeQuery = true)
    List<Object[]> findMinEmployeeCountQuantity();
}
