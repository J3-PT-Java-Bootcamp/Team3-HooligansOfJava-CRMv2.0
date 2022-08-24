package com.ironhack;

import com.ironhack.console.ConsoleBuilder;
import com.ironhack.reporting.Reporting;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleBuilder consoleBuilder = new ConsoleBuilder(scanner);
        Reporting reports = new Reporting(consoleBuilder);
        reports.menu();
    }
}
