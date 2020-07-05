package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class create_account extends AppCompatActivity{
    EditText inputUsername;
    String username;
    EditText inputEmail;
    String email;
    EditText inputPassword;
    String password;
    Button createButton;
    ProgressBar progressBar;
    FirebaseAuth firebaseCreate;
    static int passwordLength = 8;
    static int usernameLength = 3;

    /* to check for empty fields */
    private boolean emptyFieldCheck()
    {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
        {
            if(TextUtils.isEmpty(username))
            {
                inputUsername.setError("Username required");
            }

            if(TextUtils.isEmpty(email))
            {
                inputEmail.setError("Email required");
            }

            if(TextUtils.isEmpty(password))
            {
                inputPassword.setError("Password required");
            }

            return true;
        }

        else
        {
            return false;
        }

    }

    /* to check for field lengths */
    private boolean fieldLengthCheck()
    {
        if(username.length() < usernameLength || password.length() < passwordLength)
        {
            if(username.length() < usernameLength)
            {
                inputUsername.setError("Username needs to have at least 3 characters");
            }

            if(password.length() < passwordLength)
            {
                inputPassword.setError("Password needs to have at least 8 characters");
            }

            return false;
        }

        else
        {
            return true;
        }
    }

    /* to check for email format */
    private boolean emailFormatCheck()
    {
        String emailFormat = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";    /* abc123!@abc.abc */
        String emailFormatSecond = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";    /*abc123!@abc.abc.abc */

        if(email.matches(emailFormat))
        {
            return true;
        }

        else if(email.matches(emailFormatSecond))
        {
            return true;
        }

        else
        {
            inputEmail.setError("Email format is incorrect");
            return false;
        }
    }

    private void createAccount()
    {
        final boolean accountCreated = false;
        int i = 1;
        splashScreen fAuth = new splashScreen();

        firebaseCreate.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(create_account.this, "Welcome " + username, Toast.LENGTH_SHORT).show();
                    Intent createSuccess = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(createSuccess);
                    finish();
                }

                else
                {
                    Toast.makeText(create_account.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        fAuth.setFireAuthenticate(firebaseCreate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_page);

        inputUsername = findViewById(R.id.registerUsername);
        inputEmail = findViewById(R.id.registerEmail);
        inputPassword = findViewById(R.id.registerPassword);
        progressBar = findViewById(R.id.progressBar);

        splashScreen fAuth = new splashScreen();
        firebaseCreate = fAuth.getFireAuthenticate().getInstance();


    }

    public void createAccountClick(View view)
    {
        username = inputUsername.getText().toString();
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();

        emptyFieldCheck();

        /* if there are no empty fields */
        if(!emptyFieldCheck())
        {
            fieldLengthCheck();     /* check if field lengths are sufficient */

            /* if field lengths are sufficient */
            if(fieldLengthCheck())
            {
                emailFormatCheck();     /* check for the correct email address format */

                if(emailFormatCheck())
                {
                    // createAccount();
                    /* Start user registration */
                    progressBar.setVisibility(View.VISIBLE);
                    createAccount();
                }

            }
        }





    }
}
