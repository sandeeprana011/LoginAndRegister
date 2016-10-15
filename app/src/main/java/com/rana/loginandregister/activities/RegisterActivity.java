package com.rana.loginandregister.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rana.loginandregister.R;
import com.rana.loginandregister.database.User;

public class RegisterActivity extends AppCompatActivity {


    private TextView tvFirstname;
    private TextView tvLastname;
    private TextView tvEmail;
    private TextView tvPassword;
    private TextView tvAge;
    private TextView tvAddress;
    private TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvFirstname = (TextView) findViewById(R.id.t_firstname_register);
        tvLastname = (TextView) findViewById(R.id.t_lastname_register);
        tvEmail = (TextView) findViewById(R.id.t_email_register);
        tvPassword = (TextView) findViewById(R.id.t_password_register);
        tvAge = (TextView) findViewById(R.id.t_age_register);
        tvAddress = (TextView) findViewById(R.id.t_address);
        tvPhone = (TextView) findViewById(R.id.t_phone_register);

    }

    public void validateAndRegisterUser(View view) {
        if (User.count(User.class, " EMAIL=?", new String[]{tvEmail.getText().toString()}) > 0) {
            //// TODO: 15/10/16 Error user already exists
            tvEmail.setError("Email already in use!");
        } else {
            String firstName = tvFirstname.getText().toString();
            String lastName = tvLastname.getText().toString();
            String email = tvEmail.getText().toString();
            String password = tvPassword.getText().toString();
            String age = tvAge.getText().toString();
            String address = tvAddress.getText().toString();
            String phone = tvPhone.getText().toString();

            User user = new User(email, age, password, firstName, lastName, address, phone);
            user.save();
            finish();
        }
    }

}
