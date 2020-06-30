package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class loginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

    }

    public void loginClick(View view)
    {
        setContentView(R.layout.activity_main);
    }

    public void registerClick(View view)
    {
        Intent reg_account = new Intent(this, create_account.class);
        startActivity(reg_account);
    }




}


