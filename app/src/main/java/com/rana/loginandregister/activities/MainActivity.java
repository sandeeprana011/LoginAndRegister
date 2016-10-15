package com.rana.loginandregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rana.loginandregister.R;
import com.rana.loginandregister.database.User;

public class MainActivity extends AppCompatActivity {

    TextView tvEmail, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvEmail = (TextView) findViewById(R.id.email);
        tvPassword = (TextView) findViewById(R.id.password);
    }

    public void loginUser(View view) {
        String user = tvEmail.getText().toString();
        String pass = tvPassword.getText().toString();
        User userObj = User.getUser(user, pass);
        if (userObj != null) {
            //todo user successfully logged in
            Intent intent = new Intent(this, UserDetail.class);
            intent.putExtra(UserDetail.EMAIL_KEY, userObj.getEmail());
            startActivity(intent);
        } else {
            Snackbar.make(tvPassword.getRootView(), "Login failed!", Snackbar.LENGTH_SHORT).show();
        }

    }

    public void registerUser(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
