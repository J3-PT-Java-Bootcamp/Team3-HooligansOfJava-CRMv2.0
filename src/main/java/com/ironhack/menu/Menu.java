package com.ironhack.menu;


import com.ironhack.enums.OpportunityStatus;
import com.ironhack.model.*;
import com.ironhack.console.ConsoleBuilder;
import com.ironhack.enums.Industry;
import com.ironhack.enums.TypeOfProduct;

import java.util.*;

import com.ironhack.model.Lead;
import com.ironhack.reporting.Reporting;
import com.ironhack.service.*;
import org.springframework.stereotype.Component;

import static com.ironhack.enums.OpportunityStatus.*;
@Component
public class Menu {

    Scanner scanner;
    ConsoleBuilder consoleBuilder;
    SalesRepService salesRepService;
    LeadService leadService;
    OpportunityService opportunityService;
    ContactService contactService;
    AccountService accountService;
    ProductService productService;

    private String option;

    public Menu(SalesRepService salesRepService, LeadService leadService, OpportunityService opportunityService, ContactService contactService, AccountService accountService, ProductService productService) {
        this.scanner = new Scanner(System.in);
        this.consoleBuilder = new ConsoleBuilder(scanner);
        this.salesRepService = salesRepService;
        this.leadService = leadService;
        this.opportunityService = opportunityService;
        this.contactService = contactService;
        this.accountService = accountService;
        this.productService = productService;
    }

    public void start() throws InterruptedException {
        boolean exit = false;

        while (!exit) {
            List<String> options = Arrays.asList("New SalesRep","SalesRep Info","New lead", "Show leads", "Lookup Lead id", "Convert id",
                    "Search opportunity by company name", "Edit opportunity", "Reports", "Exit");
            option = consoleBuilder.listConsoleInput("Welcome to CRM. What would you like to do?", options);
            switch (option) {
                case "NEW SALESREP" -> newSalesRep();
                case "SALESREP INFO" -> getSalesRep();
                case "NEW LEAD" -> newLeadInfo();
                case "SHOW LEADS" -> showLeads();
                case "LOOKUP LEAD ID" -> searchLead();
                case "CONVERT ID" -> convertId();
                case "SEARCH OPPORTUNITY BY COMPANY NAME" -> searchOpportunityByCompanyName();
                case "EDIT OPPORTUNITY" -> editOpportunity();
                case "REPORTS" -> showReportsMenu();
                case "EXIT" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }
    }

    private void newSalesRep() {
        String salesRep = String.valueOf(consoleBuilder.textConsoleInput("Insert the Sales Rep name: "));
        System.out.println("------------------");
        salesRepService.newSalesRep(salesRep);
    }

    private void getSalesRep() {
        List<SalesRep> salesRepList = salesRepService.getSalesReps();
        if(salesRepList.size() > 0) {
            System.out.println("The available Sales Reps are: ");
            for (SalesRep salesRep : salesRepList) {
                System.out.println("Name: " + salesRep.getName());
                System.out.println("Id: " + salesRep.getId());
            }
        }
    }

    private void newLeadInfo() {
        System.out.println("Enter lead details");
        System.out.println("------------------");

        String name = consoleBuilder.textConsoleInput("Name:");
        String phoneNumber = String.valueOf(consoleBuilder.numberConsoleInput("Phone number:", 99999999, 1000000000));
        String email = consoleBuilder.emailConsoleInput("Email:");
        String companyName = consoleBuilder.textConsoleInput("Company name:");
        String salesRepName = String.valueOf(consoleBuilder.textConsoleInput("Sales Representant: "));
        SalesRep salesRep = salesRepService.getSalesRepByName(salesRepName);

        if (!name.isBlank() && !phoneNumber.isBlank() && !email.isBlank() && !companyName.isBlank() && !salesRep.getName().isBlank()) {
            Lead lead = leadService.newLead(name, phoneNumber, email, companyName, salesRep);

            System.out.println("Lead created: " + lead);
        } else {
            System.out.println("ERROR!! Enter all details");
        }
    }

    private void showLeads() {
        List<Lead> leadList = leadService.getAllLeads();

        if (leadList.size() > 0) {
            System.out.println("Total leads at the data base: " + leadList.size());
            Map<Long, String> leadsToShow = new HashMap<>();
            for (Lead lead : leadList) {
                leadsToShow.put(lead.getId(), lead.getName());
            }
            System.out.println(leadsToShow);

        } else {
            System.out.println("No existing leads to show");
        }
        System.out.println("-----------------------------");
    }

    private void searchLead() {
        List<Lead> leadList = leadService.getAllLeads();

        if (leadList.size() > 0) {
            Long[] ids = getAllLeadIds(leadList);
            Long id = consoleBuilder.numberConsoleInput("Enter lead Id:", ids);
            Lead lead = leadService.getLeadById(id);
            System.out.println(lead);
        } else {
            System.out.println("No existing leads to search");
        }
    }

    private void convertId() {
        List<Lead> leadList = leadService.getAllLeads();

        if (leadList.size() > 0) {
            System.out.println("----------");
            Long[] ids = getAllLeadIds(leadList);
            Long id = consoleBuilder.numberConsoleInput("Enter lead id to convert to opportunity:", ids);
            Lead lead = leadService.getLeadById(id);

            Account account = accountService.newAccount(lead.getCompanyName());

            Contact contact = contactService.newContact(lead, account);

            leadService.removeLead(lead);

            ArrayList<Product> productList = new ArrayList<>();
            boolean doneOrder = false;
            int count = 0;
            while (!doneOrder) {
                count++;
                List<String> options = Arrays.asList("HYBRID", "FLATBED", "BOX", "DONE");
                if (count == 1) {
                    options = Arrays.asList("HYBRID", "FLATBED", "BOX");
                }
                option = consoleBuilder.listConsoleInput("In which type of product are you interested?", options);
                if (option.equals("DONE")) {
                    doneOrder = true;
                } else {
                    TypeOfProduct type = TypeOfProduct.valueOf(option);
                    int quantity = consoleBuilder.numberConsoleInput("How many of " + option + "?", 1, 999);
                    Product product = productService.newProduct(type, quantity);

                    productList.add(product);
                    System.out.println(productList);
                }
            }

            Opportunity opportunity = opportunityService.newOpportunity(productList, contact);


            List<String> options = Arrays.asList("PRODUCE", "ECOMMERCE", "MANUFACTURING", "MEDICAL", "OTHER");
            String industry = consoleBuilder.listConsoleInput("The opportunity has been created successfully.", options);
            int employees = consoleBuilder.numberConsoleInput("Number of employees of the company:");
            String city = consoleBuilder.textConsoleInput("Company city: ");
            String country = consoleBuilder.textConsoleInput("Company country: ");
            Account updatedAccount = accountService.updateAccount(account.getId(), Industry.valueOf(industry), employees, city, country, contact);
            Opportunity updatedOpportunity = opportunityService.updateOpportunity(opportunity.getId(), contact);
        } else {
            System.out.println("No existing leads to convert");
        }
    }

    private void searchOpportunityByCompanyName() {
        System.out.println("Please enter company name to search opportunities: ");
        String name = scanner.nextLine();
        List<Opportunity> opportunities = opportunityService.getOpportunityByName(name);
        System.out.println(opportunities);
    }

    private void editOpportunity() {
        // update opportunity using opportunityService, creating a new opportunity and saving the new entity
        List<Opportunity> opportunityList = opportunityService.findAll();
        System.out.println(opportunityList);
        System.out.println("---------------------");
        System.out.print("Select opportunity id: ");
        Long id = consoleBuilder.numberConsoleInput("Select opportunity id: ", getAllOpportunitiesIds(opportunityList));
        Opportunity chosenOpportunity = opportunityService.getOpportunityById(id);
        System.out.println(chosenOpportunity);
        System.out.println("What should be the new status?");
        System.out.println("---------------------");
        List<String> options = Arrays.asList(CLOSED_LOST.toString(), CLOSED_WON.toString());
        String newStatus = consoleBuilder.listConsoleInput("What should be the new status?", options);
        Opportunity updatedOpportunity = opportunityService.updateStatus(chosenOpportunity, OpportunityStatus.valueOf(newStatus));

        System.out.println("New status: " + updatedOpportunity.getStatus());
    }

    private void showReportsMenu() {
        Reporting reports = new Reporting(consoleBuilder,salesRepService, leadService, opportunityService, contactService, accountService, productService);
        reports.menu();
    }

    private Long[] getAllLeadIds(List<Lead> leadList) {
        Long[] ids = new Long[leadList.size()];

        for (int i = 0; i < leadList.size(); i++) {
            ids[i] = leadList.get(i).getId();
        }

        return ids;
    }

    private Long[] getAllOpportunitiesIds(List<Opportunity> opportunityList) {
        Long[] ids = new Long[opportunityList.size()];

        for (int i = 0; i < opportunityList.size(); i++) {
            ids[i] = opportunityList.get(i).getId();
        }

        return ids;
    }
}