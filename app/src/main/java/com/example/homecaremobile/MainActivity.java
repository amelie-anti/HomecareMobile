package com.example.homecaremobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 2000;
    Button button_connecte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        button_connecte = (Button) findViewById(R.id.buttonConnecter);

        button_connecte.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            final Intent acceuilProprietaire = new Intent(MainActivity.this, MainProprietaireActivity.class);
            startActivityForResult(acceuilProprietaire, REQUEST_CODE);
        }
    });
}}
