package com.ironhack.model;

import com.ironhack.enums.Industry;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Account {

    private static int counter = 1000;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String companyName;
    private Industry industry;
    private int numberOfEmployees;
    private String city;
    private String country;
    private ArrayList<Contact> contactList = new ArrayList<>();

    public Account(String companyName){
        setId();
        this.companyName = companyName;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    public void setId() {
        this.id = counter++;
    }


    public void addContactToList(Contact contact) {
        contactList.add(contact);
    }


    @Override
    public String toString() {
        return "Account: " + id + '\n' +
                "Industry: " + industry + '\n' +
                "Employees: " + numberOfEmployees + '\n' +
                "City: " + city + '\n' +
                "Country: " + country + '\n' +
                "ContactList: " + contactList + '\n' +
                "CompanyName: " + companyName + '\n';
    }
}
