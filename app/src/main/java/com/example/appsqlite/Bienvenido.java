package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Bienvenido extends AppCompatActivity {

    private EditText edtNum1, edtNum2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        edtNum1 = (EditText)findViewById(R.id.edtNum1);
        edtNum2 = (EditText)findViewById(R.id.edtNum2);
    }
    public void enviar (View view){
        Intent i = new Intent(this,resultado.class);
        i.putExtra("num1", edtNum1.getText().toString());
        i.putExtra("num2", edtNum2.getText().toString());
        startActivity(i);
    }
    public void regresar (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}