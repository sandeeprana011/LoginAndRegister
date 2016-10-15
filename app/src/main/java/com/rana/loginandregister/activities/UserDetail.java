package com.rana.loginandregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rana.loginandregister.R;
import com.rana.loginandregister.database.User;

public class UserDetail extends AppCompatActivity {
    public static final String EMAIL_KEY = "email";
    TextView tvAllDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        tvAllDetails = (TextView) findViewById(R.id.alldetails);

        Intent intent = getIntent();
        String email = intent.getStringExtra(EMAIL_KEY);
        tempSetDetails(email);
    }

    private void tempSetDetails(String email) {
        User user = User.getUser(email);
        if (user != null) {
            String buildText = "Name : " + user.getFirstname() + " " + user.getLastname() + "\n" +
                    "Email : " + user.getEmail() + "\n" +
                    "Age : " + user.getAge() + "\n" +
                    "Address : " + user.getAddress() + "\n" +
                    "Phone : " + user.getPhone();
            tvAllDetails.setText(buildText);
        }
    }

}
