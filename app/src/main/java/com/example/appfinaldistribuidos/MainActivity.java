package com.example.appfinaldistribuidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        String id = i.getExtras().getString("Codigo Estudiante");

        tvWelcome = findViewById(R.id.tv_Welcome);
        tvWelcome.setText("Bienvenido: " + id);

    }

    @Override
    public void onBackPressed() {
        //Do-Nothing
    }
}
