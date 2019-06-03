package com.example.appfinaldistribuidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import model.EstudianteManager;

public class LoginActivity extends AppCompatActivity {

    private EditText etCodigo;
    private EditText etContrasenia;
    private Toast toastMessage;
    private EstudianteManager estudianteManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        estudianteManager = new EstudianteManager();
        etCodigo = findViewById(R.id.et_Codigo);
        etContrasenia = findViewById(R.id.et_Contrasenia);
    }

    public void startApp(View view){
        if (validateEmptyFields()){
            if (estudianteManager.validateEstudiante(Integer.parseInt(etCodigo.getText().toString()), etContrasenia.getText().toString())){
                toastMessage = Toast.makeText(this, "Usuario valido", Toast.LENGTH_SHORT);
                toastMessage.show();
                Intent mainActivity = new Intent(getBaseContext(), MainActivity.class);
                mainActivity.putExtra("Codigo Estudiante", etCodigo.getText().toString());
                startActivity(mainActivity);
            }else {
                toastMessage = Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT);
                toastMessage.show();
            }
        }
    }

    public boolean validateEmptyFields(){
        if(etCodigo.getText().toString().isEmpty() && etContrasenia.getText().toString().isEmpty()){
            etCodigo.setError("Por favor introduzca su codigo");
            etContrasenia.setError("Por favor introduzca su contraseña");
            return false;
        }else if(etCodigo.getText().toString().isEmpty()){
            etCodigo.setError("Por favor introduzca su codigo");
            return false;
        }else if(etContrasenia.getText().toString().isEmpty()){
            etContrasenia.setError("Por favor introduzca su contraseña");
            return false;
        }
        return true;
    }
}