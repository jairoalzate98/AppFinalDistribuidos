package com.example.appfinaldistribuidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        String id = i.getExtras().getString("Codigo Estudiante");

        tvUser = findViewById(R.id.tv_User);
        tvUser.setText("Bienvenido: " + id);
    }

    @Override
    public void onBackPressed() {

    }
}
