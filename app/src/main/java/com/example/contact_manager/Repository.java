package com.example.contact_manager;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private final ContactDAO dao;
    private final Handler handler;
    private final ExecutorService executor;

    public Repository(Application app) {

        ContactDatabase db = ContactDatabase.getInstance(app);
        this.dao = db.getContactDAO();
        handler = new Handler(Looper.getMainLooper());
        executor = Executors.newSingleThreadExecutor();
    }

    public void addContact(Contact contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insert(contact);
            }
        });
    }

    public void deleteContact(Contact contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                dao.delete(contact);
            }
        });
    }

    public LiveData<List<Contact>> getAllContacts(){
        return dao.getAllContacts();
    }

}
