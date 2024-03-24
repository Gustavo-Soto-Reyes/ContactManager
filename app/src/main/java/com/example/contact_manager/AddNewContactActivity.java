package com.example.contact_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.contact_manager.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding binding;
    private AddNewContactClickHandler handler;

    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        contact = new Contact();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_contact);
        binding.setContact(contact);

        ContactsViewModel vm = new ViewModelProvider(this).get(ContactsViewModel.class);

        handler = new AddNewContactClickHandler(contact, this, vm);
        binding.setClickHandler(handler);

    }
}