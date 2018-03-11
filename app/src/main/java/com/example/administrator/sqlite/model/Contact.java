package com.example.administrator.sqlite.model;

/**
 * Created by Administrator on 10/03/2018.
 */

public class Contact {
    private int mID;
    private String mName;
    private String mNumber;

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public Contact() {

    }

    public Contact(String mName, String mNumber) {

        this.mName = mName;
        this.mNumber = mNumber;
    }

    public Contact(int mID, String mName, String mNumber) {

        this.mID = mID;
        this.mName = mName;
        this.mNumber = mNumber;
    }
}
