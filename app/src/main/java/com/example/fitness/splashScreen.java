package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* More about intent: https://www.vogella.com/tutorials/AndroidIntent/article.html */
        Intent intent = new Intent(this, loginPage.class);
        startActivity(intent);
        finish();
    }
}