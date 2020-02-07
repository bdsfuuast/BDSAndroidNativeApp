package com.fuuast.bds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Login_Click(View view) {
        if (PerformLogin()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private boolean PerformLogin() {
        return true;
    }
}
