package com.dam.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sign_up extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    UserLocalStore userStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etName = findViewById(R.id.et_Name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        userStore = new UserLocalStore(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in:
                signIn();
                break;
            case R.id.btn_create_account2:
                createAccount();
                break;
            default:
                break;
        }
    }

    private void signIn() {
        Intent intent = new Intent(Sign_up.this, Sign_in.class);
        startActivity(intent);
        finish();
    }

    private void createAccount() {
        Toast.makeText(this, "create account", Toast.LENGTH_SHORT).show();
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();
        String email = etEmail.getText().toString();

        if (name.isEmpty()) {
            etName.setError(getString(R.string.error_name));
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError(getString(R.string.error_email));
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError(getString(R.string.error_password));
            return;
        }

        User userData = new User(name, password, email);
        Log.d("user: ", userData.toString());
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        if (userStore.getUserData() != null) {
            Toast.makeText(this, R.string.sign_up_error, Toast.LENGTH_SHORT).show();
        } else {
            userStore.storeUserData(userData);
            Toast.makeText(this, R.string.account_created, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Sign_up.this, Sign_in.class);
            startActivity(intent);

        }


    }
}
