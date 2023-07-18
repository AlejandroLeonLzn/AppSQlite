package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registrarse extends AppCompatActivity {
    private EditText edtPassR, edtUsuarioR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        edtPassR=findViewById(R.id.edtPassR);
        edtUsuarioR=findViewById(R.id.edtUsuarioR);
    }
    public void alta(View v) {
        if (edtUsuarioR.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un usuario",
                    Toast.LENGTH_SHORT).show();
        } else if(edtPassR.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese una contraseña",
                    Toast.LENGTH_SHORT).show();
        }else{
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String usu = edtUsuarioR.getText().toString();
            String pas = edtPassR.getText().toString();
            ContentValues registro = new ContentValues();
            registro.put("usuario", usu);
            registro.put("password", pas);
            bd.insert("persona", null, registro);
            bd.close();
            Toast.makeText(this, "Se cargaron los datos del usuario",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void regresar (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}