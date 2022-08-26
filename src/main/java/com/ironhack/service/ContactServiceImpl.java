package com.ironhack.service;

import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.model.Lead;
import com.ironhack.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;
    @Override
    public Contact newContact(Lead lead, Account account) {
        Contact contact = new Contact();
        contact.setId(lead.getId());
        contact.setName(lead.getName());
        contact.setPhoneNumber(lead.getPhoneNumber());
        contact.setEmail(lead.getEmail());
        contact.setAccount(account);
        return contactRepository.save(contact);
    }
}