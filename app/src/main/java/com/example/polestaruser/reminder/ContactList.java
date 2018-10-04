package com.example.polestaruser.reminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {
    private ArrayList<ContactModel> listAllContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        Intent intent=getIntent();
        listAllContacts=(ArrayList<ContactModel>) intent.getSerializableExtra("ContactList");
    }
}
