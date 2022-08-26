package com.ironhack.reporting;

import com.ironhack.console.ConsoleBuilder;
import com.ironhack.service.*;

import java.util.Arrays;
import java.util.List;

public class Reporting {
    ConsoleBuilder consoleBuilder;
    SalesRepService salesRepService;
    LeadService leadService;
    OpportunityService opportunityService;
    ContactService contactService;
    AccountService accountService;
    ProductService productService;

    public Reporting(ConsoleBuilder consoleBuilder, SalesRepService salesRepService, LeadService leadService, OpportunityService opportunityService, ContactService contactService, AccountService accountService, ProductService productService) {
        this.consoleBuilder = consoleBuilder;
        this.salesRepService = salesRepService;
        this.leadService = leadService;
        this.opportunityService = opportunityService;
        this.contactService = contactService;
        this.accountService = accountService;
        this.productService = productService;
    }

    public void menu() {
        boolean exit = false;
        while (!exit) {
            List<String> options = Arrays.asList("SalesRep", "Product", "Country", "City", "Industry", "EmployeeCount", "Quantity", "Opportunity", "Exit");
            String option = consoleBuilder.listConsoleInput("What report do you like?", options);
            switch (option) {
                case "SALESREP" -> SalesRep();
                case "PRODUCT" -> Product();
                case "COUNTRY" -> Country();
                case "CITY" -> City();
                case "INDUSTRY" -> Industry();
                case "EMPLOYEECOUNT" -> EmployeeCount();
                case "QUANTITY" -> Quantity();
                case "OPPORTUNITY" -> Opportunity();
                case "EXIT" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }
    }

    public void SalesRep() {
        boolean exit = false;
        while (!exit) {
            List<String> options = Arrays.asList("Report Lead", "Report Opportunity", "Report CLOSED-WON", "Report CLOSED-LOST", "Report OPEN", "Back");
            String option = consoleBuilder.listConsoleInput("What sales report do you like?", options);
            switch (option) {
                case "Report Lead" -> salesRepService.reportLead();
                case "REPORT OPPORTUNITY" -> salesRepService.reportOpportunity();
                case "REPORT CLOSED-WON" -> salesRepService.reportClosedWon();
                case "Report CLOSED-LOST" -> salesRepService.reportClosedLost();
                case "Report OPEN" ->salesRepService.reportOpen();
                case "BACK" -> exit = true;
                default -> System.out.println(option);
            }
        }

    }

    public void Product() {
        boolean exit = false;
        while (!exit) {
            List<String> options = Arrays.asList("Report Lead", "Report Opportunity", "Report CLOSED-WON", "Report CLOSED-LOST", "Report OPEN", "Back");
            String option = consoleBuilder.listConsoleInput("What product report do you like?", options);
            switch (option) {
                case "Report Lead " -> System.out.println("Report Lead");
                case "REPORT OPPORTUNITY" -> System.out.println("Report Opportunity");
                case "REPORT CLOSED-WON" -> System.out.println("Report CLOSED-WON");
                case "Report CLOSED-LOST" -> System.out.println("Report CLOSED-LOST");
                case "Report OPEN" -> System.out.println("Report OPEN");
                case "BACK" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }

    }

    public void Country() {
        boolean exit = false;
        while (!exit) {
            List<String> options = Arrays.asList("Report Lead", "Report Opportunity", "Report CLOSED-WON", "Report CLOSED-LOST", "Report OPEN", "Back");
            String option = consoleBuilder.listConsoleInput("What country report do you like?", options);
            switch (option) {
                case "Report Lead " -> System.out.println("Report Lead");
                case "REPORT OPPORTUNITY" -> System.out.println("Report Opportunity");
                case "REPORT CLOSED-WON" -> System.out.println("Report CLOSED-WON");
                case "Report CLOSED-LOST" -> System.out.println("Report CLOSED-LOST");
                case "Report OPEN" -> System.out.println("Report OPEN");
                case "BACK" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }

    }

    public void City() {
        boolean exit = false;
        while (!exit) {
            List<String> options = Arrays.asList("Report Lead", "Report Opportunity", "Report CLOSED-WON", "Report CLOSED-LOST", "Report OPEN", "Back");
            String option = consoleBuilder.listConsoleInput("What city report do you like?", options);
            switch (option) {
                case "Report Lead " -> System.out.println("Report Lead");
                case "REPORT OPPORTUNITY" -> System.out.println("Report Opportunity");
                case "REPORT CLOSED-WON" -> System.out.println("Report CLOSED-WON");
                case "Report CLOSED-LOST" -> System.out.println("Report CLOSED-LOST");
                case "Report OPEN" -> System.out.println("Report OPEN");
                case "BACK" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }

    }

    public void Industry() {
        boolean exit = false;
        while (!exit) {
            List<String> options = Arrays.asList("Report Lead", "Report Opportunity", "Report CLOSED-WON", "Report CLOSED-LOST", "Report OPEN", "Back");
            String option = consoleBuilder.listConsoleInput("What industry report do you like?", options);
            switch (option) {
                case "Report Lead " -> System.out.println("Report Lead");
                case "REPORT OPPORTUNITY" -> System.out.println("Report Opportunity");
                case "REPORT CLOSED-WON" -> System.out.println("Report CLOSED-WON");
                case "Report CLOSED-LOST" -> System.out.println("Report CLOSED-LOST");
                case "Report OPEN" -> System.out.println("Report OPEN");
                case "BACK" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }

    }

    public void EmployeeCount() {
        boolean exit = false;
        while (!exit) {
            List<String> options = Arrays.asList("Mean", "Median", "Max", "Min", "Back");
            String option = consoleBuilder.listConsoleInput("What employee count report do you like?", options);
            switch (option) {
                case "MEAN" -> System.out.println("Mean");
                case "MEDIAN" -> System.out.println("Median");
                case "MAX" -> System.out.println("Max");
                case "MIN" -> System.out.println("Min");
                case "BACK" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }

    }

    public void Quantity() {
        boolean exit = false;
        while (!exit) {
            List<String> options = Arrays.asList("Mean Quantity", "Median Quantity", "Max Quantity", "Min Quantity", "Back");
            String option = consoleBuilder.listConsoleInput("What quantity report do you want?", options);
            switch (option) {
                case "MEAN QUANTITY" -> productService.meanProductQuantity();
                case "MEDIAN QUANTITY" -> productService.medianProductQuantity();
                case "MAX QUANTITY" -> productService.maxProductQuantity();
                case "MIN QUANTITY" -> productService.minProductQuantity();
                case "BACK" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }
    }

    public void Opportunity() {
        boolean exit = false;
        while (!exit) {
            List<String> options = Arrays.asList("Mean", "Median", "Max", "Min", "Back");
            String option = consoleBuilder.listConsoleInput("What opportunity report do you like?", options);
            switch (option) {
                case "MEAN" -> System.out.println("Mean");
                case "MEDIAN" -> System.out.println("Median");
                case "MAX" -> System.out.println("Max");
                case "MIN" -> System.out.println("Min");
                case "BACK" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }

    }


}
