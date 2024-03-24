package com.example.contact_manager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {
    Contact contact;
    Context context;

    public AddNewContactClickHandler(Contact contact, Context context) {
        this.contact = contact;
        this.context = context;
    }

    public void onSubmitButton(View view){
        if(contact.getName() == null || contact.getEmail()==null){
            Toast.makeText(context, "Empty Fields not allowed", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("Name", contact.getName());
            i.putExtra("Email", contact.getEmail());
            context.startActivity(i);
        }
    }
}
