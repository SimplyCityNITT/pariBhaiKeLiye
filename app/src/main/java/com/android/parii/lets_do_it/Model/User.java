package com.android.parii.lets_do_it.Model;


public class User {
    private String Name;
    private String Password;
    private String Phone;

    public User(){

    }


    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    //Constructor
    public User(String name, String password) {
        Name = name;
        Password = password;

    }



    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }
}
