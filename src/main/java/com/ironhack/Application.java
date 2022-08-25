package com.ironhack;

import com.ironhack.console.ConsoleBuilder;
import com.ironhack.menu.Menu;
import com.ironhack.reporting.Reporting;
import com.ironhack.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {
    // Services
    @Autowired
    SalesRepService salesRepService;
    @Autowired
    LeadService leadService;
    @Autowired
    OpportunityService opportunityService;
    @Autowired
    ContactService contactService;
    @Autowired
    AccountService accountService;
    @Autowired
    ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(salesRepService, leadService, opportunityService, contactService, accountService, productService);
        menu.start();

        ConsoleBuilder consoleBuilder = new ConsoleBuilder(scanner);
        Reporting reports = new Reporting(consoleBuilder);
        reports.menu();
    }
}