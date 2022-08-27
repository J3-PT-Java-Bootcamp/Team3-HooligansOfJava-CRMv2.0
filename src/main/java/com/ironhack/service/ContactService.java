package com.ironhack.service;

import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.model.Lead;

import java.util.List;

public interface ContactService {
    Contact newContact(Lead lead, Account account);
}
