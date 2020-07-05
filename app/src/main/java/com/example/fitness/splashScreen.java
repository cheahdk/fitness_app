package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class splashScreen extends AppCompatActivity {

    private FirebaseAuth fireAuthenticate;

    public FirebaseAuth getFireAuthenticate() {
        return fireAuthenticate;
    }

    public void setFireAuthenticate(FirebaseAuth fireAuthenticate) {
        this.fireAuthenticate = fireAuthenticate;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fireAuthenticate = FirebaseAuth.getInstance();

        if(fireAuthenticate.getCurrentUser() != null)
        {
            /* More about intent: https://www.vogella.com/tutorials/AndroidIntent/article.html */
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        else
        {
            Intent intent = new Intent(this, loginPage.class);
            startActivity(intent);
            finish();
        }

    }
}