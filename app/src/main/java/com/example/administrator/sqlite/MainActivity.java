package com.example.administrator.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.administrator.sqlite.adapter.ContactAdapter;
import com.example.administrator.sqlite.database.DBContact;
import com.example.administrator.sqlite.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtName,edtNumber;
    private Button btnAdd;
    private ListView lvContact;
    private List<Contact> listContact;
    private ContactAdapter contactAdapter;
    private DBContact dbContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEvents();
        dbContact = new DBContact(this);
        listContact = new ArrayList<>();
        setAdapter();

    }

    private void setAdapter() {
        if (contactAdapter == null) {
            contactAdapter = new ContactAdapter(this, R.layout.custom_contact, listContact);
            lvContact.setAdapter(contactAdapter);
        } else {
            contactAdapter.notifyDataSetChanged();
        }
    }

    private void setEvents() {
        btnAdd.setOnClickListener(this);
    }

    private void initWidget() {
        edtName = (EditText) findViewById(R.id.edt_name);
        edtNumber = (EditText) findViewById(R.id.edt_number);
        btnAdd = (Button) findViewById(R.id.btn_add);
        lvContact = (ListView) findViewById(R.id.lv_contact);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_add){
            Contact contact = new Contact(edtName.getText().toString(),edtNumber.getText().toString());
            dbContact.addContact(contact);
            listContact.clear();
            listContact.addAll(dbContact.getAllContact());
            setAdapter();
        }
    }
}
