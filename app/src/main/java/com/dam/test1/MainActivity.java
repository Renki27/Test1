package com.dam.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_logout;
    UserLocalStore userStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userStore = new UserLocalStore(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_logout:
                userStore.clearUserData();
                userStore.setUserLoggedIn(false);
                Intent intent = new Intent(this, Sign_in.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
/*
    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate() == true) {

        }
    }

    public boolean authenticate() {
        return userStore.getUserLoggedIn();
    }
*/
}