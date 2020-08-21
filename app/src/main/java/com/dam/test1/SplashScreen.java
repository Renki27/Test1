package com.dam.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

    private int delay = 3000;
    UserLocalStore userStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        userStore = new UserLocalStore(this);


//        Hilo para correr el splash screen antes de entrar a la aplicacion
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (userStore.getUserLoggedIn() == true) {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashScreen.this, Sign_in.class);
                    startActivity(intent);
                    finish();
                    //importante el finish para que no se pueda volver a esta pantalla
                }
            }
        }, delay);
    }
}
