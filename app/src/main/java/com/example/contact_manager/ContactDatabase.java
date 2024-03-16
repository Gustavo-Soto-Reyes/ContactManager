package com.example.contact_manager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {
    public abstract ContactDAO getContactDAO();

    private static ContactDatabase databaseInstance;

    public static synchronized ContactDatabase getInstance(Context context){
        if (databaseInstance == null){
            databaseInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDatabase.class,
                    "contacts_db"
            ).fallbackToDestructiveMigration().build();
        }
        return databaseInstance;
    }
}
