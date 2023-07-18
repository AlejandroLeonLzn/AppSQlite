package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    private TextView tvresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvresultado = (TextView) findViewById(R.id.tvResultado);
        String num1 = getIntent().getStringExtra("num1");
        String num2 = getIntent().getStringExtra("num2");
        int a=Integer.parseInt(num1);
        int b=Integer.parseInt(num2);
        int c=(a+b);
        tvresultado.setText(" "+c);
    }
    //Regresar
    public void regresar(View view) {
        Intent i = new Intent(this, Bienvenido.class);
        startActivity(i);
    }
}