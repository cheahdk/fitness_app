package com.example.fitness;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
    FirebaseAuth fireAuthenticate;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_page);

        inputUsername = findViewById(R.id.registerUsername);
        inputEmail = findViewById(R.id.registerEmail);
        inputPassword = findViewById(R.id.registerPassword);
        fireAuthenticate = FirebaseAuth.getInstance();
    }

    public void createAccountClick(View view)
    {
        username = inputUsername.getText().toString();
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();
        boolean empty_field = false;
        boolean bad_field_length = false;
        boolean valid_email = false;

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
                    /* Start user registration */

                }

            }
        }





    }
}
