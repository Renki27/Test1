package com.dam.test1;

public class User {

     String name;
     String password;
     String email;


    public User  (String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User  (String password, String email) {
        this.password = password;
        this.email = email;
    }



}
