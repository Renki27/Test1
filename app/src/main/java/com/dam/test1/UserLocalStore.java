package com.dam.test1;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {
    public static final String SP_FILE = "usersList";
    SharedPreferences userLocal_DB;


    public UserLocalStore(Context context) {
        userLocal_DB = context.getSharedPreferences(SP_FILE, 0);
    }

    public void storeUserData(User user) {
        SharedPreferences.Editor editor = userLocal_DB.edit();
        editor.putString("name", user.name);
        editor.putString("password", user.password);
        editor.putString("email", user.email);
        editor.apply();
    }

    public User getUserData() {
        String name = userLocal_DB.getString("name", "");
        String password = userLocal_DB.getString("password", "");
        String email = userLocal_DB.getString("email", "");
        User userData = new User(name, password, email);
        return userData;
    }
    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor editor = userLocal_DB.edit();
        String name = userLocal_DB.getString("name", "");
        editor.putBoolean("loggedIn", loggedIn);
        editor.apply();
    }

    public boolean getUserLoggedIn() {
        return userLocal_DB.getBoolean("loggedIn", false) == true;
    }

    public void clearUserData () {
        SharedPreferences.Editor editor = userLocal_DB.edit();
        editor.clear();
        editor.apply();
    }
}
