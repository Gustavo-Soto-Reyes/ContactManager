package com.example.contact_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.contact_manager.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContactDatabase db;
    private ArrayList<Contact> contactsList = new ArrayList<>();
    private ContactsAdapter contactsAdapter;

    private ActivityMainBinding mainBinding;
    private MainActivityClickHandlers clickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        clickHandlers = new MainActivityClickHandlers(this);
        mainBinding.setClickHandler(clickHandlers);

        RecyclerView recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        db = ContactDatabase.getInstance(this);

        ContactsViewModel vm = new ViewModelProvider(this).get(ContactsViewModel.class);

        Contact c1 = new Contact("gus", "gus@fmail.com");
        vm.addContact(c1);
        vm.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                for (Contact c: contacts){
                    Log.v("TAG GUS", c.getName());
                    contactsList.add(c);
                }

                contactsAdapter.notifyDataSetChanged();
            }
        });

        contactsAdapter = new ContactsAdapter(contactsList);
        recyclerView.setAdapter(contactsAdapter);
    }
}