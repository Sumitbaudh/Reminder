package com.example.polestaruser.reminder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>  {
    private ArrayList<ContactModel> listAllContacts;

    public ContactListAdapter( ArrayList<ContactModel> listAllContacts)
    {
        this.listAllContacts=listAllContacts;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        public TextView contactName,contactNumber;
        public ContactViewHolder(View itemView) {
            super(itemView);
            contactName=itemView.findViewById(R.id.txt_contact_name);
            contactNumber=itemView.findViewById(R.id.txt_contact_number);
        }
    }

    public ContactViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item_view,parent,false);
        return new ContactViewHolder(itemView);
    }


    public void onBindViewHolder(ContactViewHolder holder,int position){
        ContactModel contactModel=listAllContacts.get(position);
        holder.contactName.setText(contactModel.getPersonName());
        holder.contactNumber.setText(contactModel.getPersonNumber());

    }

    public int getItemCount() {
        return listAllContacts.size();
    }
}
