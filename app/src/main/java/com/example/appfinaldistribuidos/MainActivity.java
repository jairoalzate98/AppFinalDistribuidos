package com.example.appfinaldistribuidos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import model.EstudianteManager;

public class MainActivity extends AppCompatActivity {

    private EditText etCodigo;
    private EditText etContrasenia;
    private Toast toastMessage;
    private EstudianteManager estudianteManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estudianteManager = new EstudianteManager();
        etCodigo = findViewById(R.id.et_Codigo);
        etContrasenia = findViewById(R.id.et_Contrasenia);
    }

    public void startApp(View view){
        if (validateEmptyFields()){
            if (estudianteManager.validateEstudiante(Integer.parseInt(etCodigo.getText().toString()), etContrasenia.getText().toString())){
                toastMessage = Toast.makeText(this, "Usuario valido", Toast.LENGTH_SHORT);
                toastMessage.show();
            }else {
                toastMessage = Toast.makeText(this, "Usuario no valido", Toast.LENGTH_SHORT);
                toastMessage.show();
            }
        }
    }

    public boolean validateEmptyFields(){
        if(TextUtils.isEmpty(etCodigo.getText().toString()) || TextUtils.isEmpty(etCodigo.getText().toString())){
            toastMessage = Toast.makeText(this, "Por favor introduzca sus datos", Toast.LENGTH_LONG);
            toastMessage.show();
            return false;
        }
        return true;
    }
}