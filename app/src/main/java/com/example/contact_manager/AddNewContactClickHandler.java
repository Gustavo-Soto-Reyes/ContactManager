package com.example.contact_manager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {
    Contact contact;
    Context context;

    ContactsViewModel vm;

    public AddNewContactClickHandler(Contact contact, Context context, ContactsViewModel vm) {
        this.contact = contact;
        this.context = context;
        this.vm = vm;
    }

    public void onSubmitButton(View view){
        if(contact.getName() == null || contact.getEmail()==null){
            Toast.makeText(context, "Empty Fields not allowed", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(context, MainActivity.class);
            vm.addContact(contact);

            context.startActivity(i);
        }
    }
}
