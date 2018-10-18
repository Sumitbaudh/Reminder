package com.example.polestaruser.reminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {
    private ArrayList<ContactModel> listAllContacts;
    private RecyclerView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        Intent intent=getIntent();
        listAllContacts=(ArrayList<ContactModel>) intent.getSerializableExtra("ContactList");
        contactListView=findViewById(R.id.listcontacts);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        contactListView.setLayoutManager(mLayoutManager);
        contactListView.setAdapter(new ContactListAdapter(listAllContacts));

    }
}
