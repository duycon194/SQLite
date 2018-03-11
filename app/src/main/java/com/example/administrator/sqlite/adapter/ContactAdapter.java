package com.example.administrator.sqlite.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.sqlite.R;
import com.example.administrator.sqlite.model.Contact;

import java.util.List;

/**
 * Created by Administrator on 10/03/2018.
 */

public class ContactAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Contact> arrContact;
    public ContactAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource =resource;
        this.arrContact = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_contact,parent,false);
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tv_number = (TextView) convertView.findViewById(R.id.tv_number);
        Contact contact = arrContact.get(position);
        tv_name.setText(contact.getmName().toString());
        tv_number.setText(contact.getmNumber().toString());
        return convertView;
    }
}
