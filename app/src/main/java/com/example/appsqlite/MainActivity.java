package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsuario, edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=findViewById(R.id.edtUsuario);
        edtPass=findViewById(R.id.edtPass);
    }
    public void iniciar (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String usua = edtUsuario.getText().toString();
        String passw = edtPass.getText().toString();
        Cursor fila = bd.rawQuery("select usuario,password from persona where usuario='" + usua + "'", null);
        if(edtUsuario.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese un usuario",
                    Toast.LENGTH_SHORT).show();
            bd.close();
        } else {
            if (fila.moveToFirst()) {
                String comp1 = fila.getString((0));
                String comp2 = fila.getString(1);
                if (usua.equals(comp1)) {
                    if (passw.equals(comp2)) {
                        Intent i = new Intent(this, Bienvenido.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(this, "usuario o password incorrectos",
                                Toast.LENGTH_SHORT).show();
                        bd.close();
                    }
                } else {
                    Toast.makeText(this, "usuario o password incorrectos",
                            Toast.LENGTH_SHORT).show();
                    bd.close();
                }
            } else
                Toast.makeText(this, "No existe un usuario con ese nombre",
                        Toast.LENGTH_SHORT).show();
            bd.close();
        }
    }
    public void Registrar (View view){
        Intent i = new Intent(this,Registrarse.class);
        startActivity(i);
    }

}