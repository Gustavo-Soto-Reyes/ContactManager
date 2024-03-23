package com.example.contact_manager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact_manager.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    private ArrayList<Contact> contacts;

    public ContactsAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ContactListItemBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.contact_list_item, parent, false
        );
        return new ContactsViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        Contact newContact = contacts.get(position);
        holder.listbinding.setContact(newContact);
    }

    @Override
    public int getItemCount() {
        if (contacts!= null){
            return contacts.size();
        } else {
            return 0;
        }
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {
        private ContactListItemBinding listbinding;
        public ContactsViewHolder(@NonNull ContactListItemBinding listbinding) {
            super(listbinding.getRoot());
            this.listbinding = listbinding;
        }
    }
}
