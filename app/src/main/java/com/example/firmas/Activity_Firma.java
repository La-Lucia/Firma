package com.example.firmas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.kyanogen.signatureview.SignatureView;

import java.io.ByteArrayOutputStream;

public class Activity_Firma extends AppCompatActivity {

    Button guardar;
    EditText Detalles;
    ObtenerBitmap firma;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firma);

        firma = findViewById(R.id.firma);
        guardar = findViewById(R.id.BtnGuardarFirma);
        Detalles = findViewById(R.id.TxtDescripcion);

    }

    public void guardarImagen(View view) {
        try {
            SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(Transacciones.descripcion, Detalles.getText().toString());
            valores.put(Transacciones.firma,firma.getBytes());

            Long resultado = db.insert(Transacciones.Tabla,Transacciones.id,valores);
            Toast.makeText(getApplicationContext(),"Firma guardada correctamente",Toast.LENGTH_LONG).show();

            db.close();

            Detalles.setText("");
            firma.ClearCanvas();
        }catch (SQLiteException ex){
            Toast.makeText(getApplicationContext(), "Error: "+ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void ListaFirmas(View view){

        startActivity(new Intent(this, ActivityListaFirmas.class));

    }



}