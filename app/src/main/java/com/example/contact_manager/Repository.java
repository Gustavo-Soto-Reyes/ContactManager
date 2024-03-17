package com.example.contact_manager;

import java.util.List;

public class Repository {
    private final ContactDAO dao;

    public Repository(ContactDAO dao) {
        this.dao = dao;
    }

    public void addContact(Contact contact){
        dao.insert(contact);
    }

    public void deleteContact(Contact contact){
        dao.delete(contact);
    }

    public List<Contact> getAllContacts(){
        return dao.getAllContacts();
    }

}
