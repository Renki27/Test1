package com.dam.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_in extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPassword;
    UserLocalStore userStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        userStore = new UserLocalStore(this);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        userStore = new UserLocalStore(this);


        // TODO: Tarea
        // Finalizar el método gotoRegister
        // Hacer el activity RegisterActivity y su funcionalidad
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in:
                SignIn();
                break;
            case R.id.btn_create_account:
                // TODO: Realizar el cambio de activities
                createAccount();
                break;
            default:
                break;
        }
    }

    private void SignIn() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError(getString(R.string.error_email));
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError(getString(R.string.error_password));
            return;
        }

        // TODO: Se tiene que sustituir con la logica de autenticación de la aplicación
        User tempUser = userStore.getUserData();
        if (email.equalsIgnoreCase(tempUser.email) && password.equalsIgnoreCase(tempUser.password)) {

            // TODO: almacenar en el storage el usuario logueado

            userStore.storeUserData(tempUser);
            userStore.setUserLoggedIn(true);

            Toast.makeText(this, R.string.sign_in_success, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, R.string.error_password, Toast.LENGTH_SHORT).show();
        }

    }

    private void createAccount() {
        Intent intent = new Intent(Sign_in.this, Sign_up.class);
        startActivity(intent);
        // finish();
    }
}
