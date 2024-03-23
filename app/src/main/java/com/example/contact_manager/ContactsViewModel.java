package com.example.contact_manager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactsViewModel extends AndroidViewModel {
    Repository repository;
    LiveData<List<Contact>> allContacts;
    public ContactsViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<Contact>> getAllContacts(){
        allContacts = repository.getAllContacts();
        return allContacts;
    }

    public void addContact(Contact contact){
        repository.addContact(contact);
    }

    public void deleteContact(Contact contact){
        repository.deleteContact(contact);
    }

}
